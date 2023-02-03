package Character.Job;

public class Assassin extends Job {

    public Assassin() {
        super();
        this.CON_MODIFIER = 1;
        this.DEX_MODIFIER = 3;
        this.INT_MODIFIER = 0;
        this.STR_MODIFIER = 1;
    }

    public String toString() {
        return "Assassin";
    }
    
}
