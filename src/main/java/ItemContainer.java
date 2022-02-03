import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("oq")
   @Export("taskHandler")
   @ObfuscatedSignature(
      descriptor = "Lclass73;"
   )
   public static TaskHandler taskHandler;
   @ObfuscatedName("mt")
   @Export("pcmStreamMixer")
   @ObfuscatedSignature(
      descriptor = "Lclass45;"
   )
   static PcmStreamMixer pcmStreamMixer;
   @ObfuscatedName("hz")
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("i")
   @Export("itemContainers")
   @ObfuscatedSignature(
      descriptor = "Lclass174;"
   )
   static NodeHashTable itemContainers = new NodeHashTable(32);
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lclass157;"
   )
   static Widget field286;
   @ObfuscatedName("ag")
   static long field289;
   @ObfuscatedName("w")
   @Export("ids")
   int[] ids = new int[]{-1};
   @ObfuscatedName("f")
   @Export("quantities")
   int[] quantities = new int[]{0};

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass72;)V"
   )
   static void method188(GameEngine var0) {
      if (Login.worldSelectOpen) {
         class23.method248(var0);
      } else {
         if (MouseHandler.PacketBufferNode_packetBufferNodeCount == 1 && MouseHandler.MouseHandler_lastPressedX >= 715 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            Projectile.clientPreferences.titleMusicDisabled = !Projectile.clientPreferences.titleMusicDisabled;
            class17.method185();
            if (!Projectile.clientPreferences.titleMusicDisabled) {
               //Player.method23(class40.archive6, "scape main", "", 255, false);
            } else {
               class137.midiPcmStream.method2951();
               class137.musicPlayerStatus = 1;
               class137.musicTrackArchive = null;
            }
         }

         if (Client.gameState != 5) {
            ++Login.field330;
            if (Client.gameState == 10) {
               if (MouseHandler.PacketBufferNode_packetBufferNodeCount == 1) {
                  byte var1 = 5;
                  short var2 = 463;
                  byte var3 = 100;
                  byte var4 = 35;
                  if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var3 + var1 && MouseHandler.MouseHandler_lastPressedY >= var2 && MouseHandler.MouseHandler_lastPressedY <= var4 + var2) {
                     EnumComposition.method850();
                     return;
                  }
               }

               if (Projectile.field171 != null) {
                  EnumComposition.method850();
               }

               int var9 = MouseHandler.PacketBufferNode_packetBufferNodeCount;
               int var10 = MouseHandler.MouseHandler_lastPressedX;
               int var11 = MouseHandler.MouseHandler_lastPressedY;
               short var5;
               short var12;
               if (Login.field351 == 0) {
                  var12 = 302;
                  var5 = 291;
                  if (var9 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     Login.field351 = 3;
                     Login.field340 = 0;
                  }

                  var12 = 462;
                  if (var9 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     Login.Login_response1 = "";
                     Login.Login_response2 = "Enter your username/email & password.";
                     Login.Login_response3 = "";
                     Login.field351 = 2;
                     Login.field340 = 0;
                  }
               } else if (Login.field351 == 2) {
                  var12 = 231;
                  int var13 = var12 + 30;
                  if (var9 == 1 && var11 >= var13 - 15 && var11 < var13) {
                     Login.field340 = 0;
                  }

                  var13 += 15;
                  if (var9 == 1 && var11 >= var13 - 15 && var11 < var13) {
                     Login.field340 = 1;
                  }

                  var13 += 15;
                  var5 = 302;
                  short var6 = 321;
                  if (var9 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     Login.field338 = Login.field338.trim();
                     if (Login.field338.length() == 0) {
                        BufferedFile.method624("", "Please enter your username/email address.", "");
                        return;
                     }

                     if (Login.field339.length() == 0) {
                        BufferedFile.method624("", "Please enter your password.", "");
                        return;
                     }

                     BufferedFile.method624("", "Connecting to server...", "");
                     NPC.method260(20);
                     return;
                  }

                  var5 = 462;
                  if (var9 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     Login.field351 = 0;
                     Login.field338 = "";
                     Login.field339 = "";
                  }

                  while(true) {
                     while(Client.method530()) {
                        boolean var7 = false;

                        for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var8) {
                           if (IsaacCipher.field2000 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var8)) {
                              var7 = true;
                              break;
                           }
                        }

                        if (Login.field340 == 0) {
                           if (VarbitComposition.field966 == 85 && Login.field338.length() > 0) {
                              Login.field338 = Login.field338.substring(0, Login.field338.length() - 1);
                           }

                           if (VarbitComposition.field966 == 84 || VarbitComposition.field966 == 80) {
                              Login.field340 = 1;
                           }

                           if (var7 && Login.field338.length() < 320) {
                              Login.field338 = Login.field338 + IsaacCipher.field2000;
                           }
                        } else if (Login.field340 == 1) {
                           if (VarbitComposition.field966 == 85 && Login.field339.length() > 0) {
                              Login.field339 = Login.field339.substring(0, Login.field339.length() - 1);
                           }

                           if (VarbitComposition.field966 == 84 || VarbitComposition.field966 == 80) {
                              Login.field340 = 0;
                           }

                           if (VarbitComposition.field966 == 84) {
                              Login.field338 = Login.field338.trim();
                              if (Login.field338.length() == 0) {
                                 BufferedFile.method624("", "Please enter your username/email address.", "");
                                 return;
                              }

                              if (Login.field339.length() == 0) {
                                 BufferedFile.method624("", "Please enter your password.", "");
                                 return;
                              }

                              BufferedFile.method624("", "Connecting to server...", "");
                              NPC.method260(20);
                              return;
                           }

                           if (var7 && Login.field339.length() < 20) {
                              Login.field339 = Login.field339 + IsaacCipher.field2000;
                           }
                        }
                     }

                     return;
                  }
               } else if (Login.field351 == 3) {
                  var12 = 382;
                  var5 = 321;
                  if (var9 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     Login.field351 = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("w")
   static final void method199(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   static void method186() {
      try {
         File var0 = new File(TextureProvider.userHomeDirectory, "random.dat");
         int var2;
         if (var0.exists()) {
            JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class23.field382.length; ++var1) {
               for(var2 = 0; var2 < ClientPreferences.field187.length; ++var2) {
                  File var3 = new File(ClientPreferences.field187[var2] + class23.field382[var1] + File.separatorChar + "random.dat");
                  if (var3.exists()) {
                     JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if (JagexCache.JagexCache_randomDat == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Lclass26;)V"
   )
   static final void method205(Actor var0) {
      var0.isWalking = false;
      SequenceDefinition var1;
      if (var0.movementSequence != -1) {
         var1 = class23.method250(var0.movementSequence);
         if (var1 != null && var1.frameIds != null) {
            ++var0.field449;
            if (var0.movementFrame < var1.frameIds.length && var0.field449 > var1.frameLengths[var0.movementFrame]) {
               var0.field449 = 1;
               ++var0.movementFrame;
               class14.method165(var1, var0.movementFrame, var0.x, var0.y);
            }

            if (var0.movementFrame >= var1.frameIds.length) {
               var0.field449 = 0;
               var0.movementFrame = 0;
               class14.method165(var1, var0.movementFrame, var0.x, var0.y);
            }
         } else {
            var0.movementSequence = -1;
         }
      }

      if (var0.spotAnimation != -1 && Client.cycle >= var0.field458) {
         if (var0.spotAnimationFrame < 0) {
            var0.spotAnimationFrame = 0;
         }

         int var3 = NPCComposition.method656(var0.spotAnimation).sequence;
         if (var3 != -1) {
            SequenceDefinition var2 = class23.method250(var3);
            if (var2 != null && var2.frameIds != null) {
               ++var0.spotAnimationFrameCycle;
               if (var0.spotAnimationFrame < var2.frameIds.length && var0.spotAnimationFrameCycle > var2.frameLengths[var0.spotAnimationFrame]) {
                  var0.spotAnimationFrameCycle = 1;
                  ++var0.spotAnimationFrame;
                  class14.method165(var2, var0.spotAnimationFrame, var0.x, var0.y);
               }

               if (var0.spotAnimationFrame >= var2.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var2.frameIds.length)) {
                  var0.spotAnimation = -1;
               }
            } else {
               var0.spotAnimation = -1;
            }
         } else {
            var0.spotAnimation = -1;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
         var1 = class23.method250(var0.sequence);
         if (var1.field899 == 1 && var0.field472 > 0 && var0.field456 <= Client.cycle && var0.field465 < Client.cycle) {
            var0.sequenceDelay = 1;
            return;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay == 0) {
         var1 = class23.method250(var0.sequence);
         if (var1 != null && var1.frameIds != null) {
            ++var0.sequenceFrameCycle;
            if (var0.sequenceFrame < var1.frameIds.length && var0.sequenceFrameCycle > var1.frameLengths[var0.sequenceFrame]) {
               var0.sequenceFrameCycle = 1;
               ++var0.sequenceFrame;
               class14.method165(var1, var0.sequenceFrame, var0.x, var0.y);
            }

            if (var0.sequenceFrame >= var1.frameIds.length) {
               var0.sequenceFrame -= var1.frameCount;
               ++var0.field421;
               if (var0.field421 >= var1.field898) {
                  var0.sequence = -1;
               } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var1.frameIds.length) {
                  class14.method165(var1, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
               }
            }

            var0.isWalking = var1.field902;
         } else {
            var0.sequence = -1;
         }
      }

      if (var0.sequenceDelay > 0) {
         --var0.sequenceDelay;
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      descriptor = "(Lclass157;I)I"
   )
   static final int method200(Widget var0, int var1) {
      if (var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
         try {
            int[] var2 = var0.cs1Instructions[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if (var6 == 0) {
                  return var3;
               }

               if (var6 == 1) {
                  var7 = Client.field621[var2[var4++]];
               }

               if (var6 == 2) {
                  var7 = Client.levels[var2[var4++]];
               }

               if (var6 == 3) {
                  var7 = Client.field529[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if (var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class130.method2851(var9);
                  var11 = var2[var4++];
                  if (var11 != -1 && (!class27.method571(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if (var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if (var6 == 5) {
                  var7 = Varps.Varps_main[var2[var4++]];
               }

               if (var6 == 6) {
                  var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
               }

               if (var6 == 7) {
                  var7 = Varps.Varps_main[var2[var4++]] * 100 / '뜛';
               }

               if (var6 == 8) {
                  var7 = Tiles.localPlayer.combatLevel;
               }

               if (var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if (Skills.Skills_enabled[var9]) {
                        var7 += Client.levels[var9];
                     }
                  }
               }

               if (var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class130.method2851(var9);
                  var11 = var2[var4++];
                  if (var11 != -1 && (!class27.method571(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if (var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if (var6 == 11) {
                  var7 = Client.field648;
               }

               if (var6 == 12) {
                  var7 = Client.field558;
               }

               if (var6 == 13) {
                  var9 = Varps.Varps_main[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
               }

               if (var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class133.method2863(var9);
               }

               if (var6 == 15) {
                  var8 = 1;
               }

               if (var6 == 16) {
                  var8 = 2;
               }

               if (var6 == 17) {
                  var8 = 3;
               }

               if (var6 == 18) {
                  var7 = (Tiles.localPlayer.x >> 7) + FaceNormal.baseX;
               }

               if (var6 == 19) {
                  var7 = (Tiles.localPlayer.y >> 7) + Frames.baseY;
               }

               if (var6 == 20) {
                  var7 = var2[var4++];
               }

               if (var8 == 0) {
                  if (var5 == 0) {
                     var3 += var7;
                  }

                  if (var5 == 1) {
                     var3 -= var7;
                  }

                  if (var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if (var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("ce")
   static boolean method203(String var0) {
      if (var0 == null) {
         return false;
      } else {
         String var1 = Projectile.method125(var0, class5.field75);

         for(int var2 = 0; var2 < Client.field736; ++var2) {
            if (var1.equalsIgnoreCase(Projectile.method125(Client.field532[var2].field381, class5.field75))) {
               return true;
            }
         }

         if (var0.equalsIgnoreCase(Projectile.method125(Tiles.localPlayer.field35, class5.field75))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
