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
public class StateAdapter implements IStates{

      private GameData game;

    public StateAdapter(GameData g)
    {
        this.game =g;
    }

    public GameData getGame() 
    {
        return game;
    }
    
    public void setGame(GameData game) 
    {
        this.game = game;
    }
    
    @Override
    public IStates updatePlayer() {
        return this;
    }

    @Override
    public IStates setName(String name) {
        return this;
    }

    @Override
    public IStates setDifficulty(int difficulty) {
        return this;
    }

    @Override
    public IStates setStartingArea(int area) {
        return this;
    }

    @Override
    public IStates startGame() {
        return this;
    }

    @Override
    public IStates setRestOption(int option) {
        return this;
    }

    @Override
    public IStates sellOption(int option) {
        return this;
    }

    @Override
    public IStates buyOption(int option) {
        return this;
    }

    @Override
    public IStates endGame() {
        return this;
    }

    @Override
    public IStates tradeOption(int option) {
        return this;
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
