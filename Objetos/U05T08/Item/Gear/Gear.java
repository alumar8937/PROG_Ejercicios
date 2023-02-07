package Item.Gear;

import Character.RPGCharacter;
import Character.Stat.*;
import Item.IWearable;
import Item.Item;

public abstract class Gear extends Item implements IWearable {

    protected int CON_MODIFIER = 0;
    protected int DEX_MODIFIER = 0;
    protected int INT_MODIFIER = 0;
    protected int STR_MODIFIER = 0;

    public Gear() {
        this.weight = 15;
    }
    
    //Devuelve el modificador del objeto según el stat.
    public int getModifier(Stat stat) {
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

    public void wornBy(RPGCharacter character) {
        character.wear(this);  
    }

    public void removedBy(RPGCharacter character) {
        character.remove(this);        
    }
    
}
