package org.project.entity;

import org.project.entity.enemies.Enemy;

public interface Entity {

    void attack(Entity target);
    public int getHp();

    void defend();

    void heal(int health);

    void fillMana(int mana);

    void takeDamage(int damage);

    int getMaxHP();

    int getMaxMP();

    String getName();

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
