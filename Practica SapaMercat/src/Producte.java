public abstract class Producte{
    float preu;
    String nom;
    String codiDeBarres;

    //CONSTRUCTOR Producte
    public Producte(float preu, String nom, String codiDeBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiDeBarres = codiDeBarres;
    }

    @Override
    public String toString() {
        return "Producte{" +
                "preu=" + preu +
                ", nom='" + nom + '\'' +
                ", codiDeBarres=" + codiDeBarres +
                '}';
    }
}
