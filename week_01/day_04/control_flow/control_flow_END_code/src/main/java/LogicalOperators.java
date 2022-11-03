public class LogicalOperators {

    public static void main(String[] args) {

        boolean labHandedIn = true;
        boolean studentPresent = true;

//          LOGICAL &&

        if (labHandedIn && studentPresent) {
            System.out.println("Happy trainers");
        } else {
            System.out.println("Sad trainers");
        }

//        LOGICAL ||
        boolean hasTraining = true; // ADDED
        boolean hasExperience = false;  // ADDED

        if (hasTraining || hasExperience){  // ADDED
            System.out.println("Hired!");
        }

    }

}
