package Item;
import Character.RPGCharacter;

public abstract class Item implements IStorable {

    protected double weight = 0;

    public void stowedBy(RPGCharacter character) {
        character.stow(this);
    }

    public void droppedBy(RPGCharacter character) {
        character.drop(this);
    }

    @Override
    public abstract String toString();

    public double getWeight() {
        return weight;
    }
    
}
