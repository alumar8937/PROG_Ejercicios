package Item.Food;
import Character.RPGCharacter;

public class PoisonousFoodDecorator extends Food {

    String name = "";

    public PoisonousFoodDecorator(Food food) {
        super();
        this.name = food.toString();
    }

    @Override
    public void consumedBy(RPGCharacter character) {
        character.receivesDamage(this.power);
    }

    public String toString() {
        return name;
    }

}
