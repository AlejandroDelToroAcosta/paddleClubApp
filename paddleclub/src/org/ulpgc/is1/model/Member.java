package org.ulpgc.is1.model;

import java.util.ArrayList;

public class Member extends Customer {
    private int points;

    private Adress adress;

    public Member(String name, String surname, NIF nif, int points, Adress adress, ArrayList<Reservation> reservations) {
        super(name,surname,nif,reservations);
        this.points = points;
        this.adress = adress;
    }

    public void setAdress(String street, int number, int postalCode, String city) {
        this.adress = new Adress(street, number, postalCode, city);

    }

    public String getAdress() {
        return adress.toString();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
