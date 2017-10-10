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
public class Character {
    String name;
    int health;
    int maxHealth;
    int attack;
    int defense;
    boolean defending;

    public Character(String name,int health, int attack, int defense) {
        this.name= name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        maxHealth=health;
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
    
    public void useItem(Item x){
        health += x.getRecovery();
        if(health>maxHealth){
            health=maxHealth;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }
    
    @Override
    public String toString(){
       return (name + " currently has: "+ health+ " health points left");
    }
    
    
}


