package org.example;

public class Entity_BankAccount {
    private long accountNumber;
    private String accountHolderName;
    private double balanceAmount;
    private long contactNumber;
    private String address;
    private static long baseAccountnumber = 10100056789L;

    public Entity_BankAccount(String accountHolderName,double balanceAmount,long contactNumber,String address){

        this.accountNumber=generateAccountNumber();
        this.accountHolderName=accountHolderName;
        this.balanceAmount=balanceAmount;
        this.contactNumber=contactNumber;
        this.address=address;
    }

    private long generateAccountNumber(){
        return (++baseAccountnumber + 1723);
    }

//    public void depositAmount(int money){
//        if(money>0){
//            balanceAmount+=money;
//        }
//    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {

        this.contactNumber = contactNumber;
    }

   @Override
    public String toString() {
        return "Your_BankAccount\n{\n" +
                "accountNumber = " + accountNumber+"\n" +
                "accountHolderName = " + accountHolderName +"\n"+
                "balanceAmount = " + balanceAmount +"\n"+
                "contactNumber = " + contactNumber +"\n"+
                "address = " + address + "\n}";

    }
}
