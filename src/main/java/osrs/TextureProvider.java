package osrs;

public class TextureProvider implements TextureLoader {
    static String userHomeDirectory;
    static IndexedSprite field1834;
    Texture[] textures;
    NodeDeque deque = new NodeDeque();
    int capacity;
    int remaining = 0;
    double brightness = 1.0D;
    int textureSize = 128;
    AbstractArchive archive;

    public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
        this.archive = var2;
        this.capacity = var3;
        this.remaining = this.capacity;
        this.brightness = var4;
        this.textureSize = var6;
        int[] var7 = var1.method3248(0);
        int var8 = var7.length;
        this.textures = new Texture[var1.method3214(0)];

        for (int var9 = 0; var9 < var8; ++var9) {
            Buffer var10 = new Buffer(var1.method3204(0, var7[var9]));
            this.textures[var7[var9]] = new Texture(var10);
        }

    }

    public int[] vmethod2397(int var1) {
        Texture var2 = this.textures[var1];
        if (var2 != null) {
            if (var2.pixels != null) {
                this.deque.method3529(var2);
                var2.isLoaded = true;
                return var2.pixels;
            }

            boolean var3 = var2.method2018(this.brightness, this.textureSize, this.archive);
            if (var3) {
                if (this.remaining == 0) {
                    Texture var4 = (Texture) this.deque.method3532();
                    var4.method2022();
                } else {
                    --this.remaining;
                }

                this.deque.method3529(var2);
                var2.isLoaded = true;
                return var2.pixels;
            }
        }

        return null;
    }

    public int vmethod2406(int var1) {
        return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
    }

    public boolean vmethod2418(int var1) {
        return this.textures[var1].field1494;
    }

    public boolean vmethod2395(int var1) {
        return this.textureSize == 64;
    }

    public void method2396(double var1) {
        this.brightness = var1;
        this.method2410();
    }

    public void method2410() {
        for (int var1 = 0; var1 < this.textures.length; ++var1) {
            if (this.textures[var1] != null) {
                this.textures[var1].method2022();
            }
        }

        this.deque = new NodeDeque();
        this.remaining = this.capacity;
    }

    public void method2399(int var1) {
        for (int var2 = 0; var2 < this.textures.length; ++var2) {
            Texture var3 = this.textures[var2];
            if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
                var3.method2017(var1);
                var3.isLoaded = false;
            }
        }

    }
}
