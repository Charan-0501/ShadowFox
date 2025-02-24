package org.example;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continues = true;
        do {
            System.out.println("Welcome to Calci, What do you want to perform ?");
            System.out.println("-----------------------------------------------------------");
            System.out.println(" 1. Addition +\n 2. Subtraction-\n 3. Multiplication *\n 4. Division /\n 5. Modulo % ");

            int n = sc.nextInt();
            System.out.println("Enter two numbers :");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            sc.nextLine();

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
                    if(b==0){
                        System.out.println("Division by zero is not possible");
                    }else {
                        System.out.println("Division of " + a + " and " + b + " is : " + (a / b));
                    }
                    break;
                case 5:
                    if(b==0){
                        System.out.println("Modulo by zero is not possible");
                    }else {
                        System.out.println("Modulo of " + a + " and " + b + " is : " + (a % b));
                    }
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