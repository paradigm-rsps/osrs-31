import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lclass151;"
   )
   static AbstractArchive field977;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lclass169;"
   )
   static EvictingDualNodeHashTable field968 = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("z")
   @Export("Tiles_lightness")
   static int[] Tiles_lightness;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "Lclass69;"
   )
   static IterableNodeHashTableIterator field978;
   @ObfuscatedName("f")
   public int field979;
   @ObfuscatedName("e")
   @Export("outputType")
   public char outputType;
   @ObfuscatedName("t")
   @Export("defaultStr")
   public String defaultStr = "null";
   @ObfuscatedName("d")
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("p")
   @Export("outputCount")
   public int outputCount = 0;
   @ObfuscatedName("k")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("r")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("l")
   @Export("strVals")
   public String[] strVals;

   @ObfuscatedName("f")
   @Export("method839")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   void method839(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.method841(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @Export("method841")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;I)V"
   )
   void method841(Buffer var1, int var2) {
      if (var2 == 1) {
         this.field979 = var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.method2653();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.method2653();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lclass153;I)V"
   )
   static void method851(Archive var0, int var1) {
      if (WallDecoration.NetCache_reference != null) {
         WallDecoration.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = WallDecoration.NetCache_reference.readInt();
         int var3 = WallDecoration.NetCache_reference.readInt();
         var0.method3299(var2, var3);
      } else {
         class148.method3173((Archive)null, 255, 255, 0, (byte)0, true);
         NetCache.NetCache_archives[var1] = var0;
      }
   }

   @ObfuscatedName("f")
   @Export("method852")
   public static boolean method852(int var0) {
      if (Widget.Widget_loadedInterfaces[var0]) {
         return true;
      } else if (!Widget.Widget_archive.method3207(var0)) {
         return false;
      } else {
         int var1 = Widget.Widget_archive.method3214(var0);
         if (var1 == 0) {
            Widget.Widget_loadedInterfaces[var0] = true;
            return true;
         } else {
            if (Widget.Widget_interfaceComponents[var0] == null) {
               Widget.Widget_interfaceComponents[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if (Widget.Widget_interfaceComponents[var0][var2] == null) {
                  byte[] var3 = Widget.Widget_archive.method3204(var0, var2);
                  if (var3 != null) {
                     Widget.Widget_interfaceComponents[var0][var2] = new Widget();
                     Widget.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
                     if (var3[0] == -1) {
                        Widget.Widget_interfaceComponents[var0][var2].method3337(new Buffer(var3));
                     } else {
                        Widget.Widget_interfaceComponents[var0][var2].method3336(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.Widget_loadedInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("e")
   public static boolean method843(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("k")
   static void method850() {
      try {
         if (Projectile.field171 == null) {
            Projectile.field171 = new class23(ItemContainer.taskHandler, new URL(FaceNormal.field1522));
         } else {
            byte[] var0 = Projectile.field171.method249();
            if (var0 != null) {
               Buffer var1 = new Buffer(var0);
               Login.field334 = var1.readUnsignedShort();
               Skills.field2058 = new World[Login.field334];

               World var3;
               for(int var2 = 0; var2 < Login.field334; var3.index = var2++) {
                  var3 = Skills.field2058[var2] = new World();
                  int var4 = var1.readUnsignedShort();
                  var3.id = var4 & 16383;
                  var3.field197 = (var4 & '耀') != 0;
                  var3.field201 = (var4 & 16384) != 0;
                  var3.field196 = var1.method2653();
                  var3.field205 = var1.method2653();
                  var3.field198 = var1.readUnsignedByte();
                  var3.population = var1.readShort();
               }

               JagexCache.method1720(Skills.field2058, 0, Skills.field2058.length - 1, Login.World_sortOption1, Login.World_sortOption2);
               Login.worldSelectOpen = true;
               Projectile.field171 = null;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         Projectile.field171 = null;
      }

   }

   @ObfuscatedName("ac")
   @Export("method848")
   static final void method848(boolean var0) {
      for(int var1 = 0; var1 < Client.npcCount; ++var1) {
         NPC var2 = Client.npcs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if (var2 != null && var2.vmethod281() && var2.definition.field808 == var0 && var2.definition.method634()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if (var2.size == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if (Client.field586[var4][var5] == Client.field724) {
                     continue;
                  }

                  Client.field586[var4][var5] = Client.field724;
               }

               if (!var2.definition.isInteractable) {
                  var3 -= Integer.MIN_VALUE;
               }

               Interpreter.scene.method2094(class22.Client_plane, var2.x, var2.y, BufferedFile.getTileHeight(var2.size * 64 - 64 + var2.x, var2.size * 64 - 64 + var2.y, class22.Client_plane), var2.size * 64 - 64 + 60, var2, var2.field432, var3, var2.isWalking);
            }
         }
      }

   }
}
