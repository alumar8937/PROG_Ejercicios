package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Item.Food.Apple;
import Item.Food.Behelit;
import Item.Food.Bread;
import Item.Food.Carrot;
import Item.Food.Chicken;
import Item.Food.EnhancedFoodDecorator;
import Item.Food.Food;

public class TestFood {

    double delta = 0.00001;

    @Test
    public void testFood() {

        Food apple = new Apple();
        Food behelit = new Behelit();
        Food bread = new Bread();
        Food carrot = new Carrot();
        Food chicken = new Chicken();

        EnhancedFoodDecorator superApple = new EnhancedFoodDecorator(new Apple());
        assertEquals(superApple.getPower(), 10, delta);

        assertEquals(apple.getPower(), 5, delta);
        assertEquals(behelit.getPower(), 500, delta);
        assertEquals(bread.getPower(), 10, delta);
        assertEquals(carrot.getPower(), 3, delta);
        assertEquals(chicken.getPower(), 25, delta);

    }
}
