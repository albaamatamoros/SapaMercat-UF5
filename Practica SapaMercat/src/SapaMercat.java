import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SapaMercat {
    static ArrayList<Producte> productes = new ArrayList<Producte>();
    static Map<String,Integer> carro = new HashMap<String,Integer>();

    static String opcio;
    static Scanner scan = new Scanner(System.in);
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
    //AFEGIR PRODUCTES
    private static void afegirProducteAlimentacio(){
        String nom;
        float preu;
        String dataCaducitat;
        String codiBarres;
        try {
            //
            System.out.println("Afegir aliment");

            System.out.print("Nom producte: \t");
            nom = scan.nextLine();

            System.out.print("preu: \t");
            preu = scan.nextFloat();
            scan.nextLine();

            System.out.print("Codi de barres: ");
            codiBarres = scan.nextLine();

            System.out.print("Data de caducitat: ");
            dataCaducitat = scan.nextLine();

            //productes.add(new Alimentacio(preu, nom, codiBarres, dataCaducitat));
            carro.put(nom, 1);

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
            System.out.println("Afegir tèxtil");

            System.out.print("Nom producte: \t");
            nom = scan.nextLine();

            System.out.print("preu: \t");
            preu = scan.nextFloat();
            scan.nextLine();

            System.out.print("Composició: ");
            composicio = scan.nextLine();

            System.out.print("Codi de barres: ");
            codiBarres = scan.nextLine();

            productes.add(new Textil(preu, nom, codiBarres, composicio));
            carro.put(nom, 1);

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
            System.out.println("Afegir electrònica");

            System.out.print("Nom producte: \t");
            nom = scan.nextLine();

            System.out.print("preu: \t");
            preu = scan.nextFloat();
            scan.nextLine();

            System.out.print("Garantia (dies): ");
            garantia = scan.nextInt();
            scan.nextLine();

            System.out.print("Codi de barres: ");
            codiBarres = scan.nextLine();

            productes.add(new Electronica(preu, nom, codiBarres, garantia));
            //carro.put(codiBarres, nom);

            //Mostrar Array
            for (int i = 0; i < productes.size(); i++) {
                System.out.println(productes.get(i));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //PASSAR PER CAIXA
    public static void  passarPerCaixa(){
        System.out.println("Carret");
    }

    //MOSTRAR CARRET DE COMPRA
    public static void  mostrarCarretCompra (){
        System.out.println(carro.toString());

        carro.keySet().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String item : carro.keySet()) {
            System.out.printf("%s -> %s\n",item,carro.get(item));
        }
    }
}
