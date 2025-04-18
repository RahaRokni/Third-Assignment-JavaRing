package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public  class Skeleton extends Enemy {
    private boolean hasResurrected = false;

    public Skeleton(String name ,int hp, int mp, Weapon weapon) {
        super(name ,hp, mp, weapon);
    }

    @Override
    public void useAbility(Entity target) {
        System.out.println("Skeleton ☠️ attacks with its weapon!");
        if (this.getHp() == 0 && !hasResurrected) {
            resurrectSkeleton();
            this.hasResurrected = true;
            System.out.println("Skeleton ☠️ resurrects with " + this.getHp() + " HP!");
        }
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