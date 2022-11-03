package model;

import model.interfaces.IAnimal;
import model.interfaces.IPrey;
import model.interfaces.ISwim;

public class Seal implements IAnimal, ISwim, IPrey {

    @Override
    public void eat() {
        System.out.println("Seal is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Seal is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Seal is swimming");
    }

    @Override
    public void flee() {
        System.out.println("Seal is fleeing from preditor");
    }
}
