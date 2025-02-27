package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isContinues = true;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        BankManagerMain manager = new BankManagerCopy();
        do {
            System.out.println("\nWelcome To Yes Bank,How Can I help You");
            System.out.println("------------------------------------------------------");
            System.out.println("1.Create new Bank Account\n2.View my Account details\n3.Update Account details \n4.Delete Account\n5.Exit");
            try {
                int n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        manager.createAccount();
                        break;
                    case 2:
                        manager.fetchAccountDetails();
                        break;
                    case 3:
                        manager.updateAccountDetails();
                        break;
                    case 4:
                        manager.deleteAccount();
                        break;
                    case 5:
                        manager.exitBank();
                        break;
                    default:
                        System.out.println("Please enter a valid operation");

                }
            }catch(  InputMismatchException ex1){
                System.out.println("*** Invalid Input ***\nPlease Enter a number");
                sc.nextLine();
            }
        }while (isContinues) ;

    }
}