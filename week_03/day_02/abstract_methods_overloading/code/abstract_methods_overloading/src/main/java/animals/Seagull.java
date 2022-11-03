package animals;

public class Seagull extends Bird{

    public Seagull(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "MINE!";
    }
}
