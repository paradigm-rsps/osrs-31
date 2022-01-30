import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fi")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
   @ObfuscatedName("i")
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("size")
   int size;
   @ObfuscatedName("f")
   @Export("intReplaceValues")
   int[] intReplaceValues;
   @ObfuscatedName("e")
   @Export("operations")
   int[] operations;
   @ObfuscatedName("t")
   @Export("creationErrors")
   int[] creationErrors;
   @ObfuscatedName("d")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("p")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("k")
   @Export("arguments")
   byte[][][] arguments;
}
