package org.example;

public class ContactManager implements ContactAdmin {


    public void addContact(){
        System.out.println("Enter name of the contact");
        String name = sc.nextLine();
        System.out.println("Enter Mobile number");
        long numb=sc.nextLong();
        System.out.println("Enter email of the person");
        sc.nextLine();
        String mail=sc.nextLine();
        list.add(new Contacts(name,numb,mail));
        System.out.println("Contact added successfully");

    }

    public  void seeContacts() {

        if (list.isEmpty()) {
            System.out.println("You have no contacts ,please create one to view");
        } else {
            for (Contacts i : list) {
                System.out.println(i);
            }
        }
    }

    public void deleteContact() {

        if (list.isEmpty()) {
            System.out.println("You have no contacts ,Try Creating one!");
        } else {
            System.out.println("Enter the name of contact you like to delete");
            String newName = sc.nextLine();
            Contacts yesFound=null;
            for (Contacts i : list) {
                if (i.getName().equalsIgnoreCase(newName)) {
                    yesFound = i;
                    break;
                }
            }
            if (yesFound!=null) {
                list.remove(yesFound);
                System.out.println("Contact Deleted successfully");
            } else {
                System.out.println("There is no such contact in your list ");
            }
        }
    }

    public void updateContact(){
        if (list.isEmpty()) {
            System.out.println("you have no contacts yet,please create one to Update");
            return;
        }
        else {
            System.out.println("Enter the name of the contact you like to update");
            String update1 = sc.nextLine();
            for (Contacts i : list) {
                if (i.getName().equalsIgnoreCase(update1)) {
                    System.out.println("Enter new name");
                    i.setName(sc.nextLine());
                    System.out.println("Enter new number");
                    i.setNumber(sc.nextLong());
                    System.out.println("Contact Updated Successfully");
                    return;
                }
            }
        }
        System.out.println("Contact not found");
    }

    public void exitContact(){
        Main.isContinues = false;
        System.out.println("\n---- Bye Now ! ----");
    }

}

