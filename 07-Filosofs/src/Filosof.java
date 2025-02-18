import java.util.Random;

public class Filosof extends Thread {
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private final Random random;
    private int gana; 

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.random = new Random();
        this.gana = 0;
    
    }

    public void menjar() {
        System.out.println("Filòsof: " + getName() + " intenta menjar.");
        while (true) {
            if (forquillaEsquerra.agafar()) {
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumForquilla());
                if (forquillaDreta.agafar()) {
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumForquilla() + " i està menjant.");
                    try {
                        /*Entre 1 i 2 segons */
                        Thread.sleep(1000 + random.nextInt(1001));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Filòsof: " + getName() + " ha acabat de menjar.");
                    /*Deixar forquilles per a que els altres puguin menjar. */
                  
                    forquillaDreta.deixar();
                    forquillaEsquerra.deixar();
                    return;
                } else {
                    /*forquilla esquerra en ús, llavors s'ha d'esperar */
                    System.out.println("Filòsof: " + getName() + " deixa la forquilla esquerra (" + forquillaEsquerra.getNumForquilla() + ") i espera (dreta ocupada)");
                    forquillaEsquerra.deixar();
                    gana++;
                    System.out.println("Filòsof: " + getName() + " gana=" + gana);
                }
            }
            try {
                /*Espera entre 0.5 i 1 segons per tornar-ho a intentar */
                Thread.sleep(500 + random.nextInt(501)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pensar() {
        System.out.println("Filòsof: " + getName() + " pensant.");
        try {
            /*Espera entre 1 i 2 segons */
            Thread.sleep(1000 + random.nextInt(1001)); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }


}