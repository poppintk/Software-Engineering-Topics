package command;


public class Test {

    public static void main(String[] args){
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        Command lightOn = new LightOnCommand(light);
        Command lightoff = new LightOffCommand(light);
        Command garageOpen = new GarageDoorOpenCommand(garageDoor);
        Command garageClose = new GarageDoorOffCommand(garageDoor);


        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();

        RemoteControl smartRemote = new RemoteControl();
        smartRemote.setCommand(0,lightOn,lightoff);
        smartRemote.setCommand(1,garageOpen,garageClose);


        System.out.println(smartRemote.toString());


        /**
         * 命令模式：将"请求"封装成对象，以便使用不同的请求，队列或者日志来参数化其他对象。 命令模式也支持可撤销的操作
         */
    }
}
