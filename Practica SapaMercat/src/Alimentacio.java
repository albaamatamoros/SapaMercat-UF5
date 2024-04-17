import java.util.Date;

public class Alimentacio extends Producte{

    String dataCaducitat;

    public Alimentacio(float preu, String nom, String codiDeBarres, String dataCaducitat) {
        super(preu, nom, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public String getPreu() {
        Date caducitat = new Date(dataCaducitat);
        Date dataActual = new Date();
        return dataCaducitat;
    }

    @Override
    public String toString() {
        return "Alimentacio{" +
                "dataCaducitat=" + dataCaducitat +
                ", preu=" + getPreu() +
                ", nom='" + nom + '\'' +
                ", codiDeBarres=" + codiDeBarres +
                '}';
    }
}
