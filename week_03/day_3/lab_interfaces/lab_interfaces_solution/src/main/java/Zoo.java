import model.Seal;
import model.interfaces.IAnimal;
import model.interfaces.ISwim;

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
