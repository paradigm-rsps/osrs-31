import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("Login")
public class Login {
   @ObfuscatedName("i")
   static boolean field318;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lclass86;"
   )
   static IndexedSprite field314;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lclass86;"
   )
   static IndexedSprite field315;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "[Lclass86;"
   )
   static IndexedSprite[] field341;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lclass85;"
   )
   static SpritePixels field317;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Lclass85;"
   )
   static SpritePixels field332;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Lclass86;"
   )
   static IndexedSprite field319;
   @ObfuscatedName("m")
   static int[] field323 = new int[256];
   @ObfuscatedName("o")
   static int[] field324;
   @ObfuscatedName("j")
   static int field325 = 0;
   @ObfuscatedName("n")
   static int field352 = 0;
   @ObfuscatedName("b")
   static int[] field327;
   @ObfuscatedName("y")
   static int field328 = 0;
   @ObfuscatedName("x")
   static int field329 = 0;
   @ObfuscatedName("ao")
   static int field330 = 0;
   @ObfuscatedName("ae")
   static int field331 = 0;
   @ObfuscatedName("aa")
   @Export("Login_loadingPercent")
   static int Login_loadingPercent = 10;
   @ObfuscatedName("ah")
   @Export("Login_loadingText")
   static String Login_loadingText = "";
   @ObfuscatedName("aw")
   static int field351 = 0;
   @ObfuscatedName("an")
   @Export("Login_response1")
   static String Login_response1 = "";
   @ObfuscatedName("av")
   @Export("Login_response2")
   static String Login_response2 = "";
   @ObfuscatedName("ak")
   @Export("Login_response3")
   static String Login_response3 = "";
   @ObfuscatedName("ax")
   static String field338 = "";
   @ObfuscatedName("ab")
   static String field339 = "";
   @ObfuscatedName("af")
   static int field340 = 0;
   @ObfuscatedName("aq")
   @Export("worldSelectOpen")
   static boolean worldSelectOpen = false;
   @ObfuscatedName("ag")
   @Export("worldSelectFlagSprites")
   @ObfuscatedSignature(
      descriptor = "[Lclass86;"
   )
   static IndexedSprite[] worldSelectFlagSprites;
   @ObfuscatedName("aj")
   static int field334 = 0;
   @ObfuscatedName("bh")
   @Export("World_sortOption1")
   static int[] World_sortOption1 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("ba")
   @Export("World_sortOption2")
   static int[] World_sortOption2 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("bn")
   static int field348 = -1;
   @ObfuscatedName("fq")
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("i")
   public static void method241(String var0, String var1, int var2, int var3) throws IOException {
      NetFileRequest.field2554 = var3;
      JagexCache.cacheGamebuild = var2;

      try {
         PendingSpawn.field358 = System.getProperty("os.name");
      } catch (Exception var28) {
         PendingSpawn.field358 = "Unknown";
      }

      World.field199 = PendingSpawn.field358.toLowerCase();

      try {
         TextureProvider.userHomeDirectory = System.getProperty("user.home");
         if (TextureProvider.userHomeDirectory != null) {
            TextureProvider.userHomeDirectory = TextureProvider.userHomeDirectory + "/";
         }
      } catch (Exception var27) {
         ;
      }

      try {
         if (World.field199.startsWith("win")) {
            if (TextureProvider.userHomeDirectory == null) {
               TextureProvider.userHomeDirectory = System.getenv("USERPROFILE");
            }
         } else if (TextureProvider.userHomeDirectory == null) {
            TextureProvider.userHomeDirectory = System.getenv("HOME");
         }

         if (TextureProvider.userHomeDirectory != null) {
            TextureProvider.userHomeDirectory = TextureProvider.userHomeDirectory + "/";
         }
      } catch (Exception var26) {
         ;
      }

      if (TextureProvider.userHomeDirectory == null) {
         TextureProvider.userHomeDirectory = "~/";
      }

      ClientPreferences.field187 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", TextureProvider.userHomeDirectory, "/tmp/", ""};
      class23.field382 = new String[]{".jagex_cache_" + JagexCache.cacheGamebuild, ".file_store_" + JagexCache.cacheGamebuild};
      int var18 = 0;

      label242:
      while(var18 < 4) {
         String var6 = var18 == 0 ? "" : "" + var18;
         class183.JagexCache_locationFile = new File(TextureProvider.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var33;
         if (class183.JagexCache_locationFile.exists()) {
            try {
               AccessFile var10 = new AccessFile(class183.JagexCache_locationFile, "rw", 10000L);

               Buffer var11;
               int var12;
               for(var11 = new Buffer((int)var10.method578()); var11.offset < var11.array.length; var11.offset += var12) {
                  var12 = var10.method584(var11.array, var11.offset, var11.array.length - var11.offset);
                  if (var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.method2665();
               if (var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if (var12 > 1) {
                  var13 = var11.method2665();
               }

               if (var12 <= 2) {
                  var7 = var11.method2731();
                  if (var13 == 1) {
                     var8 = var11.method2731();
                  }
               } else {
                  var7 = var11.method2655();
                  if (var13 == 1) {
                     var8 = var11.method2655();
                  }
               }

               var10.method586();
            } catch (IOException var30) {
               var30.printStackTrace();
            }

            if (var7 != null) {
               var33 = new File(var7);
               if (!var33.exists()) {
                  var7 = null;
               }
            }

            if (var7 != null) {
               var33 = new File(var7, "test.dat");
               if (!class10.method133(var33, true)) {
                  var7 = null;
               }
            }
         }

         if (var7 == null && var18 == 0) {
            label216:
            for(int var19 = 0; var19 < class23.field382.length; ++var19) {
               for(int var20 = 0; var20 < ClientPreferences.field187.length; ++var20) {
                  File var21 = new File(ClientPreferences.field187[var20] + class23.field382[var19] + File.separatorChar + var0 + File.separatorChar);
                  if (var21.exists() && class10.method133(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label216;
                  }
               }
            }
         }

         if (var7 == null) {
            var7 = TextureProvider.userHomeDirectory + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if (var8 != null) {
            File var32 = new File(var8);
            var33 = new File(var7);

            try {
               File[] var35 = var32.listFiles();
               File[] var22 = var35;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var33, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if (!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var29) {
               var29.printStackTrace();
            }

            var9 = true;
         }

         if (var9) {
            class10.method132(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         JagexCache.cacheDir = var5;
         if (!JagexCache.cacheDir.exists()) {
            JagexCache.cacheDir.mkdirs();
         }

         File[] var31 = JagexCache.cacheDir.listFiles();
         if (var31 != null) {
            File[] var34 = var31;

            for(int var23 = 0; var23 < var34.length; ++var23) {
               File var24 = var34[var23];
               if (!class10.method133(var24, false)) {
                  ++var18;
                  continue label242;
               }
            }
         }
         break;
      }

      File var4 = JagexCache.cacheDir;
      FileSystem.FileSystem_cacheDir = var4;
      if (!FileSystem.FileSystem_cacheDir.exists()) {
         throw new RuntimeException("");
      } else {
         FileSystem.FileSystem_hasPermissions = true;
         ItemContainer.method186();
         JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class40.method915("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         JagexCache.fontNameVerdana15 = new BufferedFile(new AccessFile(class40.method915("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class10.JagexCache_idxFiles = new BufferedFile[NetFileRequest.field2554];

         for(int var25 = 0; var25 < NetFileRequest.field2554; ++var25) {
            class10.JagexCache_idxFiles[var25] = new BufferedFile(new AccessFile(class40.method915("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;)V"
   )
   public static void method240(AbstractArchive var0) {
      VarpDefinition.VarpDefinition_archive = var0;
      VarpDefinition.field1039 = VarpDefinition.VarpDefinition_archive.method3214(16);
   }

   @ObfuscatedName("ad")
   @Export("method242")
   static final void loadRegions(boolean isInstance) {
      Client.isInInstance = isInstance;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var8;
      int var9;
      int var10;
      if (!Client.isInInstance) {
         var1 = Client.serverPacketBuf.readUnsignedByteSub();
         var2 = Client.serverPacketBuf.readUnsignedShortLE();
         var3 = (Client.serverPacketLength - Client.serverPacketBuf.offset) / 16;
         class161.field2709 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class161.field2709[var4][var5] = Client.serverPacketBuf.method2687();
            }
         }

         var4 = Client.serverPacketBuf.readUnsignedShortLE();
         var5 = Client.serverPacketBuf.readUnsignedShort();
         var6 = Client.serverPacketBuf.method2677();
         class149.field2463 = new int[var3];
         ObjectSound.field93 = new int[var3];
         ScriptEvent.field0 = new int[var3];
         Buffer.field2045 = new byte[var3][];
         PendingSpawn.field365 = new byte[var3][];
         boolean var7 = false;
         if ((var6 / 8 == 48 || var6 / 8 == 49) && var2 / 8 == 48) {
            var7 = true;
         }

         if (var6 / 8 == 48 && var2 / 8 == 148) {
            var7 = true;
         }

         var3 = 0;

         for(var8 = (var6 - 6) / 8; var8 <= (var6 + 6) / 8; ++var8) {
            for(var9 = (var2 - 6) / 8; var9 <= (var2 + 6) / 8; ++var9) {
               var10 = var9 + (var8 << 8);
               if (!var7 || var9 != 49 && var9 != 149 && var9 != 147 && var8 != 50 && (var8 != 49 || var9 != 47)) {
                  class149.field2463[var3] = var10;
                  ObjectSound.field93[var3] = class146.archive5.method3219("m" + var8 + "_" + var9);
                  ScriptEvent.field0[var3] = class146.archive5.method3219("l" + var8 + "_" + var9);
                  ++var3;
               }
            }
         }

         class5.method42(var6, var2, var1, var4, var5);
      } else {
         var1 = Client.serverPacketBuf.readUnsignedShortLE();
         var2 = Client.serverPacketBuf.readUnsignedByteSub();
         Client.serverPacketBuf.switchBitMode();

         for(var3 = 0; var3 < 4; ++var3) {
            for(var4 = 0; var4 < 13; ++var4) {
               for(var5 = 0; var5 < 13; ++var5) {
                  var6 = Client.serverPacketBuf.readBits(1);
                  if (var6 == 1) {
                     Client.field540[var3][var4][var5] = Client.serverPacketBuf.readBits(26);
                  } else {
                     Client.field540[var3][var4][var5] = -1;
                  }
               }
            }
         }

         Client.serverPacketBuf.switchToByteMode();
         var3 = (Client.serverPacketLength - Client.serverPacketBuf.offset) / 16;
         class161.field2709 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class161.field2709[var4][var5] = Client.serverPacketBuf.method2687();
            }
         }

         var4 = Client.serverPacketBuf.readUnsignedShortLE();
         var5 = Client.serverPacketBuf.method2677();
         var6 = Client.serverPacketBuf.method2677();
         class149.field2463 = new int[var3];
         ObjectSound.field93 = new int[var3];
         ScriptEvent.field0 = new int[var3];
         Buffer.field2045 = new byte[var3][];
         PendingSpawn.field365 = new byte[var3][];
         var3 = 0;

         for(int var16 = 0; var16 < 4; ++var16) {
            for(var8 = 0; var8 < 13; ++var8) {
               for(var9 = 0; var9 < 13; ++var9) {
                  var10 = Client.field540[var16][var8][var9];
                  if (var10 != -1) {
                     int var11 = var10 >> 14 & 1023;
                     int var12 = var10 >> 3 & 2047;
                     int var13 = (var11 / 8 << 8) + var12 / 8;

                     int var14;
                     for(var14 = 0; var14 < var3; ++var14) {
                        if (class149.field2463[var14] == var13) {
                           var13 = -1;
                           break;
                        }
                     }

                     if (var13 != -1) {
                        class149.field2463[var3] = var13;
                        var14 = var13 >> 8 & 255;
                        int var15 = var13 & 255;
                        ObjectSound.field93[var3] = class146.archive5.method3219("m" + var14 + "_" + var15);
                        ScriptEvent.field0[var3] = class146.archive5.method3219("l" + var14 + "_" + var15);
                        ++var3;
                     }
                  }
               }
            }
         }

         class5.method42(var6, var5, var2, var1, var4);
      }

   }

   @ObfuscatedName("co")
   static final void method239(int var0, String var1, String var2) {
      NPC.method256(var0, var1, var2, (String)null);
   }
}
