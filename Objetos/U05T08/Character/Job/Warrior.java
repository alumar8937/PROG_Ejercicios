package Character.Job;

public class Warrior extends Job {
    
    public Warrior() {
        super();
        this.CON_MODIFIER = 2;
        this.DEX_MODIFIER = 0;
        this.INT_MODIFIER = 0;
        this.STR_MODIFIER = 3;
    }

    public String toString() {
        return "Warrior";
    }
    
}
