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
public class AwaitCardSelection extends StateAdapter{

    public AwaitCardSelection(GameData game) {
        super(game);
    }
    
    @Override
    public IStates resolveTreasureCard() {
     
        return this;
    }

    @Override
    public IStates resolveTrapCard() {
        
        return this;
    }

    @Override
    public IStates resolveEventCard() {
        
        return this;
    }
}
