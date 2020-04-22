package factory_method;

import factory_method.pizza.ChicagoStyleCheesePizza;
import factory_method.pizza.Pizza;

public class Test {

    public static void main(String[] args){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " +  pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " +  pizza.getName() + "\n");

        /**
         *
         * 工厂方法模式： 定义类一个创建对象的接口，但由子类决定要实例化的类是哪一个。 工厂方法让类把实例化推迟到子类
         *
         * 设计原则：
         * 1）依赖倒置原则（Dependency Inversion Principle
         * 要依赖抽象，不要依赖具体类）
         * 几个指导方针帮助你遵守此原则
         * a) 变量不可以持有具体类的引用
         * 如果使用new, 就会持有具体类的引用。你可以该用工厂来避开这样的做法
         * b) 不要让类派生自具体类
         * 如果派生自具体类，你就会依赖具体类。请派生自一个抽象（接口或者抽象类）
         * c) 不要覆盖基类中已实现的方法。
         * 如果覆盖基类已实现的方法，那么你的基类就不是一个真正适合被继承的抽象。
         * 基类中已实现的方法，应该由所有的子类共享。
         *
         */

    }
}
