package lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LangProperties extends Properties{
    
    private static LangProperties INSTANCE = null;

    private static final Language DEFAULT_LANG = Language.ES;

    private LangProperties() {
        super();
        load(DEFAULT_LANG);
    }

    public static LangProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LangProperties();
        }
        return INSTANCE;
    }

    public void load(Language language) {
        try {
            load(new FileInputStream("lang"+File.pathSeparatorChar+language+".lang"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
