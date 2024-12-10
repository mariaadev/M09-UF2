package com.iticbcn.fils;

public class Fil extends Thread {
    private String nom;
    private int comportament;
    /*Variable per a la sincronització del Comportament 3*/
    private static final Object bloqueig = new Object(); 

    public Fil(String nom, int comportament) {
        this.nom = nom;
        this.comportament = comportament;
    }

    @Override
    public void run() {
        if (comportament == 1) {
            //Comportament 1: Execució intercalada
            for (int i = 1; i <= 9; i++) {
                System.out.println(nom + " " + i);
                try {
                    Thread.sleep((int) (Math.random() * 100)); //Simular intercalació
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (comportament == 2) {
            //Comportament 2: Un fil domina l'execució
            synchronized (bloqueig) {
                for (int i = 1; i <= 9; i++) {
                    System.out.println(nom + " " + i);
                }
            }
        } else if (comportament == 3) {
            //Comportament 3: Execució estrictament alternada
            synchronized (bloqueig) {
                for (int i = 1; i <= 9; i++) {
                    System.out.println(nom + " " + i);
                    bloqueig.notify(); //Notifica a l'altre fil
                    try {
                        if (i < 9) {
                            bloqueig.wait(); //Espera que l'altre fil completi el seu torn
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bloqueig.notifyAll(); //Assegura que no queden fils esperant
            }
        }
    }
}
