package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import Character.Character;
import Character.Job.Assassin;
import Character.Race.Human;

public class TestCharacter {

    double delta = 0.00001;

    @Test
    public void testCharacter() {
        Character character = new Character("Merlin", new Human(), new Assassin());

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
    
}
