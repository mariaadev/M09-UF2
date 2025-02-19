import java.util.Random;

public class Filosof extends Thread {
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private final Random random;
    private int gana; 
    private int numFilosof;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta, int numFilosof) {
        super(nom);
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.random = new Random();
        this.gana = 0;
        this.numFilosof = numFilosof;
    
    }

    public void menjar() {
        System.out.println("Filòsof: " + getName() + " intenta menjar.");
        while (!esPropietariAmbduesForquilles()) {
            agafarForquillaEsquerra();
            if (forquillaEsquerra.getEnUs()) {
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumForquilla());
                agafarForquillaDreta();
                if (forquillaDreta.getEnUs()) {
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumForquilla() + " i està menjant.");
                    try {
                        /*Entre 1 i 2 segons */
                        Thread.sleep(1000 + random.nextInt(1001));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Filòsof: " + getName() + " ha acabat de menjar.");
                    /*Deixar forquilles per a que els altres puguin menjar. */
                  
                    deixarForquilles();
                    return;
                } else {
                    /*forquilla esquerra en ús, llavors s'ha d'esperar */
                    System.out.println("Filòsof: " + getName() + " deixa la forquilla esquerra (" + forquillaEsquerra.getNumForquilla() + ") i espera (dreta ocupada)");
                    deixarForquilla(forquillaEsquerra);
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


    public int getNumFilosof(){
        return numFilosof;
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }
    public synchronized void agafarForquillaEsquerra() {
        while (forquillaEsquerra.getEsLliure() != -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        forquillaEsquerra.agafar(numFilosof);
    }

    public boolean esPropietariAmbduesForquilles() {
        return forquillaDreta.getEsLliure() != -1 && forquillaEsquerra.getEsLliure() != -1;
    }
    public synchronized void agafarForquillaDreta() {
        while (forquillaDreta.getEsLliure() != -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        forquillaDreta.agafar(numFilosof);

    }
    public void deixarForquilla(Forquilla forquilla) {
        forquilla.deixar();
        notifyAll();
    }

    public void deixarForquilles() {
        deixarForquilla(forquillaEsquerra);
        deixarForquilla(forquillaDreta);
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