public class Textil extends Producte{
    String composicioTextil;

    //CONSTRUCTOR Textil
    public Textil(float preu, String nom, String codiDeBarres, String composicioTextil) {
        super(preu, nom, codiDeBarres);
        setComposicioTextil(composicioTextil);
    }

    public String getComposicioTextil() {
        return composicioTextil;
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

    public float getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return String.format("%10s %10.2s", nom, getPreu());
    }
}
