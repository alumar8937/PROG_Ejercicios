package Character.Job;

public class Swashbuckler extends Job {

    public Swashbuckler() {
        super();
        this.CON_MODIFIER = 0;
        this.DEX_MODIFIER = 4;
        this.INT_MODIFIER = 0;
        this.STR_MODIFIER = 1;
    }

    public String toString() {
        return "Swashbuckler";
    }
    
}
