public abstract class Mamifero extends Animal {

    public Mamifero(String nombre) {
        super(nombre);
    }

    /**
     * El método mamar es común para el gato y el perro
     * 
     */
    public void mamar()
    {
        System.out.println("Cuando soy pequeño mamo");
    }   

}