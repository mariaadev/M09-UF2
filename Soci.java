import java.util.Random;

public class Soci extends Thread {
    private final Compte compte; 
    private final float APORTACIO = 10f; 
    private final int ESPERA_MAX = 100; 
    private final int MAX_ANYS = 10; 
    private final Random random; 

    public Soci() {
        this.compte = Compte.getInstance(); 
        this.random = new Random(); 
    }
    
    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        
        for (int any = 1; any <= MAX_ANYS; any++) {

            for (int mes = 1; mes <= 12; mes++) {
                if (mes % 2 == 0) {
                    compte.ingresarSaldo(APORTACIO);
                } else {
                    compte.retirarSaldo(APORTACIO);
                }
            } 

            try {
                Thread.sleep(random.nextInt(ESPERA_MAX + 1));
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            
        }
    }
}