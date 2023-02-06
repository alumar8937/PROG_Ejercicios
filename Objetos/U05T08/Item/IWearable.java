package Item;

import Character.RPGCharacter;
import Character.Stat.Stat;

public interface IWearable {

    void wornBy(RPGCharacter character);
    void removedBy(RPGCharacter character);
    int getModifier(Stat stat);

}
