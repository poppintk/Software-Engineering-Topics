package facade;

public class DvdPlayer {

    void on(){
        System.out.println("DVD is on");
    }

    void play(String movie){
        System.out.println("Movie" + movie + " is playing");
    }
    void stop(){
        System.out.println("DVD is off");
    }
    void eject(){
        System.out.println("DVD is ejected");
    }

    void off(){
        System.out.println("DVD is off");
    }
}
