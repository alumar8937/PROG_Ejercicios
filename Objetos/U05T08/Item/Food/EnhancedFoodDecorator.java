package Item.Food;

public class EnhancedFoodDecorator extends Food {

    String name = "";

    public EnhancedFoodDecorator(Food food) {
        super();
        this.power = food.power*2;
        this.name = food.toString();
    }

    public String toString() {
        return name;
    }

}
