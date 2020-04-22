package strategy;

public class SuperDuck extends Duck{
    public SuperDuck() {
        flyable = new SuperFly();
        quakable = new SuperQuake();
    }

    @Override
    public String display() {
        return "I'm super duck" + this.fly() + this.quake();
    }
}
