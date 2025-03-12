
public class Forquilla {
    private boolean enUs;
    private int numForquilla;

    public Forquilla(int numForquilla) {
        this.numForquilla = numForquilla;
        this.enUs = false;
    }

    public int getNumForquilla() {
        return numForquilla;
    }

    public void setNumForquilla(int numForquilla) {
        this.numForquilla =  numForquilla;
    }

    public boolean getEnUs() {
        return this.enUs;
    }

    public void setEnUs(boolean enUs) {
         this.enUs = enUs;
    }

    public boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    public void deixar() {
       setEnUs(false);
    }
}

