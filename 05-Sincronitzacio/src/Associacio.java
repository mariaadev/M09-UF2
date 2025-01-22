public class Associacio {
    private final int NUM_SOCIS = 1000;
    private final Soci[] SOCIS;

    public Associacio() {
        SOCIS = new Soci[NUM_SOCIS];
        for (int i = 0; i < NUM_SOCIS; i++) {
            SOCIS[i] = new Soci(); 
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : SOCIS) {
            soci.start();
        }
    }
    public void esperaPeriodeSocis() {
        for (Soci soci : SOCIS) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        Compte compte = Compte.getInstance();
        System.out.println("Saldo: " + compte.getSaldo());
    }

        public static void main(String[] args) {

            Associacio associacio = new Associacio();
            associacio.iniciaCompteTempsSocis(); 
            associacio.esperaPeriodeSocis(); 
            associacio.mostraBalancComptes(); 

        }
    
}
