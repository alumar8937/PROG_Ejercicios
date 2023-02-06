package Character;

import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;
import Item.IConsumable;

public class Character implements IDamageable {

    Stat CON = new Constitution();
    Stat DEX = new Dexterity();
    Stat INT = new Intelligence();
    Stat STR = new Strength();

    double damageTaken = 0;

    String name = "";
    Race race = null;
    Job job = null;

    public Character(String name, Race race, Job job) {
        this.name = name;
        this.race = race;
        this.job = job;

        this.CON.setValue(5);
        this.DEX.setValue(5);
        this.INT.setValue(5);
        this.STR.setValue(5);
    }

    public int getStat(Stat stat) {
        if (stat instanceof Constitution) {
            return CON.getValue();
        }
        if (stat instanceof Dexterity) {
            return DEX.getValue();
        }
        if (stat instanceof Intelligence) {
            return INT.getValue();
        }
        if (stat instanceof Strength) {
            return STR.getValue();
        }
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public Race getRace() {
        return this.race;
    }

    public Job getJob() {
        return this.job;
    }

    // (Valor base Dexterity + bonif. raza + bonif.profesion)*2
    public double velocity() {
        return this.DEX.getValue() + this.race.modifier(DEX) + this.job.modifier(DEX)*2;
    }

    // (Valor base Strength + bonif. raza + bonif.profesion)*2
    public double power() {
        return this.STR.getValue() + this.race.modifier(STR) + this.job.modifier(STR)*2;
    }

    // (Valor base Intelligence + bonif. raza + bonif.profesion)*2
    public double magic() {
        return this.INT.getValue() + this.race.modifier(INT) + this.job.modifier(INT)*2;
    }

    @Override
    // Muestra toda la información de un personaje
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Race: " + this.race.toString() + "\n" +
                "Job: " + this.job.toString() + "\n" +
                "-------------------------\n" +
                "CON: " + this.CON.getValue() + "\n" +
                "DEX: " + this.DEX.getValue() + "\n" +
                "INT: " + this.INT.getValue() + "\n" +
                "STR: " + this.STR.getValue() + "\n" +
                "-------------------------\n" +
                "Velocity: " + this.velocity() + "\n" +
                "Power: " + this.power() + "\n" +
                "Magic: " + this.magic() + "\n" +
                "-------------------------\n" +
                "Max Health: " + this.maxHealth() + "\n";
    }

    public double maxHealth() {
        return this.CON.getValue() + this.race.modifier(CON) + this.job.modifier(CON)*25;
    }

    public double health() {
        return maxHealth() - damageTaken;
    }

    public boolean isDead() {
        return (damageTaken >= maxHealth());
    }

    public void receivesDamage(double amount) {
        if (amount <= 0) {return;}
        this.damageTaken = damageTaken + amount;
        System.out.println(this.name + " takes " + amount + " damage.");       
    }

    public void heals(double amount) {
        if (amount <= 0) {return;}
        this.damageTaken = damageTaken - amount;
        if (this.damageTaken < 0) {
            this.damageTaken = 0;
        }
        System.out.println(this.name + " heals " + amount + " damage.");     
    }

    public void consumes(IConsumable consumable) {
        System.out.println(this.name + " eats:  " + consumable.getClass().getSimpleName()); 
        consumable.consumedBy(this); 
    }

}
