package programLanguage;

// Enum of supported languages.

public enum ProgramLanguage {

    ES,
    EN;
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
