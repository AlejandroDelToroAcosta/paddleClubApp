package org.ulpgc.is1.model;
import java.util.ArrayList;

public class Court {
    public String name;
    public int price;
    public CourtType type;
    private ArrayList<Reservation> reservations;


    public Court(String name, int price, CourtType type, ArrayList<Reservation> reservations) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.reservations = new ArrayList<Reservation>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CourtType getType() {
        return type;
    }

    public void setType(CourtType type) {
        this.type = type;
    }

    public ArrayList<Reservation> getReservations () {
            return reservations;
        }
    public void setReservations (ArrayList < Reservation > reservations) {
        this.reservations = reservations;
        }
    @Override
    public String toString() {
        return "Court{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", reservations=" + reservations +
                '}';
    }
    }

