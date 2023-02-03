package Character.Job;

public class Alchemist extends Job {
    
    public Alchemist() {
        super();
        this.CON_MODIFIER = 0;
        this.DEX_MODIFIER = 0;
        this.INT_MODIFIER = 4;
        this.STR_MODIFIER = 1;
    }

    public String toString() {
        return "Alchemist";
    }

}
