import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SapaMercat {
    static Scanner scan = new Scanner(System.in);
    //ARRAYLIST
    static ArrayList<Producte> productes = new ArrayList<Producte>();
    //HASHMAP
    static Map<String, String> carro = new HashMap<String, String>();
    //VARIABLES GLOBALES
    static String opcio;
    private static final int MAX_CARRO = 100;
    private static final int MAX_LLARG = 15;

    public static void main(String[] args) {
        //Mostrem el menú d'inici
        menuInici();
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
                    passarPerCaixa();
                    break;
                case "3":
                    mostrarCarretCompra();
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
                    afegirProducteTextil();
                    break;
                case "3":
                    afegirProducteElectronica();
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
        try {
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un aliment al carro:
                System.out.println("Afegir aliment");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > 15) throw new Exception("- El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("- El preu no pot ser inferior a 0");

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                System.out.print("Data de caducitat: ");
                dataCaducitat = scan.nextLine();

                productes.add(new Alimentacio(preu, nom, codiBarres, dataCaducitat));
                carro.put(nom, codiBarres);
            }
        } catch (InputMismatchException e) {
            System.out.println("- Les dades introduïdes no són del tipus de dades demanades");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void afegirProducteTextil(){
        String nom;
        float preu;
        String composicio;
        String codiBarres;
        try {
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un tèxtil al carro:
                System.out.println("Afegir tèxtil");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > 15) throw new Exception("- El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("- El preu no pot ser inferior a 0");

                System.out.print("Composició: ");
                composicio = scan.nextLine();

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                productes.add(new Textil(preu, nom, codiBarres, composicio));
                carro.put(nom, codiBarres);
            }
        } catch (InputMismatchException e) {
            System.out.println("- Les dades introduïdes no són del tipus de dades demanades");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void afegirProducteElectronica(){
        String nom;
        float preu;
        int garantia;
        String codiBarres;

        try {
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un electrònica al carro:
                System.out.println("Afegir electrònica");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > 15) throw new Exception("- El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("- El preu no pot ser inferior a 0");

                System.out.print("Garantia (dies): ");
                garantia = scan.nextInt();
                scan.nextLine();

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                productes.add(new Electronica(preu, nom, codiBarres, garantia));
                carro.put(nom, codiBarres);
            }
        } catch (InputMismatchException e) {
            System.out.println("- Les dades introduïdes no són del tipus de dades demanades");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void  passarPerCaixa(){
        LocalDate date = LocalDate.now();
        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + date);
        System.out.println("-----------------------------");
        //Mostrar ArrayList amb llista de productes.
        productes.forEach(e -> System.out.println(e));
        System.out.println("-----------------------------");
        System.out.println("Total: ");
    }

    public static void  mostrarCarretCompra (){
        System.out.println("Carret");

        //Buidem els productes del carro.
        productes.clear();
        carro.clear();
    }
}
