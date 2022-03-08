package osrs;

public class LoginType {
    public static final LoginType oldscape = new LoginType(6, 0, "", "");
    static final LoginType field2856 = new LoginType(1, 1, "", "");
    static final LoginType field2865 = new LoginType(5, 2, "", "");
    static final LoginType field2858 = new LoginType(2, 3, "", "");
    static final LoginType field2859 = new LoginType(0, 4, "", "");
    static final LoginType field2863 = new LoginType(7, 5, "", "");
    static final LoginType field2861 = new LoginType(3, 6, "", "");
    public static final LoginType field2862;
    public final int field2857;
    final String field2864;

    static {
        field2862 = new LoginType(4, -1, "", "", true, new LoginType[]{oldscape, field2856, field2865, field2859, field2858});
    }

    LoginType(int var1, int var2, String var3, String var4) {
        this.field2857 = var1;
        this.field2864 = var4;
    }

    LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
        this.field2857 = var1;
        this.field2864 = var4;
    }

    public String toString() {
        return this.field2864;
    }
}
