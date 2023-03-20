import java.util.Collection;

public class Ejercicio7 {
    private static <T> Collection<T> combinar(Collection<T> collection1, Collection<T> collection2) {
        Collection<T> returnCollection = collection1;
        returnCollection.addAll(collection2); // Unión.
        Collection<T> intersection = collection1; //Intersección
        intersection.retainAll(collection2);
        returnCollection.removeAll(intersection); // Eliminamos los elementos de la intersección.
        return returnCollection;
    }
}
