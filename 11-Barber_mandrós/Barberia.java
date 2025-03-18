import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private final Queue<Client> salaEspera;
    private final int maxCadires;
    public final Object condBarber = new Object();
    private static Barberia instancia;

    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        this.salaEspera = new LinkedList<>();
        instancia = this;
    }

    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");

        Thread barberThread = new Thread(barber);
        barberThread.start();

        barberia.iniciar();
    }

    public boolean esSalaEsperaBuida() {
        synchronized (condBarber) {
            return salaEspera.isEmpty();
        }
    }
    public static Barberia getInstancia() {
        return instancia;
    }

    public Client seguentClient() {
        synchronized (condBarber) {
            return salaEspera.poll();
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }


    public void iniciar() {
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                entrarClient(new Client(i));
                dormir(500);
            }
            dormir(10000);
            for (int i = 11; i <= 20; i++) {
                entrarClient(new Client(i));
                dormir(500);
            }
        }).start();
    }

    private void dormir(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
