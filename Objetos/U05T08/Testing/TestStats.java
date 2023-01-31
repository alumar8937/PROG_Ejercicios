package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Character.Stat.Constitution;
import Character.Stat.Dexterity;
import Character.Stat.Intelligence;
import Character.Stat.Stat;
import Character.Stat.Strength;

public class TestStats {

    @Test
    public void testStats() {

        Stat CON = new Constitution();
        Stat DEX = new Dexterity();
        Stat INT = new Intelligence();
        Stat STR = new Strength();

        assertEquals(CON.toString(), "Constitution");
        assertEquals(DEX.toString(), "Dexterity");
        assertEquals(INT.toString(), "Intelligence");
        assertEquals(STR.toString(), "Strength");

        assertEquals(CON.getValue(), 0);
        assertEquals(DEX.getValue(), 0);
        assertEquals(INT.getValue(), 0);
        assertEquals(STR.getValue(), 0);

        CON.increase();
        DEX.increase();
        INT.increase();
        STR.increase();

        assertEquals(CON.getValue(), 1);
        assertEquals(DEX.getValue(), 1);
        assertEquals(INT.getValue(), 1);
        assertEquals(STR.getValue(), 1);

        CON.decrease();
        DEX.decrease();
        INT.decrease();
        STR.decrease();

        assertEquals(CON.getValue(), 0);
        assertEquals(DEX.getValue(), 0);
        assertEquals(INT.getValue(), 0);
        assertEquals(STR.getValue(), 0);

    }
    
}
