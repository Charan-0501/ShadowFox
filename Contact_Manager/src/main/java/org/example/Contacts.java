package org.example;

public class Contacts {
    private String name;
    private long number;
    private final String email;

    public String getName(){

        return this.name;
    }

//    public long getNumber(){
//
//        return this.number;
//    }
//    public String getEmail(){
//
//        return this.email;
//    }
    public void setName(String name){

        this.name=name;
    }
//    public void setEmail(String mail){
//        this.email=mail;
//    }
    public void setNumber(long number){
        this.number=number;
    }


    public Contacts(String name,long number,String email){
        this.name=name;
        this.number=number;
        this.email=email;
    }

    @Override
    public String toString(){
        return "name : "+name+",  number: "+number+",  email: "+email;
    }

}
