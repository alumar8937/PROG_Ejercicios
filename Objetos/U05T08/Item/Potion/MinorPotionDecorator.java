package Item.Potion;

public class MinorPotionDecorator extends Potion {
    public  MinorPotionDecorator(Potion potion) {
        super();
        this.power = potion.power/2;
    }
}
