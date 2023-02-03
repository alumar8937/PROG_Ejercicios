package Character.Race;

public class Asteroth extends Race {

    public Asteroth() {
        super();
        this.CON_MODIFIER = 2;
        this.DEX_MODIFIER = 3;
        this.INT_MODIFIER = 0;
        this.STR_MODIFIER = 0;
    }

    @Override
    public String toString() {
        return "Asteroth";
    }
    
}