package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import Character.RPGCharacter;
import Character.Job.Assassin;
import Character.Race.Human;
import Character.Stat.Intelligence;
import Item.*;
import Item.Food.*;
import Item.Gear.*;


public class TestCharacter {

    double delta = 0.00001;

    @Test
    public void testCharacter() {
        RPGCharacter character = new RPGCharacter("Merlin", new Human(), new Assassin());

        assertEquals(character.getName(), "Merlin");
        assertEquals(character.getJob().toString(), "Assassin");
        assertEquals(character.getRace().toString(), "Human");

        double maxHP = character.maxHealth();

        character.receivesDamage(5); // Recibir daño en positivo (Debe restar vida.)
        assertEquals(character.health(), maxHP - 5, delta);
        
        character.receivesDamage(-5); // Recibir daño en negativo (No debe hacer nada.)
        assertEquals(character.health(), maxHP - 5, delta);

        character.heals(-5); // Curar en negativo (No debe hacer nada.)
        assertEquals(character.health(), maxHP - 5, delta);

        character.heals(5); // Curar en positivo (Debe sumar vida.)
        assertEquals(character.health(), maxHP);

    }

    @Test
    public void testInventory() {

        RPGCharacter character = new RPGCharacter("Merlin", new Human(), new Assassin());

        Food apple = new Apple();
        Food behelit = new Behelit();

        apple.stowedBy(character);
        assertEquals(character.listInventory(), "· Apple\n");

        behelit.stowedBy(character);
        assertEquals(character.listInventory(), "· Apple\n· Behelit\n");

        behelit.droppedBy(character);
        assertEquals(character.listInventory(), "· Apple\n");

        apple.droppedBy(character);
        assertEquals(character.listInventory(), "");

    }

    @Test
    public void testGear() {

        RPGCharacter character = new RPGCharacter("Merlin", new Human(), new Assassin());

        Gear glasses = new Glasses();

        int baseINTStat = character.getStat(new Intelligence());

        System.out.println("Weight carried: " + character.getWeightCarried());
        System.out.println("Max weight: " + character.getMaxWeight());

        character.stow(glasses); // Para equipar un objeto debes tenerlo en el inventario.
        character.wear(glasses);

        assertEquals(baseINTStat + 1, character.getStat(new Intelligence()));

        System.out.println("Weight carried: " + character.getWeightCarried());
        System.out.println("Max weight: " + character.getMaxWeight());

        Item leadBrick = new LeadBrick();
        Item leadBrick2 = new LeadBrick();

        character.stow(leadBrick);

        System.out.println("Weight carried: " + character.getWeightCarried());
        System.out.println("Max weight: " + character.getMaxWeight());

        character.stow(leadBrick2);

        System.out.println("Weight carried: " + character.getWeightCarried());
        System.out.println("Max weight: " + character.getMaxWeight());

    }
    
}
