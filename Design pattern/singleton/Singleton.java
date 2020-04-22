package singleton;

public class Singleton {
    // 在静态初始化器（static initializes） 中创建单件。 这段代码确保另线程安全
    private static Singleton uniqueInstance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return uniqueInstance;
    }
}
