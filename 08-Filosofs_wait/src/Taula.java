
public class Taula {
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            /*Inicialització Filòsof amb el num de fil, i el num de les forquilles */
            /* i + 1 % numFilosofs, l'últim filòsof tindrà com a forquilla dreta la primera forquilla(0) */
            filosofs[i] = new Filosof("fil" + i, forquilles[i], forquilles[(i + 1) % numFilosofs], i);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: fil:" + i + " esq:" + forquilles[i].getNumForquilla() + " dret:" + forquilles[(i + 1) % filosofs.length].getNumForquilla());
        }
        System.out.println("----------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }


    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();

        try {
            Thread.sleep(60000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("S'ha acabat el sopar.");
        /*Finalitzar el programa i els fils */
        System.exit(0);
    }
}


