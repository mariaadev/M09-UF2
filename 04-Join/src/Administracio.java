public class Administracio {

    private static final int NUM_POBLACIO_ACTIVA = 50;
    private Treballador[] poblacioActiva;

    public Administracio() {
        poblacioActiva = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacioActiva[i] = new Treballador(
                "Ciutadà-" + i, 
                25000, 
                20, 
                65);
        }
    }

    public void mostraEstadistiques() {

        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join(); 
            } catch (InterruptedException e) {
                System.err.println(treballador.getName() + " ha estat interromput durant el join.");
            }
        }

        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", 
                treballador.getName(), 
                treballador.getEdat(), 
                treballador.getCobrat());
        }
    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.mostraEstadistiques();
    }
}