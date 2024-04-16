import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SapaMercat {
    static ArrayList<Producte> productes = new ArrayList<Producte>();
    static String opcio;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //Mostrem el menú d'inici
        menuInici();
        for (int i = 0; i < productes.size(); i++) {
            System.out.println(productes.get(i));
        }
    }

    //MENÚS:
    public static void menuInici(){
        //Menú INICI
        do {
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("------------");
            System.out.println("-- INICI ---");
            System.out.println("------------");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("0) Acabar");
            opcio = scan.nextLine();
            switch (opcio) {
                case "1":
                    //Mostrem el menú de productes
                    introduirProducte();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("-------------------------------");
                    System.out.println("ATENCIÓ! Ha de ser entre 0 i 3");
                    System.out.println("-------------------------------");
            }
        } while (!(opcio.equals("0")));
    }

    public static void introduirProducte(){
        //Menú PRODUCTE
        do {
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("---------------");
            System.out.println("-- PRODUCTE ---");
            System.out.println("---------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");
            opcio = scan.nextLine();
            switch (opcio) {
                case "1":
                    afegirProducteAlimentacio();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    menuInici();
                    break;
                default:
                    System.out.println("-------------------------------");
                    System.out.println("ATENCIÓ! Ha de ser entre 0 i 3");
                    System.out.println("-------------------------------");
            }
        } while (!(opcio.equals("0")));
    }
    //PRODUCTES
    private static void afegirProducteAlimentacio(){
        String nom;
        float preu;
        String dataCaducitat;
        String codiBarres;

        System.out.println("Afegir aliment");

        System.out.print("Nom producte: \t");
        nom = scan.nextLine();

        System.out.print("preu: \t");
        preu = scan.nextFloat();
        scan.nextLine();

        System.out.print("Codi de barres: \t");
        codiBarres = scan.nextLine();

        System.out.print("Data de caducitat: \t");
        dataCaducitat = scan.nextLine();

        Alimentacio a1 = new Alimentacio(preu, nom, codiBarres, dataCaducitat);

        productes.add(a1);
    }

    private static void afegirProducteTextil(){
        System.out.println("Afegir tèxtil");
    }

    private static void afegirProducteElectronica(){
        System.out.println("Afegir electrònica");
    }
}
