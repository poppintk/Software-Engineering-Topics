package factory_method.pizza;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();


    public void prepare(){
        System.out.println("Preparing pizza : " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for(int i = 0; i < toppings.size();i++){
            System.out.println("    " + toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("Baking pizza for 25 mins at 350");
    }

    public void cut(){
        System.out.println("Cutting pizza");
    }

    public void box(){
        System.out.println("Boxing pizza");
    }

    public String getName(){
        return name;
    }
}
