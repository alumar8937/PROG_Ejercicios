package Character;

import java.util.ArrayList;
import Character.Job.Job;
import Character.Race.Race;
import Character.Stat.*;
import Item.IConsumable;
import Item.IWearable;
import Item.Item;
import Item.Weapon.Weapon;

public class RPGCharacter implements IDamageable {

    Stat CON = new Constitution();
    Stat DEX = new Dexterity();
    Stat INT = new Intelligence();
    Stat STR = new Strength();

    double damageTaken = 0;

    String name = "";
    Race race = null;
    Job job = null;

    ArrayList<Item> inventory = new ArrayList<>();
    ArrayList<IWearable> wornEquipment = new ArrayList<>();
    ArrayList<Weapon> equippedWeapons = new ArrayList<>();

    public RPGCharacter(String name, Race race, Job job) {
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
            return CON.getValue() + getGearModifiers(stat);
        }
        if (stat instanceof Dexterity) {
            return DEX.getValue() + getGearModifiers(stat);
        }
        if (stat instanceof Intelligence) {
            return INT.getValue() + getGearModifiers(stat);
        }
        if (stat instanceof Strength) {
            return STR.getValue() + getGearModifiers(stat);
        }
        return 0;
    }

    public int getGearModifiers(Stat stat) {

        int CON = 0;
        int DEX = 0;
        int INT = 0;
        int STR = 0;

        for (int i = 0; i < wornEquipment.size(); i++) {
            if (stat instanceof Constitution) {
                CON++;
            }
            if (stat instanceof Dexterity) {
                DEX++;
            }
            if (stat instanceof Intelligence) {
                INT++;
            }
            if (stat instanceof Strength) {
                STR++;
            }
        }

        if (stat instanceof Constitution) {
            return CON;
        }
        if (stat instanceof Dexterity) {
            return DEX;
        }
        if (stat instanceof Intelligence) {
            return INT;
        }
        if (stat instanceof Strength) {
            return STR;
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

    public void stow(Item item) {
        if (!inventory.contains(item) && getWeightCarried() + item.getWeight() < getMaxWeight()) {
            inventory.add(item);
        } else {
            System.out.println(this.name + " can't add that to the inventory");
        }
    }

    public void drop(Item item) {
        inventory.remove(item);
        System.out.println(this.name + " dropped " + item.getClass().getSimpleName());
    }

    public String listInventory() {

        String list = "";

        for (int i = 0; i < inventory.size(); i++) {
            list = list + "· " + inventory.get(i).toString() + "\n";
        }

        return list;

    }

    public double getWeightCarried() {
        double weight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            weight = weight + inventory.get(i).getWeight();
        }
        return weight;
    }

    public double getMaxWeight() {
        return getStat(new Strength()) * 100;
    }

    public void wear(IWearable equipment) {
        if (!wornEquipment.contains(equipment) && inventory.contains(equipment)) {
            wornEquipment.add(equipment);
        } else {
            System.out.println(this.name + " is alredy wearing that equipment (Object)!");
        }
    }

    public void remove(IWearable equipment) {
        wornEquipment.remove(equipment);
    }

    public void equipWeapon(Weapon weapon) {
        if (equippedWeapons.size() < 2 && inventory.contains(weapon)) {
            equippedWeapons.add(weapon);
        }
    }

    public void unequipWeapon(Weapon weapon) {
        equippedWeapons.remove(weapon);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Weapon> getEquippedWeapons() {
        return equippedWeapons;
    }

    public ArrayList<IWearable> getWornEquipment() {
        return wornEquipment;
    }

}
