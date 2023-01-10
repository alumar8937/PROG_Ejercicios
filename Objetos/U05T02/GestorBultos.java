// 8-01-2022 Pedro Marín Sanchis

// Este programa se encarga de gestionar los bultos.

import java.util.ArrayList;
import java.util.Scanner;

public class GestorBultos {

    private static Boolean exitCondition = false;

    private static ArrayList<Bulto> bultos = new ArrayList<>();
    private static ArrayList<Camion> camiones = new ArrayList<>();
    private static ArrayList<Mudanza> mudanzas = new ArrayList<>();

    private static void cls() { // Clear screen function.

        System.out.println("\n".repeat(100));

    }

    private static void menu(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                cls();

                correctInputFlag = true;

                System.out.println(
                        "| 0.- Salir | 1.- Crear Bulto | 2.- Crear Camión | 3.- Listar Bultos y Camiones | 4.- Menú de Mudanzas | 5.- Autogenerar Bultos y Camiones |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "1":
                        crearBulto(inputValue);
                        break;

                    case "2":
                        crearCamion(inputValue);
                        break;

                    case "3":
                        cls();
                        listarBultos(bultos);
                        listarCamiones();
                        System.out.print("Pulsa ENTER para continuar.");
                        inputValue.nextLine();
                        break;

                    case "4":
                        menuMudanza(inputValue);
                        break;

                    case "5":
                        autogenerarBultosYCamiones();
                        break;

                    case "0":
                        exitCondition = true;
                        break;

                    default:

                        correctInputFlag = false;
                        cls();
                        System.out.println("[ERROR]: Opción incorrecta, intentalo de nuevo.\n");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void crearBulto(Scanner inputValue) {

        int id;
        int volumen;
        int peso;
        boolean fragil;

        try {

            System.out.print("ID: ");
            id = inputValue.nextInt();
            inputValue.nextLine();
            System.out.print("Volumen: ");
            volumen = inputValue.nextInt();
            inputValue.nextLine();
            System.out.print("Peso: ");
            peso = inputValue.nextInt();
            inputValue.nextLine();
            System.out.print("Fragil [Y/N]: ");
            switch (inputValue.nextLine()) {
                case "Y":
                case "y":
                    fragil = true;
                    break;
                default:
                    fragil = false;
                    break;
            }

            bultos.add(new Bulto(id, volumen, peso, fragil));

        } catch (Exception e) {
        }

    }

    public static void crearCamion(Scanner inputValue) {

        String matricula;
        int volumen;
        int peso;

        try {

            System.out.print("Matricula: "); // Asumimos que la entrada es válida.
            matricula = inputValue.nextLine();
            System.out.print("Volumen: ");
            volumen = inputValue.nextInt();
            inputValue.nextLine();
            System.out.print("Peso: ");
            peso = inputValue.nextInt();
            inputValue.nextLine();

            camiones.add(new Camion(volumen, peso, matricula));

        } catch (Exception e) {
        }

    }

    public static void listarBultos(ArrayList<Bulto> bultos) {

        System.out.println("-- BULTOS --");

        for (int i = 0; i < bultos.size(); i++) {

            System.out.printf("%5d%s%10d%s%10d%s%10d%s%10b%n", i, " - ID: ", bultos.get(i).getId(), " Volumen: ",
                    bultos.get(i).getVolumen(), " Peso: ", bultos.get(i).getPeso(), " Fragil: ",
                    bultos.get(i).getFragil());

        }

    }

    public static void listarCamiones() {

        System.out.println("-- CAMIONES --");

        for (int i = 0; i < camiones.size(); i++) {

            System.out.printf("%5d%s%10s%s%10d%s%10d%n", i, " - Matricula: ", camiones.get(i).getMatricula(), " Volumen: ",
                    camiones.get(i).getCapacidadVolumen(), " Peso: ", camiones.get(i).getCapacidadPeso());

        }

    }

    public static void listarMudanzas() {

        System.out.println("-- MUDANZAS --");

        for (int i = 0; i < mudanzas.size(); i++) {

            System.out.printf("%5d%s%10d%s%10s%s%10d%n", i, " - ID: ", mudanzas.get(i).getId(), " Camión: ",
                    mudanzas.get(i).getMatriculaCamion(), " Distancia: ", mudanzas.get(i).getDistancia());

        }

    }

    public static void menuMudanza(Scanner inputValue) {

        boolean correctInputFlag = false;

        try {

            while (!correctInputFlag) {

                cls();

                System.out.println(
                        "| 0.- Volver | 1.- Crear Mudanza | 2.- Agregar Bultos a Mudanza | 3.- Mostrar Coste Mudanza |");
                System.out.print("Write your choice: ");

                switch (inputValue.nextLine()) {

                    case "1":
                        crearMudanza(inputValue);
                        break;

                    case "2":
                        agregarBultosAMudanza(inputValue, seleccionarMudanza(inputValue));
                        break;

                    case "3":
                        mostrarCosteMudanza(seleccionarMudanza(inputValue));
                        System.out.print("Pulsa ENTER para continuar.");
                        inputValue.nextLine();
                        break;

                    case "0":
                        correctInputFlag = true;
                        break;

                    default:

                        correctInputFlag = false;
                        cls();
                        System.out.println("[ERROR]: Opción incorrecta, intentalo de nuevo.\n");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public static void crearMudanza(Scanner inputValue) {

        int id;
        int distancia;
        int posicionCamion;

        try {

            System.out.print("ID: ");
            id = inputValue.nextInt();
            inputValue.nextLine();
            System.out.print("Distancia: ");
            distancia = inputValue.nextInt();
            inputValue.nextLine();

            while (true) {

                cls();
                listarCamiones();
                System.out.print("Camión [Número en lista]: ");
                posicionCamion = inputValue.nextInt();
                inputValue.nextLine();
                try {

                    mudanzas.add(new Mudanza(id, camiones.get(posicionCamion), distancia));
                    break;

                } catch (IndexOutOfBoundsException e) {}

            }

        } catch (Exception e) {}

    }

    private static Mudanza seleccionarMudanza(Scanner inputValue) {

        int posicionMudanza;

        while (true) {

            cls();
            listarMudanzas();
            System.out.print("Mudanza [Número en lista]: ");
            posicionMudanza = inputValue.nextInt();
            inputValue.nextLine();
            try {

                return mudanzas.get(posicionMudanza);

            } catch (Exception e) {}

        }

    }

    private static void mostrarCosteMudanza(Mudanza mudanza) {
        System.out.println("El coste total es de: " + mudanza.getCoste() + " €");
    }

    public static void agregarBultosAMudanza(Scanner InputValue, Mudanza mudanza) {

        int posicionBulto;

        while(true) {
            try {
                cls();
                System.out.println("-- SIN ASIGNAR --");
                listarBultos(bultos);
                System.out.println("-- ASIGNADOS --");
                listarBultos(mudanza.getBultos());
                System.out.println("Peso restante: " + (mudanza.getCapacidadPeso() - mudanza.calcularPesoTotal() + "\nVolumen Restante: " + (mudanza.getCapacidadVolumen() - mudanza.calcularVolumenTotal())));
                System.out.println("Bulto a añadir [-1 para salir]");
                posicionBulto = InputValue.nextInt();
                InputValue.nextLine();
                if (mudanza.agregarBulto(bultos.get(posicionBulto))) {
                    bultos.remove(posicionBulto);
                } else {
                    cls();
                    System.out.print("No se puede agregar este bulto. [Pulsa ENTER para continuar]");
                    InputValue.nextLine();
                }
                
            } catch (Exception e) {
                return;
            }
        }

    }

    public static void autogenerarBultosYCamiones() {

        // Bultos

        for (int i = 1; i < 6; i++) {
            bultos.add(new Bulto(i, i * 3, i * 10, true));
        }

        for (int i = 1; i < 6; i++) {
            bultos.add(new Bulto(i, i * 10, i * 5, false));
        }

        // Camiones

        camiones.add(new Camion(50, 120, "123456ABC"));
        camiones.add(new Camion(50, 50, "123456DEF"));
        camiones.add(new Camion(120, 120, "123456GHI"));

    }

    public static void main(String[] args) {

        Scanner inputValue = new Scanner(System.in);

        while (!exitCondition) {

            menu(inputValue);

        }

    }

}