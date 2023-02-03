package Character.Job;

public class Mage extends Job {
    
    public Mage() {
        super();
        this.CON_MODIFIER = 0;
        this.DEX_MODIFIER = 1;
        this.INT_MODIFIER = 4;
        this.STR_MODIFIER = 0;
    }

    public String toString() {
        return "Mage";
    }
    
}
