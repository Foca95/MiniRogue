/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.util.ArrayList;
import java.util.List;
import MR_Game_Logic.GameData;
import MR_Game_Logic.Player;
/**
 *
 * @author Foca
 */
public class Spells {
    public String name;
    public Player player;
    public GameData gamedata;
    
    
    public Spells(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void effect(){
    }
    
    public void removeEffect(){
        
    }
}
