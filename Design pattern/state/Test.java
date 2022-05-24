package state;


public class Test {

    public static void main(String[] args){
        GumballMachine gumballMachine = new GumballMachine(4);

        System.out.println(gumballMachine);
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();

        gumballMachine.ejectQuarter();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.turnCrank();

        gumballMachine.ejectQuarter();

        /**
         * State pattern
         * 状态模式： 允许对象在内部状态改变时改变它的行为， 对象看起来好像修改来它的类
         * Precondition when apply this pattern: 1) each of use case will result in state change 2) state change will impact on use case 
         */
    }
}
