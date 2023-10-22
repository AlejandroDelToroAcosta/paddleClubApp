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

    public void setExtraArrayList(ArrayList<Extra> extraArrayList) {
        this.extraArrayList = extraArrayList;
    }

    public Court getCourt() {
        return court;
    }

    public ArrayList<Extra> getExtraArrayList() {
        return extraArrayList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int price(Extra extra, Court court){
        return extra.getPrice() + court.getPrice();
    }
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", court=" + court +
                ", customer=" + customer +
                '}';
    }
}
