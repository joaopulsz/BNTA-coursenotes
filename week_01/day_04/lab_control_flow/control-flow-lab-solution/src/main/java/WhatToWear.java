import java.util.Scanner;

public class WhatToWear {

    public static void main(String[] args) {
        System.out.println("What is the weather like today?");
        Scanner weatherReader = new Scanner(System.in);
        String weatherConditions = weatherReader.nextLine();

        System.out.println("What is the forecast average temperature today?");
        Scanner temperatureReader = new Scanner(System.in);
        String temperatureString = temperatureReader.nextLine();
        int temperature = Integer.parseInt(temperatureString);

        if (weatherConditions.equals("rainy") && temperature <= 10){
            System.out.println("🥶 Wear a waterproof winter coat");
        } else if (weatherConditions.equals("snowy") || temperature <= 5){
            System.out.println("Wear gloves 🧤");
        } else if (weatherConditions.equals("sunny") || temperature > 18){
            System.out.println("Wear sunscreen and sunglasses 😎");
        }

    }

}


