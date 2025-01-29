import java.util.ArrayList;
import java.util.List;

public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        List<Assistent> assistents = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Assistent assistent = new Assistent("Asistent-" + i, esdeveniment);
            assistents.add(assistent);
            assistent.start();
        }
    }
}