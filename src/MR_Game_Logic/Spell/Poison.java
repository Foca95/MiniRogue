/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.Spell;

import MR_Game_Logic.Spells;

/**
 *
 * @author Foca
 */
public class Poison extends Spells{
    
    public Poison(){
        this.name = "Poison";
    }
    
    @Override
    public void effect(){
        gamedata.getPlayer().setDmg(5);
    }
}
