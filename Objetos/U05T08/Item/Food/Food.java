package Item.Food;

import Item.IConsumable;
import Character.Character;

public class Food implements IConsumable {

    protected double power = 0;

    public void consumedBy(Character character) {
        character.heals(this.power);
    }

    public double getPower() {
        return power;
    }
    
}
