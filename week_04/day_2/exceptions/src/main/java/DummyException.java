public class DummyException {

    public static String getExampleString() throws Exception{
        return "Everything worked!";
    }

    public static String checkIfNumberEven(int number) throws Exception{
        if (number % 2 == 0){
            return "Number is even";
        }

        throw new Exception("Number isn't even!");
    }

}
