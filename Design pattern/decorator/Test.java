package decorator;

public class Test {

    public static void main(String[] args){
        Beverage beverage = new Espresso();

        beverage = new Mocha(beverage); // Note: Mocha and Soy are concrete decorator type, 
        beverage = new Mocha(beverage); // Decorator is abstracted class has internal member variable of Beverage(target to be decorated) which also inherited Beverage type 
        beverage = new Soy(beverage);

        System.out.println(beverage.getDescription() + " cost:$" + beverage.cost());

        /**
         * 装饰者模式： 动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案
         * 设计原则：
         *  类应该对扩展开放，对修改关闭
         *  允许系统在不修改代码对情况下，进行功能扩展。
         */
    }
}
