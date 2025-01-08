import java.util.Random;

public class DormAleatori extends Thread {

    private long instant;

    public DormAleatori (String nom) {
        super(nom);
        this.instant = System.currentTimeMillis();
    }

     @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                /*Interval aleatori entre 50 i 1000 ms*/ 
                int interval = 50 + random.nextInt(951);
                
                //Temps total des de la creació fins a la execució
                long tempsTotal = System.currentTimeMillis() - instant;
                
                System.out.println(getName() + "(" + i + ") a dormir " + interval + "ms total " + tempsTotal);
                
                /*Intervals d'un en 1 */
                tempsTotal = Math.max(tempsTotal, 1);

                Thread.sleep(interval);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
        
        System.out.println("-- Fi de main -----------");
    }

}