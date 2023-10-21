package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private static int NEXT_ID = 0;
    public final int id;
    private ArrayList<Extra> extraArrayList;
    public Date date;
    private Court court;
    private Customer customer;

    public Reservation(int id, Date date, Court court, Customer customer) {
        this.id = NEXT_ID++;
        this.date = date;
        this.extraArrayList = new ArrayList<Extra>();
        this.court = court;
        this.customer = customer;
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
