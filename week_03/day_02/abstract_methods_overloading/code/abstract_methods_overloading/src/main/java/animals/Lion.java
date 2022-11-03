package animals;

public class Lion extends Animal{

    private boolean canWaitToBeKing;

    public Lion(String name, boolean canWaitToBeKing) {
        super(name);
        this.canWaitToBeKing = canWaitToBeKing;
    }

    public boolean isCanWaitToBeKing() {
        return canWaitToBeKing;
    }

    public void setCanWaitToBeKing(boolean canWaitToBeKing) {
        this.canWaitToBeKing = canWaitToBeKing;
    }

    @Override
    public String makeNoise() {
        return "Roar!";
    }

}
