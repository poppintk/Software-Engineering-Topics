package singleton;

public class Singleton4 {
    private static Singleton4 uniqueInstance = new Singleton4(); // create instance at initial runtime

    private Singleton4(){}
    
    public static Singleton4 getInstance(){
        return uniqueInstance;
    }

}
