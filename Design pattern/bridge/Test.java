package bridge;

public class Test {

    public static void main(String[] args){
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();

        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();

        /**
         * When we need bridge design pattern?
         * The bridge pattern is an application of the old advice,"Prefer composition over inheritance". It becomes handy when you must
         * subclass different times in ways that are orthogonal with one another
         * Advantages:
         * 1) Bridge pattern decouple an abstraction from its implementation so that the two can vary independently
         * 2) it is used mainly for implementing platform independence feature.
         * 3) it adds one more method level redirection to achieve the objective
         * 4) Publish abstraction interface in a separete inheritance hierarchy, and put the implementation in its own inheritance hierarchy.
         * 5) use bridge pattern to run-time binding of the implementation.
         * 6) use bridge pattern to map orthogonal class hierarchies
         * 7) Bridge is designed up-front to let the abstraction and the implementation vary independently.
         *
         */
    }
}
