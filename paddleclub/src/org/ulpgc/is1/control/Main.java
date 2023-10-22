package org.ulpgc.is1.control;

import org.ulpgc.is1.control.PaddleManager;
import org.ulpgc.is1.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PaddleManager paddleManager = new PaddleManager();
        init(paddleManager);
    }

    private static void init(PaddleManager paddleManager) {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        NIF nif1 = new NIF("23056789A");
        NIF nif2 = new NIF("12SD34TT4");

        Court court1 = new Court("Pista 1", 20, CourtType.SlowCourt, null);
        Court court2 = new Court("Pista 2", 20, CourtType.FastCourt, null);

        Customer customer1 = new Customer("Francisco", "Navarro", nif1, reservationList);
        Customer customer2 = new Customer("Juan", "Lebrón", nif2, reservationList);

        Date date1 = new Date(123, 9, 3, 15, 30);
        Date date2 = new Date(123, 6, 27, 16, 0);

        Reservation firstReservation = new Reservation(12345, date1, court1, customer1);
        Reservation secondReservation = new Reservation(12345, date2, court2, customer2);

        reservationList.add(firstReservation);
        reservationList.add(secondReservation);

        court1.setReservations(reservationList);
        court2.setReservations(reservationList);

        customer1.setReservations(reservationList);
        customer2.setReservations(reservationList);

        //
        printNIF(customer1);
        printNIF(customer2);

        printCustomerData(customer1, firstReservation);


        printCustomerData(customer2, secondReservation);

        printCourtData(court2, reservationList, 1);

        ///Crear una reserva para el primer cliente en la segunda pista

        Date reservationDate = new Date(123, 9, 5, 14, 0);
        Reservation newReservation = new Reservation(6789, reservationDate, court2, customer1);

        ArrayList<Reservation> court2Reservations = court2.getReservations();
        court2Reservations.add(newReservation);

        court2.setReservations(court2Reservations);

        ArrayList<Reservation> customer1Reservations = customer1.getReservations();
        customer1Reservations.add(newReservation);

        customer1.setReservations(customer1Reservations);

        System.out.println("Reserva creada para el Cliente 1 en la Segunda Pista:");
        System.out.println("ID de Reserva: " + newReservation.getId());
        System.out.println("Fecha y hora de reserva: " + newReservation.getDate());
        System.out.println("Pista: " + newReservation.getCourt().getName());
        System.out.println("Cliente: " + newReservation.getCustomer().getName());

    }

    private static void printNIF(Customer customer) {
        if (customer.getNif().valid() != true) {
            System.out.println("NIF no válido");
            System.out.println("- - - -");
        } else {
            System.out.println("NIF: " + customer.getNif());
            System.out.println("- - - -");
        }
    }

    //
    private static void printCustomerData(Customer customer, Reservation reservation) {
        System.out.println("Datos del cliente: {");
        System.out.println("Nombre: " + customer.getName());
        System.out.println("Apellido: " + customer.getSurname());
        System.out.println("NIF: " + customer.getNif() + "}");
        System.out.println("- - - -");

    }

    private static void printCourtData(Court court, ArrayList<Reservation> reservationList, int index) {
        System.out.println("Pista: " + court.getName());
        System.out.println("Precio: " + court.getPrice());
        System.out.println("Tipo: " + court.getType());


        System.out.println("Reservas de la Segunda Pista:");
        Reservation secondReservation = reservationList.get(index);

        System.out.println("ID de Reserva: " + secondReservation.getId());
        System.out.println("Fecha y hora de reserva: " + secondReservation.getDate());
        System.out.println("Cliente: " + secondReservation.getCustomer().getName());
        System.out.println("- - - -");


    }





}