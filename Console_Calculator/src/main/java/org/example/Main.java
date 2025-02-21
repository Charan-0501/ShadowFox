package org.example;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continues = true;
        do {
            System.out.println("Welcome to Calci, What do you want to perform ?");
            System.out.println("-----------------------------------------------------------");
            System.out.println(" 1. +\n 2. -\n 3. *\n 4. /\n 5. %");

            int n = sc.nextInt();
            System.out.println("Enter two numbers :");
            double a = sc.nextInt();
            double b = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Addition of " + a + " and " + b + " is : " + (a + b));
                    break;
                case 2:
                    System.out.println("Subtraction of " + a + " and " + b + " is : " + (a - b));
                    break;
                case 3:
                    System.out.println("Multiplication of " + a + " and " + b + " is : " + (a * b));
                    break;
                case 4:
                    System.out.println("Division of " + a + " and " + b + " is : " + (a/b));
                    break;
                case 5:
                    System.out.println("Modulo of " + a + " and " + b + " is : " + (a % b));
                    break;
                default:
                    System.out.println("Invalid Operation");
            }
            System.out.println( "Please enter yes for another calculation ,otherwise no ");
            String isContinues = sc.nextLine();
            if(isContinues.equalsIgnoreCase("no")) continues=false;


        }while(continues);
    }
}