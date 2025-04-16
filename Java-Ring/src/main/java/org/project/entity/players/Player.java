package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;
import org.project.object.consumables.Consumable;

// TODO: UPDATE IMPLEMENTATION
public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    Consumable consumable;
    private int hp;
    private int maxHP = 100;
    private int mp;
    private int maxMP = 50;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor, Consumable consumable) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
        this.armor = armor;
        this.consumable = consumable;
    }

    @Override
    public void attack(Entity target) {
        weapon.use(target);
        target.takeDamage(weapon.getDamage());
        this.mp += 5;
    }

    @Override
    public void defend() {
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        if (!armor.isBroke()) {
            armor.reduceDurability(damage);
        } else {
            hp -= damage;
        }
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > 100) {
            hp = 100;
        }
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void castingSpell ()
    {
        this.hp += 10;
        this.mp -= 20;
    }

    public void visibilityMp() {
        this.mp -= 15;
    }

    public void runAway ()
    {
        this.hp -= 40;
        this.mp -= 15;
    }

    public void getEnemyHp ()
    {
        this.hp += 70;
        this.mp += 15;
    }

}
