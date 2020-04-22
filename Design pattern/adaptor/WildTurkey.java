package adaptor;

/**
 * 假设你缺鸭子对象，想用一些火鸡对象来冒充。 显而易见，因为火鸡的接口不同，所以我们不能公然拿来用
 * 那么，就谢个adaptor吧
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
