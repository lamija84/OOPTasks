package week13.github;

public class Singleton {
    private static Singleton instance;
    private String connectionString;

    private Singleton(String connectionString)
    {
        this.connectionString=connectionString;
    }

    public static Singleton getInstance(String connectionString)
    {
        synchronized (Singleton.class)
        {
            if(instance == null)
            {
                instance=new Singleton(connectionString);
            }
        }
        return instance;
    }
    public enum SingletonEnum
    {
        INSTANCE;
    }

}
class Tester {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance("becir");
        Singleton anotherInstance = Singleton.getInstance("Becir aga");

        if(s.equals(anotherInstance)){
            System.out.println("They are the same");
            System.out.println(s.toString());
            System.out.println(anotherInstance.toString());
        }
    }
}