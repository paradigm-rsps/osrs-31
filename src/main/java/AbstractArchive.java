import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("AbstractArchive")
public abstract class AbstractArchive {
   @ObfuscatedName("s")
   @Export("gzipDecompressor")
   @ObfuscatedSignature(
      descriptor = "Lclass121;"
   )
   static GZipDecompressor gzipDecompressor = new GZipDecompressor();
   @ObfuscatedName("o")
   static int field2507 = 0;
   @ObfuscatedName("i")
   @Export("groupCount")
   int groupCount;
   @ObfuscatedName("w")
   @Export("groupIds")
   int[] groupIds;
   @ObfuscatedName("f")
   @Export("groupNameHashes")
   int[] groupNameHashes;
   @ObfuscatedName("e")
   @Export("groupNameHashTable")
   @ObfuscatedSignature(
      descriptor = "Lclass168;"
   )
   IntHashTable groupNameHashTable;
   @ObfuscatedName("t")
   @Export("groupCrcs")
   int[] groupCrcs;
   @ObfuscatedName("d")
   @Export("groupVersions")
   int[] groupVersions;
   @ObfuscatedName("p")
   @Export("fileCounts")
   int[] fileCounts;
   @ObfuscatedName("k")
   @Export("fileIds")
   int[][] fileIds;
   @ObfuscatedName("r")
   @Export("fileNameHashes")
   int[][] fileNameHashes;
   @ObfuscatedName("l")
   @Export("fileNameHashTables")
   @ObfuscatedSignature(
      descriptor = "[Lclass168;"
   )
   IntHashTable[] fileNameHashTables;
   @ObfuscatedName("a")
   @Export("groups")
   Object[] groups;
   @ObfuscatedName("z")
   @Export("files")
   Object[][] files;
   @ObfuscatedName("m")
   @Export("hash")
   public int hash;
   @ObfuscatedName("u")
   @Export("releaseGroups")
   boolean releaseGroups;
   @ObfuscatedName("g")
   @Export("shallowFiles")
   boolean shallowFiles;

   AbstractArchive(boolean var1, boolean var2) {
      this.releaseGroups = var1;
      this.shallowFiles = var2;
   }

