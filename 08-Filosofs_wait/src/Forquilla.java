
public class Forquilla {
    private boolean enUs;
    private int numForquilla;
    private int propietari;
    private final int LLIURE = -1;

    public Forquilla(int numForquilla) {
        this.numForquilla = numForquilla;
        this.enUs = false;
        this.propietari = -1;
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
        while (enUs) {        
            enUs = true;
            propietari = numFilosof;
            return true;
        }
        return false;
    }

    public synchronized void deixar() {
       setEnUs(false);
       setPropietari(LLIURE);
       notifyAll();
    }
}


