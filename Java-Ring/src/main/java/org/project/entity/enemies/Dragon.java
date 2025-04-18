package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Dragon extends Enemy {

    public Dragon(String name ,int hp, int mp, Weapon weapon) {
        super(name,hp, mp, weapon);
    }

    @Override
    public void useAbility(Entity target) {
        System.out.println("Dragon uses its fiery breath, bypassing all defenses!");
        int damage = 30;
        target.takeDamage(damage);
        System.out.println("Dragon damages ");
    }


    @Override
    public void attack(Entity target) {
        if (this.getHp() <= 50) {
            useAbility(target);
        }
        else {
            super.attack(target);
        }

    }

    @Override
    public void defend() {

    }

    @Override
    public void heal(int health) {

    }

    @Override
    public void fillMana(int mana) {

    }

    @Override
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getMaxMP() {
        return 0;
    }
}