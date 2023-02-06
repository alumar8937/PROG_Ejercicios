package Item.Food;

import Item.IConsumable;
import Item.Item;
import Character.RPGCharacter;

public abstract class Food extends Item implements IConsumable {

    protected double power = 0;

    public void consumedBy(RPGCharacter character) {
        character.heals(this.power);
    }

    public double getPower() {
        return power;
    }
    
}
