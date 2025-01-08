import java.util.Random;

public class Motor extends Thread {

    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean enFuncionament = true;

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (enFuncionament) {
            try {
                // Ajusta la potència actual cap a la potència objectiu
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                } else {
                    System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }

                // Si la potència és 0 i l'objectiu també, surt
                if (potenciaActual == 0 && potenciaObjectiu == 0) {
                    enFuncionament = false;
                    System.out.println(getName() + ": Motor aturat.");
                }

                // Retard aleatori entre 0 i 2 segons
                Thread.sleep(random.nextInt(2001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
