import java.util.Scanner;

public class SapaMercat {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //Menú
        String opcio;
        do {
            System.out.println("BENVINGUT AL SAPAMERCAT");
            System.out.println("------------");
            System.out.println("-- INICI ---");
            System.out.println("------------");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("");
            System.out.println("");
            System.out.print("");
            opcio = scan.nextLine();
            switch (opcio) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("ATENCIÓ!!! Ha de ser un valor entre 0 i 12");
                    System.out.println("------------------------------------------------------------");
            }
        } while (!(opcio.equals("0")));
    }
    }
}
