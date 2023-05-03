package lang;

public enum Language {

    ES,
    EN;
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
