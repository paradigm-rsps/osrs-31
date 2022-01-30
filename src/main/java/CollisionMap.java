import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fa")
@Implements("CollisionMap")
public class CollisionMap {
   @ObfuscatedName("aw")
   @Export("xInset")
   int xInset = 0;
   @ObfuscatedName("an")
   @Export("yInset")
   int yInset = 0;
   @ObfuscatedName("av")
   @Export("xSize")
   int xSize;
   @ObfuscatedName("ak")
   @Export("ySize")
   int ySize;
   @ObfuscatedName("ax")
   @Export("flags")
   public int[][] flags;

   public CollisionMap(int var1, int var2) {
      this.xSize = var1;
      this.ySize = var2;
      this.flags = new int[this.xSize][this.ySize];
      this.method3435();
   }

   @ObfuscatedName("i")
   @Export("method3435")
   public void method3435() {
      for(int var1 = 0; var1 < this.xSize; ++var1) {
         for(int var2 = 0; var2 < this.ySize; ++var2) {
            if (var1 != 0 && var2 != 0 && var1 < this.xSize - 5 && var2 < this.ySize - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("w")
   public void method3427(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if (var3 == 0) {
         if (var4 == 0) {
            this.method3431(var1, var2, 128);
            this.method3431(var1 - 1, var2, 8);
         }

         if (var4 == 1) {
            this.method3431(var1, var2, 2);
            this.method3431(var1, var2 + 1, 32);
         }

         if (var4 == 2) {
            this.method3431(var1, var2, 8);
            this.method3431(var1 + 1, var2, 128);
         }

         if (var4 == 3) {
            this.method3431(var1, var2, 32);
            this.method3431(var1, var2 - 1, 2);
         }
      }

      if (var3 == 1 || var3 == 3) {
         if (var4 == 0) {
            this.method3431(var1, var2, 1);
            this.method3431(var1 - 1, var2 + 1, 16);
         }

         if (var4 == 1) {
            this.method3431(var1, var2, 4);
            this.method3431(var1 + 1, var2 + 1, 64);
         }

         if (var4 == 2) {
            this.method3431(var1, var2, 16);
            this.method3431(var1 + 1, var2 - 1, 1);
         }

         if (var4 == 3) {
            this.method3431(var1, var2, 64);
            this.method3431(var1 - 1, var2 - 1, 4);
         }
      }

      if (var3 == 2) {
         if (var4 == 0) {
            this.method3431(var1, var2, 130);
            this.method3431(var1 - 1, var2, 8);
            this.method3431(var1, var2 + 1, 32);
         }

         if (var4 == 1) {
            this.method3431(var1, var2, 10);
            this.method3431(var1, var2 + 1, 32);
            this.method3431(var1 + 1, var2, 128);
         }

         if (var4 == 2) {
            this.method3431(var1, var2, 40);
            this.method3431(var1 + 1, var2, 128);
            this.method3431(var1, var2 - 1, 2);
         }

         if (var4 == 3) {
            this.method3431(var1, var2, 160);
            this.method3431(var1, var2 - 1, 2);
            this.method3431(var1 - 1, var2, 8);
         }
      }

      if (var5) {
         if (var3 == 0) {
            if (var4 == 0) {
               this.method3431(var1, var2, 65536);
               this.method3431(var1 - 1, var2, 4096);
            }

            if (var4 == 1) {
               this.method3431(var1, var2, 1024);
               this.method3431(var1, var2 + 1, 16384);
            }

            if (var4 == 2) {
               this.method3431(var1, var2, 4096);
               this.method3431(var1 + 1, var2, 65536);
            }

            if (var4 == 3) {
               this.method3431(var1, var2, 16384);
               this.method3431(var1, var2 - 1, 1024);
            }
         }

         if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
               this.method3431(var1, var2, 512);
               this.method3431(var1 - 1, var2 + 1, 8192);
            }

            if (var4 == 1) {
               this.method3431(var1, var2, 2048);
               this.method3431(var1 + 1, var2 + 1, 32768);
            }

            if (var4 == 2) {
               this.method3431(var1, var2, 8192);
               this.method3431(var1 + 1, var2 - 1, 512);
            }

            if (var4 == 3) {
               this.method3431(var1, var2, 32768);
               this.method3431(var1 - 1, var2 - 1, 2048);
            }
         }

         if (var3 == 2) {
            if (var4 == 0) {
               this.method3431(var1, var2, 66560);
               this.method3431(var1 - 1, var2, 4096);
               this.method3431(var1, var2 + 1, 16384);
            }

            if (var4 == 1) {
               this.method3431(var1, var2, 5120);
               this.method3431(var1, var2 + 1, 16384);
               this.method3431(var1 + 1, var2, 65536);
            }

            if (var4 == 2) {
               this.method3431(var1, var2, 20480);
               this.method3431(var1 + 1, var2, 65536);
               this.method3431(var1, var2 - 1, 1024);
            }

            if (var4 == 3) {
               this.method3431(var1, var2, 81920);
               this.method3431(var1, var2 - 1, 1024);
               this.method3431(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @Export("method3428")
   public void method3428(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if (var5) {
         var6 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if (var7 >= 0 && var7 < this.xSize) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if (var8 >= 0 && var8 < this.ySize) {
                  this.method3431(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   public void method3429(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("t")
   public void method3430(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("d")
   @Export("method3431")
   void method3431(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("p")
   public void method3432(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      if (var3 == 0) {
         if (var4 == 0) {
            this.method3433(var1, var2, 128);
            this.method3433(var1 - 1, var2, 8);
         }

         if (var4 == 1) {
            this.method3433(var1, var2, 2);
            this.method3433(var1, var2 + 1, 32);
         }

         if (var4 == 2) {
            this.method3433(var1, var2, 8);
            this.method3433(var1 + 1, var2, 128);
         }

         if (var4 == 3) {
            this.method3433(var1, var2, 32);
            this.method3433(var1, var2 - 1, 2);
         }
      }

      if (var3 == 1 || var3 == 3) {
         if (var4 == 0) {
            this.method3433(var1, var2, 1);
            this.method3433(var1 - 1, var2 + 1, 16);
         }

         if (var4 == 1) {
            this.method3433(var1, var2, 4);
            this.method3433(var1 + 1, var2 + 1, 64);
         }

         if (var4 == 2) {
            this.method3433(var1, var2, 16);
            this.method3433(var1 + 1, var2 - 1, 1);
         }

         if (var4 == 3) {
            this.method3433(var1, var2, 64);
            this.method3433(var1 - 1, var2 - 1, 4);
         }
      }

      if (var3 == 2) {
         if (var4 == 0) {
            this.method3433(var1, var2, 130);
            this.method3433(var1 - 1, var2, 8);
            this.method3433(var1, var2 + 1, 32);
         }

         if (var4 == 1) {
            this.method3433(var1, var2, 10);
            this.method3433(var1, var2 + 1, 32);
            this.method3433(var1 + 1, var2, 128);
         }

         if (var4 == 2) {
            this.method3433(var1, var2, 40);
            this.method3433(var1 + 1, var2, 128);
            this.method3433(var1, var2 - 1, 2);
         }

         if (var4 == 3) {
            this.method3433(var1, var2, 160);
            this.method3433(var1, var2 - 1, 2);
            this.method3433(var1 - 1, var2, 8);
         }
      }

      if (var5) {
         if (var3 == 0) {
            if (var4 == 0) {
               this.method3433(var1, var2, 65536);
               this.method3433(var1 - 1, var2, 4096);
            }

            if (var4 == 1) {
               this.method3433(var1, var2, 1024);
               this.method3433(var1, var2 + 1, 16384);
            }

            if (var4 == 2) {
               this.method3433(var1, var2, 4096);
               this.method3433(var1 + 1, var2, 65536);
            }

            if (var4 == 3) {
               this.method3433(var1, var2, 16384);
               this.method3433(var1, var2 - 1, 1024);
            }
         }

         if (var3 == 1 || var3 == 3) {
            if (var4 == 0) {
               this.method3433(var1, var2, 512);
               this.method3433(var1 - 1, var2 + 1, 8192);
            }

            if (var4 == 1) {
               this.method3433(var1, var2, 2048);
               this.method3433(var1 + 1, var2 + 1, 32768);
            }

            if (var4 == 2) {
               this.method3433(var1, var2, 8192);
               this.method3433(var1 + 1, var2 - 1, 512);
            }

            if (var4 == 3) {
               this.method3433(var1, var2, 32768);
               this.method3433(var1 - 1, var2 - 1, 2048);
            }
         }

         if (var3 == 2) {
            if (var4 == 0) {
               this.method3433(var1, var2, 66560);
               this.method3433(var1 - 1, var2, 4096);
               this.method3433(var1, var2 + 1, 16384);
            }

            if (var4 == 1) {
               this.method3433(var1, var2, 5120);
               this.method3433(var1, var2 + 1, 16384);
               this.method3433(var1 + 1, var2, 65536);
            }

            if (var4 == 2) {
               this.method3433(var1, var2, 20480);
               this.method3433(var1 + 1, var2, 65536);
               this.method3433(var1, var2 - 1, 1024);
            }

            if (var4 == 3) {
               this.method3433(var1, var2, 81920);
               this.method3433(var1, var2 - 1, 1024);
               this.method3433(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @Export("method3446")
   public void method3446(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if (var6) {
         var7 += 131072;
      }

      var1 -= this.xInset;
      var2 -= this.yInset;
      int var8;
      if (var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if (var8 >= 0 && var8 < this.xSize) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if (var9 >= 0 && var9 < this.ySize) {
                  this.method3433(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @Export("method3433")
   void method3433(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("l")
   public void method3425(int var1, int var2) {
      var1 -= this.xInset;
      var2 -= this.yInset;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("a")
   public boolean method3438(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var3 == var1 && var2 == var4) {
         return true;
      } else {
         var1 -= this.xInset;
         var2 -= this.yInset;
         var3 -= this.xInset;
         var4 -= this.yInset;
         if (var5 == 0) {
            if (var6 == 0) {
               if (var3 - 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 19661088) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 19661058) == 0) {
                  return true;
               }
            } else if (var6 == 1) {
               if (var3 == var1 && var2 == var4 + 1) {
                  return true;
               }

               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661064) == 0) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661184) == 0) {
                  return true;
               }
            } else if (var6 == 2) {
               if (var3 + 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 19661088) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 19661058) == 0) {
                  return true;
               }
            } else if (var6 == 3) {
               if (var3 == var1 && var2 == var4 - 1) {
                  return true;
               }

               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661064) == 0) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661184) == 0) {
                  return true;
               }
            }
         }

         if (var5 == 2) {
            if (var6 == 0) {
               if (var3 - 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661184) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 19661058) == 0) {
                  return true;
               }
            } else if (var6 == 1) {
               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661064) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 19661058) == 0) {
                  return true;
               }
            } else if (var6 == 2) {
               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661064) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 19661088) == 0) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1) {
                  return true;
               }
            } else if (var6 == 3) {
               if (var3 - 1 == var1 && var2 == var4) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 19661088) == 0) {
                  return true;
               }

               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 19661184) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1) {
                  return true;
               }
            }
         }

         if (var5 == 9) {
            if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 32) == 0) {
               return true;
            }

