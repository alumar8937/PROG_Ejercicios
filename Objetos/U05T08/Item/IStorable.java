package Item;

import Character.RPGCharacter;

public interface IStorable {

    void stowedBy(RPGCharacter character);
    void droppedBy(RPGCharacter character);
    
}