   @ObfuscatedName("i")
   @Export("method3202")
   void method3202(byte[] var1) {
      this.hash = FileSystem.method1516(var1, var1.length);
      Buffer var2 = new Buffer(class120.method2582(var1));
      int var3 = var2.readUnsignedByte();
      if (var3 >= 5 && var3 <= 7) {
         if (var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if (var3 >= 7) {
            this.groupCount = var2.method2680();
         } else {
            this.groupCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.groupIds = new int[this.groupCount];
         int var7;
         if (var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.method2680();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.readUnsignedShort();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         }

         this.groupCrcs = new int[var6 + 1];
         this.groupVersions = new int[var6 + 1];
         this.fileCounts = new int[var6 + 1];
         this.fileIds = new int[var6 + 1][];
         this.groups = new Object[var6 + 1];
         this.files = new Object[var6 + 1][];
         if (var4 != 0) {
            this.groupNameHashes = new int[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupNameHashes[this.groupIds[var7]] = var2.readInt();
            }

            this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupCrcs[this.groupIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupVersions[this.groupIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.fileCounts[this.groupIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if (var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.method2680();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         }

         if (var4 != 0) {
            this.fileNameHashes = new int[var6 + 1][];
            this.fileNameHashTables = new IntHashTable[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               this.fileNameHashes[var8] = new int[this.files[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.readInt();
               }

               this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("w")
   @Export("vmethod3297")
   void vmethod3297(int var1) {
   }

   @ObfuscatedName("f")
   @Export("method3204")
   public byte[] method3204(int var1, int var2) {
      return this.method3205(var1, var2, (int[])null);
   }

   @ObfuscatedName("e")
   @Export("method3205")
   public byte[] method3205(int var1, int var2, int[] var3) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] == null) {
            boolean var4 = this.method3218(var1, var3);
            if (!var4) {
               this.vmethod3298(var1);
               var4 = this.method3218(var1, var3);
               if (!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = class7.method56(this.files[var1][var2], false);
         if (this.shallowFiles) {
            this.files[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("t")
   @Export("method3206")
   public boolean method3206(int var1, int var2) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] != null) {
            return true;
         } else if (this.groups[var1] != null) {
            return true;
         } else {
            this.vmethod3298(var1);
            return this.groups[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("d")
   @Export("method3207")
   public boolean method3207(int var1) {
      if (this.groups[var1] != null) {
         return true;
      } else {
         this.vmethod3298(var1);
         return this.groups[var1] != null;
      }
   }

   @ObfuscatedName("p")
   @Export("method3208")
   public boolean method3208() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.groupIds.length; ++var2) {
         int var3 = this.groupIds[var2];
         if (this.groups[var3] == null) {
            this.vmethod3298(var3);
            if (this.groups[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @Export("method3209")
   public byte[] method3209(int var1) {
      if (this.files.length == 1) {
         return this.method3204(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.method3204(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @Export("method3210")
   public byte[] method3210(int var1, int var2) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] == null) {
            boolean var3 = this.method3218(var1, (int[])null);
            if (!var3) {
               this.vmethod3298(var1);
               var3 = this.method3218(var1, (int[])null);
               if (!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = class7.method56(this.files[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("l")
   @Export("method3233")
   public byte[] method3233(int var1) {
      if (this.files.length == 1) {
         return this.method3210(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.method3210(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @Export("vmethod3298")
   void vmethod3298(int var1) {
   }

   @ObfuscatedName("z")
   @Export("method3248")
   public int[] method3248(int var1) {
      return this.fileIds[var1];
   }

   @ObfuscatedName("s")
   @Export("method3214")
   public int method3214(int var1) {
      return this.files[var1].length;
   }

   @ObfuscatedName("m")
   @Export("method3264")
   public int method3264() {
      return this.files.length;
   }

   @ObfuscatedName("u")
   @Export("method3216")
   public void method3216(int var1) {
      for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
         this.files[var1][var2] = null;
      }

   }

   @ObfuscatedName("g")
   @Export("method3217")
   public void method3217() {
      for(int var1 = 0; var1 < this.files.length; ++var1) {
         if (this.files[var1] != null) {
            for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
               this.files[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @Export("method3218")
   boolean method3218(int var1, int[] var2) {
      if (this.groups[var1] == null) {
         return false;
      } else {
         int var3 = this.fileCounts[var1];
         int[] var4 = this.fileIds[var1];
         Object[] var5 = this.files[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if (var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if (var6) {
            return true;
         } else {
            byte[] var18;
            if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
               var18 = class7.method56(this.groups[var1], true);
               Buffer var8 = new Buffer(var18);
               var8.method2662(var2, 5, var8.array.length);
            } else {
               var18 = class7.method56(this.groups[var1], false);
            }

            byte[] var20 = class120.method2582(var18);
            if (this.releaseGroups) {
               this.groups[var1] = null;
            }

            if (var3 > 1) {
               int var9 = var20.length;
               --var9;
               int var10 = var20[var9] & 255;
               var9 -= var3 * var10 * 4;
               Buffer var11 = new Buffer(var20);
               int[] var12 = new int[var3];
               var11.offset = var9;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.readInt();
                     var12[var15] += var14;
                  }
               }

               byte[][] var19 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var19[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var9;
               var14 = 0;

               for(var15 = 0; var15 < var10; ++var15) {
                  int var16 = 0;

                  for(int var17 = 0; var17 < var3; ++var17) {
                     var16 += var11.readInt();
                     System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                     var12[var17] += var16;
                     var14 += var16;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if (!this.shallowFiles) {
                     var5[var4[var15]] = PacketBuffer.method2537(var19[var15], false);
                  } else {
                     var5[var4[var15]] = var19[var15];
                  }
               }
            } else if (!this.shallowFiles) {
               var5[var4[0]] = PacketBuffer.method2537(var20, false);
            } else {
               var5[var4[0]] = var20;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @Export("method3219")
   public int method3219(String var1) {
      var1 = var1.toLowerCase();
      return this.groupNameHashTable.method3471(class65.method1456(var1));
   }

   @ObfuscatedName("j")
   @Export("method3238")
   public int method3238(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.fileNameHashTables[var1].method3471(class65.method1456(var2));
   }

   @ObfuscatedName("n")
   @Export("method3263")
   public byte[] method3263(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.method3471(class65.method1456(var1));
      int var4 = this.fileNameHashTables[var3].method3471(class65.method1456(var2));
      return this.method3204(var3, var4);
   }

   @ObfuscatedName("q")
   @Export("method3222")
   public boolean method3222(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.method3471(class65.method1456(var1));
      int var4 = this.fileNameHashTables[var3].method3471(class65.method1456(var2));
      return this.method3206(var3, var4);
   }

   @ObfuscatedName("c")
   public void method3231(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.method3471(class65.method1456(var1));
      if (var2 >= 0) {
         this.vmethod3297(var2);
      }
   }

   @ObfuscatedName("w")
   @Export("method3230")
   @ObfuscatedSignature(
      descriptor = "(II)Lclass157;"
   )
   public static Widget method3230(int var0, int var1) {
      Widget var2 = class130.getWidget(var0);
      if (var1 == -1) {
         return var2;
      } else {
         return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
      }
   }
}
