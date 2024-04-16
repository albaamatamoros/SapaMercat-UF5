import java.util.Date;

public class Alimentacio extends Producte{

    Date dataCaducitat;

    public Alimentacio(float preu, String nom, int codiDeBarres, Date dataCaducitat) {
        super(preu, nom, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public Date getPreu() {
        return dataCaducitat;
    }
}
