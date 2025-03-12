class Barber extends Thread {
    private final String nom;
    private final Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }
}