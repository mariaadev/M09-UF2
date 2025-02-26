import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Filosof extends Thread {
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private final Random random;
    private int gana; 
    private int numFilosof;
    private Long iniciGana;
    private Long fiGana;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta, int numFilosof) {
        super(nom);
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.random = new Random();
        this.gana = 0;
        this.numFilosof = numFilosof;
        this.iniciGana = 0L;
        this.fiGana = 0L;
    }

    public void menjar() {
        while (true) {
            agafarForquillaEsquerra();
            if (forquillaEsquerra.getEnUs()) {
                System.out.println(getName() + " té forquilla esquerra (" + forquillaEsquerra.getNumForquilla() + ")");
                agafarForquillaDreta();
                if (forquillaDreta.getEnUs()) {
                    System.out.println(getName() + " té forquilles esq(" + forquillaEsquerra.getNumForquilla() + ") dreta(" + forquillaDreta.getNumForquilla() + ")");
                    System.out.println(getName() + " menja amb gana " + gana);
                    try {
                        /*Entre 1 i 2 segons */
                        Thread.sleep(1000 + random.nextInt(1001));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.fiGana = System.currentTimeMillis();
                    this.gana = (int) TimeUnit.MILLISECONDS.toSeconds((Math.abs(iniciGana - fiGana)));
                    System.out.println(getName() + " ha acabat de menjar.");
                    /*Deixar forquilles per a que els altres puguin menjar. */
                  
                    deixarForquilles();
                    System.out.println(getName() + " deixa les forquilles.");
                    return;
                } else {
                    /*forquilla esquerra en ús, llavors s'ha d'esperar */
                    System.out.println("Filòsof: " + getName() + " deixa la forquilla esquerra (" + forquillaEsquerra.getNumForquilla() + ") i espera (dreta ocupada)");
                    deixarForquilla(forquillaEsquerra);
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
    public  void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar(numFilosof);
    }

    public boolean esPropietariAmbduesForquilles() {
        return forquillaDreta.getEsLliure() != -1 && forquillaEsquerra.getEsLliure() != -1;
    }
    public  void agafarForquillaDreta() {
        forquillaDreta.agafar(numFilosof);

    }
    public void deixarForquilla(Forquilla forquilla) {
        forquilla.deixar();
    }

    public void deixarForquilles() {
        deixarForquilla(forquillaDreta);
        deixarForquilla(forquillaEsquerra);
    }

    public void pensar() {
        this.iniciGana = System.currentTimeMillis();
        System.out.println(getName() + " pensant.");
        try {
            /*Espera entre 1 i 2 segons */
            Thread.sleep(1000 + random.nextInt(1001)); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int calcularGana() {
        return gana;
    }

    public void resetGana() {
        this.iniciGana = System.currentTimeMillis();
        this.gana = 0;
    }
    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }


}