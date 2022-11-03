package animals;

public class Parrot extends Bird{

    public Parrot(String name){
        super(name);
    }

    @Override
    public String makeNoise(){
        return "Squawk!";
    }

    public String sayName(){
        return String.format("My name is %s.", this.name);
    }

}
