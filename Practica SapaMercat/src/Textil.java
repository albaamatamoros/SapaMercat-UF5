public class Textil extends Producte{
    String composicioTextil;

    public Textil(float preu, String nom, int codiDeBarres, String composicioTextil) {
        super(preu, nom, codiDeBarres);
        this.composicioTextil = composicioTextil;
    }
}
