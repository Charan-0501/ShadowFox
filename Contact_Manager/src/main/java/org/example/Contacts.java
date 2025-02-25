package org.example;

public class Contacts {
    private String name;
    private long number;
    private String email;

    public String getName(){
        return this.name;
    }

    public long getNumber(){
        return this.number;
    }
    public String getEmail(){
        return this.email;
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
