package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public interface BankManagerMain {

    ArrayList<Entity_BankAccount> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void createAccount();
    void fetchAllAccountDetails();
    void fetchAccountDetails();
    void updateAccountDetails();
    void deleteAccount();
    void exitBank();

}
