package org.ulpgc.is1.model;
import java.util.ArrayList;

public class Customer {
    public String name;
    public String surname;
    public NIF nif;
    private ArrayList<Reservation> reservations;


    public Customer(String name, String surname, NIF nif, ArrayList<Reservation> reservations) {
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.reservations = reservations;
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

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nif=" + nif.getNumber() +
                '}'
                ;
    }

    public Reservation getReservations(int index) {
        return reservations.get(index);
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
