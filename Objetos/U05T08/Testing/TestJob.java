package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Character.Job.*;
import Character.Stat.*;

public class TestJob {
    @Test
    public void testJobs() {

        int sum = 0; //Should result 5 for every Job.

        Job[] jobs = {
            new Assassin(),
            new Mage(),
            new Warrior(),
            new Alchemist(),
            new Swashbuckler()
        };

        Stat[] stats = {
            new Constitution(),
            new Dexterity(),
            new Intelligence(),
            new Strength()
        };

        for (int i = 0; i < jobs.length; i++) {
            sum = 0;
            for (int j = 0; j < stats.length; j++) {
                sum = sum + jobs[i].modifier(stats[j]);
            }
            assertEquals(sum, 5);
        }

        assertEquals(jobs[0].toString(), "Assassin");
        assertEquals(jobs[1].toString(), "Mage");
        assertEquals(jobs[2].toString(), "Warrior");
        assertEquals(jobs[3].toString(), "Alchemist");
        assertEquals(jobs[4].toString(), "Swashbuckler");

        assertEquals(jobs[0].equals(jobs[1]), true);

    }
}
