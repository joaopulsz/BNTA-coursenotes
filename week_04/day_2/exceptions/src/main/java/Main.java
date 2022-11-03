import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       String result;

       try {
           result = DummyException.checkIfNumberEven(11);
       } catch (Exception exception){
           result = exception.getMessage();
           exception.printStackTrace();
       }

       System.out.println(result);

    }

}
