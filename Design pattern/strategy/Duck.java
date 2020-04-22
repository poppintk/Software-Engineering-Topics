package strategy;

public class Duck {
    Flyable flyable;
    Quakable quakable;

    public Duck() {
    }

    String fly(){
        return flyable.fly();
    }

    String quake(){
        return quakable.quake();
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void setQuakable(Quakable quakable) {
        this.quakable = quakable;
    }

    String swim(){
        return "swim!";
    }

    // alternatively, we can make display abstract and make strategy.Duck abstract class
    public String display(){
        return null;
    };

}
