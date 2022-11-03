public class ArraysPlayground {

    public static void main(String[] args) {

//        String trainer1 = "Anna";
//        String trainer2 = "Colin";
//        String trainer3 = "Iain";

        String[] trainers = {"Anna", "Colin", "Iain", "Zsolt"};
//
//        String firstTrainer = trainers[10];
//
//        System.out.println(firstTrainer);

        String[] emptyTrainers = new String[3]; // [null (0), null (1), null (2)]

        emptyTrainers[0] = "Anna";
        emptyTrainers[1] = "Colin";
        emptyTrainers[2] = "Iain";

        System.out.println(emptyTrainers[2]);

        emptyTrainers[2] = "Zsolt";

        System.out.println(emptyTrainers[2]);

        int trainerCount = trainers.length;

        System.out.println(trainerCount);

        emptyTrainers[3] = "Richard";
        System.out.println(emptyTrainers);


    }

}
