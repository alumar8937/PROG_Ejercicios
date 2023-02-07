package Item.Potion;

import Item.IConsumable;
import Item.Item;
import Character.RPGCharacter;

public abstract class Potion extends Item implements IConsumable {

    protected double power = 0;

    public Potion() {
        this.weight = 5;
    }

    public void consumedBy(RPGCharacter character) {
        character.heals(this.power);
    }

    public double getPower() {
        return power;
    }
    
}
