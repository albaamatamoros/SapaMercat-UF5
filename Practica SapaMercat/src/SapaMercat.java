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
    static ArrayList<Producte> productes = new ArrayList<>();
    static ArrayList<Producte> prodTextil = new ArrayList<>();
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
            System.out.println("4) Cercar producte");
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
                case "4":
                    buscarAmbCodi();
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

                System.out.print("Nom producte: ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El nom del producte no pot ser superior a 15");

                System.out.print("preu: ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres ha de ser de 4 digits i només pot contenir números");

                System.out.print("Data de caducitat: ");
                dataCaducitat = scan.nextLine();

                //Cridem el mètode correctData per verificar el format de dataCaducita.
                Alimentacio.correctData(dataCaducitat);

                //Creem l'objecte Alimentació i el fiquem a l'arraylist productes.
                productes.add(new Alimentacio(preu, nom, codiBarres, dataCaducitat));
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

                System.out.print("Nom producte: ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El nom del producte no pot ser superior a 15");

                System.out.print("preu: ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Composició: ");
                composicio = scan.nextLine();

                if (!composicio.matches("[a-zA-Z]")) throw new IllegalArgumentException("La composició no pot contenir números només lletres");

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres ha de ser de 4 digits i només pot contenir números");

                //Comprovem que no es repeteixin dos prod tèxtil iguals.
                if (textilRepetit(codiBarres)){
                    System.out.println("No es pot repetir el codi de barres d'un producte textil");
                } else {
                    //Creem l'objecte Textil i el fiquem a l'arraylist productes.
                    productes.add(new Textil(preu, nom, codiBarres, composicio));
                    //Creem l'objecte Textil i el fiquem a l'arraylist prodTextil productes.
                    prodTextil.add(new Textil(preu, nom, codiBarres, composicio));
                }
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

                System.out.print("Nom producte: ");
                nom = scan.nextLine();

                //Exception nom superior a 15 caràcters.
                if (nom.length() > MAX_LLARG) throw new Exception("El codi de barres ha de ser de 4 digits i només pot contenir números");

                System.out.print("preu: ");
                preu = scan.nextFloat();
                scan.nextLine();

                //Exception preu inferior a 0.
                if (preu < 0) throw new Exception("El preu no pot ser inferior a 0");

                System.out.print("Garantia (dies): ");
                garantia = scan.nextInt();
                scan.nextLine();

                System.out.print("Codi de barres: ");
                codiBarres = scan.nextLine();

                if (!codiBarres.matches("\\d{4}")) throw new IllegalArgumentException("El codi de barres només pot contenir números");

                //Creem l'objecte Electronica i el fiquem a l'arraylist productes.
                productes.add(new Electronica(preu, nom, codiBarres, garantia));
            }
        }catch (InputMismatchException e) {
            System.out.println("Les dades introduïdes no són del tipus de dades demanades");
            logException(e);
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //Comprovem que el producte textil no estigui repetit.
    public static boolean textilRepetit(String codi){
       boolean repetit = false;
       for (Producte p : prodTextil){
           if (p.getCodiBarres().matches(codi)){
               repetit = true;
               break;
           }
       }
       return repetit;
    }

    //PASSAR PER CAIXA:
    //Mètode per saber el valor total de tota la compra més els detalls dels productes.
    public static void  passarPerCaixa(){
        //Ordenem l'array
        Collections.sort(productes);

        //Cridem el mètode afegirACarroPerCaixa i el mètode llegirPreuTextil per actualitzar preus.
        for(Producte p: productes){
            afegirACarroPerCaixa(p);
            llegirPreuTextil(p);
        }

        //Agafem la data actual.
        LocalDate date = LocalDate.now();
        //Menú tiquet.
        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + date);
        System.out.println("-----------------------------");
        //Mostrar LinkedHashMap amb els productes.
        Collections.sort(productes);
        caixa.forEach((k,v) -> System.out.println(v[0] + " - " + v[1] + " - " + v[2] + " : " + (Float.parseFloat(v[2]) * (Float.parseFloat(v[1])))));
        System.out.println("-----------------------------");
        System.out.println("Total: " + calculPreuFinal());
        // Limpiar los productos del carro, de la caixa i de la llista productes.
        productes.clear();
        prodTextil.clear();
        carro.clear();
        caixa.clear();
    }

    //Funció que calcula el preu final de la compra.
    public static float calculPreuFinal(){
        float preuTotal = 0.0f;
        //Fem un bucle per poder fer el càlcul de tots els preus dels productes al HashMap.
        for (Map.Entry<String, String[]> entry : caixa.entrySet()) {
            String[] v = entry.getValue();
            float preuUnitari = Float.parseFloat(v[2]);
            int quantitat = Integer.parseInt(v[1]);
            preuTotal += preuUnitari * quantitat;
        }
        //Retornem el preuTotal per mostrar-lo per pantalla.
        return preuTotal;
    }

    //Mètode per afegir a un LinkedHashMap caixa, els valors necessaris a imprimir en passarPerCaixa i contar les unitats dels productes.
    public static void afegirACarroPerCaixa(Producte p){
        //Afegim l'objecte Alimentació,Textil o Electronica en el LinkedHashMap "caixa". (En aquest comparem CodiBarres + preuUnitari)
        String codiPreu = p.getCodiBarres() + p.getPreu();
        if (!(caixa.containsKey(codiPreu))){
            String[] valorCarro = new String[3];
            valorCarro[0] = p.getNom();
            valorCarro[1] = "1";
            valorCarro[2] = p.getPreu() + "";
            caixa.put(codiPreu, valorCarro);
        } else {
            String[] valorCarro = new String[3];
            valorCarro[0] = caixa.get(codiPreu)[0];
            valorCarro[1] = (Integer.parseInt(caixa.get(codiPreu)[1]) + 1) + "";
            valorCarro[2] = p.getPreu() + "";
            caixa.replace(codiPreu, valorCarro);
        }
    }

    //MOSTRAR CARRO:
    //Mètode per afegir a un LinkedHashMap carro, els valors necessaris a imprimir en mostrarCarro i contar les unitats dels productes.
    public static void afegirACarro(Producte p){
        //Afegim l'objecte Alimentació,Textil o Electronica en el LinkedHashMap "carro". (En aquest comparem CodiBarres)
        if (!(carro.containsKey(p.getCodiBarres()))){
            String[] valorCarro = new String[2];
            valorCarro[0] = p.getNom();
            valorCarro[1] = "1";
            carro.put(p.getCodiBarres(), valorCarro);
        } else {
            String[] valorCarro = new String[2];
            valorCarro[0] = carro.get(p.getCodiBarres())[0];
            valorCarro[1] = (Integer.parseInt(carro.get(p.getCodiBarres())[1]) + 1) + "" ;
            carro.replace(p.getCodiBarres(), valorCarro);
        }
    }

    //Mètode per veure tots els productes del carro.
    public static void  mostrarCarretCompra (){
        //Ordenem l'array
        Collections.sort(productes);
        //Cridem el mètode añadirACarro.
        for(Producte p: productes){
            afegirACarro(p);
        }
        if (carro.isEmpty()){
            System.out.println("El carro està buit");
        } else {
            carro.forEach((k,v) -> System.out.println(v[0] + " -> " + v[1]));
        }
        carro.clear();
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
    public static void llegirPreuTextil(Producte p) {
        try {
            File fitxer = new File("./updates/UpdateTextilPrices.dat");
            HashMap<String, String> textilFitxer = new HashMap<String, String>();

            FileReader reader = new FileReader(fitxer);
            BufferedReader br = new BufferedReader(reader);
            String fila;

            while((fila = br.readLine()) != null) {
                String[] valor = fila.split(":");
                textilFitxer.put(valor[0], valor[1]);
            }

            if (p instanceof Textil) {
                if (textilFitxer.containsKey(p.getCodiBarres())) {
                    String valor = textilFitxer.get(p.getCodiBarres());
                    p.setPreu(Float.parseFloat(valor));
                }
            }
            textilFitxer.forEach((k,v) -> System.out.println(k + " " + v));
        } catch (Exception e){
            System.out.println(e.getMessage());
            logException(e);
        }
    }

    //Mètode per buscar un producte en concret al carro mitjançant el codi.
    public static void buscarAmbCodi() {
        if (!(productes.isEmpty())){
            //Demanem per pantalla el codi que volem buscar, si el carro està buit directament informarem l'usuari.
            System.out.println("Introdueix un codi per cercar el nom del producte:");
            String codiBarres = scan.nextLine().trim();

            //Creem una variable boolean per poder saber si l'usuari ha trobat el producte o no, i poder informar.
            boolean producteTrobat = false;

            //Amb un for hem de recórrer tots els productes de l'array.
            for (int i = 0; i < productes.size(); i++) {
                Producte productActual = productes.get(i);
                if (codiBarres.equals(productActual.getCodiBarres())) {
                    producteTrobat = true;
                    System.out.println("El producte cercat és: " + productActual.getNom());
                }
            }

            //Si el bool es manté en false significa que no hem trobat cap producte.
            if (producteTrobat == false){
                System.out.println("El codi introduït no existeix al carro");
            }
        } else {
            System.out.println("El carro és buit, no es pot trobar cap producte");
        }


    }
}