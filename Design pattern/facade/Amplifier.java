package facade;

public class Amplifier {

    void on(){
        System.out.println("Amplifier is on");
    }

    void setDvd(DvdPlayer dvd){
        System.out.println("Amplifier set in DVD");
    }

    void  setSurroundSound(){
        System.out.println("Amplifier setting Sounds");
    }

    void setVolume(int v){
        System.out.println("Amplifier setting volume");
    }

    void off(){
        System.out.println("Amplifier setting off");
    }

}
