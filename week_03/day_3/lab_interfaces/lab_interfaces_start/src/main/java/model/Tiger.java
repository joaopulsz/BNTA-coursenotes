package model;

import model.interfaces.ISwim;

// Hint: missing an interface and a method implementation
public class Tiger implements ISwim {

    @Override
    public void swim() {
        System.out.println("Tiger is swimming");
    }
}
