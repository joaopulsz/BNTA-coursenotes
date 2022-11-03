package model;

import model.interfaces.IAnimal;
import model.interfaces.IFly;
import model.interfaces.IHunt;

public class Eagle  implements IFly, IHunt {

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }

   // @Override
    public void hunt() {
        System.out.println("Eagle is flying");
    }
}
