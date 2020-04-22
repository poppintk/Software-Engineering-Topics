package singleton;

/**
 * 性能是个问题
 */
public class Singleton3 {
    private static  Singleton3 uniqueInstance;

    private Singleton3(){}

    /**
     *
     * 通过增加synchzonized 关键字到getInstance()方法中，我们迫使每个线程在进入这个方法之前，要先等候别等
     * 线程离开该方法。也就是说，不会有2个线程可以同时进入这个方法
     * 但是性能是个问题
     */
    public static synchronized Singleton3 getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }

        return uniqueInstance;
    }

}
