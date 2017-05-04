/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
/**
 *
 * @author pedri
 */
public class AwaitTrading extends StateAdapter implements Constants{
    
    public AwaitTrading(GameData g) {
        super(g);
    }
    
    @Override
    public IStates tradeOption(int option){
        if(option == BUY){
            buyOption(option);
            return this;
        }
        if(option == SELL){
            sellOption(option);
            return this;
        }if(option == SKIP){
            return new AwaitCardSelection(getGame());
        }
        return this;
    }
    
    @Override
    public IStates sellOption(int option){
        Player p = getGame().getPlayer();
        int pArmor = p.getArmor();
        int pGold = p.getGold();
        String pSpell[] = p.getSpells();
        if(option == 1){
            if(pArmor <= 0){
                return this;
            }
            p.setGold(pGold + 3);
            p.setArmor(pArmor - 1);
        }
        if(option == 2){
            if(pSpell.length == 0){
                return this;
            }
            //Falta venda de spell especifico
        }
        return this;
    }
    
    @Override
    public IStates buyOption(int option){
        Player p = getGame().getPlayer();
        int pFood = p.getFood();
        int pHealth = p.getHp();
        int pArmor = p.getArmor();
        int pGold = p.getGold();
        String pSpell[] = p.getSpells();
        switch(option){
            case 1:
                if(pGold < 1){
                    break;
                }
                p.setGold(pGold - 1);
                p.setFood(pFood + 1);
                break;
            case 2:
                if(pGold < 1){
                    break;
                }
                p.setGold(pGold - 1);
                p.setHp(pHealth + 1);
                break;
            case 3:
                if(pGold < 3){
                    break;
                }
                p.setGold(pGold - 3);
                p.setHp(pHealth + 4);
                break;
            case 4:
                if(pGold < 6){
                    break;
                }
                p.setGold(pGold - 6);
                p.setArmor(pArmor + 1);
                break;
            case 5:
                if(pGold < 8){
                    break;
                }
                p.setGold(pGold - 8);
                //Falta comprar spell especifico
                break;
        }
        return this;
    }
    
}
