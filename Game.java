/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 *To-do
 * -find more clean way for party to be killed
 * -armor
 * -spells
 * 
 * @author Justin
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        int input = 0;
        Scanner keyboard = new Scanner(System.in);
        boolean partyDied = false;
        boolean groupDied = false;
        Item[] inventory = new Item[5];
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item(45, "Health Potion");
        }

        Character[] party = new Character[3];
        party[0] = new Character("Tiz", 100, 12, 5);
        party[1] = new Character("Ringabel", 100, 10, 7);
        party[2] = new Character("Edea", 100, 15, 5);

        Enemy[] group = new Enemy[2];
        group[0] = new Enemy("Skeleton", 50, 10, 5);
        group[1] = new Enemy("Slime", 25, 8, 5);

        //System.out.println(printGroup(group));
        while ((partyDied == false) && (groupDied == false)) {
            for (int i = 0; i < party.length; i++) {
                if (party[i] != null) {
                    party[i].setDefending(false);
                    System.out.println(party[i].toString()); 
                    System.out.println("1: Attack     2.Defend");
                    System.out.println("3. Item");
                    System.out.print("Select an option: ");
                    input = keyboard.nextInt();
                    if (input == 1) {
                        System.out.println(printGroup(group));
                        System.out.print("Select an enemy to attack");

                        input = keyboard.nextInt();
                        System.out.println(group[input].takeHit(party[i].attackStrength()));
                        if (group[input].getHealth() <= 0) {
                            group[input] = null;
                            if (groupDead(group)) {
                                groupDied = true;
                            }
                        }

                    } else if (input == 2) {
                        party[i].setDefending(true);
                        System.out.println(party[i].getName() + " is now defending");
                    }

                }
            }

            for (int i = 0; i < group.length; i++) {
                int x=0;
                if (group[i] != null) {
                    System.out.println("I got here");
                    x = group[i].chooseTarget(party);
                    try{
                    System.out.println(party[x].takeHit(group[i].attackStrength()));
                    if(party[x].getHealth()<=0){
                        party[x]=null;
                        if(partyDead(party)){
                            partyDied=true;
                            break;
                        }
                    }
                    }catch(NullPointerException npe){
                        System.out.println("You have been killed, oh no!");
                    }
                }
            }

        }
        if (groupDied) {
            System.out.println("Congratulations, you won!");
        }
           

    }

    public static String printGroup(Enemy[] group) {
        String rc = "";
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null) {
                rc += i + "." + group[i].toString() + "\n";
            }
        }
        return rc;
    }

    public static boolean groupDead(Enemy[] group) {
        boolean rc = true;
        for (Enemy x : group) {
            if (x != null) {
                rc = false;
            }
        }
        return rc;
    }
    public static boolean partyDead (Character[] party){
        boolean rc=true;
        for(Character x : party){
            if(x!=null){
                rc=false;
            }
        }
        return rc;
    }

}
