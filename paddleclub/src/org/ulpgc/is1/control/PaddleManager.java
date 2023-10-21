package org.ulpgc.is1.control;

import org.ulpgc.is1.model.Court;
import org.ulpgc.is1.model.Customer;
import org.ulpgc.is1.model.NIF;
import org.ulpgc.is1.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class PaddleManager {

    public List<Customer> customerList;
    public List<Court> courtList;

    public PaddleManager(){
        customerList = new ArrayList<>();
        courtList = new ArrayList<>();
    }
    public void addCustomer(String name, String surname, String nifNumber) {
        NIF nif = new NIF(nifNumber);
        Customer customer;
        customer = new Customer(name, surname, nif);

        customerList.add(customer);

    }
    public Customer getCustomerList(int index){
        return customerList.get(index);
    }


}
