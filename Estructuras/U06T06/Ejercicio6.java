import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio6 {
    private static Scanner inputValue = new Scanner(System.in);
    public static void main(String[] args) {

        LinkedList<Persona> personas = new LinkedList<Persona>();

        while (true) {
            String name = "";
            String surname = "";
            String nickname = "";
            int age = 0;
            System.out.println("\nAñadir Persona: ");
            System.out.print("Name: ");
            name = inputValue.nextLine();
            if (name.equals("")) {break;}
            System.out.print("Surname: ");
            surname = inputValue.nextLine();
            if (surname.equals("")) {break;}
            System.out.print("Nickname: ");
            nickname = inputValue.nextLine();
            if (nickname.equals("")) {break;}
            System.out.print("Age: ");
            age = inputValue.nextInt();
            inputValue.nextLine();
            personas.add(new Persona(name, surname, nickname, age));
        }
        
        List<String> nombres =  personas.stream()
                                        .map(Persona::getSurname)
                                        .distinct()
                                        .sorted()
                                        .collect(Collectors.toList());
        nombres.forEach( p -> System.out.println(p));
    
    }
}
