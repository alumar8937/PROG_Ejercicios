/**
 * Esta clase da cierta funcionalidad para un Animal que tiene un nombre y sabe hacer ciertas cosas!
 */
public class Animal
{
    private String nombre;

    /**
     * Constructor para objetos de la clase Animal
     */
    public Animal(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * El método comunicarse es común para el gato y el perro, aunque cada uno lo hace de una forma
     * 
     */
    public void comunicarse()
    {
        System.out.println("Mi nombre es " + nombre);
    }

    /**
     * El método respirar es común para el gato y el perro
     * 
     */
    public void respirar()
    {
        System.out.println("Respiro aire por los pulmones");
    }    

    /**
     * El método moverse es común para el gato y el perro
     * 
     */
    public void moverse()
    {
        System.out.println("Me muevo a 4 patas");
    }    

    /**
     * El método mamar es común para el gato y el perro
     * 
     */
    public void mamar()
    {
        System.out.println("Cuando soy pequeño mamo");
    }    
    
    
    /**
     *
     * toString() Representación como cadena de un objeto animal
     *
     * @returns  La representación como cadena de un objeto animal
     *
     */
    public String toString()
    {
        return "Animal: " + nombre;
    }
}