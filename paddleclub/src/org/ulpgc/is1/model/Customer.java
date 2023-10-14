package org.ulpgc.is1.model;

public class Customer {
    private String name;
    private String surname;
    private Nif nif;
    //TODO crear clase nif


    public Customer(String name, String surname, Nif nif) {
        this.name = name;
        this.surname = surname;
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }
}
