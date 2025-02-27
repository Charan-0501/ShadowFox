package org.example;

public class BankManagerCopy implements BankManagerMain{


    public void createAccount(){
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Initial Amount");
        double moneyy=sc.nextDouble();
        System.out.println("Enter Mobile Number");
        long number=sc.nextLong();
        System.out.println("Enter Address");
        sc.nextLine();
        String address=sc.nextLine();
        list.add(new Entity_BankAccount(name,moneyy,number,address));
        System.out.println("Account Created successfully");

    }

    public  void fetchAllAccountDetails() {

        if (list.isEmpty()) {
            System.out.println("There are no Accounts");
        } else {
            for (Entity_BankAccount i : list) {
                System.out.println(i);
            }
        }
    }
    public  void fetchAccountDetails() {

        if (list.isEmpty()) {
            System.out.println("You have no Account");
        } else {
            System.out.println("Enter the Account holder name");
            String s = sc.nextLine();
            for (Entity_BankAccount i : list) {
                if(i.getAccountHolderName().equalsIgnoreCase(s)){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("No Account Found with that name");
        }
    }

    public void deleteAccount() {

        if (list.isEmpty()) {
            System.out.println("There are no Accounts to Delete");
        } else {
            System.out.println("Enter the name of Account holder you want to delete");
            String newName = sc.nextLine();
            Entity_BankAccount yesFound=null;
            for (Entity_BankAccount i : list) {
                if (i.getAccountHolderName().equalsIgnoreCase(newName)) {
                    yesFound = i;
                    break;
                }
            }
            if (yesFound!=null) {
                list.remove(yesFound);
                System.out.println("Account Deleted successfully");
            } else {
                System.out.println("No Account Found with that name");
            }
        }
    }

    public void updateAccountDetails(){
        if (list.isEmpty()) {
            System.out.println("There are no Accounts ");
            return;
        }
        else {
            System.out.println("Enter the Account holder name you like to update");
            String update1 = sc.nextLine();
            for (Entity_BankAccount i : list) {
                if (i.getAccountHolderName().equalsIgnoreCase(update1)) {
                    System.out.println("You can only update name and number\n Enter new name");
                    i.setAccountHolderName(sc.nextLine());
                    System.out.println("Enter new contact number");
                    i.setContactNumber(sc.nextLong());
                    System.out.println("Account details updated Successfully");
                    return;
                }
            }
        }
        System.out.println("No Account found with that name");
    }

    public  void exitBank(){
        Main.isContinues = false;
        System.out.println("\n---- Bye Now ! ----");
    }

}
