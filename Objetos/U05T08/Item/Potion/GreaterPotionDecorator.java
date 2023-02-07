package Item.Potion;

public class GreaterPotionDecorator extends Potion{

    String name = "";

    public  GreaterPotionDecorator(Potion potion) {
        super();
        this.power = potion.power*2;
        this.name = potion.toString();
    }

    public String toString() {
        return name;
    }
    
}
