package app.car;

public class IdGen {
    private static long id = 0;

    public static synchronized String getId()
    {
        return String.valueOf(id++);
    }
}
