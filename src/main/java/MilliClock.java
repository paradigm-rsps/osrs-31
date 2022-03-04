import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("by")
@Implements("MilliClock")
public class MilliClock extends Clock {
   @ObfuscatedName("i")
   long[] field1255 = new long[10];
   @ObfuscatedName("w")
   int field1256 = 256;
   @ObfuscatedName("f")
   int field1262 = 1;
   @ObfuscatedName("e")
   long field1257 = ClientPreferences.method148();
   @ObfuscatedName("t")
   int field1254 = 0;
   @ObfuscatedName("d")
   int field1259;

   MilliClock() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1255[var1] = this.field1257;
      }

   }

   @ObfuscatedName("i")
   @Export("vmethod1698")
   public void vmethod1698() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1255[var1] = 0L;
      }

   }

   @ObfuscatedName("w")
   @Export("vmethod1701")
   int vmethod1701(int var1, int var2) {
      int var3 = this.field1256;
      int var4 = this.field1262;
      this.field1256 = 300;
      this.field1262 = 1;
      this.field1257 = ClientPreferences.method148();
      if (0L == this.field1255[this.field1259]) {
         this.field1256 = var3;
         this.field1262 = var4;
      } else if (this.field1257 > this.field1255[this.field1259]) {
         this.field1256 = (int)((long)(var1 * 2560) / (this.field1257 - this.field1255[this.field1259]));
      }

      if (this.field1256 < 25) {
         this.field1256 = 25;
      }

      if (this.field1256 > 256) {
         this.field1256 = 256;
         this.field1262 = (int)((long)var1 - (this.field1257 - this.field1255[this.field1259]) / 10L);
      }

      if (this.field1262 > var1) {
         this.field1262 = var1;
      }

      this.field1255[this.field1259] = this.field1257;
      this.field1259 = (this.field1259 + 1) % 10;
      int var5;
      if (this.field1262 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if (0L != this.field1255[var5]) {
               this.field1255[var5] += (long)this.field1262;
            }
         }
      }

      if (this.field1262 < var2) {
         this.field1262 = var2;
      }

      SequenceDefinition.method761((long)this.field1262);

      for(var5 = 0; this.field1254 < 256; this.field1254 += this.field1256) {
         ++var5;
      }

      this.field1254 &= 255;
      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lclass115;I)V"
   )
   public static void method1433(PacketBuffer var0, int var1) {
      while(true) {
         ReflectionCheck var2 = (ReflectionCheck)class181.reflectionChecks.method3533();
         if (var2 == null) {
            return;
         }

         var0.writeByteOpcode(var1);
         var0.writeByte(0);
         int var3 = var0.offset;
         var0.writeInt(var2.id);

         for(int var4 = 0; var4 < var2.size; ++var4) {
            if (var2.creationErrors[var4] != 0) {
               var0.writeByte(var2.creationErrors[var4]);
            } else {
               try {
                  int var5 = var2.operations[var4];
                  Field var6;
                  int var7;
                  if (var5 == 0) {
                     var6 = var2.fields[var4];
                     var7 = Reflection.getInt(var6, (Object)null);
                     var0.writeByte(0);
                     var0.writeInt(var7);
                  } else if (var5 == 1) {
                     var6 = var2.fields[var4];
                     Reflection.setInt(var6, (Object)null, var2.intReplaceValues[var4]);
                     var0.writeByte(0);
                  } else if (var5 == 2) {
                     var6 = var2.fields[var4];
                     var7 = var6.getModifiers();
                     var0.writeByte(0);
                     var0.writeInt(var7);
                  }

                  Method var26;
                  if (var5 != 3) {
                     if (var5 == 4) {
                        var26 = var2.methods[var4];
                        var7 = var26.getModifiers();
                        var0.writeByte(0);
                        var0.writeInt(var7);
                     }
                  } else {
                     var26 = var2.methods[var4];
                     byte[][] var11 = var2.arguments[var4];
                     Object[] var8 = new Object[var11.length];

                     for(int var9 = 0; var9 < var11.length; ++var9) {
                        ObjectInputStream var10 = new ObjectInputStream(new ByteArrayInputStream(var11[var9]));
                        var8[var9] = var10.readObject();
                     }

                     Object var12 = Reflection.invoke(var26, (Object)null, var8);
                     if (var12 == null) {
                        var0.writeByte(0);
                     } else if (var12 instanceof Number) {
                        var0.writeByte(1);
                        var0.writeLong(((Number)var12).longValue());
                     } else if (var12 instanceof String) {
                        var0.writeByte(2);
                        var0.writeStringCp1252NullTerminated((String)var12);
                     } else {
                        var0.writeByte(4);
                     }
                  }
               } catch (ClassNotFoundException var14) {
                  var0.writeByte(-10);
               } catch (InvalidClassException var15) {
                  var0.writeByte(-11);
               } catch (StreamCorruptedException var16) {
                  var0.writeByte(-12);
               } catch (OptionalDataException var17) {
                  var0.writeByte(-13);
               } catch (IllegalAccessException var18) {
                  var0.writeByte(-14);
               } catch (IllegalArgumentException var19) {
                  var0.writeByte(-15);
               } catch (InvocationTargetException var20) {
                  var0.writeByte(-16);
               } catch (SecurityException var21) {
                  var0.writeByte(-17);
               } catch (IOException var22) {
                  var0.writeByte(-18);
               } catch (NullPointerException var23) {
                  var0.writeByte(-19);
               } catch (Exception var24) {
                  var0.writeByte(-20);
               } catch (Throwable var25) {
                  var0.writeByte(-21);
               }
            }
         }

         var0.method2664(var3);
         var0.writeLengthByte(var0.offset - var3);
         var2.method3567();
      }
   }

   @ObfuscatedName("a")
   @Export("method1438")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass108;"
   )
   static Frames method1438(int var0) {
      Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.method3474((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         var1 = FloorDecoration.method2382(SequenceDefinition.SequenceDefinition_animationsArchive, SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
         if (var1 != null) {
            SequenceDefinition.SequenceDefinition_cachedFrames.method3473(var1, (long)var0);
         }

         return var1;
      }
   }
}
