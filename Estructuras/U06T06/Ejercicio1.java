import java.util.LinkedList;

public class Ejercicio1 {
    public static void main(String[] args) {
        LinkedList<Persona> personas = new LinkedList<Persona>();
        personas.add(new Persona("Jose","Ju", "Miguelcín",2));
        personas.add(new Persona("Moisés","Génesis", "Eldelbarco",902));
        personas.add(new Persona("Paco", "Deltabaco", "Mr.Malboro",27));
        int anyo = 2023; // Numero mágico, lo sé ):
        personas.forEach( (p) -> {if (anyo - p.getAge() < 1970){System.out.println(p);}});
    }
}