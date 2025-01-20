import java.util.Random;

public class Treballador extends Thread {
    
    private int souAnualBrut;
    private int edatIniciTreball;
    private int edatFiTreball;
    private int edatActual;
    private float cobrat;

    private Random rnd;

    public Treballador(String nom, int souAnualBrut, int edatIniciTreball, int edatFiTreball){
        super(nom);
        this.souAnualBrut = souAnualBrut;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.rnd = new Random();
    }

    private void cobra() {
        cobrat += (souAnualBrut / 12.0f); 
    }

    private void pagaImpostos() {
        cobrat -= (souAnualBrut / 12.0f) * 0.24f;
    }

    @Override
    public void run() {
        while (edatActual < edatFiTreball) { 
            if (edatActual >= edatIniciTreball) { 
                for (int k = 0; k < 12; k++) { 
                    cobra();
                    pagaImpostos();
                }
            }
            edatActual++; 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.err.println(getName() + " interrumpido.");
            }
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }


}