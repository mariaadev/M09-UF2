class Client {
    private final String nom;

    public Client(int id) {
        this.nom = "Client " + id;
    }

    public void tallarseElCabell() {
        System.out.println(nom + " s'està tallant el cabell.");
    }

    public String getNom() {
        return nom;
    }
}