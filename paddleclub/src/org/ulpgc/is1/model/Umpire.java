package org.ulpgc.is1.model;

public class Umpire extends Extra {
    private String name;
    private String surname;

    public Umpire(String name, String surname, int price) {
        super(price);
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName(){
        return name + " " + surname;
    }
}
