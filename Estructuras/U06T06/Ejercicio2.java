import java.util.LinkedList;

public class Ejercicio2 {
    public static void main(String[] args) {
        LinkedList<Persona> personas = new LinkedList<Persona>();
        personas.add(new Persona("Jose","Miau", "Miguelcín",2));
        personas.add(new Persona("Moisés","Génesis", "Eldelbarco",902));
        personas.add(new Persona("Paco", "Deltabaco", "Mr.Malboro",27));
        
        personas.forEach( (p) -> {if (p.getSurname().substring(0,1).equalsIgnoreCase("M")) {System.out.println(p);}});
    }
}
