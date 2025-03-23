package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private int damage;
    private int manaCost;
    private int durability;

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(int damage, int manaCost, int durability) {
        this.damage = damage;
        this.manaCost = manaCost;
        this.durability = durability;
    }

    @Override
    public void use(Entity target) {
        if (durability > 0) {
        target.takeDamage(damage + 5);
        durability -= 2;
        } else {
            System.out.println("Weapon is broken and cannot be used!");
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDurability() {
        return durability;
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
