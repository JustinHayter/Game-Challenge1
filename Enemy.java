/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Justin
 */
import java.util.Random;

public class Enemy {

    int health;
    int attack;
    int defense;
    String name;
    static Random rand = new Random();

    public Enemy(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int attackStrength(){
        return attack;
    }

    public String takeHit(int hit) {
        String rc = "";
        health = health - (hit - defense);
        rc = name + " took " + (hit - defense) + "damage, now has " + health + " health points remaining";
        if (health < 0) {
            rc += "\n" + name + " has been killed";
        }
        return rc;

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String toString() {
        return (name + " currently has: " + health + " health points left");
    }

    public int chooseTarget(Character[] party) {
        int x = 0;
        int rc=0;
        while (x <100) {
            rc = rand.nextInt(party.length);
            if (party[rc] != null) {
                break;
            }
            x++;
        }
        return rc;
    }

}
