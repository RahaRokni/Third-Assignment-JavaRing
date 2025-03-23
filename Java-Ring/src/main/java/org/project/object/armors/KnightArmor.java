package org.project.object.armors;

// TODO: UPDATE IMPLEMENTATION
public class KnightArmor extends Armor {
    public KnightArmor() {
        super(30, 50); // High defense and durability for knight armor
    }

    @Override
    public String toString() {
        return "Knight Armor - " + super.toString();
    }
}