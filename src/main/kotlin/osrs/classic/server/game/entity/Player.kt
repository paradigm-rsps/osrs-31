package osrs.classic.server.game.entity

import osrs.classic.server.ServerConfig
import osrs.classic.server.event.EventBus
import osrs.classic.server.event.dispatch
import osrs.classic.server.event.player.PlayerCycleEvent
import osrs.classic.server.event.player.PlayerLoginEvent
import osrs.classic.server.event.player.PlayerLogoutEvent
import osrs.classic.server.event.player.PlayerMoveEvent
import osrs.classic.server.game.Appearance
import osrs.classic.server.game.MovementType
import osrs.classic.server.game.Privilege
import osrs.classic.server.game.entity.pathfinder.PlayerPathfinder
import osrs.classic.server.game.entity.update.PlayerUpdateFlag
import osrs.classic.server.game.interfaces.DisplayMode
import osrs.classic.server.game.manager.*
import osrs.classic.server.game.map.Tile
import osrs.classic.server.net.StatusResponse
import osrs.classic.server.net.game.GameProtocol
import osrs.classic.server.net.login.LoginRequest
import osrs.classic.server.net.login.LoginResponse
import osrs.classic.server.net.packet.server.IF_OPENTOP
import osrs.classic.server.net.packet.server.RebuildRegionNormal
import osrs.classic.server.net.packet.unknown.server.RunClientScript
import osrs.classic.server.util.SHA256
import osrs.classic.server.util.logger.Logger


class Player(val client: Client) : LivingEntity() {

    var username: String = ""
    var passwordHash: String = ""
    var displayName: String = ""
    var privilege: Privilege = Privilege.ADMINISTRATOR
    var appearance: Appearance = Appearance.DEFAULT
    var displayMode: DisplayMode = DisplayMode.FIXED
    var pid: Int = -1
    var member: Boolean = true
    var skullIcon: Int = -1
    var prayerIcon: Int = -1
    override var combatLevel: Int = 3

    /**
     * The pathfinder configured for players.
     */
    override val pathfinder = PlayerPathfinder(this)

    /**
     * Gets and Sets whether the player is running or not.
     */
    override var running: Boolean = super.running
        set(value) {
            field = value
            addMovementModeUpdateFlag()
        }

/**
     * The run energy value of the player.
     *//*

    var runEnergy: Int = 0
        set(value) {
            field = value
            client.write(UpdateRunEnergy(value))
        }

    */

    /**
     * Whether this player can walk through walls and blocked terrain.
     */
    var noclip: Boolean = false

    /*
     * Player context managers.
     */
    val gpi = GpiManager(this)
    val scene = SceneManager(this)
    val interfaces = InterfaceManager(this)
    val npcs = NpcManager(this)
    private val varpManager = VarpManager(this)
    override val updateFlags = sortedSetOf<PlayerUpdateFlag>()

/*
    *//**
     * Runs a client script with ID for this player.
     *
     * @param id Int
     * @param params Array<out Any>
     */
    fun runClientScript(id: Int, vararg params: Any) {
        client.write(RunClientScript(id, *params))
    }

    /**
     * Updates a varp's bit value for this player.
     *
     * @param id Int
     * @param value Int
     */
    fun updateVarbit(id: Int, value: Int) {
        varpManager.updateVarbit(id, value)
    }

    /**
     * Updates a Varp's value for this player.
     *
     * @param id Int
     * @param value Int
     */
    fun updateVarp(id: Int, value: Int) {
        varpManager.updateVarp(id, value)
    }

    /**
     * A map of varps by their ID for this player.
     */
    val varps: Map<Int, Int> get() = varpManager.varps.toMap()

/*
    fun sendGameMessage(message: String, type: MessageType = MessageType.GAME) {
        client.write(SendMessageGame(type.id, false, message))
    }
*/

    fun initialize() {

        //gpi.initialize()
        scene.initialize()
        //interfaces.initialize()
    }

    internal fun login(request: LoginRequest) {
        username = request.username
        displayName = request.username

        if(request.password != null) {
            passwordHash = SHA256.hash(request.password)
        }

        /*
         * Set the player tile to the default home tile.
         */
        tile = Tile(ServerConfig.DEFAULTS.HOME_TILE.X, ServerConfig.DEFAULTS.HOME_TILE.Y, ServerConfig.DEFAULTS.HOME_TILE.PLANE)
        prevTile = tile
        prevPathTile = tile.copy()

        /*
         * Register the player with the game world.
         */
        world.players.add(this)

        /*
         * Update the Session State values and Isaac Random values.
         */
        client.session.client = client
        client.session.seed = request.seed
        client.session.xteas = request.xteas
/*        client.session.reconnectXteas = request.reconnectXteas*/

        client.session.encoderIsaac.init(IntArray(4) { request.xteas[it] + 50 })
        client.session.decoderIsaac.init(request.xteas)

        val response = LoginResponse(StatusResponse.NORMAL, this)
        client.session.writeAndFlush(response)
        .addListener {
            if (it.isSuccess) {
                client.session.protocol.set(GameProtocol(client.session))
                this.initialize()
                client.session.writeAndFlush(IF_OPENTOP(548))
                EventBus.dispatch(PlayerLoginEvent(this))
                Logger.info("[username: $username] has connected to the server.")
            }
        }
    }

    internal fun logout() {
        world.players.remove(this)

        EventBus.dispatch(PlayerLogoutEvent(this))

        Logger.info("[username: $username] has disconnected from the server.")
    }

    internal fun synchronize() {
        varpManager.synchronize()
        scene.synchronize()
        //gpi.synchronize()
        //npcs.synchronize()
        client.flush()
    }

    override fun postProcess() {
        super.postProcess()
        EventBus.dispatch(PlayerCycleEvent(this))
        varpManager.synchronize()
        scene.postProcess()
    }

    override fun scheduleMoveEvent(type: MovementType) = EventBus.dispatch(PlayerMoveEvent(this, type))

    override fun addAppearanceUpdateFlag() { updateFlags.add(PlayerUpdateFlag.APPEARANCE) }
    override fun addForceChatUpdateFlag() { updateFlags.add(PlayerUpdateFlag.FORCE_CHAT) }
    override fun addMovementUpdateFlag() { updateFlags.add(PlayerUpdateFlag.MOVEMENT) }
    override fun addMovementModeUpdateFlag() { updateFlags.add(PlayerUpdateFlag.MOVEMENT_MODE) }
}