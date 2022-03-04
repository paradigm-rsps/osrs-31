import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Interpreter")
public class Interpreter {
   @ObfuscatedName("ny")
   static int field416;
   @ObfuscatedName("w")
   static int[] field406;
   @ObfuscatedName("f")
   static String[] field407;
   @ObfuscatedName("e")
   @Export("Interpreter_arrayLengths")
   static int[] Interpreter_arrayLengths = new int[5];
   @ObfuscatedName("t")
   @Export("Interpreter_arrays")
   static int[][] Interpreter_arrays = new int[5][5000];
   @ObfuscatedName("d")
   @Export("Interpreter_intStack")
   static int[] Interpreter_intStack = new int[1000];
   @ObfuscatedName("p")
   @Export("Interpreter_stringStack")
   static String[] Interpreter_stringStack = new String[1000];
   @ObfuscatedName("k")
   @Export("Interpreter_frameDepth")
   static int Interpreter_frameDepth = 0;
   @ObfuscatedName("r")
   @Export("Interpreter_frames")
   static class17[] Interpreter_frames = new class17[50];
   @ObfuscatedName("z")
   @Export("Interpreter_calendar")
   static Calendar Interpreter_calendar = Calendar.getInstance();
   @ObfuscatedName("s")
   @Export("Interpreter_MONTHS")
   static final String[] Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("db")
   @Export("scene")
   @ObfuscatedSignature(
      descriptor = "Lclass94;"
   )
   static Scene scene;

