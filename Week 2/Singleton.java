import java.io.*;
class Singleton {
    private static Singleton instance;
    private Singleton()
    {
        System.out.println("Singleton created.");
    }
    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    public static void testMethod()
    {
        System.out.println("This is a Singleton class.");
    }
}

class Main {
    public static void main(String[] args)
    {
        Singleton s = Singleton.getInstance();
        s.testMethod();
    }
}