import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SapaMercat {
    static Scanner scan = new Scanner(System.in);
    //ARRAYLIST i HASHMAP
    static ArrayList<Producte> productes = new ArrayList<Producte>();
    //Utilitzem LinkedHashMap perquè el HashMap quedi ordenat segons com introduïm els productes.
    static LinkedHashMap<String, String[]> carro = new LinkedHashMap<>();
    static LinkedHashMap<String, String[]> caixa = new LinkedHashMap<>();
    //VARIABLES GLOBALS
    static String opcio;
    private static final int MAX_CARRO = 100;
    private static final int MAX_LLARG = 15;

    public static void main(String[] args) {
        //Cridem el mètode menuInici.
        menuInici();
    }

    //MENÚ INICI:
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
        //MENÚ PRODUCTE:
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
    //AFEGIR PRODUCTES:
    //Mètode per afegir un producte alimentacio.
    private static void afegirProducteAlimentacio(){
        String nom;
        float preu;
        String dataCaducitat;
        String codiBarres;
        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un aliment al carro:
                System.out.println("Afegir aliment");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                System.out.print("Data de caducitat: ");
                dataCaducitat = scan.nextLine();

                //Cridem el mètode correctData per verificar el format de dataCaducita.
                Alimentacio.correctData(dataCaducitat);

                //Creem l'objecte Alimentació i el fiquem a l'arraylist productes.
                productes.add(new Alimentacio(preu, nom, codiBarres, dataCaducitat));

                //Cridem el mètode afegirACarro.
                afegirACarro(nom, codiBarres);
                //Cridem el mètode afegirACarroPerCaixa
                afegirACarroPerCaixa(nom, codiBarres, preu);
            }
        } catch (ParseException e) {
            System.out.println("El format de <Data de caducitat> no és correcte");
            logException(e);
        } catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //Mètode per afegir un producte textil.
    private static void afegirProducteTextil(){
        String nom;
        float preu;
        String composicio;
        String codiBarres;
        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un tèxtil al carro:
                System.out.println("Afegir tèxtil");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Composició: ");
                composicio = scan.nextLine();

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                //Creem l'objecte Textil i el fiquem a l'arraylist productes.
                productes.add(new Textil(preu, nom, codiBarres, composicio));

                //Cridem el mètode añadirACarro.
                afegirACarro(nom, codiBarres);
                //Cridem el mètode afegirACarroPerCaixa
                afegirACarroPerCaixa(nom, codiBarres, preu);

                //Cridem al mètode llegirPreuTextil per comprovar el preu al fitxer UpdateTextilPrices.dat
                llegirPreuTextil();
            }
        } catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //Mètode per afegir un producte electronic.
    private static void afegirProducteElectronica(){
        String nom;
        float preu;
        int garantia;
        String codiBarres;

        try {
            //Fem un if per comprovar que al carro no entrin més de 100 productes.
            if (productes.size() == MAX_CARRO){
                System.out.println("El carro està ple");
            } else {
                //Afegir un electrònica al carro:
                System.out.println("Afegir electrònica");

                System.out.print("Nom producte: \t");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El nom del producte no pot ser superior a 15");

                System.out.print("preu: \t");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Garantia (dies): ");
                garantia = scan.nextInt();
                scan.nextLine();

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                //Creem l'objecte Electronica i el fiquem a l'arraylist productes.
                productes.add(new Electronica(preu, nom, codiBarres, garantia));

                //Cridem el mètode añadirACarro.
                afegirACarro(nom, codiBarres);
                //Cridem el mètode afegirACarroPerCaixa
                afegirACarroPerCaixa(nom, codiBarres, preu);
            }
        } catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //PASSAR PER CAIXA:
    //Mètode per saber el valor total de tota la compra més els detalls dels productes.
    public static void  passarPerCaixa(){
        LocalDate date = LocalDate.now();
        //Menú tiquet.
        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + date);
        System.out.println("-----------------------------");
        //Mostrar LinkedHashMap amb els productes.
        caixa.forEach((k,v) -> System.out.println(v[0] + " - " + v[1] + " - " + v[2] + " : " + (Float.parseFloat(v[2]) * (Float.parseFloat(v[1])))));
        System.out.println("-----------------------------");
        System.out.println("Total :");
        // Limpiar los productos del carro, de la caixa i de la llista productes.
        productes.clear();
        carro.clear();
        caixa.clear();
    }

    //Mètode per afegir a un LinkedHashMap caixa, els valors necessaris a imprimir en passarPerCaixa i contar les unitats dels productes.
    public static void afegirACarroPerCaixa(String nom, String codi, float preu){
        //Afegim l'objecte Alimentació,Textil o Electronica en el LinkedHashMap "caixa". (En aquest comparem CodiBarres + preuUnitari)
        String codiPreu = codi + preu;
        if (!(caixa.containsKey(codiPreu))){
            String[] valorCarro = new String[3];
            valorCarro[0] = nom;
            valorCarro[1] = "1";
            valorCarro[2] = preu + "";
            caixa.put(codiPreu, valorCarro);
        } else {
            String[] valorCarro = new String[3];
            valorCarro[0] = caixa.get(codiPreu)[0];
            valorCarro[1] = (Integer.parseInt(caixa.get(codiPreu)[1]) + 1) + "";
            valorCarro[2] = preu + "";
            caixa.replace(codiPreu, valorCarro);
        }
    }

    //MOSTRAR CARRO:
    //Mètode per afegir a un LinkedHashMap carro, els valors necessaris a imprimir en mostrarCarro i contar les unitats dels productes.
    public static void afegirACarro(String nom, String codi){
        //Afegim l'objecte Alimentació,Textil o Electronica en el LinkedHashMap "carro". (En aquest comparem CodiBarres)
        if (!(carro.containsKey(codi))){
            String[] valorCarro = new String[2];
            valorCarro[0] = nom;
            valorCarro[1] = "1";
            carro.put(codi, valorCarro);
        } else {
            String[] valorCarro = new String[2];
            valorCarro[0] = carro.get(codi)[0];
            valorCarro[1] = (Integer.parseInt(carro.get(codi)[1]) + 1) + "" ;
            carro.replace(codi, valorCarro);
        }
    }

    //Mètode per veure tots els productes del carro.
    public static void  mostrarCarretCompra (){
        carro.forEach((k,v) -> System.out.println(v[0] + " -> " + v[1]));
    }

    //FITXER EXCEPTION:
    //Mètode per guardar excepcions en un fitxer .dat
    public static void logException(Exception e) {
        try {
            //Creem el fitxer on es registraran totes les excepcions.
            File fitxer = new File("./logs/Exceptions.dat");
            //Donem l'arxiu i el valor "true", aquest ultim és un indicador perquè afegeixi les dades al final de l'arxiu.
            FileOutputStream file = new FileOutputStream(fitxer, true);
            PrintStream writer = new PrintStream(file);

            //Agafem la data amb l'hora i tots els detalls possibles perquè quedi constància de quan va succeir aquest excepció.
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");


            //Escrivim al fitxer totes les excepcions.
            writer.println("Excepció : " + simpleDateFormat.format(data) + " " + " : " + e.getMessage());
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("- No es troba el fitxer");
            logException(e);
        } catch (Exception ex){
            System.out.println("- No s'ha pogut escriure al fitxer");
            logException(e);
        }
    }

    //FITXER UPDATETEXTILPRICES.DAT:
    //Mètode per llegir el fitxer UpdateTextilPrices i comprovar els preus segons el codi.
    public static void llegirPreuTextil(){
        try {
            File fitxer = new File("./updates/UpdateTextilPrices.dat");
            FileReader reader = new FileReader(fitxer);
            BufferedReader br = new BufferedReader(reader);
            String fila;
        } catch (Exception e) {

        }
    }
}