   @ObfuscatedName("w")
   @Export("method276")
   public static String method276(long var0) {
      if (var0 > 0L && var0 < 6582952005840035281L) {
         if (0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class145.base37Table[(int)(var6 - 37L * var0)];
               if (var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("d")
   public static void method270(int var0) {
      class137.musicPlayerStatus = 1;
      class137.musicTrackArchive = null;
      class125.musicTrackGroupId = -1;
      FloorDecoration.musicTrackFileId = -1;
      class147.musicTrackVolume = 0;
      VarbitComposition.musicTrackBoolean = false;
      class65.pcmSampleLength = var0;
   }

   @ObfuscatedName("q")
   static final void method274() {
      class159.method3380();
      Occluder.method2419();
      ArchiveDiskActionHandler.method3323();
      ObjectComposition.ObjectDefinition_cached.method3482();
      ObjectComposition.ObjectDefinition_cachedModelData.method3482();
      ObjectComposition.ObjectDefinition_cachedEntities.method3482();
      ObjectComposition.ObjectDefinition_cachedModels.method3482();
      NPCComposition.NpcDefinition_cached.method3482();
      NPCComposition.NpcDefinition_cachedModels.method3482();
      ItemComposition.ItemDefinition_cached.method3482();
      ItemComposition.ItemDefinition_cachedModels.method3482();
      ItemComposition.ItemDefinition_cachedSprites.method3482();
      TaskHandler.method1623();
      SpotAnimationDefinition.SpotAnimationDefinition_cached.method3482();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.method3482();
      VarbitComposition.VarbitDefinition_cached.method3482();
      FloorUnderlayDefinition.method718();
      PlayerComposition.Widget_cachedSprites.method3482();
      Widget.Widget_cachedModels.method3482();
      Widget.Widget_cachedFonts.method3482();
      Widget.Widget_cachedSpriteMasks.method3482();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2410();
      Script.field68.method3482();
      MusicPatchNode.archive1.method3217();
      class7.archive3.method3217();
      class83.archive4.method3217();
      class7.field102.method3217();
      class146.archive5.method3217();
      class40.archive6.method3217();
      InterfaceParent.archive7.method3217();
      MouseRecorder.archive8.method3217();
      class10.archive9.method3217();
      DynamicObject.archive10.method3217();
      World.archive11.method3217();
      AbstractByteArrayCopier.archive12.method3217();
   }

   @ObfuscatedName("at")
   static final void method275(int var0, int var1, int var2, int var3) {
      Rasterizer2D.method1953(var0, var1, var0 + var2, var3 + var1);
      Rasterizer3D.method2352();
      ++Client.field724;
      NPC.method267(true);
      EnumComposition.method848(true);
      NPC.method267(false);
      EnumComposition.method848(false);

      int var6;
      for(Projectile var4 = (Projectile)Client.field619.method3533(); var4 != null; var4 = (Projectile)Client.field619.method3535()) {
         if (var4.plane == class22.Client_plane && Client.cycle <= var4.cycleEnd) {
            if (Client.cycle >= var4.cycleStart) {
               if (var4.targetIndex > 0) {
                  NPC var34 = Client.npcs[var4.targetIndex - 1];
                  if (var34 != null && var34.x >= 0 && var34.x < 13312 && var34.y >= 0 && var34.y < 13312) {
                     var4.method114(var34.x, var34.y, BufferedFile.method603(var34.x, var34.y, var4.plane) - var4.endHeight, Client.cycle);
                  }
               }

               if (var4.targetIndex < 0) {
                  var6 = -var4.targetIndex - 1;
                  Player var44;
                  if (var6 == Client.localPlayerIndex) {
                     var44 = Tiles.localPlayer;
                  } else {
                     var44 = Client.players[var6];
                  }

                  if (var44 != null && var44.x >= 0 && var44.x < 13312 && var44.y >= 0 && var44.y < 13312) {
                     var4.method114(var44.x, var44.y, BufferedFile.method603(var44.x, var44.y, var4.plane) - var4.endHeight, Client.cycle);
                  }
               }

               var4.method115(Client.field525);
               scene.method2094(class22.Client_plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1, false);
            }
         } else {
            var4.method3567();
         }
      }

      for(GraphicsObject var35 = (GraphicsObject)Client.field620.method3533(); var35 != null; var35 = (GraphicsObject)Client.field620.method3535()) {
         if (var35.plane == class22.Client_plane && !var35.isFinished) {
            if (Client.cycle >= var35.cycleStart) {
               var35.method207(Client.field525);
               if (var35.isFinished) {
                  var35.method3567();
               } else {
                  scene.method2094(var35.plane, var35.x, var35.y, var35.height, 60, var35, 0, -1, false);
               }
            }
         } else {
            var35.method3567();
         }
      }

      int var5;
      int var25;
      if (!Client.field730) {
         var25 = Client.field516;
         if (Client.field568 / 256 > var25) {
            var25 = Client.field568 / 256;
         }

         if (Client.field731[4] && Client.field733[4] + 128 > var25) {
            var25 = Client.field733[4] + 128;
         }

         var5 = Client.field551 + Client.field569 & 2047;
         SceneTilePaint.method2210(Client.field572, BufferedFile.method603(Tiles.localPlayer.x, Tiles.localPlayer.y, class22.Client_plane) - 50, MouseHandler.field1402, var25, var5, var25 * 3 + 600);
      }

      if (!Client.field730) {
         var25 = VarpDefinition.method936();
      } else {
         var25 = Renderable.method2038();
      }

      var5 = Login.cameraX;
      var6 = class22.cameraY;
      int var7 = class17.cameraZ;
      int var8 = NPC.cameraPitch;
      int var9 = MouseRecorder.cameraYaw;

      int var10;
      int var11;
      for(var10 = 0; var10 < 5; ++var10) {
         if (Client.field731[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field575[var10] * 2 + 1) - (double)Client.field575[var10] + Math.sin((double)Client.field735[var10] * ((double)Client.field587[var10] / 100.0D)) * (double)Client.field733[var10]);
            if (var10 == 0) {
               Login.cameraX += var11;
            }

            if (var10 == 1) {
               class22.cameraY += var11;
            }

            if (var10 == 2) {
               class17.cameraZ += var11;
            }

            if (var10 == 3) {
               MouseRecorder.cameraYaw = var11 + MouseRecorder.cameraYaw & 2047;
            }

            if (var10 == 4) {
               NPC.cameraPitch += var11;
               if (NPC.cameraPitch < 128) {
                  NPC.cameraPitch = 128;
               }

               if (NPC.cameraPitch > 383) {
                  NPC.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseHandler.MouseHandler_x;
      var11 = MouseHandler.MouseHandler_y;
      if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         Model.field1917 = true;
         Model.field1920 = 0;
         Model.field1877 = MouseHandler.MouseHandler_x - var0;
         Model.field1919 = MouseHandler.MouseHandler_y - var1;
      } else {
         Model.field1917 = false;
         Model.field1920 = 0;
      }

      SequenceDefinition.method759();
      Rasterizer2D.method1962(var0, var1, var2, var3, 0);
      SequenceDefinition.method759();
      scene.method2171(Login.cameraX, class22.cameraY, class17.cameraZ, NPC.cameraPitch, MouseRecorder.cameraYaw, var25);
      SequenceDefinition.method759();
      scene.method2055();
      Client.field576 = 0;

      int var12;
      int var26;
      for(var12 = -1; var12 < Client.npcCount + Client.field604; ++var12) {
         Object var32;
         if (var12 == -1) {
            var32 = Tiles.localPlayer;
         } else if (var12 < Client.field604) {
            var32 = Client.players[Client.field524[var12]];
         } else {
            var32 = Client.npcs[Client.npcIndices[var12 - Client.field604]];
         }

         if (var32 != null && ((Actor)var32).vmethod281()) {
            NPCComposition var14;
            if (var32 instanceof NPC) {
               var14 = ((NPC)var32).definition;
               if (var14.transforms != null) {
                  var14 = var14.method657();
               }

               if (var14 == null) {
                  continue;
               }
            }

            if (var12 >= Client.field604) {
               var14 = ((NPC)var32).definition;
               if (var14.transforms != null) {
                  var14 = var14.method657();
               }

               if (var14.field811 >= 0 && var14.field811 < class14.mapMarkerSprites.length) {
                  Script.method33((Actor)var32, ((Actor)var32).defaultHeight + 15);
                  if (Client.viewportTempX > -1) {
                     class14.mapMarkerSprites[var14.field811].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 30);
                  }
               }

               if (Client.hintArrowType == 1 && Client.npcIndices[var12 - Client.field604] == Client.field499 && Client.cycle % 20 < 10) {
                  Script.method33((Actor)var32, ((Actor)var32).defaultHeight + 15);
                  if (Client.viewportTempX > -1) {
                     ObjectSound.headIconHintSprites[0].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
                  }
               }
            } else {
               var26 = 30;
               Player var33 = (Player)var32;
               if (var33.headIconPk != -1 || var33.headIconPrayer != -1) {
                  Script.method33((Actor)var32, ((Actor)var32).defaultHeight + 15);
                  if (Client.viewportTempX > -1) {
                     if (var33.headIconPk != -1) {
                        class161.field2711[var33.headIconPk].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - var26);
                        var26 += 25;
                     }

                     if (var33.headIconPrayer != -1) {
                        class14.mapMarkerSprites[var33.headIconPrayer].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - var26);
                        var26 += 25;
                     }
                  }
               }

               if (var12 >= 0 && Client.hintArrowType == 10 && Client.field524[var12] == Client.field500) {
                  Script.method33((Actor)var32, ((Actor)var32).defaultHeight + 15);
                  if (Client.viewportTempX > -1) {
                     ObjectSound.headIconHintSprites[1].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - var26);
                  }
               }
            }

            if (((Actor)var32).field434 != null && (var12 >= Client.field604 || Client.field700 == 0 || Client.field700 == 3 || Client.field700 == 1 && ItemContainer.method203(((Player)var32).field35))) {
               Script.method33((Actor)var32, ((Actor)var32).defaultHeight);
               if (Client.viewportTempX > -1 && Client.field576 < Client.field577) {
                  Client.field581[Client.field576] = class40.fontBold12.method3601(((Actor)var32).field434) / 2;
                  Client.field528[Client.field576] = class40.fontBold12.ascent;
                  Client.field625[Client.field576] = Client.viewportTempX;
                  Client.field722[Client.field576] = Client.viewportTempY;
                  Client.field582[Client.field576] = ((Actor)var32).field436;
                  Client.field583[Client.field576] = ((Actor)var32).field445;
                  Client.field584[Client.field576] = ((Actor)var32).field435;
                  Client.field522[Client.field576] = ((Actor)var32).field434;
                  ++Client.field576;
               }
            }

            if (((Actor)var32).field441 > Client.cycle) {
               Script.method33((Actor)var32, ((Actor)var32).defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  var26 = ((Actor)var32).field431 * 30 / ((Actor)var32).field425;
                  if (var26 > 30) {
                     var26 = 30;
                  }

                  Rasterizer2D.method1962(var0 + Client.viewportTempX - 15, Client.viewportTempY + var1 - 3, var26, 5, 65280);
                  Rasterizer2D.method1962(var26 + (var0 + Client.viewportTempX - 15), Client.viewportTempY + var1 - 3, 30 - var26, 5, 16711680);
               }
            }

            for(var26 = 0; var26 < 4; ++var26) {
               if (((Actor)var32).hitSplatCycles[var26] > Client.cycle) {
                  Script.method33((Actor)var32, ((Actor)var32).defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     if (var26 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var26 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var26 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     MouseRecorder.headIconPrayerSprites[((Actor)var32).hitSplatValues[var26]].method1855(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 12);
                     AccessFile.field762.method3676(Integer.toString(((Actor)var32).hitSplatTypes[var26]), var0 + Client.viewportTempX - 1, Client.viewportTempY + var1 + 3, 16777215, 0);
                  }
               }
            }
         }
      }

      int var13;
      int var15;
      int var16;
      int var18;
      int var21;
      int var27;
      for(var12 = 0; var12 < Client.field576; ++var12) {
         var13 = Client.field625[var12];
         var26 = Client.field722[var12];
         var15 = Client.field581[var12];
         var16 = Client.field528[var12];
         boolean var17 = true;

         while(var17) {
            var17 = false;

            for(var18 = 0; var18 < var12; ++var18) {
               if (var26 + 2 > Client.field722[var18] - Client.field528[var18] && var26 - var16 < Client.field722[var18] + 2 && var13 - var15 < Client.field581[var18] + Client.field625[var18] && var13 + var15 > Client.field625[var18] - Client.field581[var18] && Client.field722[var18] - Client.field528[var18] < var26) {
                  var26 = Client.field722[var18] - Client.field528[var18];
                  var17 = true;
               }
            }
         }

         Client.viewportTempX = Client.field625[var12];
         Client.viewportTempY = Client.field722[var12] = var26;
         String var30 = Client.field522[var12];
         if (Client.chatEffects == 0) {
            int var31 = 16776960;
            if (Client.field582[var12] < 6) {
               var31 = Client.field699[Client.field582[var12]];
            }

            if (Client.field582[var12] == 6) {
               var31 = Client.field724 % 20 < 10 ? 16711680 : 16776960;
            }

            if (Client.field582[var12] == 7) {
               var31 = Client.field724 % 20 < 10 ? 255 : '\uffff';
            }

            if (Client.field582[var12] == 8) {
               var31 = Client.field724 % 20 < 10 ? '뀀' : 8454016;
            }

            if (Client.field582[var12] == 9) {
               var27 = 150 - Client.field584[var12];
               if (var27 < 50) {
                  var31 = var27 * 1280 + 16711680;
               } else if (var27 < 100) {
                  var31 = 16776960 - (var27 - 50) * 327680;
               } else if (var27 < 150) {
                  var31 = (var27 - 100) * 5 + '\uff00';
               }
            }

            if (Client.field582[var12] == 10) {
               var27 = 150 - Client.field584[var12];
               if (var27 < 50) {
                  var31 = var27 * 5 + 16711680;
               } else if (var27 < 100) {
                  var31 = 16711935 - (var27 - 50) * 327680;
               } else if (var27 < 150) {
                  var31 = (var27 - 100) * 327680 + 255 - (var27 - 100) * 5;
               }
            }

            if (Client.field582[var12] == 11) {
               var27 = 150 - Client.field584[var12];
               if (var27 < 50) {
                  var31 = 16777215 - var27 * 327685;
               } else if (var27 < 100) {
                  var31 = (var27 - 50) * 327685 + '\uff00';
               } else if (var27 < 150) {
                  var31 = 16777215 - (var27 - 100) * 327680;
               }
            }

            if (Client.field583[var12] == 0) {
               class40.fontBold12.method3676(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0);
            }

            if (Client.field583[var12] == 1) {
               class40.fontBold12.method3645(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.field724);
            }

            if (Client.field583[var12] == 2) {
               class40.fontBold12.method3611(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.field724);
            }

            if (Client.field583[var12] == 3) {
               class40.fontBold12.method3612(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.field724, 150 - Client.field584[var12]);
            }

            if (Client.field583[var12] == 4) {
               var27 = (150 - Client.field584[var12]) * (class40.fontBold12.method3601(var30) + 100) / 150;
               Rasterizer2D.method1954(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
               class40.fontBold12.method3626(var30, var0 + Client.viewportTempX + 50 - var27, Client.viewportTempY + var1, var31, 0);
               Rasterizer2D.method1953(var0, var1, var0 + var2, var3 + var1);
            }

            if (Client.field583[var12] == 5) {
               var27 = 150 - Client.field584[var12];
               var21 = 0;
               if (var27 < 25) {
                  var21 = var27 - 25;
               } else if (var27 > 125) {
                  var21 = var27 - 125;
               }

               Rasterizer2D.method1954(var0, Client.viewportTempY + var1 - class40.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
               class40.fontBold12.method3676(var30, var0 + Client.viewportTempX, var21 + Client.viewportTempY + var1, var31, 0);
               Rasterizer2D.method1953(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class40.fontBold12.method3676(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
         }
      }

      NPC.method262(var0, var1);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2399(Client.field525);
      if (Client.mouseCrossColor == 1) {
         Client.scrollBarSprites[Client.mouseCrossState / 100].method1855(Client.mouseCrossX - 8, Client.mouseCrossY - 8);
      }

      if (Client.mouseCrossColor == 2) {
         Client.scrollBarSprites[Client.mouseCrossState / 100 + 4].method1855(Client.mouseCrossX - 8, Client.mouseCrossY - 8);
      }

      method272();
      if (Client.field496) {
         var12 = var0 + 512 - 5;
         var13 = var1 + 20;
         VertexNormal.field1511.method3607("Fps:" + GameEngine.fps, var12, var13, 16776960, -1);
         var13 += 15;
         Runtime var36 = Runtime.getRuntime();
         var15 = (int)((var36.totalMemory() - var36.freeMemory()) / 1024L);
         var16 = 16776960;
         if (var15 > 32768 && Client.isLowDetail) {
            var16 = 16711680;
         }

         if (var15 > 65536 && !Client.isLowDetail) {
            var16 = 16711680;
         }

         VertexNormal.field1511.method3607("Mem:" + var15 + "k", var12, var13, var16, -1);
         var13 += 15;
      }

      Login.cameraX = var5;
      class22.cameraY = var6;
      class17.cameraZ = var7;
      NPC.cameraPitch = var8;
      MouseRecorder.cameraYaw = var9;
      if (Client.field489 && class136.method2869(true, false) == 0) {
         Client.field489 = false;
      }

      if (Client.field489) {
         Rasterizer2D.method1962(var0, var1, var2, var3, 0);
         class27.method570("Loading - please wait.", false);
      }

      if (!Client.field489 && !Client.isMenuOpen && var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
            ArchiveDisk.method1503("Walk here", "", 23, 0, var10 - var0, var11 - var1);
         }

         var12 = -1;

         for(var13 = 0; var13 < Model.field1920; ++var13) {
            var26 = Model.field1921[var13];
            var15 = var26 & 127;
            var16 = var26 >> 7 & 127;
            int var37 = var26 >> 29 & 3;
            var18 = var26 >> 14 & 32767;
            if (var26 != var12) {
               var12 = var26;
               if (var37 == 2 && scene.method2071(class22.Client_plane, var15, var16, var26) >= 0) {
                  ObjectComposition var19 = GameBuild.getObjectComposition(var18);
                  if (var19.transforms != null) {
                     var19 = var19.method673();
                  }

                  if (var19 == null) {
                     continue;
                  }

                  if (Client.isItemSelected == 1) {
                     ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(65535) + var19.name, 1, var26, var15, var16);
                  } else if (Client.isSpellSelected) {
                     if ((FaceNormal.field1523 & 4) == 4) {
                        ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(65535) + var19.name, 2, var26, var15, var16);
                     }
                  } else {
                     String[] var20 = var19.actions;
                     if (Client.field511) {
                        var20 = Tile.method2299(var20);
                     }

                     if (var20 != null) {
                        for(var21 = 4; var21 >= 0; --var21) {
                           if (var20[var21] != null) {
                              short var22 = 0;
                              if (var21 == 0) {
                                 var22 = 3;
                              }

                              if (var21 == 1) {
                                 var22 = 4;
                              }

                              if (var21 == 2) {
                                 var22 = 5;
                              }

                              if (var21 == 3) {
                                 var22 = 6;
                              }

                              if (var21 == 4) {
                                 var22 = 1001;
                              }

                              ArchiveDisk.method1503(var20[var21], ScriptEvent.method0(65535) + var19.name, var22, var26, var15, var16);
                           }
                        }
                     }

                     ArchiveDisk.method1503("Examine", ScriptEvent.method0(65535) + var19.name, 1002, var19.id << 14, var15, var16);
                  }
               }

               NPC var28;
               Player var42;
               if (var37 == 1) {
                  NPC var38 = Client.npcs[var18];
                  if (var38.definition.size == 1 && (var38.x & 127) == 64 && (var38.y & 127) == 64) {
                     for(var27 = 0; var27 < Client.npcCount; ++var27) {
                        var28 = Client.npcs[Client.npcIndices[var27]];
                        if (var28 != null && var28 != var38 && var28.definition.size == 1 && var38.x == var28.x && var28.y == var38.y) {
                           Tile.method2300(var28.definition, Client.npcIndices[var27], var15, var16);
                        }
                     }

                     for(var27 = 0; var27 < Client.field604; ++var27) {
                        var42 = Client.players[Client.field524[var27]];
                        if (var42 != null && var42.x == var38.x && var42.y == var38.y) {
                           Actor.method297(var42, Client.field524[var27], var15, var16);
                        }
                     }
                  }

                  Tile.method2300(var38.definition, var18, var15, var16);
               }

               if (var37 == 0) {
                  Player var39 = Client.players[var18];
                  if ((var39.x & 127) == 64 && (var39.y & 127) == 64) {
                     for(var27 = 0; var27 < Client.npcCount; ++var27) {
                        var28 = Client.npcs[Client.npcIndices[var27]];
                        if (var28 != null && var28.definition.size == 1 && var28.x == var39.x && var28.y == var39.y) {
                           Tile.method2300(var28.definition, Client.npcIndices[var27], var15, var16);
                        }
                     }

                     for(var27 = 0; var27 < Client.field604; ++var27) {
                        var42 = Client.players[Client.field524[var27]];
                        if (var42 != null && var39 != var42 && var42.x == var39.x && var39.y == var42.y) {
                           Actor.method297(var42, Client.field524[var27], var15, var16);
                        }
                     }
                  }

                  Actor.method297(var39, var18, var15, var16);
               }

               if (var37 == 3) {
                  NodeDeque var40 = Client.groundItems[class22.Client_plane][var15][var16];
                  if (var40 != null) {
                     for(TileItem var41 = (TileItem)var40.method3554(); var41 != null; var41 = (TileItem)var40.method3561()) {
                        ItemComposition var43 = class27.method571(var41.id);
                        if (Client.isItemSelected == 1) {
                           ArchiveDisk.method1503("Use", Client.selectedItemName + " " + "->" + " " + ScriptEvent.method0(16748608) + var43.name, 16, var41.id, var15, var16);
                        } else if (Client.isSpellSelected) {
                           if ((FaceNormal.field1523 & 1) == 1) {
                              ArchiveDisk.method1503(Client.field641, Client.field594 + " " + "->" + " " + ScriptEvent.method0(16748608) + var43.name, 17, var41.id, var15, var16);
                           }
                        } else {
                           String[] var29 = var43.groundActions;
                           if (Client.field511) {
                              var29 = Tile.method2299(var29);
                           }

                           for(int var23 = 4; var23 >= 0; --var23) {
                              if (var29 != null && var29[var23] != null) {
                                 byte var24 = 0;
                                 if (var23 == 0) {
                                    var24 = 18;
                                 }

                                 if (var23 == 1) {
                                    var24 = 19;
                                 }

                                 if (var23 == 2) {
                                    var24 = 20;
                                 }

                                 if (var23 == 3) {
                                    var24 = 21;
                                 }

                                 if (var23 == 4) {
                                    var24 = 22;
                                 }

                                 ArchiveDisk.method1503(var29[var23], ScriptEvent.method0(16748608) + var43.name, var24, var41.id, var15, var16);
                              } else if (var23 == 2) {
                                 ArchiveDisk.method1503("Take", ScriptEvent.method0(16748608) + var43.name, 20, var41.id, var15, var16);
                              }
                           }

                           ArchiveDisk.method1503("Examine", ScriptEvent.method0(16748608) + var43.name, 1004, var41.id, var15, var16);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   static final void method272() {
      Client.xPadding = 0;
      int var0 = (Tiles.localPlayer.x >> 7) + FaceNormal.baseX;
      int var1 = (Tiles.localPlayer.y >> 7) + Frames.baseY;
      if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.xPadding = 1;
      }

      if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.xPadding = 1;
      }

      if (Client.xPadding == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.xPadding = 0;
      }

   }
}
