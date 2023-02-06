package Item.Food;
import Character.Character;

public class PoisonousFoodDecorator extends Food {
    public PoisonousFoodDecorator(Food food) {
        super();
    }

    @Override
    public void consumedBy(Character character) {
        character.receivesDamage(this.power);
    }

}
