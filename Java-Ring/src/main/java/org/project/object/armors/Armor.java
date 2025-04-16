package org.project.object.armors;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.maxDefense = defense;
        this.durability = durability;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    // TODO: (BONUS) UPDATE THE REPAIR METHOD
    public void repair() {
        if (isBroke) {
            isBroke = false;
            defense = maxDefense;
            durability = maxDurability;
            System.out.println("Armor has been repaired.");
        } else {
            System.out.println("Armor is not broken and does not need repair.");
        }
    }


    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }

    public void reduceDurability(int amount) {
        if (!isBroke) {
            System.out.println("Armor protected you from enemy attack.");
            durability -= amount;
            checkBreak();
            if (isBroke) {
                System.out.println("Armor has broken!");
            }
        }
    }

    @Override
    public String toString() {
        return "Defense: " + defense + ", Durability: " + durability + ", Broken: " + isBroke;
    }
}
