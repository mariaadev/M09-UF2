import java.util.ArrayList;
import java.util.Random;

public class Estanc {
    private final ArrayList<Tabac> tabacs = new ArrayList<>();
    private final ArrayList<Llumi> llumins = new ArrayList<>();
    private final ArrayList<Paper> papers = new ArrayList<>();
    private boolean obert = true;
    private final Random rand = new Random();

    public synchronized void nouSubministrament() {
        if (!obert) return;

        try {
            Thread.sleep(500 + rand.nextInt(1000)); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int tipus = rand.nextInt(3);
        switch (tipus) {
            case 0 -> addTabac();
            case 1 -> addPaper();
            case 2 -> addLlumi();
        }

        notifyAll();
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint Tabac");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint Llumí");
        notifyAll();
    }

    public synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized boolean venTabac() {
        while (tabacs.isEmpty() && obert) esperar();
        if (!obert) return false;
        tabacs.removeLast();
        return true;
    }

    public synchronized boolean venLlumi() {
        while (llumins.isEmpty() && obert) esperar();
        if (!obert) return false;
        llumins.removeLast();
        return true;
    }

    public synchronized boolean venPaper() {
        while (papers.isEmpty() && obert) esperar();
        if (!obert) return false;
        papers.removeLast();
        return true;
    }

    private void esperar() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tancarEstanc() {
        obert = false;
        System.out.println("Estanc tancat");
        notifyAll();
    }
}
