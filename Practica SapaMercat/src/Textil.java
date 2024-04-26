public class Textil extends Producte{
    String composicioTextil;

    public Textil(float preu, String nom, String codiDeBarres, String composicioTextil) {
        super(preu, nom, codiDeBarres);
        this.composicioTextil = composicioTextil;
    }

    @Override
    public String toString() {
        return nom + " 1 " + preu + " " + preu;
    }
}
