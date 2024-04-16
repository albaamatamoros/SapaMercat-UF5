public class Electronica extends Producte{
    int diesDeGarantia;

    public Electronica(float preu, String nom, int codiDeBarres, int diesDeGarantia) {
        super(preu, nom, codiDeBarres);
        this.diesDeGarantia = diesDeGarantia;
    }

    public double getPreu() {
        //
        return preu + preu * ((double) diesDeGarantia / 365) * 0.1;
    }
}
