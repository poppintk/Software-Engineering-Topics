package decorator;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    /**
     * 要让Mocha 能够引用 一个Beverage,做法如下
     * 1） 用一个实例变量记录饮料，也就是被装饰者。
     * 2） 想棒法让被装饰者（饮料） 被记录到实例变量中，这里到做法是，把饮料当作构造器到参数，再由构造器将此饮料记录在实例变量中。
     *
     */

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
