package programLanguage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ProgramLanguageProperties extends Properties{
    
    private static ProgramLanguageProperties INSTANCE = null;

    private static final ProgramLanguage DEFAULT_LANG = ProgramLanguage.EN;

    private ProgramLanguageProperties() {
        super();
        load(DEFAULT_LANG);
    }

    public static ProgramLanguageProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProgramLanguageProperties();
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
