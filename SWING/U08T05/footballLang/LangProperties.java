package footballLang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class LangProperties extends Properties{
    
    private static LangProperties INSTANCE = null;

    private static final Language DEFAULT_LANG = Language.EN;

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
            FileInputStream fis = new FileInputStream(new File("footballLang"+File.separatorChar+language+".lang"));
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            load(in);
        } catch (Exception e) {}
    }

}
