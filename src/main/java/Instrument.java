import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Instrument")
public class Instrument {
   @ObfuscatedName("v")
   @Export("Instrument_samples")
   static int[] Instrument_samples;
   @ObfuscatedName("j")
   @Export("Instrument_noise")
   static int[] Instrument_noise = new int['耀'];
   @ObfuscatedName("n")
   @Export("Instrument_sine")
   static int[] Instrument_sine;
   @ObfuscatedName("c")
   @Export("Instrument_phases")
   static int[] Instrument_phases;
   @ObfuscatedName("h")
   @Export("Instrument_delays")
   static int[] Instrument_delays;
   @ObfuscatedName("b")
   @Export("Instrument_volumeSteps")
   static int[] Instrument_volumeSteps;
   @ObfuscatedName("y")
   @Export("Instrument_pitchSteps")
   static int[] Instrument_pitchSteps;
   @ObfuscatedName("x")
   @Export("Instrument_pitchBaseSteps")
   static int[] Instrument_pitchBaseSteps;
   @ObfuscatedName("i")
   @Export("pitch")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope pitch;
   @ObfuscatedName("w")
   @Export("volume")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope volume;
   @ObfuscatedName("f")
   @Export("pitchModifier")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope pitchModifier;
   @ObfuscatedName("e")
   @Export("pitchModifierAmplitude")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope pitchModifierAmplitude;
   @ObfuscatedName("t")
   @Export("volumeMultiplier")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope volumeMultiplier;
   @ObfuscatedName("d")
   @Export("volumeMultiplierAmplitude")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope volumeMultiplierAmplitude;
   @ObfuscatedName("p")
   @Export("release")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope release;
   @ObfuscatedName("k")
   @Export("attack")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope attack;
   @ObfuscatedName("r")
   @Export("oscillatorVolume")
   int[] oscillatorVolume = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   @Export("oscillatorPitch")
   int[] oscillatorPitch = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("a")
   @Export("oscillatorDelays")
   int[] oscillatorDelays = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("z")
   @Export("delayTime")
   int delayTime = 0;
   @ObfuscatedName("s")
   @Export("delayDecay")
   int delayDecay = 100;
   @ObfuscatedName("m")
   @Export("filter")
   @ObfuscatedSignature(
      descriptor = "Lclass63;"
   )
   AudioFilter filter;
   @ObfuscatedName("u")
   @Export("filterEnvelope")
   @ObfuscatedSignature(
      descriptor = "Lclass55;"
   )
   SoundEnvelope filterEnvelope;
   @ObfuscatedName("g")
   @Export("duration")
   int duration = 500;
   @ObfuscatedName("o")
   @Export("offset")
   int offset = 0;

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < 32768; ++var1) {
         Instrument_noise[var1] = (var0.nextInt() & 2) - 1;
      }

      Instrument_sine = new int['耀'];

      for(var1 = 0; var1 < 32768; ++var1) {
         Instrument_sine[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      Instrument_samples = new int[220500];
      Instrument_phases = new int[5];
      Instrument_delays = new int[5];
      Instrument_volumeSteps = new int[5];
      Instrument_pitchSteps = new int[5];
      Instrument_pitchBaseSteps = new int[5];
   }

   @ObfuscatedName("i")
   @Export("method1317")
   final int[] method1317(int var1, int var2) {
      class127.method2846(Instrument_samples, 0, var1);
      if (var2 < 10) {
         return Instrument_samples;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.pitch.method1333();
         this.volume.method1333();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if (this.pitchModifier != null) {
            this.pitchModifier.method1333();
            this.pitchModifierAmplitude.method1333();
            var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
            var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if (this.volumeMultiplier != null) {
            this.volumeMultiplier.method1333();
            this.volumeMultiplierAmplitude.method1333();
            var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
            var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if (this.oscillatorVolume[var11] != 0) {
               Instrument_phases[var11] = 0;
               Instrument_delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
               Instrument_volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
               Instrument_pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               Instrument_pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.pitch.method1330(var1);
            var13 = this.volume.method1330(var1);
            if (this.pitchModifier != null) {
               var14 = this.pitchModifier.method1330(var1);
               var15 = this.pitchModifierAmplitude.method1330(var1);
               var12 += this.method1316(var7, var15, this.pitchModifier.form) >> 1;
               var7 = var7 + var6 + (var14 * var5 >> 16);
            }

            if (this.volumeMultiplier != null) {
               var14 = this.volumeMultiplier.method1330(var1);
               var15 = this.volumeMultiplierAmplitude.method1330(var1);
               var13 = var13 * ((this.method1316(var10, var15, this.volumeMultiplier.form) >> 1) + '耀') >> 15;
               var10 = var10 + var9 + (var14 * var8 >> 16);
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if (this.oscillatorVolume[var14] != 0) {
                  var15 = Instrument_delays[var14] + var11;
                  if (var15 < var1) {
                     Instrument_samples[var15] += this.method1316(Instrument_phases[var14], var13 * Instrument_volumeSteps[var14] >> 15, this.pitch.form);
                     Instrument_phases[var14] += (var12 * Instrument_pitchSteps[var14] >> 16) + Instrument_pitchBaseSteps[var14];
                  }
               }
            }
         }

         int var16;
         if (this.release != null) {
            this.release.method1333();
            this.attack.method1333();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.release.method1330(var1);
               var16 = this.attack.method1330(var1);
               if (var20) {
                  var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
               } else {
                  var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
               }

               var11 += 256;
               if (var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if (var20) {
                  Instrument_samples[var14] = 0;
               }
            }
         }

         if (this.delayTime > 0 && this.delayDecay > 0) {
            var11 = (int)((double)this.delayTime * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               Instrument_samples[var12] += Instrument_samples[var12 - var11] * this.delayDecay / 100;
            }
         }

         if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
            this.filterEnvelope.method1333();
            var11 = this.filterEnvelope.method1330(var1 + 1);
            var12 = this.filter.method1419(0, (float)var11 / 65536.0F);
            var13 = this.filter.method1419(1, (float)var11 / 65536.0F);
            if (var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if (var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)Instrument_samples[var14 + var12 - 1 - var17] * (long)AudioFilter.coefficients[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)Instrument_samples[var14 - 1 - var17] * (long)AudioFilter.coefficients[1][var17] >> 16);
                  }

                  Instrument_samples[var14] = var16;
                  var11 = this.filterEnvelope.method1330(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if (var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)Instrument_samples[var14 + var12] * (long)AudioFilter.forwardMultiplier >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
                     }

                     Instrument_samples[var14] = var17;
                     var11 = this.filterEnvelope.method1330(var1 + 1);
                     ++var14;
                  }

                  if (var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)Instrument_samples[var14 + var12 - 1 - var18] * (long)AudioFilter.coefficients[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)Instrument_samples[var14 - 1 - var18] * (long)AudioFilter.coefficients[1][var18] >> 16);
                        }

                        Instrument_samples[var14] = var17;
                        this.filterEnvelope.method1330(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.filter.method1419(0, (float)var11 / 65536.0F);
                  var13 = this.filter.method1419(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if (Instrument_samples[var11] < -32768) {
               Instrument_samples[var11] = -32768;
            }

            if (Instrument_samples[var11] > 32767) {
               Instrument_samples[var11] = 32767;
            }
         }

         return Instrument_samples;
      }
   }

   @ObfuscatedName("w")
   @Export("method1316")
   final int method1316(int var1, int var2, int var3) {
      if (var3 == 1) {
         return (var1 & 32767) < 16384 ? var2 : -var2;
      } else if (var3 == 2) {
         return Instrument_sine[var1 & 32767] * var2 >> 14;
      } else if (var3 == 3) {
         return (var2 * (var1 & 32767) >> 14) - var2;
      } else {
         return var3 == 4 ? var2 * Instrument_noise[var1 / 2607 & 32767] : 0;
      }
   }

   @ObfuscatedName("f")
   @Export("method1319")
   @ObfuscatedSignature(
      descriptor = "(Lclass126;)V"
   )
   final void method1319(Buffer var1) {
      this.pitch = new SoundEnvelope();
      this.pitch.method1331(var1);
      this.volume = new SoundEnvelope();
      this.volume.method1331(var1);
      int var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.offset;
         this.pitchModifier = new SoundEnvelope();
         this.pitchModifier.method1331(var1);
         this.pitchModifierAmplitude = new SoundEnvelope();
         this.pitchModifierAmplitude.method1331(var1);
      }

      var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.offset;
         this.volumeMultiplier = new SoundEnvelope();
         this.volumeMultiplier.method1331(var1);
         this.volumeMultiplierAmplitude = new SoundEnvelope();
         this.volumeMultiplierAmplitude.method1331(var1);
      }

      var2 = var1.readUnsignedByte();
      if (var2 != 0) {
         --var1.offset;
         this.release = new SoundEnvelope();
         this.release.method1331(var1);
         this.attack = new SoundEnvelope();
         this.attack.method1331(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2658();
         if (var4 == 0) {
            break;
         }

         this.oscillatorVolume[var3] = var4;
         this.oscillatorPitch[var3] = var1.method2657();
         this.oscillatorDelays[var3] = var1.method2658();
      }

      this.delayTime = var1.method2658();
      this.delayDecay = var1.method2658();
      this.duration = var1.readUnsignedShort();
      this.offset = var1.readUnsignedShort();
      this.filter = new AudioFilter();
      this.filterEnvelope = new SoundEnvelope();
      this.filter.method1420(var1, this.filterEnvelope);
   }
}