            if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 2) == 0) {
               return true;
            }

            if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 8) == 0) {
               return true;
            }

            if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 128) == 0) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("z")
   public boolean method3444(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var3 == var1 && var2 == var4) {
         return true;
      } else {
         var1 -= this.xInset;
         var2 -= this.yInset;
         var3 -= this.xInset;
         var4 -= this.yInset;
         if (var5 == 6 || var5 == 7) {
            if (var5 == 7) {
               var6 = var6 + 2 & 3;
            }

            if (var6 == 0) {
               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 128) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 2) == 0) {
                  return true;
               }
            } else if (var6 == 1) {
               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 8) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 2) == 0) {
                  return true;
               }
            } else if (var6 == 2) {
               if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 8) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 32) == 0) {
                  return true;
               }
            } else if (var6 == 3) {
               if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 128) == 0) {
                  return true;
               }

               if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 32) == 0) {
                  return true;
               }
            }
         }

         if (var5 == 8) {
            if (var3 == var1 && var2 == var4 + 1 && (this.flags[var1][var2] & 32) == 0) {
               return true;
            }

            if (var3 == var1 && var2 == var4 - 1 && (this.flags[var1][var2] & 2) == 0) {
               return true;
            }

            if (var3 - 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 8) == 0) {
               return true;
            }

            if (var3 + 1 == var1 && var2 == var4 && (this.flags[var1][var2] & 128) == 0) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   public boolean method3467(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var3 + var5 - 1;
      int var9 = var4 + var6 - 1;
      if (var1 >= var3 && var1 <= var8 && var2 >= var4 && var2 <= var9) {
         return true;
      } else if (var3 - 1 == var1 && var2 >= var4 && var2 <= var9 && (this.flags[var1 - this.xInset][var2 - this.yInset] & 8) == 0 && (var7 & 8) == 0) {
         return true;
      } else if (var8 + 1 == var1 && var2 >= var4 && var2 <= var9 && (this.flags[var1 - this.xInset][var2 - this.yInset] & 128) == 0 && (var7 & 2) == 0) {
         return true;
      } else if (var2 == var4 - 1 && var1 >= var3 && var1 <= var8 && (this.flags[var1 - this.xInset][var2 - this.yInset] & 2) == 0 && (var7 & 4) == 0) {
         return true;
      } else {
         return var9 + 1 == var2 && var1 >= var3 && var1 <= var8 && (this.flags[var1 - this.xInset][var2 - this.yInset] & 32) == 0 && (var7 & 1) == 0;
      }
   }
}
