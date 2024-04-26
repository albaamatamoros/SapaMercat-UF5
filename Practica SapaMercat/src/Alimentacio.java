import java.time.LocalDate;
import java.util.Date;

public class Alimentacio extends Producte{

    String dataCaducitat;

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

    //Calcular el preu segons la data de caducitat.
    public double getPreuCaducitat() {
        Date data = new Date(System.currentTimeMillis());
        Date dataCad = new Date(dataCaducitat);

        int dias = (int) ((dataCad.getTime() - data.getTime()));

        return preu - preu*((double) 1 /(dias+1)) + (preu * 0.1);
    }

    @Override
    public String toString() {
        return nom + " 1 " + getPreuCaducitat() + " " + getPreuCaducitat();
    }
}
