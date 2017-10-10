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
public class Item {
    int recovery;
    String name;

    public Item(int recovery, String name) {
        this.recovery = recovery;
        this.name = name;
    }
        
     
    public int getRecovery() {
        return recovery;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
