import java.util.ArrayList;

public class ArrayListPlayground {

    public static void main(String[] args) {

        ArrayList<String> trainers = new ArrayList<>();

        trainers.add("Colin");
        trainers.add("Anna");
        trainers.add("Iain");

        System.out.println(trainers);

        String firstTrainer = trainers.get(0);

        System.out.println(firstTrainer);

//        String mysteryTrainer = trainers.get(10);

        System.out.println(trainers.size());

        trainers.remove(0);

        System.out.println(trainers);

    }
}
