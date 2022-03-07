package osrs;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

@ObfuscatedName("cg")
public final class class82 extends AbstractRasterProvider implements ImageProducer, ImageObserver {
    @ObfuscatedName("ic")
    @Export("selectedItemSlot")
    static int selectedItemSlot;
    @ObfuscatedName("bv")
    @Export("currentPort")
    static int currentPort;
    @ObfuscatedName("i")
    ColorModel field1435;
    @ObfuscatedName("w")
    ImageConsumer field1436;

    @ObfuscatedName("i")
    final void vmethod1940(int var1, int var2, Component var3) {
        super.width = var1;
        super.height = var2;
        super.pixels = new int[var2 * var1 + 1];
        this.field1435 = new DirectColorModel(32, 16711680, 65280, 255);
        super.field1458 = var3.createImage(this);
        this.method1729();
        var3.prepareImage(super.field1458, this);
        this.method1729();
        var3.prepareImage(super.field1458, this);
        this.method1729();
        var3.prepareImage(super.field1458, this);
        this.method1822();
    }

    @ObfuscatedName("w")
    public final void vmethod1945(Graphics var1, int var2, int var3) {
        this.method1729();
        var1.drawImage(super.field1458, var2, var3, this);
    }

    @ObfuscatedName("f")
    public final void vmethod1941(Graphics var1, int var2, int var3, int var4, int var5) {
        this.method1736(var2, var3, var4, var5);
        Shape var6 = var1.getClip();
        var1.clipRect(var2, var3, var4, var5);
        var1.drawImage(super.field1458, 0, 0, this);
        var1.setClip(var6);
    }

    @ObfuscatedName("e")
    synchronized void method1729() {
        if (this.field1436 != null) {
            this.field1436.setPixels(0, 0, super.width, super.height, this.field1435, super.pixels, 0, super.width);
            this.field1436.imageComplete(2);
        }
    }

    @ObfuscatedName("t")
    synchronized void method1736(int var1, int var2, int var3, int var4) {
        if (this.field1436 != null) {
            this.field1436.setPixels(var1, var2, var3, var4, this.field1435, super.pixels, var2 * super.width + var1, super.width);
            this.field1436.imageComplete(2);
        }
    }

    public synchronized void addConsumer(ImageConsumer var1) {
        this.field1436 = var1;
        var1.setDimensions(super.width, super.height);
        var1.setProperties(null);
        var1.setColorModel(this.field1435);
        var1.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer var1) {
        return var1 == this.field1436;
    }

    public void startProduction(ImageConsumer var1) {
        this.addConsumer(var1);
    }

    public void requestTopDownLeftRightResend(ImageConsumer var1) {
    }

