package Character.Race;

public class Vampyre extends Race {

    public Vampyre() {
        super();
        this.CON_MODIFIER = 3;
        this.DEX_MODIFIER = 0;
        this.INT_MODIFIER = 1;
        this.STR_MODIFIER = 1;
    }

    @Override
    public String toString() {
        return "Vampyre";
    }
    
}