package org.ulpgc.is1.control;

import org.ulpgc.is1.control.PaddleManager;
import org.ulpgc.is1.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PaddleManager paddleManager = new PaddleManager();
        init(paddleManager);
        System.out.println(paddleManager.getCustomerList(0));
        System.out.println(paddleManager.getCustomerList(0).getReservations(0));
        System.out.println(paddleManager.getCustomerList(1).getNif());

    }
    private static void init(PaddleManager paddleManager) {
        ArrayList<Reservation> reservations = new ArrayList<>();

        Reservation reservation1 = new Reservation(1, new Date(123, 1, 22), null, null);
        Court court1 = new Court("Pista 1", 20, CourtType.FastCourt, null);

        reservation1.setCourt(court1);
        court1.addReservation(reservation1);



        Court court2 = new Court("Pista 2", 15, CourtType.SlowCourt, null);
        Reservation reservation2 = new Reservation(2, new Date(123, 1, 23), null, null);

        reservation2.setCourt(court2);

        reservations.add(reservation1);
        reservations.add(reservation2);

        paddleManager.addCustomer("Juan", "Lebron", "12345612N", new ArrayList<>(Arrays.asList(reservation1)));

        paddleManager.addCustomer("Francisco", "Navarro", "12SD34TT4", new ArrayList<>(reservations));
    }

}



