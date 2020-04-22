package adaptor;

public class Test {

    public static void main(String[] args){
        MallardDuck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();

        Duck turkyAdapter = new TurkeyAdaptor(turkey);

        System.out.println("The turkey says....");

        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says....");
        duck.quack();
        duck.fly();

        System.out.println("\n The TurkeyAdapter says....");

        turkyAdapter.quack();
        turkyAdapter.fly();

        /**
         * 适配器模式： 将一个类的接口，转化成客户期望的另一个接口， 适配器让原本接口不兼容的类可以合作无间。
         *
         * 注意： 一个类转化另一个类，不支持一对多的转化， 如果要支持用facade pattern (外观模式)
         * 适配器模式将一个或多个类接口变成客户所期望的一个接口。 虽然大多数教科书采用的例子中适配器只适配一个类，但是你可
         * 以适配许多类来提供一个接口让客户编码。类似地，一个外观也可以只针对一个拥有复杂接口的类提供简化的接口。两种模式的差异，不在于
         * 他们"包装" 类几个类，而是在于他们的意图。适配器模式的意图是，"改变" 接口符合客户的期望；而外观模式的意图
         * 是，提供子系统的一个简化接口。
         *
         * 这个是对象适配器的例子，即通过组合来适配被适配者
         * 另一种是 类适配器，
         * 类适配器不是使用组合来适配被适配者，而是继承被适配者和目标类。
         *
         * 模版方法 VS 策略
         * 1） 模版方法用当是继承abstract class 定义类一个算法大纲，由子类定义其中某些步骤的内容
         * , 而策略用的是组合让客户可以选择算法实现
         * 2）
         *
         */


    }
}
