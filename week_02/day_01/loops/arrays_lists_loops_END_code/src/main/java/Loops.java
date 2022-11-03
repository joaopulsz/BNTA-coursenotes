import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void main(String[] args) {

        ArrayList<String> colours = new ArrayList<>();
        colours.add("red");
        colours.add("green");
        colours.add("silver");
        colours.add("pink");

        System.out.println(colours);

        System.out.println("--Using enhanced for loop--");
        for (String colour : colours){
            System.out.println(colour);
        }

        System.out.println("--Using classic for loop:--");
        for (int i = 0; i < colours.size(); i++){
            String colour = colours.get(i);
            System.out.println(colour);
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i+=2){
            numbers.add(i);
        }

        System.out.println("numbers: " + numbers);




    }

}
