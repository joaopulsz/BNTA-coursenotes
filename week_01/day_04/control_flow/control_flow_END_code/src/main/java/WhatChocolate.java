import java.util.Scanner;

public class WhatChocolate {

    public static void main(String[] args) {
        // Prompt a user to input their favourite chocolate
        // Collect user input
        // if chocolate is bounty, print 'Gross'
        // otherwise print 'yum'

        System.out.println("What is your favourite chocolate?");

        Scanner reader = new Scanner(System.in);
        String favouriteChocolate = reader.nextLine();

        if (favouriteChocolate.equals("Bounty")){
            System.out.println("gross");
        } else if (favouriteChocolate.equals("Crunchie")){
            System.out.println("The best!");
        } else {
            System.out.println("yum");
        }

        // TERNARY REFACTOR (for first two statement ONLY)
        // String result = favouriteChocolate.equals("Bounty") ? "Gross" : "Yum";
        // System.out.println(result);
    }

}
