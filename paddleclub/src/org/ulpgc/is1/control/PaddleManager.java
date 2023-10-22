package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaddleManager {

    public List<Customer> customerList;
    public List<Court> courtList;

    public PaddleManager(){
        customerList = new ArrayList<>();
        courtList = new ArrayList<>();
    }
    public void addCustomer(String name, String surname, String nifNumber, ArrayList<Reservation> reservations) {
        NIF nif = new NIF(nifNumber);
        Customer customer;
        customer = new Customer(name, surname, nif, reservations);

        customerList.add(customer);

    }
    public Customer getCustomerList(int index){
        return customerList.get(index);
    }

    public void addCourt(String name, int price, CourtType type, ArrayList<Reservation> reservations){
        Court newCourt = new Court(name, price, type, reservations);
        courtList.add(newCourt);
    }

    public Court getCourtList(int index){
        return courtList.get(index);
    }
}
