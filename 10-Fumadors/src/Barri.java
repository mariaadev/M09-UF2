import java.util.ArrayList;


public class Barri {
    private Estanc estanc;
    private ArrayList<Fumador> fumadors;

    public Barri() {
        this.estanc = new Estanc();
        this.fumadors = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            fumadors.add(new Fumador(estanc, i));
        }
    }

    public void iniciar() {
        for (Fumador f : fumadors) {
            f.start();
        }

        Thread estancThread = new Thread(() -> {
            while (true) {
                estanc.nouSubministrament(); 
                boolean totsHanAcabat = true;
                for (Fumador f : fumadors) {
                    if (f.esFilIniciat()) {
                        totsHanAcabat = false;
                        break;
                    }
                }

                if (totsHanAcabat) {
                    estanc.tancarEstanc(); 
                    break;
                }
            }
        });

        estancThread.start();

        for (Fumador f : fumadors) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            estancThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Estanc tancat.");
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.iniciar();
    }
}


