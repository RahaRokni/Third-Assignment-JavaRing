# Adventure Game

This is a simple text-based adventure game implemented in Java. The game allows the player to choose a character, explore different locations, and battle enemies. The game ends when the player defeats all enemies in all locations or is defeated by an enemy.

## Game Implementation

### Classes Overview

1. **Main.java**:
   - The main class that runs the game.
   - Handles player creation, location selection, and combat mechanics.

2. **Player.java**:
   - Abstract base class for all player characters.
   - Contains common attributes like health points (HP), mana points (MP), and methods for attacking and taking damage.

3. **Assassin.java**, **Wizard.java**, **Knight.java**:
   - Subclasses of `Player` representing different character types.
   - Each class has unique abilities:
     - **Assassin**: Can become invisible.
     - **Wizard**: Can cast spells.
     - **Knight**: Can perform a strong kick.

4. **Enemy.java**:
   - Base class for all enemies.
   - Contains attributes like HP and methods for attacking.

5. **Dragon.java**, **Goblin.java**, **Skeleton.java**:
   - Subclasses of `Enemy` representing different enemy types.

6. **Location.java**:
   - Represents a game location.
   - Contains a list of enemies and a description.

7. **Weapon.java**:
   - Abstract base class for weapons.
   - Contains attributes like damage and mana cost.

8. **Sword.java**:
   - A specific weapon type with a unique ability.

9. **Armor.java**:
   - Abstract base class for armor.
   - Contains attributes like defense and durability.

10. **KnightArmor.java**:
    - A specific armor type with high defense and durability.

11. **Consumable.java**:
    - Abstract base class for consumable items.
    - Contains attributes like quantity and effect value.

12. **Flask.java**:
    - A specific consumable item that heals the player.

### Game Flow

1. **Character Selection**:
   - The player chooses a character (Assassin, Wizard, or Knight).
   - Each character has unique abilities and starting equipment.

2. **Location Selection**:
   - The player chooses a location to explore.
   - Each location has a description and a list of enemies.

3. **Combat**:
   - The player encounters enemies in the selected location.
   - The player can attack, use an ability, run away, or change the location.
   - Combat continues until the player or the enemy is defeated.

4. **Game Over**:
   - The game ends when the player defeats all enemies in all locations or is defeated by an enemy.

### How to Run the Game

1. Ensure you have Java installed on your system.
2. Compile the Java files:
```
javac org/project/*.java org/project/entity/*.java org/project/entity/enemies/*.java org/project/entity/players/*.java org/project/location/*.java org/project/object/*.java org/project/object/armors/*.java org/project/object/consumables/*.java org/project/object/weapons/*.java
```
3. Run the game:
```
java org.project.Main
```
###Conclusion
This adventure game is a simple yet fun implementation of a text-based RPG. It demonstrates the use of object-oriented programming principles in Java, including inheritance, polymorphism, and encapsulation. Enjoy the game and happy adventuring!
    

