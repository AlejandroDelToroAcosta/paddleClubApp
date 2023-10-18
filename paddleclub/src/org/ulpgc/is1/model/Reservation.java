package org.ulpgc.is1.model;

import java.util.Date;

public class Reservation {
    private static int NEXT_ID = 0;
    private final int id;

    Date date;

    public Reservation(int id, Date date) {
        this.id = NEXT_ID++;
        this.date = date;

    }

    public static int getNextId() {
        return NEXT_ID;
    }

    public static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int price(Extra extra, Court court){
        return extra.getPrice() + court.getPrice();
    }
}
