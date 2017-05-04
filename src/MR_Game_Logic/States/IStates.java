/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic.States;

/**
 *
 * @author pedri
 */
public interface IStates {
    //All Phases
    public IStates updatePlayer();
    //AwaitBeginning
    public IStates setName(String name);
    public IStates setDifficulty(int difficulty);
    public IStates setStartingArea(int area);
    public IStates startGame();
    //AwaitCardSelection
    public IStates resolveTreasureCard();
    public IStates resolveTrapCard();
    public IStates resolveEventCard();
    //AwaitRest
    public IStates setRestOption(int option);
    //AwaitTrading
    public IStates tradeOption(int option);
    public IStates sellOption(int option);
    public IStates buyOption(int option);
    
    public IStates endGame();
}
