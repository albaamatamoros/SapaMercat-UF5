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

    /*@Override
    public int compareTo(Producte o){
        return composicioTextil.length() - ((Textil) o).getComposicioTextil().length();
    }*/

    @Override
    public String toString() {
        if (getPreu() <= 0){ return String.format("%10s 0€", nom); }
        else { return String.format("%10s %10.2f", nom, getPreu()); }
    }
}
