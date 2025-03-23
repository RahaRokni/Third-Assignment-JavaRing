package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.consumables.Consumable;
import org.project.object.weapons.Weapon;

public class Assassin extends Player {
    private boolean visibility = true;
    public Assassin(String name, int hp, int mp, Weapon weapon, Armor armor, Consumable consumable) {
        super(name, hp, mp,weapon, armor, consumable);
    }

    public void becomesInvisible () {
        if (this.getMp() >= 15)
        {
            this.visibility = false;
            this.visibilityMp();
            System.out.println(this.name + " becomes invisible! Immune to damage for the next attack.");
        }
        else {
            System.out.println(this.name + " does not have enough mana to become invisible!");
        }
    }


    @Override
    public void attack(Entity target) {
        if (!visibility)
        {
            int increasedDamage = 10;
            target.takeDamage(30);
            System.out.println(this.name + " attacks from the shadows, dealing " + increasedDamage + " damage!");
            this.visibility = true;
        }
        else {
            super.attack(target);
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (!visibility) {
            System.out.println(this.name + " is invisible and avoids the attack!");
        } else {
            super.takeDamage(damage);
        }
    }
}
