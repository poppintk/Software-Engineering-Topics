package strategy;

public class NormalDuck extends Duck {
    public NormalDuck() {
        flyable = new NormalFly();
        quakable = new NormalQuake();
    }


    public String display() {
        return "I'M Normal duck: " + this.fly() + " " + this.quake();
    }
}
