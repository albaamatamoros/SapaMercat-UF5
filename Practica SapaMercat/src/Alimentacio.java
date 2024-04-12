public class Alimentacio extends Producte{

    String dataCaducitat;

    public Alimentacio(float preu, String nom, int codiDeBarres, String dataCaducitat) {
        super(preu, nom, codiDeBarres);
        this.dataCaducitat = dataCaducitat;
    }
}
