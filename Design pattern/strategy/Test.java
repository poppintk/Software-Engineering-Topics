package strategy;

public class Test {
    public static void main(String[] args){
        Duck duck = new NormalDuck();
        System.out.println(duck.display());

        Duck superDuck = new SuperDuck();
        System.out.println(superDuck.display());


        // make normal duck with super power
        Flyable superFly = new SuperFly();
        Quakable quakable = new SuperQuake();

        duck.setFlyable(superFly);
        duck.setQuakable(quakable);

        System.out.println(duck.display());

        /**
         * strategy pattern works on mutiple algorithms
         * 策略模式 定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法地变化独立于使用算法的客户
         */
        /**
         * 设计原则
         * 1） 找粗应用中可能需要变化之处，把他们独立出来。
         * 2） 多用组合(has-a -> )，少用继承（is - a or extends -\>）, implement - - - \>
         * 3） 针对接口编程，而不是针对实现编程
         */



    }
}
