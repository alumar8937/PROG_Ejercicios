package Character.Job;

import Character.Stat.*;

public abstract class Job {

    protected int CON_MODIFIER = 0;
    protected int DEX_MODIFIER = 0;
    protected int INT_MODIFIER = 0;
    protected int STR_MODIFIER = 0;

    @Override
    public abstract String toString();
    
    //Devuelve el modificador de la profesión segun el stat
    public int modifier(Stat stat) {
        if (stat instanceof Constitution) {
            return CON_MODIFIER;
        }
        if (stat instanceof Dexterity) {
            return DEX_MODIFIER;
        }
        if (stat instanceof Intelligence) {
            return INT_MODIFIER;
        }
        if (stat instanceof Strength) {
            return STR_MODIFIER;
        }
        return 0;
    }
    
    @Override
    //Devuelve true si son la misma clase
    public boolean equals(Object obj){
        return (obj instanceof Job); // ????
    }
    
}
