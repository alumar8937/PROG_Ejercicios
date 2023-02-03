package Character.Race;

public class Human extends Race {

    public Human() {
        super();
        this.CON_MODIFIER = 2;
        this.DEX_MODIFIER = 1;
        this.INT_MODIFIER = 0;
        this.STR_MODIFIER = 2;
    }
    
    @Override
    public String toString() {
        return "Human";
    }
    
}
