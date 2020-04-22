package adaptor;

public class TurkeyAdaptor implements Duck {
    Turkey turkey;

    public TurkeyAdaptor(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        /**
         * 火鸡的飞行距离很短，不像鸭子可以长途飞行。 要让鸭子的飞行和火鸡的飞行能够对应，必须连续五次调用火鸡的fly()来完成
         */
        for(int i = 0; i < 5; i++){
            turkey.fly();
        }
    }
}
