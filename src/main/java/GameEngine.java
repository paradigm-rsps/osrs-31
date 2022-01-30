import java.applet.Applet;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pq")
   @Export("volatileFocus")
   static volatile boolean volatileFocus = true;
   @ObfuscatedName("op")
   @Export("gameEngine")
   @ObfuscatedSignature(
      descriptor = "Lclass72;"
   )
   static GameEngine gameEngine = null;
   @ObfuscatedName("ox")
   @Export("isKilled")
   static boolean isKilled = false;
   @ObfuscatedName("om")
   @Export("GameEngine_redundantStartThreadCount")
   static int GameEngine_redundantStartThreadCount = 0;
   @ObfuscatedName("px")
   protected static volatile boolean field1318 = true;
   @ObfuscatedName("pb")
   protected static volatile boolean field1313 = false;
   @ObfuscatedName("of")
   @Export("stopTimeMs")
   static long stopTimeMs = 0L;
   @ObfuscatedName("on")
   @Export("cycleDurationMillis")
   static int cycleDurationMillis = 20;
   @ObfuscatedName("pi")
   @Export("clientTickTimes")
   protected static long[] clientTickTimes = new long[32];
   @ObfuscatedName("pn")
   @Export("graphicsTickTimes")
   protected static long[] graphicsTickTimes = new long[32];
   @ObfuscatedName("oz")
   @Export("fiveOrOne")
   static int fiveOrOne = 1;
   @ObfuscatedName("og")
   @Export("fps")
   protected static int fps = 0;
   @ObfuscatedName("pz")
   static volatile long field1321 = 0L;
   @ObfuscatedName("ps")
   static int field1319 = 500;
   @ObfuscatedName("oa")
   @Export("hasErrored")
   boolean hasErrored = false;

   @ObfuscatedName("ny")
   @Export("method1537")
   protected final boolean method1537() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if (!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if (var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if (var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method1533("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("nm")
   @Export("method1533")
   protected void method1533(String var1) {
      if (!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("no")
   @Export("method1571")
   protected final synchronized void method1571() {
      Object var1;
      if (ObjectSound.field87 != null) {
         var1 = ObjectSound.field87;
      } else {
         var1 = this;
      }

      if (Tiles.field131 != null) {
         Tiles.field131.removeFocusListener(this);
         ((Container)var1).remove(Tiles.field131);
      }

      Tiles.field131 = new Canvas(this);
      ((Container)var1).add(Tiles.field131);
      Tiles.field131.setSize(SoundSystem.canvasWidth, ItemLayer.canvasHeight);
      Tiles.field131.setVisible(true);
      if (ObjectSound.field87 != null) {
         Insets var2 = ObjectSound.field87.getInsets();
         Tiles.field131.setLocation(var2.left, var2.top);
      } else {
         Tiles.field131.setLocation(0, 0);
      }

      Tiles.field131.addFocusListener(this);
      Tiles.field131.requestFocus();
      field1318 = true;
      field1313 = false;
      field1321 = ClientPreferences.method148();
   }

   @ObfuscatedName("nz")
   @Export("method1524")
   final synchronized void method1524() {
      if (!isKilled) {
         isKilled = true;

         try {
            Tiles.field131.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1532();
         } catch (Exception var4) {
            ;
         }

         if (ObjectSound.field87 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if (ItemContainer.taskHandler != null) {
            try {
               ItemContainer.taskHandler.method1624();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1534();
      }
   }

   @ObfuscatedName("nv")
   @Export("method1519")
   protected final void method1519(int var1, int var2, int var3) {
      try {
         if (gameEngine != null) {
            ++GameEngine_redundantStartThreadCount;
            if (GameEngine_redundantStartThreadCount >= 3) {
               this.method1533("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         gameEngine = this;
         SoundSystem.canvasWidth = var1;
         ItemLayer.canvasHeight = var2;
         class125.RunException_revision = var3;
         RunException.RunException_applet = this;
         if (ItemContainer.taskHandler == null) {
            ItemContainer.taskHandler = new TaskHandler();
         }

         ItemContainer.taskHandler.method1599(this, 1);
      } catch (Exception var5) {
         ScriptEvent.method3((String)null, var5);
         this.method1533("crash");
      }

   }

   @ObfuscatedName("nh")
   @Export("method1593")
   void method1593() {
      long var1 = ClientPreferences.method148();
      long var3 = clientTickTimes[VarpDefinition.field1040];
      clientTickTimes[VarpDefinition.field1040] = var1;
      VarpDefinition.field1040 = VarpDefinition.field1040 + 1 & 31;
      if (var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class23.hasFocus = volatileFocus;
      }

      this.vmethod1530();
   }

   @ObfuscatedName("ni")
   void method1523() {
      long var1 = ClientPreferences.method148();
      long var3 = graphicsTickTimes[World.field203];
      graphicsTickTimes[World.field203] = var1;
      World.field203 = World.field203 + 1 & 31;
      if (var3 != 0L && var1 > var3) {
         int var5 = (int)(var1 - var3);
         fps = ((var5 >> 1) + 32000) / var5;
      }

      if (++field1319 - 1 > 50) {
         field1319 -= 50;
         field1318 = true;
         Tiles.field131.setSize(SoundSystem.canvasWidth, ItemLayer.canvasHeight);
         Tiles.field131.setVisible(true);
         if (ObjectSound.field87 != null) {
            Insets var6 = ObjectSound.field87.getInsets();
            Tiles.field131.setLocation(var6.left, var6.top);
         } else {
            Tiles.field131.setLocation(0, 0);
         }
      }

      this.vmethod1586();
   }

   @ObfuscatedName("e")
   protected abstract void vmethod1534();

   @ObfuscatedName("p")
   protected abstract void vmethod1529();

   @ObfuscatedName("k")
   @Export("vmethod1530")
   protected abstract void vmethod1530();

   @ObfuscatedName("r")
   protected abstract void vmethod1586();

   @ObfuscatedName("l")
   @Export("vmethod1532")
   protected abstract void vmethod1532();

   public void destroy() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = ClientPreferences.method148();
         SequenceDefinition.method761(5000L);
         this.method1524();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if (this == gameEngine && !isKilled) {
         field1318 = true;
         if (TaskHandler.javaVersion != null && TaskHandler.javaVersion.startsWith("1.5") && ClientPreferences.method148() - field1321 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if (var2 == null || var2.width >= SoundSystem.canvasWidth && var2.height >= ItemLayer.canvasHeight) {
               field1313 = true;
            }
         }

      }
   }

   public void run() {
      try {
         int var3;
         if (TaskHandler.javaVendor != null) {
            String var1 = TaskHandler.javaVendor.toLowerCase();
            if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = TaskHandler.javaVersion;
               if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method1533("wrongjava");
                  return;
               }

               if (var2.startsWith("1.6.0_")) {
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= '0' && var5 <= '9';
                     if (!var4) {
                        break;
                     }
                  }

                  String var6 = var2.substring(6, var3);
                  if (Tiles.method112(var6)) {
                     int var11 = FaceNormal.method2027(var6, 10, true);
                     if (var11 < 10) {
                        this.method1533("wrongjava");
                        return;
                     }
                  }
               }

               fiveOrOne = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method1571();
         MouseRecorder.field262 = BoundaryObject.method2204(SoundSystem.canvasWidth, ItemLayer.canvasHeight, Tiles.field131);
         this.vmethod1529();
         class22.field376 = BufferedFile.method617();

         label83:
         while(true) {
            TaskHandler var9;
            java.awt.Canvas var10;
            do {
               if (0L != stopTimeMs && ClientPreferences.method148() >= stopTimeMs) {
                  break label83;
               }

               class135.field2329 = class22.field376.vmethod1701(cycleDurationMillis, fiveOrOne);

               for(int var7 = 0; var7 < class135.field2329; ++var7) {
                  this.method1593();
               }

               this.method1523();
               var9 = ItemContainer.taskHandler;
               var10 = Tiles.field131;
            } while(var9.thread == null);

            for(var3 = 0; var3 < 50 && var9.thread.peekEvent() != null; ++var3) {
               SequenceDefinition.method761(1L);
            }

            if (var10 != null) {
               var9.thread.postEvent(new ActionEvent(var10, 1001, "dummy"));
            }
         }
      } catch (Exception var8) {
         ScriptEvent.method3((String)null, var8);
         this.method1533("crash");
      }

      this.method1524();
   }

   public void start() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = 0L;
      }
   }

   public void stop() {
      if (this == gameEngine && !isKilled) {
         stopTimeMs = ClientPreferences.method148() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      volatileFocus = true;
      field1318 = true;
   }

   public final void focusLost(FocusEvent var1) {
      volatileFocus = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }
}
