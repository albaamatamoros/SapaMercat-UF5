public class Electronica extends Producte{
    int diesDeGarantia;

    //CONSTRUCTOR Electronica
    public Electronica(float preu, String nom, String codiDeBarres, int diesDeGarantia) {
        super(preu, nom, codiDeBarres);
        this.diesDeGarantia = diesDeGarantia;
    }

    public int getDiesDeGarantia() {
        return diesDeGarantia;
    }

    public void setDiesDeGarantia(int diesDeGarantia) {
        this.diesDeGarantia = diesDeGarantia;
    }

    public float getPreu() {
        return (float) (preu + preu * ( diesDeGarantia / 365) * 0.1);
    }

    @Override
    public String toString() {
        return String.format("%10s %10.2s", nom, getPreu());
    }
}
