package org.project;

import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;
import org.project.location.Location;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.consumables.Flask;
import org.project.object.weapons.Sword;
import org.project.object.consumables.Consumable;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;

        List<Location> locations = new ArrayList<>();
        List<Enemy> forestEnemies = new ArrayList<>();
        forestEnemies.add(new Dragon("Dragon",100, 80, new Sword()));
        forestEnemies.add(new Goblin("Goblin",80, 60, new Sword()));

        List<Enemy> cavernEnemies = new ArrayList<>();
        cavernEnemies.add(new Skeleton("Skeleton",150, 120, new Sword()));
        cavernEnemies.add(new Goblin("Goblin",80, 60, new Sword()));

        List<Enemy> cityEnemies = new ArrayList<>();
        cityEnemies.add(new Skeleton("Skeleton",150, 120, new Sword()));
        cityEnemies.add(new Dragon("Dragon",100, 80, new Sword()));

        locations.add(new Location("Enchanted Forest", "A magical forest filled with glowing lights and mythical creatures.", forestEnemies));
        locations.add(new Location("Frozen Cavern", "An icy cave inhabited by a fearsome ice dragon and other cold-dwelling creatures.", cavernEnemies));
        locations.add(new Location("Lost City", "An ancient city hidden deep within the jungle, filled with traps and treasures.", cityEnemies));

        System.out.println("Welcome to the Adventure Game!");

        System.out.println("\nChoose an Character:");
        System.out.println("1. Assaaain");
        System.out.println("2. Wizard");
        System.out.println("3. Knight");

        Player player = null;

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                player =  new Assassin("Gandalf", 100, 50, new Sword(), new KnightArmor(), new Flask());
                System.out.println("Assassin created: " + player.getName());
                break;

            case 2:
                player = new Wizard("Gandalf", 100, 50, new Sword(), new KnightArmor(), new Flask());
                System.out.println("Wizard created: " + player.getName());
                break;

            case 3:
                player = new Knight("Arthur", 120, 20, new Sword(), new KnightArmor(), new Flask());
                System.out.println("Knight created: " + player.getName());
                break;

            default:
                System.out.println("Invalid choice.");
        }

        while (!gameOver) {
            System.out.println("\nChoose a location:");
            for (int i = 0; i < locations.size(); i++) {
                if (!locations.get(i).isVisited()) {
                    System.out.println((i + 1) + ". " + locations.get(i).getName());
                }
            }


            int locationChoice = scanner.nextInt();
            if (locationChoice < 1 || locationChoice > locations.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            Location selectedLocation = locations.get(locationChoice - 1);
            if (selectedLocation.isVisited()) {
                System.out.println("This location has already been visited. Choose another.");
                continue;
            }

            selectedLocation.setVisited(true);

            List<Enemy> enemies = selectedLocation.getEnemies();
            System.out.println("You have entered " + selectedLocation.getName() + "!");
            System.out.println(selectedLocation.getDescription());
            System.out.println();
                boolean playerDefeated = false;
                boolean leavedLocation = false;
                for (Enemy enemy : enemies) {
                    if (!playerDefeated) {
                        System.out.println("An enemy " + enemy.getName() + " appears!");
                        boolean enemyDefeated = false;

                        while (!enemyDefeated && !playerDefeated && !leavedLocation) {
                            System.out.println("you have: " + player.getHp()+ " hp and " + player.getMp() + " mp and your enemy " + enemy.getName() + " has " + enemy.getHp()+ " hp");
                            System.out.println();
                            System.out.println("\nWhat would you like to do?");
                            System.out.println("1. Attack");
                            System.out.println("2. Use Ability");
                            System.out.println("3. Run Away");
                            System.out.println("4. Change Location");
                            int actionChoice = scanner.nextInt();

                            switch (actionChoice) {
                                case 1:
                                    System.out.println("You attack the " + enemy.getName() + "!");
                                    player.attack(enemy);
                                    if (enemy.getHp() <= 0) {
                                        System.out.println("You defeated the " + enemy.getName() + "!");
                                        player.getEnemyHp();
                                        enemyDefeated = true;
                                    } else {
                                        System.out.println("The " + enemy.getName() + " is still alive!");
                                        System.out.println("the "+ enemy.getName() + " attacks you!");
                                        enemy.attack(player);
                                        player.takeDamage(20);
                                        if (player.getHp() <= 0) {
                                            System.out.println("You have been defeated by the " + enemy.getName() + " !");
                                            playerDefeated = true;
                                            gameOver = true;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    if (player instanceof Assassin) {
                                        ((Assassin) player).becomesInvisible();
                                    } else if (player instanceof Wizard) {
                                        ((Wizard) player).castSpell(enemy);
                                    } else if (player instanceof Knight) {
                                        ((Knight) player).strongKick(enemy);
                                    }
                                    if (enemy.getHp() <= 0) {
                                        System.out.println("You defeated the " + enemy.getName() + "!");
                                        enemyDefeated = true;
                                    } else {
                                        System.out.println("The " + enemy.getName() + " is still alive!");
                                    }
                                    break;

                                case 3:
                                    if (player.getMp() >= 15 && player.getHp() >= 50) {
                                        System.out.println("You run away from the " + enemy.getName() + "!");
                                        player.runAway();
                                        enemyDefeated = true;
                                    }else {
                                        System.out.println("You can't run away :(!");
                                    }
                                    break;

                                case 4:
                                    System.out.println("You decide to leave the " + selectedLocation.getName() + " and choose another location.");
                                    leavedLocation = true;
                                    enemyDefeated = true;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }

                        if (locations.stream().allMatch(Location::isVisited)) {
                            System.out.println("You have visited all locations. Game over!");
                            gameOver = true;
                        }
                    }
                }
            }
        }
    }