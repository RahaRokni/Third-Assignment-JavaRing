package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public class Sword extends Weapon {
    /*
    THIS IS AN EXAMPLE OF A WEAPON DESIGN.
    */

    private int abilityCharge;

    public Sword() {
        super(10,5, 10);
        this.abilityCharge = 0;
    }

    // TODO: (BONUS) UPDATE THE UNIQUE ABILITY
    public void uniqueAbility(ArrayList<Enemy> targets) {
        if (getDurability() > 0) {
            abilityCharge += 2;
            for (Enemy target : targets) {
                target.takeDamage(getDamage());
            }
            System.out.println("Sword's unique ability used! Damage increased by " + abilityCharge);
        } else {
            System.out.println("Sword is broken and cannot use its ability!");
        }
    }

    @Override
    public int getDamage() {
        return super.getDamage() + abilityCharge;
    }

    @Override
    public void use(Entity target) {
        if (getDurability() > 0) {
            super.use(target);
            System.out.println("Sword used on " + target.getName() + "!");
        } else {
            System.out.println("Sword is broken and cannot be used!");
        }
    }
}
