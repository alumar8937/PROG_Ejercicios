package Character.Race;

public class Elf extends Race {

    public Elf() {
        super();
        this.CON_MODIFIER = -1;
        this.DEX_MODIFIER = 3;
        this.INT_MODIFIER = 3;
        this.STR_MODIFIER = 0;
    }

    @Override
    public String toString() {
        return "Elf";
    }
    
}