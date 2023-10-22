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
         ArrayList<Reservation> reservationList = paddleManager.reserve();

        //. Crear dos clientes. El primer cliente será miembro del club de paddle.
        //El segundo cliente tendrá el NIF: “12SD34TT4”.

        paddleManager.addCustomer("Francisco", "Navarro", "12345678A",reservationList);
        paddleManager.addCustomer("Juan", "Lebrón", "12SD34TT4", reservationList);

        //Crear dos pistas de paddle, una será de tipo rápido y otra de tipo lento.
        paddleManager.addCourt("Pista 1", 20, CourtType.SlowCourt, reservationList);
        paddleManager.addCourt("Pista 2", 25, CourtType.FastCourt, reservationList);

        Court court1 = paddleManager.getCourtList(0);
        Court court2 = paddleManager.getCourtList(1);
        Customer customer1 = paddleManager.getCustomerList(0);
        Customer customer2 = paddleManager.getCustomerList(1);

        Date date1 = new Date(123, 9, 3, 15, 30);
        Date date2 = new Date(123, 6, 27, 16, 0);

        Reservation firstReservation = new Reservation(0, date1, court1, customer1);
        Reservation secondReservation = new Reservation(0, date2, court2, customer2);


        reservationList.add(firstReservation);
        reservationList.add(secondReservation);

        court1.setReservations(reservationList);
        court2.setReservations(reservationList);

        customer1.setReservations(reservationList);
        customer2.setReservations(reservationList);

        //Imprimir por pantalla los NIF’s válidos de los clientes del club.
        printNIF(customer1);
        printNIF(customer2);

        //Imprimir por pantalla los datos del primer cliente.
        printCustomerData(customer1, firstReservation);

        //Imprimir por pantalla los datos del segundo cliente.
        printCustomerData(customer2, secondReservation);

        //Imprimir por pantalla los datos de la segunda pista.
        printCourtData(court2, reservationList, 1);

        ///Crear una reserva para el primer cliente en la segunda pista

        Date reservationDate = new Date(123, 9, 5, 14, 0);
        Reservation newReservation = new Reservation(0, reservationDate, court2, customer1);


        if (!reservationExists(newReservation, reservationList)) {
            reservationList.add(newReservation);
            court2.setReservations(reservationList);
            customer1.setReservations(reservationList);

            System.out.println("Reserva creada para el Cliente 1 en la Segunda Pista:");
            System.out.println("ID de Reserva: " + newReservation.getId());
            System.out.println("Fecha y hora de reserva: " + newReservation.getDate());
            System.out.println("Pista: " + newReservation.getCourt().getName());
            System.out.println("Cliente: " + newReservation.getCustomer().getName());
            System.out.println("- - - -");
        } else {
            System.out.println("La reserva ya existe en la lista de reservas.");
        }

        //Borrar el segundo cliente

        paddleManager.removeCustomer(customer2);

        System.out.println(paddleManager.customerList);
        System.out.println("Cliente eliminado");
        System.out.println("- - - -");

        //Imprimir por pantalla el número de clientes del club

        int countedClients = paddleManager.count();
        System.out.println("Número de clientes :" + countedClients);
        System.out.println("- - - -");

        printAllReservations(reservationList);
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
    private static boolean reservationExists(Reservation reservation, ArrayList<Reservation> reservationList) {
        for (Reservation existingReservation : reservationList) {
            if (existingReservation.getId() == reservation.getId()) {
                return true;
            }
        }
        return false;
    }


    private static void printAllReservations(ArrayList<Reservation> reservationList) {
        System.out.println("Reservas realizadas:");
        int extraprice = 5;
        Extra extra = new Extra(extraprice) {
            @Override
            public String getName() {
                return null;
            }
        };

        for (Reservation reservation : reservationList) {
            Customer customer = reservation.getCustomer();
            Court court = reservation.getCourt();
            Date date = reservation.getDate();
            int cost = reservation.price(extra, court) ;

            System.out.println("Cliente: " + customer.getName() + " " + customer.getSurname());
            System.out.println("Pista: " + court.getName());
            System.out.println("Fecha: " + date);
            System.out.println("Coste de la reserva: " + cost);
            System.out.println("- - - -");
        }
    }

}