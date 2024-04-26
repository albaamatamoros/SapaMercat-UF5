import java.time.LocalDate;
import java.util.Date;

public class Alimentacio extends Producte{

    String dataCaducitat;

    //CONSTRUCTOR Alimentacio
    public Alimentacio(float preu, String nom, String codiDeBarres, String dataCaducitat) {
        super(preu, nom, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public String getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    //Calculem el preu segons la data de caducitat.
    public double getPreuCaducitat() {
        //Creem un objecte Date que guarda la data i hora actual.
        Date data = new Date(System.currentTimeMillis());
        Date dataCad = new Date(dataCaducitat);

        //Fem un càlcul però obtenir la diferència de dies entre dues dates.
        int dias = (int) ((dataCad.getTime() - data.getTime()));

        //Retornem el nou preu del producte basant-nos en els dies que li queden per caducar.
        return preu - preu*((double) 1 /(dias+1)) + (preu * 0.1);
    }

    @Override
    public String toString() {
        return nom + " 1 " + getPreuCaducitat() + " " + getPreuCaducitat();
    }
}
