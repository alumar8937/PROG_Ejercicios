package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Character.Race.*;
import Character.Stat.*;

public class TestRace {
    @Test
    public void testJobs() {

        int sum = 0; //Should result 5 for every Job.

        Race[] races = {
            new Asteroth(),
            new Elf(),
            new Human(),
            new Orc(),
            new Vampyre()
        };

        Stat[] stats = {
            new Constitution(),
            new Dexterity(),
            new Intelligence(),
            new Strength()
        };

        for (int i = 0; i < races.length; i++) {
            sum = 0;
            for (int j = 0; j < stats.length; j++) {
                sum = sum + races[i].modifier(stats[j]);
            }
            assertEquals(sum, 5);
        }

        assertEquals(races[0].toString(), "Asteroth");
        assertEquals(races[1].toString(), "Elf");
        assertEquals(races[2].toString(), "Human");
        assertEquals(races[3].toString(), "Orc");
        assertEquals(races[4].toString(), "Vampyre");

        assertEquals(races[0].equals(races[1]), true);

    }
}
