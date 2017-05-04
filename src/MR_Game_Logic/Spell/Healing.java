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
public class Healing extends Spells{
    
    public Healing(){
        this.name = "Healing";
    }
    
    @Override
    public void effect(){
        gamedata.getPlayer().setHp(gamedata.getPlayer().getHp() + 8);
    }
}
