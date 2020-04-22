package singleton;

/**
 * 双重检查锁
 * 如果性能是你关系的重点，那么这个做法可以帮你大大的减少getInstance()的时间耗费
 * 但是不适合java 1.4 之前的版本
 */
public class Singleton2 {

    private volatile static Singleton2 uniqueInstance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        //检查实例，如果不存在，就进入同步区块
        // 注意，只有第一次才会彻底执行这里的代码
        if(uniqueInstance == null){
            synchronized (Singleton2.class){
                // 进入区块后，在检查一次。如果仍是null,才创建实例
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }
}
