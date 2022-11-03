package stuff;

public class Pet {

    private String name;
    private String species;
    private Toy toy;

    public Pet(String name, String species, Toy toy){
        this.name = name;
        this.species = species;
        this.toy = toy;
    }

    public void playWithToy(){
        this.toy.makeNoise();
    }

}
