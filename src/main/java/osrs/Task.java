package osrs;

public class Task {
    Task next;
    public volatile int status = 0;
    int type;
    public int intArgument;
    Object objectArgument;
    public volatile Object result;
}
