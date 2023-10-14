package org.ulpgc.is1.model;

public class Member extends Customer {
    private int points;

    private Adress adress;

    public Member(String name, String surname, Nif nif, int points, Adress adress) {
        super(name, surname, nif);
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
