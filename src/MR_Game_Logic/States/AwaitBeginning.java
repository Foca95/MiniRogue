/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.GameData;
/**
 *
 * @author pedri
 */
public class AwaitBeginning extends StateAdapter{

    public AwaitBeginning(GameData g) {
        super(g);
    }
    
    @Override
    public IStates setName(String name){
        getGame().getPlayer().setName(name);
        return this;
    }
    
    @Override
    public IStates setDifficulty(int difficulty){
        getGame().setDifficulty(difficulty);
        return this;
    }
    
    @Override
    public IStates setStartingArea(int area){
        getGame().setArena(area);
        return this;
    }
    
    @Override
    public IStates startGame(){
        if(getGame().getArena() != 1){
            if(getGame().initializeOnArea(getGame().getArena()))
                return new AwaitCardSelection(getGame());
        }
        if(getGame().initialize())
            return new AwaitCardSelection(getGame());
        
        return this;
    }
}
