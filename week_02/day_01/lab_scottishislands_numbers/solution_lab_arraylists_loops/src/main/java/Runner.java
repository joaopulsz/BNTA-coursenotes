import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

//        SCOTTISH ISLANDS
        List<String> scottishIslands = new ArrayList<>();
        scottishIslands.add("Jura");
        scottishIslands.add("Mull");
        scottishIslands.add("Skye");
        scottishIslands.add("Arran");
        scottishIslands.add("Tresco");

//        1. Add "Coll" to the end of the list
        scottishIslands.add("Coll");

//        2. Add "Tiree" to the start of the list
        scottishIslands.add(0, "Tiree");

//        3. Add "Islay" after "Jura" and before "Mull"
        scottishIslands.add(2, "Islay");

//        4. Print out the index position of "Skye"
        int skyeIndex = scottishIslands.indexOf("Skye");
        System.out.println("Skye index: " + skyeIndex);

//        5. Remove "Tresco" from the list by name
        scottishIslands.remove("Tresco");

//        6. Remove "Arran" from the list by index
        scottishIslands.remove(5);

//        7. Print the number of islands in your arraylist
        int numberOfIslands = scottishIslands.size();
        System.out.println("number of islands: " + numberOfIslands);

//        8. Sort the list alphabetically
        Collections.sort(scottishIslands);

//        9. Print out all the islands using a for loop
        for (String island : scottishIslands) {
            System.out.println(island);
        }

        System.out.println(scottishIslands);



//        NUMBERS
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 1, 4, 2, 7, 1, 6, 15, 13, 99, 7);

        System.out.println("numbers: " + numbers);

//        1. Print out a list of the even integers
        List<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers){
            if (number % 2 == 0){
                evenNumbers.add(number);
            }
        }
        System.out.println("even numbers: " + evenNumbers);

//        2. Print the difference between the largest and smallest value
        int maxNumber = Collections.max(numbers);
        int minNumber = Collections.min(numbers);
        int difference = maxNumber - minNumber;
        System.out.println("difference between min and max: " + difference);

//        3. Print true if the list contains a 1 next to a 1 somewhere.
        boolean result = false;
        int index = 0;
        for (int number : numbers) {
            if(number == 1 && numbers.get(index+1) == 1){
                result = true;
            }
            index += 1;
        }
         System.out.println("(numbers contains 1 next to a 1) is: " + result);

//        4. Print the sum of the numbers
        int sumOfNumbers = 0;
        for (int number : numbers){
            sumOfNumbers += number;
        }
        System.out.println("Sum of numbers: " + sumOfNumbers);


//        5. Print the sum of the numbers...
//           ...except the number 13 is unlucky, so it does not count...
//           ...and numbers that come immediately after a 13 also do not count.
//
//          So [7, 2, 13, 2] would have sum of 9.

        int total = 0;
        for (int number : numbers){
            if(number == 13){ 
                break;
            }
            total += number;
        }
        System.out.println("Sum of numbers (no 13!): " + total);
    }


}
