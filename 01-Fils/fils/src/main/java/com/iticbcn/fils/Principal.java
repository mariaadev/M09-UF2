package com.iticbcn.fils;

public class Principal {
    public static void main(String[] args) {
        //Comportament 1
        System.out.println("Comportament 1: Execució intercalada");
        System.out.println("Termina thread main");
        
        Fil filJuan1 = new Fil("Juan", 1);
        Fil filPepe1 = new Fil("Pepe", 1);
        filJuan1.start();
        filPepe1.start();

        try {
            filJuan1.join();
            filPepe1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termina el fil Juan");
        System.out.println("Termina el fil Pepe");

        //Comportament 2
        System.out.println("\nComportament 2: Execució dominant");
        Fil filJuan2 = new Fil("Juan", 2);
        Fil filPepe2 = new Fil("Pepe", 2);

        filJuan2.start();
        filPepe2.start();
        try {
            filJuan2.join();
            filPepe2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termina el fil Juan");
        System.out.println("Termina el fil Pepe");

        //Comportament 3
        System.out.println("\nComportament 3: Execució alternança estricta");
        Fil filJuan3 = new Fil("Juan", 3);
        Fil filPepe3 = new Fil("Pepe", 3);
        filJuan3.start();
        filPepe3.start();
        try {
            filJuan3.join();
            filPepe3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termina el fil Juan");
        System.out.println("Termina el fil Pepe");
    }
}
