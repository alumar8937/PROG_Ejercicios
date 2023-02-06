package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Item.Potion.*;

public class TestPotion {

    double delta = 0.00001;

    @Test
    public void testPotion() {

        HealingPotion healingPotion = new HealingPotion();
        MinorPotionDecorator minorHealingPotion = new MinorPotionDecorator(healingPotion);
        GreaterPotionDecorator greaterHealingPotion = new GreaterPotionDecorator(healingPotion);

        assertEquals(healingPotion.getPower(), 50, delta);
        assertEquals(minorHealingPotion.getPower(), 25, delta);
        assertEquals(greaterHealingPotion.getPower(), 100, delta);

    }
    
}
