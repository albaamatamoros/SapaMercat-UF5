public class Producte {
    float preu;
    String nom;
    int codiDeBarres;

    //Constructor Prodcute

    public Producte(float preu, String nom, int codiDeBarres) {
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
