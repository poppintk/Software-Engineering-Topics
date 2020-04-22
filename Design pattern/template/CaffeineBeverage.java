package template;

public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    //变化的部分
    abstract void brew();
    //变化的部分
    abstract void addCondiments();

    /**
     * 以下是不变的部分
     */
    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }


    /**
     *
     * 我们在这里定义类一个方法（通常） 是空的缺省实现。 这个方法只会返回true， 不做别的事。
     * 这就是一个钩子，但不见得一定要这么做。
     */
    boolean customerWantsCondiments(){
        return true;
    }
}