    public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
        return true;
    }

    public synchronized void removeConsumer(ImageConsumer var1) {
        if (var1 == this.field1436) {
            this.field1436 = null;
        }

    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lclass151;Lclass151;II)Lclass182;"
    )
    public static Font method1757(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
        return !KitDefinition.method796(var0, var2, var3) ? null : class134.method2864(var1.method3204(var2, var3));
    }

    @ObfuscatedName("e")
    @Export("method1737")
    static Class method1737(String var0) throws ClassNotFoundException {
        if (var0.equals("B")) {
            return Byte.TYPE;
        } else if (var0.equals("I")) {
            return Integer.TYPE;
        } else if (var0.equals("S")) {
            return Short.TYPE;
        } else if (var0.equals("J")) {
            return Long.TYPE;
        } else if (var0.equals("Z")) {
            return Boolean.TYPE;
        } else if (var0.equals("F")) {
            return Float.TYPE;
        } else if (var0.equals("D")) {
            return Double.TYPE;
        } else {
            return var0.equals("C") ? Character.TYPE : Reflection.findClass(var0);
        }
    }

    @ObfuscatedName("cm")
    @Export("method1754")
    @ObfuscatedSignature(
            descriptor = "(Lclass157;)V"
    )
    static void invalidateWidget(Widget var0) {
        if (var0.cycle == Client.field685) {
            Client.field686[var0.rootIndex] = true;
        }

    }

    @ObfuscatedName("ci")
    static final void method1730(int var0, int var1, int var2) {
        SequenceDefinition.method759();
        Rasterizer2D.method1953(var0, var1, var0 + TextureProvider.field1834.subWidth, var1 + TextureProvider.field1834.subHeight);
        if (Client.field717 != 2 && Client.field717 != 5) {
            int var3 = Client.field554 + Client.field569 & 2047;
            int var4 = Tiles.localPlayer.x / 32 + 48;
            int var5 = 464 - Tiles.localPlayer.y / 32;
            MouseRecorder.sceneMinimapSprite.method1847(var0 + 25, var1 + 5, 146, 151, var4, var5, var3, Client.field556 + 256, class112.field1931, VarpDefinition.field1044);

            int var6;
            int var7;
            int var8;
            for (var6 = 0; var6 < Client.field711; ++var6) {
                var7 = Client.field712[var6] * 4 + 2 - Tiles.localPlayer.x / 32;
                var8 = Client.field713[var6] * 4 + 2 - Tiles.localPlayer.y / 32;
                Script.method35(var0, var1, var7, var8, Client.field714[var6]);
            }

            int var9;
            int var10;
            for (var6 = 0; var6 < 104; ++var6) {
                for (var7 = 0; var7 < 104; ++var7) {
                    NodeDeque var15 = Client.groundItems[class22.scenePlane][var6][var7];
                    if (var15 != null) {
                        var9 = var6 * 4 + 2 - Tiles.localPlayer.x / 32;
                        var10 = var7 * 4 + 2 - Tiles.localPlayer.y / 32;
                        Script.method35(var0, var1, var9, var10, NPC.modIconSprites[0]);
                    }
                }
            }

            for (var6 = 0; var6 < Client.npcCount; ++var6) {
                NPC var14 = Client.npcs[Client.npcIndices[var6]];
                if (var14 != null && var14.vmethod281()) {
                    NPCComposition var20 = var14.definition;
                    if (var20 != null && var20.transforms != null) {
                        var20 = var20.method657();
                    }

                    if (var20 != null && var20.field804 && var20.isInteractable) {
                        var9 = var14.x / 32 - Tiles.localPlayer.x / 32;
                        var10 = var14.y / 32 - Tiles.localPlayer.y / 32;
                        Script.method35(var0, var1, var9, var10, NPC.modIconSprites[1]);
                    }
                }
            }

            for (var6 = 0; var6 < Client.field604; ++var6) {
                Player var19 = Client.players[Client.field524[var6]];
                if (var19 != null && var19.vmethod281()) {
                    var8 = var19.x / 32 - Tiles.localPlayer.x / 32;
                    var9 = var19.y / 32 - Tiles.localPlayer.y / 32;
                    boolean var16 = ItemContainer.method203(var19.field35);

                   boolean var11 = false;

                    for (int var12 = 0; var12 < SoundSystem.field1188; ++var12) {
                        if (var19.field35.equals(ItemComposition.field1026[var12].field112)) {
                            var11 = true;
                            break;
                        }
                    }

                    boolean var17 = Tiles.localPlayer.team != 0 && var19.team != 0 && var19.team == Tiles.localPlayer.team;

                   if (var16) {
                        Script.method35(var0, var1, var8, var9, NPC.modIconSprites[3]);
                    } else if (var17) {
                        Script.method35(var0, var1, var8, var9, NPC.modIconSprites[4]);
                    } else if (var11) {
                        Script.method35(var0, var1, var8, var9, NPC.modIconSprites[5]);
                    } else {
                        Script.method35(var0, var1, var8, var9, NPC.modIconSprites[2]);
                    }
                }
            }

            if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
                if (Client.hintArrowType == 1 && Client.field499 >= 0 && Client.field499 < Client.npcs.length) {
                    NPC var13 = Client.npcs[Client.field499];
                    if (var13 != null) {
                        var7 = var13.x / 32 - Tiles.localPlayer.x / 32;
                        var8 = var13.y / 32 - Tiles.localPlayer.y / 32;
                        Projectile.method124(var0, var1, var7, var8, ItemLayer.mapDotSprites[1]);
                    }
                }

                if (Client.hintArrowType == 2) {
                    var6 = Client.hintArrowX * 4 - FaceNormal.baseX * 4 + 2 - Tiles.localPlayer.x / 32;
                    var7 = Client.hintArrowY * 4 - Frames.baseY * 4 + 2 - Tiles.localPlayer.y / 32;
                    Projectile.method124(var0, var1, var6, var7, ItemLayer.mapDotSprites[1]);
                }

                if (Client.hintArrowType == 10 && Client.field500 >= 0 && Client.field500 < Client.players.length) {
                    Player var18 = Client.players[Client.field500];
                    if (var18 != null) {
                        var7 = var18.x / 32 - Tiles.localPlayer.x / 32;
                        var8 = var18.y / 32 - Tiles.localPlayer.y / 32;
                        Projectile.method124(var0, var1, var7, var8, ItemLayer.mapDotSprites[1]);
                    }
                }
            }

            if (Client.field715 != 0) {
                var6 = Client.field715 * 4 + 2 - Tiles.localPlayer.x / 32;
                var7 = Client.field716 * 4 + 2 - Tiles.localPlayer.y / 32;
                Script.method35(var0, var1, var6, var7, ItemLayer.mapDotSprites[0]);
            }

            Rasterizer2D.method1962(var0 + 93 + 4, var1 + 82 - 4, 3, 3, 16777215);
        } else {
            Rasterizer2D.method2003(var0 + 25, var1 + 5, 0, class112.field1931, VarpDefinition.field1044);
        }

        if (Client.field717 < 3) {
            TaskHandler.compass.method1847(var0, var1, 33, 33, 25, 25, Client.field569, 256, class148.field2460, Client.field561);
        } else {
            Rasterizer2D.method2003(var0, var1, 0, class148.field2460, Client.field561);
        }

        if (Client.field688[var2]) {
            TextureProvider.field1834.method1936(var0, var1);
        }

        Client.field687[var2] = true;
    }
}
