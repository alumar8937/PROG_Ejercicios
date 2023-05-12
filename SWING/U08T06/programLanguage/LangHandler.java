package programLanguage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

// This class manages program language and reads from the dictionary files located in /programLanguage.

public class LangHandler extends Properties{
    
    private static LangHandler INSTANCE = null;

    private static final ProgramLanguage DEFAULT_LANG = ProgramLanguage.ES;

    private LangHandler() {
        super();
        load(DEFAULT_LANG);
    }

    public static LangHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LangHandler();
        }
        return INSTANCE;
    }

    public void load(ProgramLanguage language) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("programLanguage"+File.separatorChar+language+".lang"));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            load(inputStreamReader);
        } catch (Exception e) {}
    }

}
