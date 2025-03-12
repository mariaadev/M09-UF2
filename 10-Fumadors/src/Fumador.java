import java.util.Random;

public class Fumador extends Thread {
    private final Estanc estanc;
    private final int id;
    private int numFumades = 0;
    private boolean esFilIniciat;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    public boolean esFilIniciat() {
        return esFilIniciat;
    }

    private boolean compraTabac() {
        if (estanc.venTabac()) {
            System.out.println("Fumador " + id + " comprant Tabac");
            return true;
        }
        return false;
    }

    private boolean compraPaper() {
        if (estanc.venPaper()) {
            System.out.println("Fumador " + id + " comprant Paper");
            return true;
        }
        return false;
    }

    private boolean compraLlumi() {
        if (estanc.venLlumi()) {
            System.out.println("Fumador " + id + " comprant Llumí");
            return true;
        }
        return false;
    }

    private void fuma() {
        try {
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + new Random().nextInt(500));
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
            esFilIniciat = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        esFilIniciat = true;
        while (numFumades < 3) {
            if (compraTabac() && compraPaper() && compraLlumi()) {
                fuma();
            }
        }
        System.out.println("Fumador " + id + ": He acabat de fumar.");
    }
}
