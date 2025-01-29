import java.util.Random;

public class Assistent extends Thread {

    private Esdeveniment esdeveniment;
    private String nom = "";
    private Random random = new Random();

    public Assistent (String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }   

    public String getNom() {
        return this.nom;
    }

    @Override
    public void run() {
        /*Eternament */
        while (true) {
            try {
                /*Num random entre 0 i 1 sec */
                Thread.sleep(random.nextInt(1000));
                /*50% possibilitats de fer reserva */
                if (random.nextInt(100) < 30) {  // 30% probabilitat de fer reserva
                    esdeveniment.ferReserva(this);
                } else {  // 70% probabilitat de cancel·lar
                    esdeveniment.cancelaReserva(this);
                } 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
