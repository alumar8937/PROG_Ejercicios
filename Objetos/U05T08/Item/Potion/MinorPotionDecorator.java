package Item.Potion;

public class MinorPotionDecorator extends Potion {

    String name = "";

    public  MinorPotionDecorator(Potion potion) {
        super();
        this.power = potion.power/2;
        this.name = potion.toString();
    }

    public String toString() {
        return name;
    }

}
