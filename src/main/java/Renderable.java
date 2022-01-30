import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cr")
@Implements("Renderable")
public abstract class Renderable extends DualNode {
   @ObfuscatedName("kv")
   static int field1546;
   @ObfuscatedName("bt")
   @Export("height")
   public int height = 1000;

   @ObfuscatedName("w")
   @Export("vmethod2030")
   @ObfuscatedSignature(
      descriptor = "()Lclass111;"
   )
   protected Model vmethod2030() {
      return null;
   }

   @ObfuscatedName("ae")
   void vmethod2441(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.vmethod2030();
      if (var10 != null) {
         this.height = var10.height;
         var10.vmethod2441(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lclass0;)V"
   )
   static void method2040(ScriptEvent var0) {
      Object[] var1 = var0.args;
      int var2 = (Integer)var1[0];
      Script var3 = Tile.method2297(var2);
      if (var3 != null) {
         int var4 = 0;
         int var5 = 0;
         int var6 = -1;
         int[] var7 = var3.field61;
         int[] var8 = var3.field62;
         byte var9 = -1;
         Interpreter.Interpreter_frameDepth = 0;

         int var12;
         try {
            Interpreter.field406 = new int[var3.field64];
            int var10 = 0;
            Interpreter.field407 = new String[var3.field65];
            int var11 = 0;

            int var13;
            String var32;
            for(var12 = 1; var12 < var1.length; ++var12) {
               if (var1[var12] instanceof Integer) {
                  var13 = (Integer)var1[var12];
                  if (var13 == -2147483647) {
                     var13 = var0.field2;
                  }

                  if (var13 == -2147483646) {
                     var13 = var0.field7;
                  }

                  if (var13 == -2147483645) {
                     var13 = var0.widget != null ? var0.widget.id * -257050011 * -1026201747 : -1;
                  }

                  if (var13 == -2147483644) {
                     var13 = var0.field3;
                  }

                  if (var13 == -2147483643) {
                     var13 = var0.widget != null ? var0.widget.childIndex * -837358285 * -819014149 : -1;
                  }

                  if (var13 == -2147483642) {
                     var13 = var0.field5 != null ? var0.field5.id * -257050011 * -1026201747 : -1;
                  }

                  if (var13 == -2147483641) {
                     var13 = var0.field5 != null ? var0.field5.childIndex * -837358285 * -819014149 : -1;
                  }

                  if (var13 == -2147483640) {
                     var13 = var0.field4;
                  }

                  if (var13 == -2147483639) {
                     var13 = var0.field9;
                  }

                  Interpreter.field406[var10++] = var13;
               } else if (var1[var12] instanceof String) {
                  var32 = (String)var1[var12];
                  if (var32.equals("event_opbase")) {
                     var32 = var0.field8;
                  }

                  Interpreter.field407[var11++] = var32;
               }
            }

            var12 = 0;

            label3012:
            while(true) {
               ++var12;
               if (var12 > 200000) {
                  throw new RuntimeException();
               }

               ++var6;
               int var46 = var7[var6];
               int var14;
               int var18;
               int var19;
               int var20;
               int var33;
               int var35;
               int var39;
               int[] var53;
               String[] var56;
               byte[] var59;
               String var84;
               String var87;
               byte var95;
               String var97;
               if (var46 < 100) {
                  if (var46 == ScriptOpcodes.ICONST) {
                     Interpreter.Interpreter_intStack[var4++] = var8[var6];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.GET_VARP) {
                     var13 = var8[var6];
                     Interpreter.Interpreter_intStack[var4++] = Varps.Varps_main[var13];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SET_VARP) {
                     var13 = var8[var6];
                     --var4;
                     Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[var4];
                     PendingSpawn.method243(var13);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SCONST) {
                     Interpreter.Interpreter_stringStack[var5++] = var3.field69[var6];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.JUMP) {
                     var6 += var8[var6];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPNE) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] != Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPEQ) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] == Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPLT) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] < Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPGT) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] > Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.RETURN) {
                     if (Interpreter.Interpreter_frameDepth == 0) {
                        return;
                     }

                     class17 var82 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                     var3 = var82.field279;
                     var7 = var3.field61;
                     var8 = var3.field62;
                     var6 = var82.field282;
                     Interpreter.field406 = var82.field280;
                     Interpreter.field407 = var82.field281;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.GET_VARBIT) {
                     var13 = var8[var6];
                     Interpreter.Interpreter_intStack[var4++] = class133.method2863(var13);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SET_VARBIT) {
                     var13 = var8[var6];
                     --var4;
                     var14 = Interpreter.Interpreter_intStack[var4];
                     VarbitComposition var68 = (VarbitComposition)VarbitComposition.VarbitDefinition_cached.method3474((long)var13);
                     VarbitComposition var75;
                     if (var68 != null) {
                        var75 = var68;
                     } else {
                        var59 = VarbitComposition.VarbitDefinition_archive.method3204(14, var13);
                        var68 = new VarbitComposition();
                        if (var59 != null) {
                           var68.method830(new Buffer(var59));
                        }

                        VarbitComposition.VarbitDefinition_cached.method3473(var68, (long)var13);
                        var75 = var68;
                     }

                     var33 = var75.baseVar;
                     var18 = var75.startBit;
                     var19 = var75.endBit;
                     var20 = Varps.Varps_masks[var19 - var18];
                     if (var14 < 0 || var14 > var20) {
                        var14 = 0;
                     }

                     var20 <<= var18;
                     Varps.Varps_main[var33] = Varps.Varps_main[var33] & ~var20 | var14 << var18 & var20;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPLE) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] <= Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.IF_ICMPGE) {
                     var4 -= 2;
                     if (Interpreter.Interpreter_intStack[var4] >= Interpreter.Interpreter_intStack[var4 + 1]) {
                        var6 += var8[var6];
                     }
                     continue;
                  }

                  if (var46 == ScriptOpcodes.ILOAD) {
                     Interpreter.Interpreter_intStack[var4++] = Interpreter.field406[var8[var6]];
                     continue;
                  }

                  int var10001;
                  if (var46 == ScriptOpcodes.ISTORE) {
                     var10001 = var8[var6];
                     --var4;
                     Interpreter.field406[var10001] = Interpreter.Interpreter_intStack[var4];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SLOAD) {
                     Interpreter.Interpreter_stringStack[var5++] = Interpreter.field407[var8[var6]];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SSTORE) {
                     var10001 = var8[var6];
                     --var5;
                     Interpreter.field407[var10001] = Interpreter.Interpreter_stringStack[var5];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.JOIN_STRING) {
                     var13 = var8[var6];
                     var5 -= var13;
                     String[] var74 = Interpreter.Interpreter_stringStack;
                     if (var13 == ScriptOpcodes.ICONST) {
                        var97 = "";
                     } else if (var13 == ScriptOpcodes.GET_VARP) {
                        String var67 = var74[var5];
                        if (var67 == null) {
                           var97 = "null";
                        } else {
                           var97 = var67.toString();
                        }
                     } else {
                        var35 = var5 + var13;
                        var33 = 0;

                        for(var18 = var5; var18 < var35; ++var18) {
                           var84 = var74[var18];
                           if (var84 == null) {
                              var33 += 4;
                           } else {
                              var33 += var84.length();
                           }
                        }

                        StringBuilder var93 = new StringBuilder(var33);

                        for(var19 = var5; var19 < var35; ++var19) {
                           var87 = var74[var19];
                           if (var87 == null) {
                              var93.append("null");
                           } else {
                              var93.append(var87);
                           }
                        }

                        var97 = var93.toString();
                     }

                     Interpreter.Interpreter_stringStack[var5++] = var97;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.POP_INT) {
                     --var4;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.POP_STRING) {
                     --var5;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.INVOKE) {
                     var13 = var8[var6];
                     Script var102 = Tile.method2297(var13);
                     var53 = new int[var102.field64];
                     var56 = new String[var102.field65];

                     for(var33 = 0; var33 < var102.field66; ++var33) {
                        var53[var33] = Interpreter.Interpreter_intStack[var33 + (var4 - var102.field66)];
                     }

                     for(var33 = 0; var33 < var102.field70; ++var33) {
                        var56[var33] = Interpreter.Interpreter_stringStack[var33 + (var5 - var102.field70)];
                     }

                     var4 -= var102.field66;
                     var5 -= var102.field70;
                     class17 var77 = new class17();
                     var77.field279 = var3;
                     var77.field282 = var6;
                     var77.field280 = Interpreter.field406;
                     var77.field281 = Interpreter.field407;
                     Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var77;
                     var3 = var102;
                     var7 = var102.field61;
                     var8 = var102.field62;
                     var6 = -1;
                     Interpreter.field406 = var53;
                     Interpreter.field407 = var56;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.GET_VARC_INT) {
                     Interpreter.Interpreter_intStack[var4++] = Client.field677[var8[var6]];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SET_VARC_INT) {
                     var10001 = var8[var6];
                     --var4;
                     Client.field677[var10001] = Interpreter.Interpreter_intStack[var4];
                     continue;
                  }

                  if (var46 == ScriptOpcodes.DEFINE_ARRAY) {
                     var13 = var8[var6] >> 16;
                     var14 = var8[var6] & '\uffff';
                     --var4;
                     var39 = Interpreter.Interpreter_intStack[var4];
                     if (var39 >= 0 && var39 <= 5000) {
                        Interpreter.Interpreter_arrayLengths[var13] = var39;
                        var95 = -1;
                        if (var14 == 105) {
                           var95 = 0;
                        }

                        var33 = 0;

                        while(true) {
                           if (var33 >= var39) {
                              continue label3012;
                           }

                           Interpreter.Interpreter_arrays[var13][var33] = var95;
                           ++var33;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if (var46 == ScriptOpcodes.GET_ARRAY_INT) {
                     var13 = var8[var6];
                     --var4;
                     var14 = Interpreter.Interpreter_intStack[var4];
                     if (var14 >= 0 && var14 < Interpreter.Interpreter_arrayLengths[var13]) {
                        Interpreter.Interpreter_intStack[var4++] = Interpreter.Interpreter_arrays[var13][var14];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if (var46 == ScriptOpcodes.SET_ARRAY_INT) {
                     var13 = var8[var6];
                     var4 -= 2;
                     var14 = Interpreter.Interpreter_intStack[var4];
                     if (var14 >= 0 && var14 < Interpreter.Interpreter_arrayLengths[var13]) {
                        Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[var4 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if (var46 == ScriptOpcodes.GET_VARC_STRING_OLD) {
                     var32 = Client.field678[var8[var6]];
                     if (var32 == null) {
                        var32 = "null";
                     }

                     Interpreter.Interpreter_stringStack[var5++] = var32;
                     continue;
                  }

                  if (var46 == ScriptOpcodes.SET_VARC_STRING_OLD) {
                     var10001 = var8[var6];
                     --var5;
                     Client.field678[var10001] = Interpreter.Interpreter_stringStack[var5];
                     continue;
                  }
               }

               boolean var60;
               if (var8[var6] == 1) {
                  var60 = true;
               } else {
                  var60 = false;
               }

               Widget var16;
               Widget var34;
               Widget var52;
               if (var46 < 1000) {
                  if (var46 == ScriptOpcodes.CC_CREATE) {
                     var4 -= 3;
                     var14 = Interpreter.Interpreter_intStack[var4];
                     var39 = Interpreter.Interpreter_intStack[var4 + 1];
                     var35 = Interpreter.Interpreter_intStack[var4 + 2];
                     if (var39 == 0) {
                        throw new RuntimeException();
                     }

                     var52 = class130.method2851(var14);
                     if (var52.children == null) {
                        var52.children = new Widget[var35 + 1];
                     }

                     if (var52.children.length <= var35) {
                        Widget[] var91 = new Widget[var35 + 1];

                        for(var19 = 0; var19 < var52.children.length; ++var19) {
                           var91[var19] = var52.children[var19];
                        }

                        var52.children = var91;
                     }

                     if (var35 > 0 && var52.children[var35 - 1] == null) {
                        throw new RuntimeException("" + (var35 - 1));
                     }

                     Widget var92 = new Widget();
                     var92.type = var39;
                     var92.parentId = var92.id = var52.id;
                     var92.childIndex = var35;
                     var92.isIf3 = true;
                     var52.children[var35] = var92;
                     if (var60) {
                        Skills.field2054 = var92;
                     } else {
                        ItemContainer.field286 = var92;
                     }

                     class82.method1754(var52);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.CC_DELETE) {
                     var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                     Widget var72 = class130.method2851(var34.id);
                     var72.children[var34.childIndex] = null;
                     class82.method1754(var72);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.CC_DELETEALL) {
                     --var4;
                     var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                     var34.children = null;
                     class82.method1754(var34);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.CC_FIND) {
                     var4 -= 2;
                     var14 = Interpreter.Interpreter_intStack[var4];
                     var39 = Interpreter.Interpreter_intStack[var4 + 1];
                     var16 = AbstractArchive.method3230(var14, var39);
                     if (var16 != null && var39 != -1) {
                        Interpreter.Interpreter_intStack[var4++] = 1;
                        if (var60) {
                           Skills.field2054 = var16;
                        } else {
                           ItemContainer.field286 = var16;
                        }
                        continue;
                     }

                     Interpreter.Interpreter_intStack[var4++] = 0;
                     continue;
                  }
               } else if (var46 >= 1000 && var46 < 1100 || var46 >= 2000 && var46 < 2100) {
                  if (var46 >= 2000) {
                     var46 -= 1000;
                     --var4;
                     var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                  } else {
                     var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                  }

                  if (var46 == ScriptOpcodes.CC_SETPOSITION) {
                     var4 -= 2;
                     var34.rawX = Interpreter.Interpreter_intStack[var4];
                     var34.field2579 = Interpreter.Interpreter_intStack[var4 + 1];
                     class82.method1754(var34);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.CC_SETSIZE) {
                     var4 -= 2;
                     var34.width = Interpreter.Interpreter_intStack[var4];
                     var34.height = Interpreter.Interpreter_intStack[var4 + 1];
                     class82.method1754(var34);
                     continue;
                  }

                  if (var46 == ScriptOpcodes.CC_SETHIDE) {
                     --var4;
                     boolean var100 = Interpreter.Interpreter_intStack[var4] == 1;
                     if (var100 != var34.field2588) {
                        var34.field2588 = var100;
                        class82.method1754(var34);
                     }
                     continue;
                  }
               } else {
                  String var15;
                  if ((var46 < 1100 || var46 >= 1200) && (var46 < 2100 || var46 >= 2200)) {
                     if ((var46 < 1200 || var46 >= 1300) && (var46 < 2200 || var46 >= 2300)) {
                        if (var46 >= 1300 && var46 < 1400 || var46 >= 2300 && var46 < 2400) {
                           if (var46 >= 2000) {
                              var46 -= 1000;
                              --var4;
                              var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                           } else {
                              var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                           }

                           if (var46 == ScriptOpcodes.CC_SETOP) {
                              --var4;
                              var39 = Interpreter.Interpreter_intStack[var4] - 1;
                              if (var39 >= 0 && var39 <= 9) {
                                 --var5;
                                 var34.method3339(var39, Interpreter.Interpreter_stringStack[var5]);
                                 continue;
                              }

                              --var5;
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETDRAGGABLE) {
                              var4 -= 2;
                              var39 = Interpreter.Interpreter_intStack[var4];
                              var35 = Interpreter.Interpreter_intStack[var4 + 1];
                              var34.parent = AbstractArchive.method3230(var39, var35);
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETDRAGGABLEBEHAVIOR) {
                              --var4;
                              var34.isScrollBar = Interpreter.Interpreter_intStack[var4] == 1;
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETDRAGDEADZONE) {
                              --var4;
                              var34.field2567 = Interpreter.Interpreter_intStack[var4];
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETDRAGDEADTIME) {
                              --var4;
                              var34.field2640 = Interpreter.Interpreter_intStack[var4];
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETOPBASE) {
                              --var5;
                              var34.field2636 = Interpreter.Interpreter_stringStack[var5];
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_SETTARGETVERB) {
                              --var5;
                              var34.spellActionName = Interpreter.Interpreter_stringStack[var5];
                              continue;
                           }

                           if (var46 == ScriptOpcodes.CC_CLEAROPS) {
                              var34.actions = null;
                              continue;
                           }
                        } else {
                           int[] var49;
                           if (var46 >= 1400 && var46 < 1500 || var46 >= 2400 && var46 < 2500) {
                              if (var46 >= 2000) {
                                 var46 -= 1000;
                                 --var4;
                                 var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                              } else {
                                 var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                              }

                              --var5;
                              var15 = Interpreter.Interpreter_stringStack[var5];
                              var49 = null;
                              if (var15.length() > 0 && var15.charAt(var15.length() - 1) == 'Y') {
                                 --var4;
                                 var33 = Interpreter.Interpreter_intStack[var4];
                                 if (var33 > 0) {
                                    for(var49 = new int[var33]; var33-- > 0; var49[var33] = Interpreter.Interpreter_intStack[var4]) {
                                       --var4;
                                    }
                                 }

                                 var15 = var15.substring(0, var15.length() - 1);
                              }

                              Object[] var65 = new Object[var15.length() + 1];

                              for(var18 = var65.length - 1; var18 >= 1; --var18) {
                                 if (var15.charAt(var18 - 1) == 's') {
                                    --var5;
                                    var65[var18] = Interpreter.Interpreter_stringStack[var5];
                                 } else {
                                    --var4;
                                    var65[var18] = new Integer(Interpreter.Interpreter_intStack[var4]);
                                 }
                              }

                              --var4;
                              var18 = Interpreter.Interpreter_intStack[var4];
                              if (var18 != -1) {
                                 var65[0] = new Integer(var18);
                              } else {
                                 var65 = null;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONCLICK) {
                                 var34.field2645 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONHOLD) {
                                 var34.field2648 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONRELEASE) {
                                 var34.field2659 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONMOUSEOVER) {
                                 var34.field2649 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONMOUSELEAVE) {
                                 var34.field2651 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONDRAG) {
                                 var34.field2657 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONTARGETLEAVE) {
                                 var34.onTargetLeave = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONVARTRANSMIT) {
                                 var34.field2656 = var65;
                                 var34.field2654 = var49;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONTIMER) {
                                 var34.field2658 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONOP) {
                                 var34.field2635 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONDRAGCOMPLETE) {
                                 var34.field2653 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONCLICKREPEAT) {
                                 var34.field2629 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONMOUSEREPEAT) {
                                 var34.field2650 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONINVTRANSMIT) {
                                 var34.field2630 = var65;
                                 var34.field2605 = var49;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONSTATTRANSMIT) {
                                 var34.field2620 = var65;
                                 var34.field2687 = var49;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONTARGETENTER) {
                                 var34.field2660 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONSCROLLWHEEL) {
                                 var34.field2661 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONCHATTRANSMIT) {
                                 var34.field2665 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONKEY) {
                                 var34.field2666 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONFRIENDTRANSMIT) {
                                 var34.field2571 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONCLANTRANSMIT) {
                                 var34.field2618 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONMISCTRANSMIT) {
                                 var34.field2669 = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONDIALOGABORT) {
                                 var34.onDialogAbort = var65;
                              }

                              if (var46 == ScriptOpcodes.CC_SETONSUBCHANGE) {
                                 var34.onSubChange = var65;
                              }

                              var34.hasListener = true;
                              continue;
                           }

                           if (var46 < 1600) {
                              var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                              if (var46 == ScriptOpcodes.CC_GETX) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.rawX;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETY) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2579;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETWIDTH) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.width;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETHEIGHT) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.height;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETHIDE) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2588 ? 1 : 0;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETLAYER) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.parentId;
                                 continue;
                              }
                           } else if (var46 < 1700) {
                              var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                              if (var46 == ScriptOpcodes.CC_GETSCROLLX) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2589;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETSCROLLY) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2655;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETTEXT) {
                                 Interpreter.Interpreter_stringStack[var5++] = var34.field2633;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2576;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2592;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETMODELZOOM) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2679;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETMODELANGLE_X) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.modelAngleX;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2614;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.modelAngleY;
                                 continue;
                              }
                           } else if (var46 < 1800) {
                              var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                              if (var46 == ScriptOpcodes.CC_GETINVOBJECT) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2680;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETINVCOUNT) {
                                 if (var34.field2680 != -1) {
                                    Interpreter.Interpreter_intStack[var4++] = var34.field2681;
                                 } else {
                                    Interpreter.Interpreter_intStack[var4++] = 0;
                                 }
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETID) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.childIndex;
                                 continue;
                              }
                           } else if (var46 < 1900) {
                              var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                              if (var46 == ScriptOpcodes.CC_GETTARGETMASK) {
                                 Interpreter.Interpreter_intStack[var4++] = class40.method905(SoundSystem.method1326(var34));
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETOP) {
                                 --var4;
                                 var39 = Interpreter.Interpreter_intStack[var4];
                                 --var39;
                                 if (var34.actions != null && var39 < var34.actions.length && var34.actions[var39] != null) {
                                    Interpreter.Interpreter_stringStack[var5++] = var34.actions[var39];
                                    continue;
                                 }

                                 Interpreter.Interpreter_stringStack[var5++] = "";
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.CC_GETOPBASE) {
                                 if (var34.field2636 == null) {
                                    Interpreter.Interpreter_stringStack[var5++] = "";
                                 } else {
                                    Interpreter.Interpreter_stringStack[var5++] = var34.field2636;
                                 }
                                 continue;
                              }
                           } else if (var46 < 2600) {
                              --var4;
                              var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                              if (var46 == ScriptOpcodes.IF_GETX) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.rawX;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETY) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2579;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETWIDTH) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.width;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETHEIGHT) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.height;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETHIDE) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2588 ? 1 : 0;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETLAYER) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.parentId;
                                 continue;
                              }
                           } else if (var46 < 2700) {
                              --var4;
                              var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                              if (var46 == ScriptOpcodes.IF_GETSCROLLX) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2589;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETSCROLLY) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2655;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETTEXT) {
                                 Interpreter.Interpreter_stringStack[var5++] = var34.field2633;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETSCROLLWIDTH) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2576;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETSCROLLHEIGHT) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2592;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETMODELZOOM) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2679;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETMODELANGLE_X) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.modelAngleX;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETMODELANGLE_Z) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2614;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETMODELANGLE_Y) {
                                 Interpreter.Interpreter_intStack[var4++] = var34.modelAngleY;
                                 continue;
                              }
                           } else if (var46 < 2800) {
                              if (var46 == ScriptOpcodes.IF_GETINVOBJECT) {
                                 --var4;
                                 var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                                 Interpreter.Interpreter_intStack[var4++] = var34.field2680;
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETINVCOUNT) {
                                 --var4;
                                 var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                                 if (var34.field2680 != -1) {
                                    Interpreter.Interpreter_intStack[var4++] = var34.field2681;
                                 } else {
                                    Interpreter.Interpreter_intStack[var4++] = 0;
                                 }
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_HASSUB) {
                                 --var4;
                                 var14 = Interpreter.Interpreter_intStack[var4];
                                 InterfaceParent var47 = (InterfaceParent)Client.interfaceParents.method3512((long)var14);
                                 if (var47 != null) {
                                    Interpreter.Interpreter_intStack[var4++] = 1;
                                 } else {
                                    Interpreter.Interpreter_intStack[var4++] = 0;
                                 }
                                 continue;
                              }
                           } else if (var46 < 2900) {
                              --var4;
                              var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                              if (var46 == ScriptOpcodes.IF_GETTARGETMASK) {
                                 Interpreter.Interpreter_intStack[var4++] = class40.method905(SoundSystem.method1326(var34));
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETOP) {
                                 --var4;
                                 var39 = Interpreter.Interpreter_intStack[var4];
                                 --var39;
                                 if (var34.actions != null && var39 < var34.actions.length && var34.actions[var39] != null) {
                                    Interpreter.Interpreter_stringStack[var5++] = var34.actions[var39];
                                    continue;
                                 }

                                 Interpreter.Interpreter_stringStack[var5++] = "";
                                 continue;
                              }

                              if (var46 == ScriptOpcodes.IF_GETOPBASE) {
                                 if (var34.field2636 == null) {
                                    Interpreter.Interpreter_stringStack[var5++] = "";
                                 } else {
                                    Interpreter.Interpreter_stringStack[var5++] = var34.field2636;
                                 }
                                 continue;
                              }
                           } else {
                              boolean var83;
                              if (var46 < 3200) {
                                 if (var46 == ScriptOpcodes.MES) {
                                    --var5;
                                    var97 = Interpreter.Interpreter_stringStack[var5];
                                    Login.method239(0, "", var97);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.ANIM) {
                                    var4 -= 2;
                                    SpotAnimationDefinition.method770(Tiles.localPlayer, Interpreter.Interpreter_intStack[var4], Interpreter.Interpreter_intStack[var4 + 1]);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.IF_CLOSE) {
                                    Client.field519.method2512(255);

                                    for(InterfaceParent var98 = (InterfaceParent)Client.interfaceParents.method3515(); var98 != null; var98 = (InterfaceParent)Client.interfaceParents.method3516()) {
                                       if (var98.field56 == 0 || var98.field56 == 3) {
                                          Tiles.method60(var98, true);
                                       }
                                    }

                                    if (Client.meslayerContinueWidget != null) {
                                       class82.method1754(Client.meslayerContinueWidget);
                                       Client.meslayerContinueWidget = null;
                                    }
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.RESUME_COUNTDIALOG) {
                                    --var5;
                                    var97 = Interpreter.Interpreter_stringStack[var5];
                                    var39 = 0;
                                    if (Tiles.method112(var97)) {
                                       var35 = FaceNormal.method2027(var97, 10, true);
                                       var39 = var35;
                                    }

                                    Client.field519.method2512(163);
                                    Client.field519.method2634(var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.RESUME_NAMEDIALOG) {
                                    --var5;
                                    var97 = Interpreter.Interpreter_stringStack[var5];
                                    Client.field519.method2512(104);
                                    Client.field519.method2631(var97.length() + 1);
                                    Client.field519.method2636(var97);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.RESUME_STRINGDIALOG) {
                                    --var5;
                                    var97 = Interpreter.Interpreter_stringStack[var5];
                                    Client.field519.method2512(180);
                                    Client.field519.method2631(var97.length() + 1);
                                    Client.field519.method2636(var97);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.OPPLAYER) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    --var5;
                                    var15 = Interpreter.Interpreter_stringStack[var5];
                                    var83 = false;

                                    for(var33 = 0; var33 < Client.field604; ++var33) {
                                       Player var37 = Client.players[Client.field524[var33]];
                                       if (var37 != null && var37.field35 != null && var37.field35.equalsIgnoreCase(var15)) {
                                          FileSystem.method1517(Tiles.localPlayer.hitSplatTypes2[0], Tiles.localPlayer.hitSplatValues2[0], var37.hitSplatTypes2[0], var37.hitSplatValues2[0], false, 0, 0, 1, 1, 0, 2);
                                          if (var14 == ScriptOpcodes.GET_VARP) {
                                             Client.field519.method2512(2);
                                             Client.field519.method2768(Client.field524[var33]);
                                          } else if (var14 == 4) {
                                             Client.field519.method2512(142);
                                             Client.field519.method2768(Client.field524[var33]);
                                          } else if (var14 == ScriptOpcodes.JUMP) {
                                             Client.field519.method2512(198);
                                             Client.field519.method2674(Client.field524[var33]);
                                          } else if (var14 == ScriptOpcodes.IF_ICMPNE) {
                                             Client.field519.method2512(254);
                                             Client.field519.method2778(Client.field524[var33]);
                                          }

                                          var83 = true;
                                          break;
                                       }
                                    }

                                    if (!var83) {
                                       Login.method239(0, "", "Unable to find " + var15);
                                    }
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.IF_DRAGPICKUP) {
                                    var4 -= 3;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    var35 = Interpreter.Interpreter_intStack[var4 + 2];
                                    var52 = class130.method2851(var35);
                                    ByteArrayPool.method2503(var52, var14, var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.CC_DRAGPICKUP) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    var16 = var60 ? Skills.field2054 : ItemContainer.field286;
                                    ByteArrayPool.method2503(var16, var14, var39);
                                    continue;
                                 }
                              } else if (var46 < 3300) {
                                 if (var46 == ScriptOpcodes.SOUND_SYNTH) {
                                    var4 -= 3;
                                    ClientPreferences.method151(Interpreter.Interpreter_intStack[var4], Interpreter.Interpreter_intStack[var4 + 1], Interpreter.Interpreter_intStack[var4 + 2]);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.SOUND_SONG) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    if (var14 == -1 && !Client.field562) {
                                       class137.midiPcmStream.method2951();
                                       class137.musicPlayerStatus = 1;
                                       class137.musicTrackArchive = null;
                                    } else if (var14 != -1 && var14 != Client.currentTrackGroupId && Client.field718 != 0 && !Client.field562) {
                                       ObjectSound.method43(2, class40.archive6, var14, 0, Client.field718, false);
                                    }

                                    Client.currentTrackGroupId = var14;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.SOUND_JINGLE) {
                                    var4 -= 2;
                                    MouseRecorder.method171(Interpreter.Interpreter_intStack[var4], Interpreter.Interpreter_intStack[var4 + 1]);
                                    continue;
                                 }
                              } else if (var46 < 3400) {
                                 if (var46 == ScriptOpcodes.CLIENTCLOCK) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.cycle;
                                    continue;
                                 }

                                 ItemContainer var36;
                                 if (var46 == ScriptOpcodes.INV_GETOBJ) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    var49 = Interpreter.Interpreter_intStack;
                                    var33 = var4++;
                                    var36 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var14);
                                    if (var36 == null) {
                                       var18 = -1;
                                    } else if (var39 >= 0 && var39 < var36.ids.length) {
                                       var18 = var36.ids[var39];
                                    } else {
                                       var18 = -1;
                                    }

                                    var49[var33] = var18;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INV_GETNUM) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    Interpreter.Interpreter_intStack[var4++] = Tiles.method95(var14, var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INV_TOTAL) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    Interpreter.Interpreter_intStack[var4++] = FileSystem.method1514(var14, var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INV_SIZE) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = VertexNormal.method2025(var14).field1032;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.STAT) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = Client.field621[var14];
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.STAT_BASE) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = Client.levels[var14];
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.STAT_XP) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = Client.field529[var14];
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.COORD) {
                                    var14 = class22.Client_plane;
                                    var39 = (Tiles.localPlayer.x >> 7) + FaceNormal.baseX;
                                    var35 = (Tiles.localPlayer.y >> 7) + Frames.baseY;
                                    Interpreter.Interpreter_intStack[var4++] = (var39 << 14) + var35 + (var14 << 28);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.COORDX) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = var14 >> 14 & 16383;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.COORDZ) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = var14 >> 28;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.COORDY) {
                                    --var4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    Interpreter.Interpreter_intStack[var4++] = var14 & 16383;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.MAP_MEMBERS) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.isMembersWorld ? 1 : 0;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INVOTHER_GETOBJ) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4] + '耀';
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    var49 = Interpreter.Interpreter_intStack;
                                    var33 = var4++;
                                    var36 = (ItemContainer)ItemContainer.itemContainers.method3512((long)var14);
                                    if (var36 == null) {
                                       var18 = -1;
                                    } else if (var39 >= 0 && var39 < var36.ids.length) {
                                       var18 = var36.ids[var39];
                                    } else {
                                       var18 = -1;
                                    }

                                    var49[var33] = var18;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INVOTHER_GETNUM) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4] + '耀';
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    Interpreter.Interpreter_intStack[var4++] = Tiles.method95(var14, var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.INVOTHER_TOTAL) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4] + '耀';
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    Interpreter.Interpreter_intStack[var4++] = FileSystem.method1514(var14, var39);
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.STAFFMODLEVEL) {
                                    if (Client.field563 >= 2) {
                                       Interpreter.Interpreter_intStack[var4++] = Client.field563;
                                    } else {
                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                    }
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.REBOOTTIMER) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.field585;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.MAP_WORLD) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.ViewportMouse_x;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.RUNENERGY_VISIBLE) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.field648;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.RUNWEIGHT_VISIBLE) {
                                    Interpreter.Interpreter_intStack[var4++] = Client.field558;
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.PLAYERMOD) {
                                    if (Client.field566) {
                                       Interpreter.Interpreter_intStack[var4++] = 1;
                                    } else {
                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                    }
                                    continue;
                                 }
                              } else if (var46 < 3500) {
                                 if (var46 == ScriptOpcodes.ENUM_STRING) {
                                    var4 -= 2;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    EnumComposition var50 = DynamicObject.method162(var14);
                                    if (var50.outputType != 's') {
                                       ;
                                    }

                                    for(var33 = 0; var33 < var50.outputCount; ++var33) {
                                       if (var39 == var50.keys[var33]) {
                                          Interpreter.Interpreter_stringStack[var5++] = var50.strVals[var33];
                                          var50 = null;
                                          break;
                                       }
                                    }

                                    if (var50 != null) {
                                       Interpreter.Interpreter_stringStack[var5++] = var50.defaultStr;
                                    }
                                    continue;
                                 }

                                 if (var46 == ScriptOpcodes.ENUM) {
                                    var4 -= 4;
                                    var14 = Interpreter.Interpreter_intStack[var4];
                                    var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                    var35 = Interpreter.Interpreter_intStack[var4 + 2];
                                    var33 = Interpreter.Interpreter_intStack[var4 + 3];
                                    EnumComposition var86 = DynamicObject.method162(var35);
                                    if (var14 == var86.field979 && var39 == var86.outputType) {
                                       for(var19 = 0; var19 < var86.outputCount; ++var19) {
                                          if (var33 == var86.keys[var19]) {
                                             if (var39 == 115) {
                                                Interpreter.Interpreter_stringStack[var5++] = var86.strVals[var19];
                                             } else {
                                                Interpreter.Interpreter_intStack[var4++] = var86.intVals[var19];
                                             }

                                             var86 = null;
                                             break;
                                          }
                                       }

                                       if (var86 != null) {
                                          if (var39 == 115) {
                                             Interpreter.Interpreter_stringStack[var5++] = var86.defaultStr;
                                          } else {
                                             Interpreter.Interpreter_intStack[var4++] = var86.defaultInt;
                                          }
                                       }
                                       continue;
                                    }

                                    if (var39 == 115) {
                                       Interpreter.Interpreter_stringStack[var5++] = "null";
                                    } else {
                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var21;
                                 String var88;
                                 if (var46 < 3700) {
                                    if (var46 == ScriptOpcodes.FRIEND_COUNT) {
                                       if (Client.field737 == 0) {
                                          Interpreter.Interpreter_intStack[var4++] = -2;
                                       } else if (Client.field737 == 1) {
                                          Interpreter.Interpreter_intStack[var4++] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = Client.field736;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_GETNAME) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field737 == 2 && var14 < Client.field736) {
                                          Interpreter.Interpreter_stringStack[var5++] = Client.field532[var14].field381;
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = "";
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_GETWORLD) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field737 == 2 && var14 < Client.field736) {
                                          Interpreter.Interpreter_intStack[var4++] = Client.field532[var14].field370;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_GETRANK) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field737 == 2 && var14 < Client.field736) {
                                          Interpreter.Interpreter_intStack[var4++] = Client.field532[var14].field371;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_SETRANK) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       --var4;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       class1.method5(var97, var39);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_ADD) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       NPC.method264(var97);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_DEL) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       NPC.method265(var97);
                                       continue;
                                    }

                                    class10 var54;
                                    if (var46 == ScriptOpcodes.IGNORE_ADD) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97 == null) {
                                          continue;
                                       }

                                       if ((Client.field534 < 100 || Client.field610 == 1) && Client.field534 < 400) {
                                          var15 = Projectile.method125(var97, class5.field75);
                                          if (var15 == null) {
                                             continue;
                                          }

                                          for(var35 = 0; var35 < Client.field534; ++var35) {
                                             var54 = Client.field741[var35];
                                             var88 = Projectile.method125(var54.field177, class5.field75);
                                             if (var88 != null && var88.equals(var15)) {
                                                Login.method239(0, "", var97 + " is already on your ignore list");
                                                continue label3012;
                                             }

                                             if (var54.field178 != null) {
                                                var84 = Projectile.method125(var54.field178, class5.field75);
                                                if (var84 != null && var84.equals(var15)) {
                                                   Login.method239(0, "", var97 + " is already on your ignore list");
                                                   continue label3012;
                                                }
                                             }
                                          }

                                          for(var35 = 0; var35 < Client.field736; ++var35) {
                                             class22 var57 = Client.field532[var35];
                                             var88 = Projectile.method125(var57.field381, class5.field75);
                                             if (var88 != null && var88.equals(var15)) {
                                                Login.method239(0, "", "Please remove " + var97 + " from your friend list first");
                                                continue label3012;
                                             }

                                             if (var57.field369 != null) {
                                                var84 = Projectile.method125(var57.field369, class5.field75);
                                                if (var84 != null && var84.equals(var15)) {
                                                   Login.method239(0, "", "Please remove " + var97 + " from your friend list first");
                                                   continue label3012;
                                                }
                                             }
                                          }

                                          if (Projectile.method125(Tiles.localPlayer.field35, class5.field75).equals(var15)) {
                                             Login.method239(0, "", "You can't add yourself to your own ignore list");
                                          } else {
                                             Client.field519.method2512(63);
                                             PacketBuffer var55 = Client.field519;
                                             var33 = var97.length() + 1;
                                             var55.method2631(var33);
                                             Client.field519.method2636(var97);
                                          }
                                          continue;
                                       }

                                       Login.method239(0, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.IGNORE_DEL) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97 == null) {
                                          continue;
                                       }

                                       var15 = Projectile.method125(var97, class5.field75);
                                       if (var15 == null) {
                                          continue;
                                       }

                                       var35 = 0;

                                       while(true) {
                                          if (var35 >= Client.field534) {
                                             continue label3012;
                                          }

                                          var54 = Client.field741[var35];
                                          var88 = var54.field177;
                                          var84 = Projectile.method125(var88, class5.field75);
                                          if (BufferedFile.method599(var97, var15, var88, var84)) {
                                             --Client.field534;

                                             for(var20 = var35; var20 < Client.field534; ++var20) {
                                                Client.field741[var20] = Client.field741[var20 + 1];
                                             }

                                             Client.field674 = Client.field681;
                                             Client.field519.method2512(250);
                                             PacketBuffer var38 = Client.field519;
                                             var21 = var97.length() + 1;
                                             var38.method2631(var21);
                                             Client.field519.method2636(var97);
                                             continue label3012;
                                          }

                                          ++var35;
                                       }
                                    }

                                    if (var46 == ScriptOpcodes.FRIEND_TEST) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97.startsWith(FloorOverlayDefinition.method829(0)) || var97.startsWith(FloorOverlayDefinition.method829(1))) {
                                          var97 = var97.substring(7);
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = ItemContainer.method203(var97) ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
                                       if (Client.field660 != null) {
                                          Interpreter.Interpreter_stringStack[var5++] = SoundCache.method1371(Client.field660);
                                       } else {
                                          Interpreter.Interpreter_stringStack[var5++] = "";
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
                                       if (Client.field660 != null) {
                                          Interpreter.Interpreter_intStack[var4++] = SoundSystem.field1188;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = 0;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field660 != null && var14 < SoundSystem.field1188) {
                                          Interpreter.Interpreter_stringStack[var5++] = ItemComposition.field1026[var14].field112;
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = "";
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field660 != null && var14 < SoundSystem.field1188) {
                                          Interpreter.Interpreter_intStack[var4++] = ItemComposition.field1026[var14].field109;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field660 != null && var14 < SoundSystem.field1188) {
                                          Interpreter.Interpreter_intStack[var4++] = ItemComposition.field1026[var14].field105;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
                                       Interpreter.Interpreter_intStack[var4++] = FloorUnderlayDefinition.field882;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_KICKUSER) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       class5.method40(var97);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATRANK) {
                                       Interpreter.Interpreter_intStack[var4++] = MusicPatch.field2354;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_JOINCHAT) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (!var97.equals("")) {
                                          Client.field519.method2512(8);
                                          PacketBuffer var48 = Client.field519;
                                          var35 = var97.length() + 1;
                                          var48.method2631(var35);
                                          Client.field519.method2636(var97);
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_LEAVECHAT) {
                                       class23.method251();
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.IGNORE_COUNT) {
                                       if (Client.field737 == 0) {
                                          Interpreter.Interpreter_intStack[var4++] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = Client.field534;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.IGNORE_GETNAME) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (Client.field737 != 0 && var14 < Client.field534) {
                                          Interpreter.Interpreter_stringStack[var5++] = Client.field741[var14].field177;
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = "";
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.IGNORE_TEST) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97.startsWith(FloorOverlayDefinition.method829(0)) || var97.startsWith(FloorOverlayDefinition.method829(1))) {
                                          var97 = var97.substring(7);
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = ObjectSound.method45(var97) ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_ISSELF) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       if (ItemComposition.field1026 != null && var14 < SoundSystem.field1188 && ItemComposition.field1026[var14].field112.equalsIgnoreCase(Tiles.localPlayer.field35)) {
                                          Interpreter.Interpreter_intStack[var4++] = 1;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
                                       if (Client.field720 != null) {
                                          Interpreter.Interpreter_stringStack[var5++] = SoundCache.method1371(Client.field720);
                                       } else {
                                          Interpreter.Interpreter_stringStack[var5++] = "";
                                       }
                                       continue;
                                    }
                                 } else if (var46 < 4100) {
                                    if (var46 == ScriptOpcodes.ADD) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var39 + var14;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.SUB) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 - var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.MULTIPLY) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var39 * var14;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.DIV) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 / var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.RANDOM) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = (int)(Math.random() * (double)var14);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.RANDOMINC) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = (int)(Math.random() * (double)(var14 + 1));
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.INTERPOLATE) {
                                       var4 -= 5;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       var35 = Interpreter.Interpreter_intStack[var4 + 2];
                                       var33 = Interpreter.Interpreter_intStack[var4 + 3];
                                       var18 = Interpreter.Interpreter_intStack[var4 + 4];
                                       Interpreter.Interpreter_intStack[var4++] = var14 + (var39 - var14) * (var18 - var35) / (var33 - var35);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.ADDPERCENT) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 + var14 * var39 / 100;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.SETBIT) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 | 1 << var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CLEARBIT) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 & -1 - (1 << var39);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.TESTBIT) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = (var14 & 1 << var39) != 0 ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.MOD) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 % var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.POW) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       if (var14 == 0) {
                                          Interpreter.Interpreter_intStack[var4++] = 0;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = (int)Math.pow((double)var14, (double)var39);
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.INVPOW) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       if (var14 == 0) {
                                          Interpreter.Interpreter_intStack[var4++] = 0;
                                       } else if (var39 == ScriptOpcodes.ICONST) {
                                          Interpreter.Interpreter_intStack[var4++] = Integer.MAX_VALUE;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = (int)Math.pow((double)var14, 1.0D / (double)var39);
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.AND) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 & var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OR) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_intStack[var4++] = var14 | var39;
                                       continue;
                                    }
                                 } else if (var46 < 4200) {
                                    if (var46 == ScriptOpcodes.APPEND_NUM) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       --var4;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_stringStack[var5++] = var97 + var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.APPEND) {
                                       var5 -= 2;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var15 = Interpreter.Interpreter_stringStack[var5 + 1];
                                       Interpreter.Interpreter_stringStack[var5++] = var97 + var15;
                                       continue;
                                    }

                                    int var22;
                                    int var23;
                                    int var76;
                                    if (var46 == ScriptOpcodes.APPEND_SIGNNUM) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       --var4;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       var56 = Interpreter.Interpreter_stringStack;
                                       var33 = var5++;
                                       if (var39 < 0) {
                                          var84 = Integer.toString(var39);
                                       } else {
                                          var21 = var39;
                                          if (var39 < 0) {
                                             var87 = Integer.toString(var39, 10);
                                          } else {
                                             var22 = 2;

                                             for(var23 = var39 / 10; var23 != 0; ++var22) {
                                                var23 /= 10;
                                             }

                                             char[] var24 = new char[var22];
                                             var24[0] = '+';

                                             for(int var70 = var22 - 1; var70 > 0; --var70) {
                                                int var73 = var21;
                                                var21 /= 10;
                                                var76 = var73 - var21 * 10;
                                                if (var76 >= 10) {
                                                   var24[var70] = (char)(var76 + 87);
                                                } else {
                                                   var24[var70] = (char)(var76 + 48);
                                                }
                                             }

                                             var87 = new String(var24);
                                          }

                                          var84 = var87;
                                       }

                                       var56[var33] = var97 + var84;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.LOWERCASE) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       Interpreter.Interpreter_stringStack[var5++] = var97.toLowerCase();
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.FROMDATE) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       long var40 = 86400000L * ((long)var14 + 11745L);
                                       Interpreter.Interpreter_calendar.setTime(new Date(var40));
                                       var33 = Interpreter.Interpreter_calendar.get(5);
                                       var18 = Interpreter.Interpreter_calendar.get(2);
                                       var19 = Interpreter.Interpreter_calendar.get(1);
                                       Interpreter.Interpreter_stringStack[var5++] = var33 + "-" + Interpreter.Interpreter_MONTHS[var18] + "-" + var19;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.TEXT_GENDER) {
                                       var5 -= 2;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var15 = Interpreter.Interpreter_stringStack[var5 + 1];
                                       if (Tiles.localPlayer.appearance != null && Tiles.localPlayer.appearance.isFemale) {
                                          Interpreter.Interpreter_stringStack[var5++] = var15;
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var97;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.TOSTRING) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_stringStack[var5++] = Integer.toString(var14);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.COMPARE) {
                                       var5 -= 2;
                                       int[] var99 = Interpreter.Interpreter_intStack;
                                       var39 = var4++;
                                       var88 = Interpreter.Interpreter_stringStack[var5];
                                       var84 = Interpreter.Interpreter_stringStack[var5 + 1];
                                       var20 = 0;
                                       var21 = var88.length();
                                       var22 = var84.length();
                                       var23 = 0;
                                       int var42 = 0;
                                       byte var25 = 0;
                                       byte var26 = 0;

                                       label2809:
                                       while(true) {
                                          if (var23 - var25 >= var21 && var42 - var26 >= var22) {
                                             var76 = Math.min(var21, var22);

                                             int var78;
                                             char var81;
                                             for(var78 = 0; var78 < var76; ++var78) {
                                                char var79 = var88.charAt(var78);
                                                var81 = var84.charAt(var78);
                                                if (var79 != var81 && Character.toUpperCase(var79) != Character.toUpperCase(var81)) {
                                                   var79 = Character.toLowerCase(var79);
                                                   var81 = Character.toLowerCase(var81);
                                                   if (var81 != var79) {
                                                      var33 = InterfaceParent.method29(var79, var20) - InterfaceParent.method29(var81, var20);
                                                      break label2809;
                                                   }
                                                }
                                             }

                                             var78 = var21 - var22;
                                             if (var78 != 0) {
                                                var33 = var78;
                                             } else {
                                                for(int var80 = 0; var80 < var76; ++var80) {
                                                   var81 = var88.charAt(var80);
                                                   char var31 = var84.charAt(var80);
                                                   if (var31 != var81) {
                                                      var33 = InterfaceParent.method29(var81, var20) - InterfaceParent.method29(var31, var20);
                                                      break label2809;
                                                   }
                                                }

                                                var33 = 0;
                                             }
                                             break;
                                          }

                                          if (var23 - var25 >= var21) {
                                             var33 = -1;
                                             break;
                                          }

                                          if (var42 - var26 >= var22) {
                                             var33 = 1;
                                             break;
                                          }

                                          char var27;
                                          if (var25 != ScriptOpcodes.ICONST) {
                                             var27 = (char)var25;
                                             boolean var69 = false;
                                          } else {
                                             var27 = var88.charAt(var23++);
                                          }

                                          char var28;
                                          if (var26 != 0) {
                                             var28 = (char)var26;
                                             boolean var71 = false;
                                          } else {
                                             var28 = var84.charAt(var42++);
                                          }

                                          byte var29;
                                          if (var27 == 198) {
                                             var29 = 69;
                                          } else if (var27 == 230) {
                                             var29 = 101;
                                          } else if (var27 == 223) {
                                             var29 = 115;
                                          } else if (var27 == 338) {
                                             var29 = 69;
                                          } else if (var27 == 339) {
                                             var29 = 101;
                                          } else {
                                             var29 = 0;
                                          }

                                          var25 = var29;
                                          byte var30;
                                          if (var28 == 198) {
                                             var30 = 69;
                                          } else if (var28 == 230) {
                                             var30 = 101;
                                          } else if (var28 == 223) {
                                             var30 = 115;
                                          } else if (var28 == 338) {
                                             var30 = 69;
                                          } else if (var28 == 339) {
                                             var30 = 101;
                                          } else {
                                             var30 = 0;
                                          }

                                          var26 = var30;
                                          var27 = Buffer.method2810(var27, var20);
                                          var28 = Buffer.method2810(var28, var20);
                                          if (var27 != var28 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                             var27 = Character.toLowerCase(var27);
                                             var28 = Character.toLowerCase(var28);
                                             if (var28 != var27) {
                                                var33 = InterfaceParent.method29(var27, var20) - InterfaceParent.method29(var28, var20);
                                                break;
                                             }
                                          }
                                       }

                                       if (var33 > 0) {
                                          var95 = 1;
                                       } else if (var33 < 0) {
                                          var95 = -1;
                                       } else {
                                          var95 = 0;
                                       }

                                       var99[var39] = var95;
                                       continue;
                                    }

                                    Font var90;
                                    if (var46 == ScriptOpcodes.PARAHEIGHT) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var4 -= 2;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       var35 = Interpreter.Interpreter_intStack[var4 + 1];
                                       var59 = class17.archive13.method3204(var35, 0);
                                       var90 = new Font(var59);
                                       Interpreter.Interpreter_intStack[var4++] = var90.method3672(var97, var39);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.PARAWIDTH) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var4 -= 2;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       var35 = Interpreter.Interpreter_intStack[var4 + 1];
                                       var59 = class17.archive13.method3204(var35, 0);
                                       var90 = new Font(var59);
                                       Interpreter.Interpreter_intStack[var4++] = var90.method3604(var97, var39);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.TEXT_SWITCH) {
                                       var5 -= 2;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var15 = Interpreter.Interpreter_stringStack[var5 + 1];
                                       --var4;
                                       if (Interpreter.Interpreter_intStack[var4] == 1) {
                                          Interpreter.Interpreter_stringStack[var5++] = var97;
                                       } else {
                                          Interpreter.Interpreter_stringStack[var5++] = var15;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.ESCAPE) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       Interpreter.Interpreter_stringStack[var5++] = AbstractFont.method3605(var97);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.APPEND_CHAR) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       --var4;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_stringStack[var5++] = var97 + (char)var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAR_ISPRINTABLE) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = class120.method2581((char)var14) ? 1 : 0;
                                       continue;
                                    }

                                    char var66;
                                    boolean var85;
                                    if (var46 == ScriptOpcodes.CHAR_ISALPHANUMERIC) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var53 = Interpreter.Interpreter_intStack;
                                       var35 = var4++;
                                       var66 = (char)var14;
                                       var85 = var66 >= '0' && var66 <= '9' || var66 >= 'A' && var66 <= 'Z' || var66 >= 'a' && var66 <= 'z';
                                       var53[var35] = var85 ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAR_ISALPHA) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var53 = Interpreter.Interpreter_intStack;
                                       var35 = var4++;
                                       var66 = (char)var14;
                                       var85 = var66 >= 'A' && var66 <= 'Z' || var66 >= 'a' && var66 <= 'z';
                                       var53[var35] = var85 ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAR_ISNUMERIC) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var53 = Interpreter.Interpreter_intStack;
                                       var35 = var4++;
                                       var66 = (char)var14;
                                       var85 = var66 >= '0' && var66 <= '9';
                                       var53[var35] = var85 ? 1 : 0;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.STRING_LENGTH) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97 != null) {
                                          Interpreter.Interpreter_intStack[var4++] = var97.length();
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = 0;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.SUBSTRING) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var4 -= 2;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       var35 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Interpreter.Interpreter_stringStack[var5++] = var97.substring(var39, var35);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.REMOVETAGS) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       StringBuilder var51 = new StringBuilder(var97.length());
                                       var83 = false;

                                       for(var33 = 0; var33 < var97.length(); ++var33) {
                                          var66 = var97.charAt(var33);
                                          if (var66 == ScriptOpcodes.SWITCH) {
                                             var83 = true;
                                          } else if (var66 == '>') {
                                             var83 = false;
                                          } else if (!var83) {
                                             var51.append(var66);
                                          }
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var51.toString();
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.STRING_INDEXOF_CHAR) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       --var4;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = var97.indexOf(var39);
                                       continue;
                                    }
                                 } else if (var46 < 4300) {
                                    if (var46 == ScriptOpcodes.OC_NAME) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_stringStack[var5++] = class27.method571(var14).name;
                                       continue;
                                    }

                                    ItemComposition var58;
                                    if (var46 == ScriptOpcodes.OC_OP) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       var58 = class27.method571(var14);
                                       if (var39 >= 1 && var39 <= 5 && var58.groundActions[var39 - 1] != null) {
                                          Interpreter.Interpreter_stringStack[var5++] = var58.groundActions[var39 - 1];
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = "";
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OC_IOP) {
                                       var4 -= 2;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       var58 = class27.method571(var14);
                                       if (var39 >= 1 && var39 <= 5 && var58.inventoryActions[var39 - 1] != null) {
                                          Interpreter.Interpreter_stringStack[var5++] = var58.inventoryActions[var39 - 1];
                                          continue;
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = "";
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OC_COST) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = class27.method571(var14).price;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OC_STACKABLE) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = class27.method571(var14).isStackable == 1 ? 1 : 0;
                                       continue;
                                    }

                                    ItemComposition var63;
                                    if (var46 == ScriptOpcodes.OC_CERT) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var63 = class27.method571(var14);
                                       if (var63.noteTemplate == -1 && var63.note >= 0) {
                                          Interpreter.Interpreter_intStack[var4++] = var63.note;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = var14;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OC_UNCERT) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var63 = class27.method571(var14);
                                       if (var63.noteTemplate >= 0 && var63.note >= 0) {
                                          Interpreter.Interpreter_intStack[var4++] = var63.note;
                                          continue;
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = var14;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.OC_MEMBERS) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       Interpreter.Interpreter_intStack[var4++] = class27.method571(var14).isMembersOnly ? 1 : 0;
                                       continue;
                                    }
                                 } else if (var46 < 5100) {
                                    if (var46 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
                                       Interpreter.Interpreter_intStack[var4++] = Client.field700;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_SETFILTER) {
                                       var4 -= 3;
                                       Client.field700 = Interpreter.Interpreter_intStack[var4];
                                       var39 = Interpreter.Interpreter_intStack[var4 + 1];
                                       class136[] var61 = new class136[]{class136.field2336, class136.field2332, class136.field2335};
                                       class136[] var64 = var61;
                                       var18 = 0;

                                       class136 var101;
                                       while(true) {
                                          if (var18 >= var64.length) {
                                             var101 = null;
                                             break;
                                          }

                                          class136 var89 = var64[var18];
                                          if (var39 == var89.value) {
                                             var101 = var89;
                                             break;
                                          }

                                          ++var18;
                                       }

                                       ByteArrayPool.field1945 = var101;
                                       if (ByteArrayPool.field1945 == null) {
                                          ByteArrayPool.field1945 = class136.field2332;
                                       }

                                       Client.field748 = Interpreter.Interpreter_intStack[var4 + 2];
                                       Client.field519.method2512(91);
                                       Client.field519.method2631(Client.field700);
                                       Client.field519.method2631(ByteArrayPool.field1945.value);
                                       Client.field519.method2631(Client.field748);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var4 -= 2;
                                       var39 = Interpreter.Interpreter_intStack[var4];
                                       var35 = Interpreter.Interpreter_intStack[var4 + 1];
                                       Client.field519.method2512(193);
                                       PacketBuffer var62 = Client.field519;
                                       var18 = var97.length() + 1;
                                       var62.method2631(var18 + 2);
                                       Client.field519.method2636(var97);
                                       Client.field519.method2631(var39 - 1);
                                       Client.field519.method2631(var35);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var15 = null;
                                       if (var14 < 100) {
                                          var15 = Client.field697[var14];
                                       }

                                       if (var15 == null) {
                                          var15 = "";
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var15;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var39 = -1;
                                       if (var14 < 100 && Client.field697[var14] != null) {
                                          var39 = Client.field694[var14];
                                       }

                                       Interpreter.Interpreter_intStack[var4++] = var39;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
                                       if (ByteArrayPool.field1945 == null) {
                                          Interpreter.Interpreter_intStack[var4++] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[var4++] = ByteArrayPool.field1945.value;
                                       }
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_SENDPUBLIC) {
                                       --var5;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       if (var97.startsWith("::")) {
                                          if (var97.equalsIgnoreCase("::toggleroof")) {
                                             Projectile.clientPreferences.roofsHidden = !Projectile.clientPreferences.roofsHidden;
                                             class17.method185();
                                             if (Projectile.clientPreferences.roofsHidden) {
                                                Login.method239(0, "", "Roofs are now all hidden");
                                             } else {
                                                Login.method239(0, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if (Client.field563 >= 2) {
                                             if (var97.equalsIgnoreCase("::gc")) {
                                                System.gc();
                                             }

                                             if (var97.equalsIgnoreCase("::clientdrop")) {
                                                Clock.method1461();
                                             }

                                             if (var97.equalsIgnoreCase("::fpson")) {
                                                Client.field496 = true;
                                             }

                                             if (var97.equalsIgnoreCase("::fpsoff")) {
                                                Client.field496 = false;
                                             }

                                             if (var97.equalsIgnoreCase("::noclip")) {
                                                for(var39 = 0; var39 < 4; ++var39) {
                                                   for(var35 = 1; var35 < 103; ++var35) {
                                                      for(var33 = 1; var33 < 103; ++var33) {
                                                         Client.collisionMaps[var39].flags[var35][var33] = 0;
                                                      }
                                                   }
                                                }
                                             }

                                             if (var97.equalsIgnoreCase("::errortest") && Client.ViewportMouse_y == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          Client.field519.method2512(210);
                                          Client.field519.method2631(var97.length() - 1);
                                          Client.field519.method2636(var97.substring(2));
                                          continue;
                                       }

                                       var15 = var97.toLowerCase();
                                       byte var96 = 0;
                                       if (var15.startsWith("yellow:")) {
                                          var96 = 0;
                                          var97 = var97.substring("yellow:".length());
                                       } else if (var15.startsWith("red:")) {
                                          var96 = 1;
                                          var97 = var97.substring("red:".length());
                                       } else if (var15.startsWith("green:")) {
                                          var96 = 2;
                                          var97 = var97.substring("green:".length());
                                       } else if (var15.startsWith("cyan:")) {
                                          var96 = 3;
                                          var97 = var97.substring("cyan:".length());
                                       } else if (var15.startsWith("purple:")) {
                                          var96 = 4;
                                          var97 = var97.substring("purple:".length());
                                       } else if (var15.startsWith("white:")) {
                                          var96 = 5;
                                          var97 = var97.substring("white:".length());
                                       } else if (var15.startsWith("flash1:")) {
                                          var96 = 6;
                                          var97 = var97.substring("flash1:".length());
                                       } else if (var15.startsWith("flash2:")) {
                                          var96 = 7;
                                          var97 = var97.substring("flash2:".length());
                                       } else if (var15.startsWith("flash3:")) {
                                          var96 = 8;
                                          var97 = var97.substring("flash3:".length());
                                       } else if (var15.startsWith("glow1:")) {
                                          var96 = 9;
                                          var97 = var97.substring("glow1:".length());
                                       } else if (var15.startsWith("glow2:")) {
                                          var96 = 10;
                                          var97 = var97.substring("glow2:".length());
                                       } else if (var15.startsWith("glow3:")) {
                                          var96 = 11;
                                          var97 = var97.substring("glow3:".length());
                                       }

                                       var15 = var97.toLowerCase();
                                       byte var94 = 0;
                                       if (var15.startsWith("wave:")) {
                                          var94 = 1;
                                          var97 = var97.substring("wave:".length());
                                       } else if (var15.startsWith("wave2:")) {
                                          var94 = 2;
                                          var97 = var97.substring("wave2:".length());
                                       } else if (var15.startsWith("shake:")) {
                                          var94 = 3;
                                          var97 = var97.substring("shake:".length());
                                       } else if (var15.startsWith("scroll:")) {
                                          var94 = 4;
                                          var97 = var97.substring("scroll:".length());
                                       } else if (var15.startsWith("slide:")) {
                                          var94 = 5;
                                          var97 = var97.substring("slide:".length());
                                       }

                                       Client.field519.method2512(46);
                                       Client.field519.method2631(0);
                                       var18 = Client.field519.offset;
                                       Client.field519.method2631(var96);
                                       Client.field519.method2631(var94);
                                       MouseRecorder.method167(Client.field519, var97);
                                       Client.field519.method2642(Client.field519.offset - var18);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_SENDPRIVATE) {
                                       var5 -= 2;
                                       var97 = Interpreter.Interpreter_stringStack[var5];
                                       var15 = Interpreter.Interpreter_stringStack[var5 + 1];
                                       Client.field519.method2512(215);
                                       Client.field519.method2778(0);
                                       var35 = Client.field519.offset;
                                       Client.field519.method2636(var97);
                                       MouseRecorder.method167(Client.field519, var15);
                                       Client.field519.method2641(Client.field519.offset - var35);
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_SENDCLAN) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var15 = null;
                                       if (var14 < 100) {
                                          var15 = Client.field695[var14];
                                       }

                                       if (var15 == null) {
                                          var15 = "";
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var15;
                                       continue;
                                    }

                                    if (var46 == 5011) {
                                       --var4;
                                       var14 = Interpreter.Interpreter_intStack[var4];
                                       var15 = null;
                                       if (var14 < 100) {
                                          var15 = Client.field696[var14];
                                       }

                                       if (var15 == null) {
                                          var15 = "";
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var15;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_PLAYERNAME) {
                                       if (Tiles.localPlayer != null && Tiles.localPlayer.field35 != null) {
                                          var97 = Tiles.localPlayer.field35;
                                       } else {
                                          var97 = "";
                                       }

                                       Interpreter.Interpreter_stringStack[var5++] = var97;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
                                       Interpreter.Interpreter_intStack[var4++] = Client.field748;
                                       continue;
                                    }

                                    if (var46 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
                                       Interpreter.Interpreter_intStack[var4++] = Client.field580;
                                       continue;
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        if (var46 >= 2000) {
                           var46 -= 1000;
                           --var4;
                           var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                        } else {
                           var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                        }

                        class82.method1754(var34);
                        if (var46 == ScriptOpcodes.CC_SETOBJECT) {
                           var4 -= 2;
                           var39 = Interpreter.Interpreter_intStack[var4];
                           var35 = Interpreter.Interpreter_intStack[var4 + 1];
                           var34.field2680 = var39;
                           var34.field2681 = var35;
                           ItemComposition var17 = class27.method571(var39);
                           var34.modelAngleX = var17.xan2d;
                           var34.modelAngleY = var17.yan2d;
                           var34.field2614 = var17.zan2d;
                           var34.field2577 = var17.offsetX2d;
                           var34.field2668 = var17.offsetY2d;
                           var34.field2679 = var17.zoom2d;
                           if (var34.width > 0) {
                              var34.field2679 = var34.field2679 * 32 / var34.width;
                           }
                           continue;
                        }

                        if (var46 == ScriptOpcodes.CC_SETNPCHEAD) {
                           var34.modelType = 2;
                           --var4;
                           var34.modelId = Interpreter.Interpreter_intStack[var4];
                           continue;
                        }

                        if (var46 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
                           var34.modelType = 3;
                           var34.modelId = Tiles.localPlayer.appearance.method3401();
                           continue;
                        }
                     }
                  } else {
                     if (var46 >= 2000) {
                        var46 -= 1000;
                        --var4;
                        var34 = class130.method2851(Interpreter.Interpreter_intStack[var4]);
                     } else {
                        var34 = var60 ? Skills.field2054 : ItemContainer.field286;
                     }

                     if (var46 == ScriptOpcodes.CC_SETSCROLLPOS) {
                        var4 -= 2;
                        var34.field2589 = Interpreter.Interpreter_intStack[var4];
                        if (var34.field2589 > var34.field2576 - var34.width) {
                           var34.field2589 = var34.field2576 - var34.width;
                        }

                        if (var34.field2589 < 0) {
                           var34.field2589 = 0;
                        }

                        var34.field2655 = Interpreter.Interpreter_intStack[var4 + 1];
                        if (var34.field2655 > var34.field2592 - var34.height) {
                           var34.field2655 = var34.field2592 - var34.height;
                        }

                        if (var34.field2655 < 0) {
                           var34.field2655 = 0;
                        }

                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETCOLOUR) {
                        --var4;
                        var34.field2593 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETFILL) {
                        --var4;
                        var34.field2647 = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTRANS) {
                        --var4;
                        var34.field2582 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETLINEWID) {
                        --var4;
                        var34.field2599 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETGRAPHIC) {
                        --var4;
                        var34.spriteId2 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SET2DANGLE) {
                        --var4;
                        var34.field2688 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTILING) {
                        --var4;
                        var34.field2603 = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETMODEL) {
                        var34.modelType = 1;
                        --var4;
                        var34.modelId = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETMODELANGLE) {
                        var4 -= 6;
                        var34.field2577 = Interpreter.Interpreter_intStack[var4];
                        var34.field2668 = Interpreter.Interpreter_intStack[var4 + 1];
                        var34.modelAngleX = Interpreter.Interpreter_intStack[var4 + 2];
                        var34.modelAngleY = Interpreter.Interpreter_intStack[var4 + 3];
                        var34.field2614 = Interpreter.Interpreter_intStack[var4 + 4];
                        var34.field2679 = Interpreter.Interpreter_intStack[var4 + 5];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETMODELANIM) {
                        --var4;
                        var39 = Interpreter.Interpreter_intStack[var4];
                        if (var39 != var34.sequenceId) {
                           var34.sequenceId = var39;
                           var34.modelFrame = 0;
                           var34.modelFrameCycle = 0;
                           class82.method1754(var34);
                        }
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETMODELORTHOG) {
                        --var4;
                        var34.field2621 = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTEXT) {
                        --var5;
                        var15 = Interpreter.Interpreter_stringStack[var5];
                        if (!var15.equals(var34.field2633)) {
                           var34.field2633 = var15;
                           class82.method1754(var34);
                        }
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTEXTFONT) {
                        --var4;
                        var34.fontId = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTEXTALIGN) {
                        var4 -= 3;
                        var34.field2626 = Interpreter.Interpreter_intStack[var4];
                        var34.field2627 = Interpreter.Interpreter_intStack[var4 + 1];
                        var34.field2625 = Interpreter.Interpreter_intStack[var4 + 2];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETTEXTSHADOW) {
                        --var4;
                        var34.field2628 = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETOUTLINE) {
                        --var4;
                        var34.field2604 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
                        --var4;
                        var34.field2667 = Interpreter.Interpreter_intStack[var4];
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETVFLIP) {
                        --var4;
                        var34.field2606 = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETHFLIP) {
                        --var4;
                        var34.spriteFlipV = Interpreter.Interpreter_intStack[var4] == 1;
                        class82.method1754(var34);
                        continue;
                     }

                     if (var46 == ScriptOpcodes.CC_SETSCROLLSIZE) {
                        var4 -= 2;
                        var34.field2576 = Interpreter.Interpreter_intStack[var4];
                        var34.field2592 = Interpreter.Interpreter_intStack[var4 + 1];
                        class82.method1754(var34);
                        continue;
                     }
                  }
               }

               throw new IllegalStateException();
            }
         } catch (Exception var45) {
            StringBuilder var44 = new StringBuilder(30);
            var44.append("").append(var3.key).append(" ");

            for(var12 = Interpreter.Interpreter_frameDepth - 1; var12 >= 0; --var12) {
               var44.append("").append(Interpreter.Interpreter_frames[var12].field279.key).append(" ");
            }

            var44.append("").append(var9);
            ScriptEvent.method3(var44.toString(), var45);
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "([BIIII[Lclass163;)V"
   )
   static final void method2039(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               Player.method26(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("ag")
   static final int method2038() {
      if (Projectile.clientPreferences.roofsHidden) {
         return class22.Client_plane;
      } else {
         int var0 = BufferedFile.method603(Login.cameraX, class17.cameraZ, class22.Client_plane);
         return var0 - class22.cameraY < 800 && (Tiles.Tiles_renderFlags[class22.Client_plane][Login.cameraX >> 7][class17.cameraZ >> 7] & 4) != 0 ? class22.Client_plane : 3;
      }
   }
}
