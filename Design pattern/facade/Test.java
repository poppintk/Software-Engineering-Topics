package facade;



public class Test {

    public static void main(String[] args){
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp,tuner,dvd,cd,projector,lights,screen,popper);

        homeTheaterFacade.watchMovie("Raiders of the Lost Ark");
        System.out.println("----------------");
        homeTheaterFacade.endMovie();
        /**
         * 外观模式：提供类一个统一的接口， 用来访问子系统中一群接口。 外观定义类一个高层接口， 让子系统更容易使用。
         * 设计原则：
         * 最少知识原则： 只和你的密友谈话
         * 这个原则希望我们在设计中，不要让太多的类耦合在一起，免得修改系统中一部分，会影响到其他部分。如果许多类之间互相依赖，那么这个系统就会变成
         * 一个易碎的系统，它需要花许多成本维护，也会因为太复杂而不容易被其他人了解。
         * 例子：
         *  1）不采用这个原则：
         *  public float getTemp(){
         *      Thermometer thermometer = station.getThermomenter();// 这里，我们从气象站取得温度计对象，然后再从温度计对象取得温度
         *      return thermometer.getTemperature();
         *  }
         *
         *  2）采用这个原则
         *  public float getTemp(){
         *      return station.getTemperature(); // 采用此原则时， 我们在气象站中加进一个方法，用来向温度计请求温度。者可以减少我们所依赖的类的数目。
         *  }
         */
    }
}
