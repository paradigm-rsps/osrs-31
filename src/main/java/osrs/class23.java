package osrs;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

public class class23 {
    protected static boolean hasFocus;
    static SoundCache soundCache;
    static String[] field382;
    byte[] field392 = new byte[4];
    int field387;
    Task field383;
    DataInputStream field384;
    int field386;
    byte[] field388;
    int field385;
    long field393;

    class23(TaskHandler var1, URL var2) {
        this.field383 = var1.method1601(var2);
        this.field387 = 0;
        this.field393 = ClientPreferences.method148() + 30000L;
    }

    byte[] method249() throws IOException {
        if (ClientPreferences.method148() > this.field393) {
            throw new IOException();
        } else {
            if (this.field387 == 0) {
                if (this.field383.status == 2) {
                    throw new IOException();
                }

                if (this.field383.status == 1) {
                    this.field384 = (DataInputStream) this.field383.result;
                    this.field387 = 1;
                }
            }

            int var1;
            if (this.field387 == 1) {
                var1 = this.field384.available();
                if (var1 > 0) {
                    if (var1 + this.field386 > 4) {
                        var1 = 4 - this.field386;
                    }

                    this.field386 += this.field384.read(this.field392, this.field386, var1);
                    if (this.field386 == 4) {
                        int var2 = (new Buffer(this.field392)).readInt();
                        this.field388 = new byte[var2];
                        this.field387 = 2;
                    }
                }
            }

            if (this.field387 == 2) {
                var1 = this.field384.available();
                if (var1 > 0) {
                    if (var1 + this.field385 > this.field388.length) {
                        var1 = this.field388.length - this.field385;
                    }

                    this.field385 += this.field384.read(this.field388, this.field385, var1);
                    if (this.field388.length == this.field385) {
                        return this.field388;
                    }
                }
            }

            return null;
        }
    }

    static void method248(GameEngine var0) {
        if (MouseHandler.PacketBufferNode_packetBufferNodeCount == 1) {
            short var1 = 280;
            if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(0, 0);
                return;
            }

            if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(0, 1);
                return;
            }

            short var2 = 390;
            if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(1, 0);
                return;
            }

            if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(1, 1);
                return;
            }

            short var3 = 500;
            if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(2, 0);
                return;
            }

            if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(2, 1);
                return;
            }

            short var4 = 610;
            if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(3, 0);
                return;
            }

            if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                AccessFile.method573(3, 1);
                return;
            }

            if (MouseHandler.MouseHandler_lastPressedX >= 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= 758 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                Login.worldSelectOpen = false;
                Login.field317.method1835(0, 0);
                Login.field332.method1835(382, 0);
                Login.field319.method1936(382 - Login.field319.subWidth / 2, 18);
                return;
            }

            if (Login.field348 != -1) {
                World var5 = Skills.field2058[Login.field348];
                if (var5.field197 != Client.isMembersWorld) {
                    Client.isMembersWorld = var5.field197;
                    TileItem.method179(var5.field197);
                }

                SoundSystem.worldHost = var5.field196;
                Client.ViewportMouse_x = var5.id;
                MouseRecorder.OSRS_PORT = Client.ViewportMouse_y == 0 ? 'ꩊ' : var5.id + '鱀';
                Client.somePortIncrement = Client.ViewportMouse_y == 0 ? 443 : var5.id + '썐';
                class82.currentPort = MouseRecorder.OSRS_PORT;
                Login.worldSelectOpen = false;
                Login.field317.method1835(0, 0);
                Login.field332.method1835(382, 0);
                Login.field319.method1936(382 - Login.field319.subWidth / 2, 18);
                return;
            }
        }

    }

    static final int method253(int var0, int var1, int var2) {
        int var3 = var0 / var2;
        int var4 = var0 & var2 - 1;
        int var5 = var1 / var2;
        int var6 = var1 & var2 - 1;
        int var7 = ScriptEvent.method4(var3, var5);
        int var8 = ScriptEvent.method4(var3 + 1, var5);
        int var9 = ScriptEvent.method4(var3, var5 + 1);
        int var10 = ScriptEvent.method4(var3 + 1, var5 + 1);
        int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
        int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
        int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
        int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
        int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
        int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
        return var15;
    }

    static final void method251() {
        Client.rsaBuf.writeByteOpcode(8);
        Client.rsaBuf.writeByte(0);
    }
}
