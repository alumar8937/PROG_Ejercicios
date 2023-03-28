import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio3 {
    public static void main(String[] args) {
        LinkedList<Persona> personas = new LinkedList<Persona>();
        personas.add(new Persona("Jose","Miau", "Miguelcín",2));
        personas.add(new Persona("Moisés","Génesis", "Eldelbarco",902));
        personas.add(new Persona("Paco", "Deltabaco", "Mr.Malboro",27));
        personas.add(new Persona("Lorena", "García", "Lola", 29));
        personas.add(new Persona("Marcelo", "Hernández", "El Mago", 42));
        personas.add(new Persona("Carolina", "Martínez", "Carol", 25));
        personas.add(new Persona("Gonzalo", "Gómez", "Gonza", 36));
        personas.add(new Persona("Sofía", "Sánchez", "Sofi", 18));
        personas.add(new Persona("Juan", "Pérez", "El Profe", 51));
        personas.add(new Persona("Lucas", "Gutiérrez", "Luqui", 10));
        personas.add(new Persona("Valentina", "Rodríguez", "Vale", 27));
        personas.add(new Persona("Diego", "López", "Dieguito", 5));
        personas.add(new Persona("Amanda", "Fernández", "Mandy", 38));
        personas.add(new Persona("Amanda", "Fernández", "Mandy", 38));
        personas.add(new Persona("Amanda", "Fernández", "Mandy", 38));
        personas.add(new Persona("Amanda", "Fernández", "Mandy", 38));

        
        List<String> nombres =  personas.stream()
                                        .map(Persona::getName)
                                        .distinct()
                                        .sorted()
                                        .collect(Collectors.toList());
        nombres.forEach( p -> System.out.println(p));
    
    }
}
