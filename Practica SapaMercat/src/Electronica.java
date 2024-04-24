public class Electronica extends Producte{
    int diesDeGarantia;

    public Electronica(float preu, String nom, String codiDeBarres, int diesDeGarantia) {
        super(preu, nom, codiDeBarres);
        this.diesDeGarantia = diesDeGarantia;
    }

    public float setPreu() {
        return (float) (preu + preu * ( diesDeGarantia / 365) * 0.1);
    }

    public float getPreu() { return setPreu(); }

    @Override
    public String toString() {
        return "Electronica{" +
                "diesDeGarantia=" + diesDeGarantia +
                ", preu=" + getPreu() +
                ", nom='" + nom + '\'' +
                ", codiDeBarres=" + codiDeBarres +
                '}';
    }
}
