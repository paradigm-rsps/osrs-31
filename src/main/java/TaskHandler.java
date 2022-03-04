import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("TaskHandler")
public class TaskHandler implements Runnable {
   @ObfuscatedName("i")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("w")
   @Export("javaVersion")
   static String javaVersion;
   @ObfuscatedName("es")
   @Export("compass")
   @ObfuscatedSignature(
      descriptor = "Lclass85;"
   )
   static SpritePixels compass;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      descriptor = "[Lclass86;"
   )
   static IndexedSprite[] field1338;
   @ObfuscatedName("f")
   class42 field1326;
   @ObfuscatedName("e")
   @Export("current")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   Task current = null;
   @ObfuscatedName("t")
   @Export("task")
   @ObfuscatedSignature(
      descriptor = "Lclass78;"
   )
   Task task = null;
   @ObfuscatedName("d")
   Thread field1329;
   @ObfuscatedName("p")
   @Export("isClosed")
   boolean isClosed = false;
   @ObfuscatedName("k")
   @Export("thread")
   public EventQueue thread;

   TaskHandler() {
      javaVendor = "Unknown";
      javaVersion = "1.1";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.thread = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.isClosed = false;
      this.field1329 = new Thread(this);
      this.field1329.setPriority(10);
      this.field1329.setDaemon(true);
      this.field1329.start();
   }

   @ObfuscatedName("e")
   @Export("method1624")
   final void method1624() {
      synchronized(this) {
         this.isClosed = true;
         this.notifyAll();
      }

      try {
         this.field1329.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   @Export("method1610")
   @ObfuscatedSignature(
      descriptor = "(IIILjava/lang/Object;)Lclass78;"
   )
   final Task method1610(int var1, int var2, int var3, Object var4) {
      Task var5 = new Task();
      var5.type = var1;
      var5.intArgument = var2;
      var5.objectArgument = var4;
      synchronized(this) {
         if (this.task != null) {
            this.task.next = var5;
            this.task = var5;
         } else {
            this.task = this.current = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("d")
   @Export("method1612")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Lclass78;"
   )
   public final Task createSocket(String var1, int var2) {
      return this.method1610(1, var2, 0, var1);
   }

   @ObfuscatedName("p")
   @Export("method1599")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Runnable;I)Lclass78;"
   )
   public final Task method1599(Runnable var1, int var2) {
      return this.method1610(2, var2, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)Lclass78;"
   )
   public final Task method1605(int var1) {
      return this.method1610(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;)Lclass78;"
   )
   public final Task method1601(URL var1) {
      return this.method1610(4, 0, 0, var1);
   }

   @ObfuscatedName("l")
   public final class42 method1602() {
      return this.field1326;
   }

   public final void run() {
      while(true) {
         Task var1;
         synchronized(this) {
            while(true) {
               if (this.isClosed) {
                  return;
               }

               if (this.current != null) {
                  var1 = this.current;
                  this.current = this.current.next;
                  if (this.current == null) {
                     this.task = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.type;
            if (var5 == 1) {
               var1.result = new Socket(InetAddress.getByName((String)var1.objectArgument), var1.intArgument);
            } else if (var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.objectArgument);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.intArgument);
               var1.result = var3;
            } else if (var5 == 4) {
               var1.result = new DataInputStream(((URL)var1.objectArgument).openStream());
            } else if (var5 == 3) {
               String var10 = (var1.intArgument >> 24 & 255) + "." + (var1.intArgument >> 16 & 255) + "." + (var1.intArgument >> 8 & 255) + "." + (var1.intArgument & 255);
               var1.result = InetAddress.getByName(var10).getHostName();
            }

            var1.status = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.status = 2;
         }
      }
   }

   @ObfuscatedName("f")
   @Export("method1625")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if (var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if (var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if (var7 == 402) {
            var3[var6 + var4] = -125;
         } else if (var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if (var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if (var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if (var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if (var7 == 710) {
            var3[var6 + var4] = -120;
         } else if (var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if (var7 == 352) {
            var3[var6 + var4] = -118;
         } else if (var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if (var7 == 338) {
            var3[var6 + var4] = -116;
         } else if (var7 == 381) {
            var3[var6 + var4] = -114;
         } else if (var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if (var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if (var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if (var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if (var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if (var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if (var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if (var7 == 732) {
            var3[var6 + var4] = -104;
         } else if (var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if (var7 == 353) {
            var3[var6 + var4] = -102;
         } else if (var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if (var7 == 339) {
            var3[var6 + var4] = -100;
         } else if (var7 == 382) {
            var3[var6 + var4] = -98;
         } else if (var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("f")
   @Export("method1598")
   @ObfuscatedSignature(
      descriptor = "(Lclass151;Ljava/lang/String;Ljava/lang/String;)Lclass86;"
   )
   public static IndexedSprite method1598(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.method3219(var1);
      int var4 = var0.method3238(var3, var2);
      IndexedSprite var5;
      if (!KitDefinition.method796(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite var7 = new IndexedSprite();
         var7.width = class83.SpriteBuffer_spriteWidth;
         var7.height = class83.SpriteBuffer_spriteHeight;
         var7.xOffset = class83.SpriteBuffer_xOffsets[0];
         var7.yOffset = class165.SpriteBuffer_yOffsets[0];
         var7.subWidth = class112.SpriteBuffer_spriteWidths[0];
         var7.subHeight = class83.SpriteBuffer_spriteHeights[0];
         var7.palette = FloorUnderlayDefinition.SpriteBuffer_spritePalette;
         var7.pixels = class145.SpriteBuffer_pixels[0];
         FileSystem.method1515();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("d")
   public static String method1595(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if (var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if (var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if (var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if (Character.isLetter(var5)) {
            var3 = 0;
         } else if (var5 != '.' && var5 != '?' && var5 != '!') {
            if (Character.isSpaceChar(var5)) {
               if (var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("z")
   public static void method1623() {
      SequenceDefinition.SequenceDefinition_cached.method3482();
      SequenceDefinition.SequenceDefinition_cachedFrames.method3482();
   }
}
