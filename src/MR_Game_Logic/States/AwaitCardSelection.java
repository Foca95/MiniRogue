/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

import MR_Game_Logic.*;
import MR_Game_Logic.Spell.Fireball;
import MR_Game_Logic.Spell.Healing;
import MR_Game_Logic.Spell.Ice;
import MR_Game_Logic.Spell.Poison;

/**
 *
 * @author pedri
 */
public class AwaitCardSelection extends StateAdapter{

    public AwaitCardSelection(GameData game) {
        super(game);
    }
    
    @Override
    public IStates resolveTreasureCard(int roll, int roll2) {
        Player p = getGame().getPlayer();
        if (getGame().isFight()) {
            getGame().setUiText("Ganhou 2 de Gold");
            p.setGold(p.getGold() + 2);
        } else {
            getGame().setUiText("Ganhou 1 de Gold");
            p.setGold(p.getGold() + 1);
        }
        if (roll2 >= 5) {
            switch (roll2) {
                case 1:
                    p.setArmor(p.getArmor() + 1);
                    getGame().setUiText("Ganhou 1 de Armor");
                    break;
                case 2:
                    p.setXp(p.getXp() + 2);
                    getGame().setUiText("Ganhou 2 de Xp");
                    break;
                case 3:
                    if (p.spells.size() == 2) {
                        getGame().removesSpell();
                    }
                    getGame().setUiText("Ganhou 1 Spell FireBall");
                    p.spells.add(new Fireball());
                    break;
                case 4:
                    if (p.spells.size() == 2) {
                        getGame().removesSpell();
                    }
                    getGame().setUiText("Ganhou 1 Spell Ice");
                    p.spells.add(new Ice());
                    break;
                case 5:
                    if (p.spells.size() == 2) {
                        getGame().removesSpell();
                    }
                    getGame().setUiText("Ganhou 1 Spell Poison");
                    p.spells.add(new Poison());
                    break;
                case 6:
                    if (p.spells.size() == 2) {
                        getGame().removesSpell();
                    }
                    getGame().setUiText("Ganhou 1 Spell Healing");
                    p.spells.add(new Healing());
                    break;
            }
        }
        getGame().setArenaLevel(getGame().getArenaLevel() + 1);
        return this;
    }

    @Override
    public IStates resolveTrapCard(int firstRoll, int SecondRoll) {
        Player p = getGame().getPlayer();
        if (!getGame().skillCheck(SecondRoll)) {
            switch (firstRoll) {
                case 1:
                    p.setFood(p.getFood() - 1);
                    getGame().setUiText("Perdeu 1 de Food");
                    break;
                case 2:
                    p.setGold(p.getGold() - 1);
                    getGame().setUiText("Perdeu 1 de Gold");
                    break;
                case 3:
                    p.setArmor(p.getArmor() - 1);
                    getGame().setUiText("Perdeu 1 de Armor");
                    break;
                case 4:
                    p.setHp(p.getHp() - 1);
                    getGame().setUiText("Perdeu 1 de Hp");
                    break;
                case 5:
                    p.setXp(p.getXp() - 1);
                    getGame().setUiText("Perdeu 1 de Xp");
                    break;
                case 6:
                    p.setHp(p.getHp() - 2);
                    if (getGame().getLevel() == 5) {
                        getGame().setUiText("Perdeu 2 de Hp");
                        break;
                    }
                    getGame().setArenaBellow(getGame().getArena());
                    getGame().setUiText("Perdeu 2 de HP e foi movido para a arena " + getGame().getArena());
                    break;

            }
        }
        getGame().setArenaLevel(getGame().getArenaLevel() + 1);
        return this;
    }

    @Override
    public IStates resolveEventCard(int option) {
        Player p = getGame().getPlayer();
        switch (option) {
            case 1:
                p.setFood(p.getFood() + 1);
                getGame().setUiText("Ganhou 1 de Food");
                break;
            case 2:
                p.setHp(p.getHp() + 2);
                getGame().setUiText("Ganhou 2 de Hp");
                break;
            case 3:
                p.setGold(p.getGold() + 2);
                getGame().setUiText("Ganhou 2 de Gold");
                break;
            case 4:
                p.setXp(p.getXp() + 2);
                getGame().setUiText("Ganhou 2 de Xp");
                getGame().checkLevelUp();
                break;
            case 5:
                p.setArmor(p.getArmor() + 1);
                getGame().setUiText("Ganhou 2 de Armor");
                break;
            case 6:
                //Fazer combate
                //HP = dice + arena
                //DMG = leveldungeon * 2
                //REWARD = 2xp
                getGame().setUiText("Fase de Combate");
                break;
        }
        getGame().setArenaLevel(getGame().getArenaLevel() + 1);
        return this;
    }
    
    @Override
    public IStates resolveCard(String card){
        if(card == "Resting")
            return new AwaitRest(getGame());
        if(card == "Merchant")
            return new AwaitTrading(getGame());
        if(card == "Monster")
            return this;
        if(card == "Boss Monster")
            return this;
        return this;
    }
}
