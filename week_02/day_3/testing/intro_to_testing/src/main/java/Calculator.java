public class Calculator {

    public Calculator(){

    }

    public int add(int number1, int number2){
        return number1 + number2;
    }

    public int subtract(int number1, int number2){
        return number1 - number2;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public boolean isDivisibleBy(int a, int b){
        return a % b == 0;
    }

    public int doubleIfDivisibleBy(int a, int b){
        if (isDivisibleBy(a, b)){
            return multiply(a, 2);
        } else {
            return a;
        }
    }

}
