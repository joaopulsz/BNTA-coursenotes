import model.interfaces.IAnimal;

import java.util.ArrayList;

public class Zoo {
    // The IAnimal interface doesn't exist yet, can you fix the error?
    public ArrayList<IAnimal> allAnimals;

    public Zoo() {
        allAnimals = new ArrayList<IAnimal>();
    }

    public void addAnimal(IAnimal animal) {
        allAnimals.add(animal);
    }
}
