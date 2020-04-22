package template;

public class Test {
    public static void main(String[] args){
        CaffeineBeverage teaHook = new TeaWithHook();
        CaffeineBeverage coffeeWithHook = new CoffeeWithHook();

        System.out.println("\n Making tea....");
        teaHook.prepareRecipe();


        System.out.println("\n Making coffee....");
        coffeeWithHook.prepareRecipe();

        /**
         * 模版方法模式： 在一个方法中定义一个算法的骨架， 而将一些步骤延迟到子类中。 模版方法使得子类可以在不改变算法结构
         * 到情况下，重新定义算法中到某些步骤。
         * 注意： 模版就是一个方法，更具体地说，这个方法将算法定义成一组步骤，其中到任何步骤都可以是抽象的，由子类负责实现。
         *
         * 设计原则：
         *  好莱坞原则： 别调用我们，我们会调用你。
         *
         *  当我们设计模版方法模式时，我们告诉子类，"不要调用我们，我们会调用你"
         *
         */

    }
}
