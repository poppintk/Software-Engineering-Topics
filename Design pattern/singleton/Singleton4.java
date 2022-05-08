package singleton;

public class Singleton3 {
    private static Singleton3 uniqueInstance = new Singleton3(); // create instance at initial runtime

    private Singleton3(){}
    
    public static Singleton3 getInstance(){
        return uniqueInstance;
    }

}
