package Item.Food;

public class EnhancedFoodDecorator extends Food {
    public EnhancedFoodDecorator(Food food) {
        super();
        this.power = food.power*2;
    }
}
