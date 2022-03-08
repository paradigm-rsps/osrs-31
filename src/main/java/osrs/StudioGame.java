package osrs;

public enum StudioGame implements class117 {
    runescape("runescape", "RuneScape", 0),
    stellardawn("stellardawn", "Stellar Dawn", 1),
    game3("game3", "Game 3", 2),
    game4("game4", "Game 4", 3),
    game5("game5", "Game 5", 4),
    oldscape("oldscape", "RuneScape 2007", 5);

    static Task field2087;
    public final String name;
    final int id;

    StudioGame(String var3, String var4, int var5) {
        this.name = var3;
        this.id = var5;
    }

    public int vmethod2859() {
        return this.id;
    }
}
