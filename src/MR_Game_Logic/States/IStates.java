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
    public IStates resolveCard(String card);
    public IStates resolveTreasureCard(int roll, int roll2);
    public IStates resolveTrapCard(int firstRoll, int SecondRoll);
    public IStates resolveEventCard(int option);
    //AwaitRest
    public IStates setRestOption(int option);
    //AwaitTrading
    public IStates skip();
    public IStates spellSelected(int option);
    public IStates sellOption(int option);
    public IStates buyOption(int option);
    
    public IStates endGame();
}
