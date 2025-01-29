import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    
    private List<Assistent> assistents;
    private int placesDisponibles;
    private int numPlacesMax;

    public Esdeveniment(int numPlacesMax) { 
        this.numPlacesMax = numPlacesMax;
        this.assistents = new ArrayList<>();
        this.placesDisponibles = numPlacesMax;
    }

    public synchronized void ferReserva(Assistent assistent) {
        while (placesDisponibles <= 0) {
            try {
                wait();  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.assistents.add(assistent);
        placesDisponibles -=1;
        System.out.println(assistent.getNom() + " ha reservat una plaça. Places disponibles: " + placesDisponibles);
        notifyAll();
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (!assistents.contains(assistent)) { 
            System.out.println(assistent.getNom() + " no ha pogut cancelar una reserva inexistent. Places disponibles: " + placesDisponibles);
            return;
        }
        while (!assistents.contains(assistent)) { 
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assistents.remove(assistent);
        placesDisponibles+=1;
        System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
        notifyAll(); 
    }
}
