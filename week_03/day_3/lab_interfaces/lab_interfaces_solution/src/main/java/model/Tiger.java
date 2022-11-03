package model;

import model.interfaces.*;

public class Tiger implements IAnimal, IRun, IHunt, ISwim {

    @Override
    public void eat() {
        System.out.println("Tiger is eating");

    }

    @Override
    public void sleep() {
        System.out.println("Tiger is sleeping");
    }

    @Override
    public void hunt() {
        System.out.println("Tiger is hunting");
    }

    @Override
    public void run() {
        System.out.println("Tiger is running");
    }

    @Override
    public void swim() {
        System.out.println("Tiger is swimming");
    }
}
