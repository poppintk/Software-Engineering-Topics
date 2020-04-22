package decorator;

public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";// description 继承自 Beverage
    }

    @Override
    public double cost(){
        return 1.99;
    }
}
