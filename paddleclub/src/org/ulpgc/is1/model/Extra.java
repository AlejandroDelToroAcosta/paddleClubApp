package org.ulpgc.is1.model;

public abstract class Extra {
    public int price;

    public Extra(int price) {
        this.price = price;
    }

    public abstract String getName();
}
