package org.ulpgc.is1.model;

public class Court {
    public String name;
    public int price;
    public Court type;



    public Court(String name, int price, Court type) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public Court getType() {
        return type;
    }

    public void setType(Court type) {
        this.type = type;
    }
}
