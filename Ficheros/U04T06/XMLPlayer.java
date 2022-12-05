import java.io.File;
import java.util.ArrayList;

public class XMLPlayer {

    public static ArrayList<Player> loadXMLFile(File file) {

        ArrayList<Player> list = new ArrayList<Player>(1);

        list.add(new Player(9, "Brazil", "Gabriel Martinelli", 2001, (float) 1.78, "Arsenal (ENG)"));
        list.add(new Player(9, "Brazil", "Gabriel Martinelli", 2001, (float) 1.78, "Arsenal (ENG)"));
        list.add(new Player(9, "Brazil", "Gabriel Martinelli", 2001, (float) 1.78, "Arsenal (ENG)"));
        list.add(new Player(9, "Brazil", "Gabriel Martinelli", 2001, (float) 1.78, "Arsenal (ENG)"));

        return list;

    }


    public static ArrayList<Player> appendXMLFile(ArrayList<Player> list, File file) {

        for (Player i: loadXMLFile(file)) {

            list.add(i);

        }

        return list;

    }


    public static void exportXMLFile(ArrayList<Player> list, File file) {



    }
    
}
