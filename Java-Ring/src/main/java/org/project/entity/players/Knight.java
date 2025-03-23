package org.project.entity.players;
import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.consumables.Consumable;
import org.project.object.consumables.Flask;
import org.project.object.weapons.Weapon;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

// TODO: UPDATE IMPLEMENTATION
public class Knight extends Player {
    int countRounds = 0;
    private Armor armor;
    public Knight(String name, int hp, int mp,Weapon weapon, Armor armor, Consumable consumable) {
        super(name, hp, mp,weapon,armor, consumable);

    }

    public void strongKick (Enemy target) {
        if (this.getMp() >= 10) {
//            int kickDamage = this.armor.getDamage() + 20;
            target.takeDamage(30);
            System.out.println(this.name + "performs a strong kick" + 30 + " damage");
            countRounds = 0;
        }
        else
        {
            System.out.println(this.name + "cannot use the strong kick yet!");
        }
    }

    @Override
    public void attack(Entity target) {
        super.attack(target);
    }
}
