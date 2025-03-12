import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private final Queue<Client> salaEspera = new LinkedList<>();
    private final int maxCadires;
    public final Object condBarber = new Object();
    private static Barberia instancia;

    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        instancia = this;
    }

    public static void main(String[] args) {
    }
}
