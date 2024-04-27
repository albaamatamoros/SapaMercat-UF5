import java.util.Comparator;

public abstract class Producte implements Comparable<Producte>, Comparator<Producte> {
    float preu;
    String nom;
    String codiDeBarres;

    //CONSTRUCTOR Producte
    public Producte(float preu, String nom, String codiDeBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiDeBarres = codiDeBarres;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodiBarres() {
        return codiDeBarres;
    }

    public void setCodiDeBarres(String codiDeBarres) {
        this.codiDeBarres = codiDeBarres;
    }
    @Override
    public int compareTo(Producte o) {
        return (Integer.parseInt(codiDeBarres) - Integer.parseInt(o.getCodiBarres()));
    }

    @Override
    public int compare(Producte o1, Producte o2) {
        return (int) (o1.getPreu() - o2.getPreu());
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
