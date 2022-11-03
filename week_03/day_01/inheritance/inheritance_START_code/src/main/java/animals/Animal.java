package animals;

public class Animal {

    private String name;
    private String type;
    private boolean healthy;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.healthy = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public String makeNoise(){
        return String.format("Hello, my name is %s.", this.name);
    }

    public String eat(){
        return "Mmm, that was tasty!";
    }
}
