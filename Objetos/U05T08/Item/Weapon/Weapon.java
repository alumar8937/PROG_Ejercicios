package Item.Weapon;

import Character.RPGCharacter;
import Item.Item;

public abstract class Weapon extends Item {

    protected double damage = 0;

    public Weapon() {
        this.weight = 10;
    }

    public void attacks(RPGCharacter character) {
        character.receivesDamage(damage);
    }
    
}
