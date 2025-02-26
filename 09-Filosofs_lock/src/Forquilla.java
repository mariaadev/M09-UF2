import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private boolean enUs;
    private int numForquilla;
    private int propietari;
    private final int LLIURE = -1;
    private ReentrantLock bloqueig;

    public Forquilla(int numForquilla) {
        this.numForquilla = numForquilla;
        this.enUs = false;
        this.propietari = -1;
        this.bloqueig = new ReentrantLock();
    }

    public int getNumForquilla() {
        return numForquilla;
    }

    public void setNumForquilla(int numForquilla) {
        this.numForquilla =  numForquilla;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }
    public int getEsLliure() {
        return LLIURE;
    }

    public boolean getEnUs() {
        return this.enUs;
    }

    public void setEnUs(boolean enUs) {
         this.enUs = enUs;
    }

    public  boolean agafar(int numFilosof) {
        if (bloqueig.tryLock()) {        
            enUs = true;
            propietari = numFilosof;
            return true;
        }
        return false;
    }

    public void deixar() {
        if (bloqueig.isHeldByCurrentThread()) {
            bloqueig.unlock();
            setEnUs(false);
            setPropietari(LLIURE);
        }
       
      
      
    }
}


