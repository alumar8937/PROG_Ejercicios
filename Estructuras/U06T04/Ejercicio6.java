import java.util.Collection;

public class Ejercicio6 {
    private static <T> Collection<T> combinar(Collection<T> collection1, Collection<T> collection2) {
        Collection<T> returnCollection = collection1;
        returnCollection.retainAll(collection2);
        return returnCollection;
    }
}
