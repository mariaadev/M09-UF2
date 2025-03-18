class Barber extends Thread {
    private final String nom;
    

    public Barber(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Barberia.getInstancia().condBarber) {
                while (Barberia.getInstancia().esSalaEsperaBuida()) {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + nom + " dormint");
                    try {
                        Barberia.getInstancia().condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            Client client;
            synchronized (Barberia.getInstancia().condBarber) {
                client = Barberia.getInstancia().seguentClient();
            }

            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
            }
        }
    }
}