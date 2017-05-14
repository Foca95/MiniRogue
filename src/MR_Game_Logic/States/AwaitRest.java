/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.GameData;
import MR_Game_Logic.Player;
/**
 *
 * @author pedri
 */
public class AwaitRest extends StateAdapter{
    
    public AwaitRest(GameData g) {
        super(g);
    }
    
    @Override
    public IStates setRestOption(int option){
        Player p = getGame().getPlayer();
        int pXp = p.getXp();
        int pFood = p.getFood();
        int pHealth = p.getHp();
        if(option == 1){
            p.setXp(pXp + 1);
            getGame().setUiText("Ganhou 1 de Xp");
            getGame().checkLevelUp();
        }
        if(option == 2){
            getGame().setUiText("Ganhou 1 de Food");
            p.setFood(pFood + 1); 
        }
        if(option == 3){
            getGame().setUiText("Ganhou 2 de Hp");
            p.setHp(pHealth + 2);
        }
        getGame().checkCardEnd();
        return new AwaitCardSelection(getGame());
    }
}
