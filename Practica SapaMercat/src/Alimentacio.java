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

    public String getPreuCaducitat() {
        return dataCaducitat;
    }

    @Override
    public String toString() {
        return nom + " 1 " + getPreuCaducitat() + " " + getPreuCaducitat();
    }
}
