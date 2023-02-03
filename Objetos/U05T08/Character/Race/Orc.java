package Character.Race;

public class Orc extends Race {

    public Orc() {
        super();
        this.CON_MODIFIER = 3;
        this.DEX_MODIFIER = 0;
        this.INT_MODIFIER = -3;
        this.STR_MODIFIER = 5;
    }

    @Override
    public String toString() {
        return "Orc";
    }
    
}
