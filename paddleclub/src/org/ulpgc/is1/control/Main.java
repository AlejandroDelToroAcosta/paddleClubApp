package org.ulpgc.is1.control;

public class Main {

    public static void main(String[] args) {
        PaddleManager paddleManager = new PaddleManager();
        init(paddleManager);
        System.out.println(paddleManager.getCustomerList(0));

    }
    private static void init(PaddleManager paddleManager){
        paddleManager.addCustomer("Juan", "Lebrón", "11111111A");
    }

}
