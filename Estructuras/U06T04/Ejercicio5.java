import java.util.Set;

public class Ejercicio5 {
    private static <T> Set<T> combinar(Set<T> set1, Set<T> set2) {
        Set<T> returnSet = set1;
        returnSet.addAll(set2);
        return returnSet;
    }
}
