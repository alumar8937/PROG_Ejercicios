package Item.Potion;

public class GreaterPotionDecorator extends Potion{
    public  GreaterPotionDecorator(Potion potion) {
        super();
        this.power = potion.power*2;
    }
}
