
public class Compte {

    private static Compte instancia = new Compte();
    private float saldo;

    private Compte() {
        this.saldo = 0f;
    }

    public static Compte getInstance() {
        return instancia;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public synchronized void ingresarSaldo(float canvi) {
        saldo += canvi;
    }
    public synchronized void retirarSaldo(float canvi) {
        saldo -= canvi;
    }
}
