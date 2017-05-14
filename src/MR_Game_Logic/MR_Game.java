package MR_Game_Logic;

import MR_Game_Logic.States.*;

/**
 *
 * @author pedri
 */

public class MR_Game
{    
    private GameData gameData;
    private IStates state; 
    
    public MR_Game()
    {
        gameData = new GameData();
        setState(new AwaitBeginning(gameData));
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData)
    {
        this.gameData = gameData;
    }

    public IStates getState()
    {
        return state;
    }
    
    private void setState(IStates state)
    {
        this.state = state;
    }        
    
     // Methods retrieve data from the game
    
    public String dungeonToString()
    {
        return gameData.dungeoToString();
    }                    

    public int getLevel()
    {
        return gameData.getLevel();
    }
    
    public int getArena()
    {
        return gameData.getArena();
    }
    
    public int getArenaLevel()
    {
        return gameData.getArenaLevel();
    }
    
    public Player getPlayer()
    {
        return gameData.getPlayer();
    }
    
    public int getHP()
    {
        return gameData.getPlayer().getHp();
    }
 
    public Dungeon getDungeon() {
        return gameData.getDungeon();
    }

    public int getNumDices() {
        return gameData.getNumDices();
    }

    public int getDifficulty() {
        return gameData.getDifficulty();
    }

    public Dice getDice() {
        return gameData.getDice();
    }
    
    public String getUiText(){
        return gameData.getUiText();
    }
    
    public String getPlayerStats(){
       return gameData.getPlayer().playerToString();
    }
     public String getDungeonStats(){
       return gameData.dungeonToString();
     }
    
    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    

    public void setName(String name) 
    {
        setState(getState().setName(name));
    }
    
     public void setDifficulty(int difficulty) 
    {
        setState(getState().setDifficulty(difficulty));
    }
    
    public void setStartingArea(int area){
        setState(getState().setStartingArea(area));
    }
    public void startGame(){
        setState(getState().startGame());
    }

    public void resolveTreasureCard(int roll, int roll2){
        setState(getState().resolveTreasureCard(roll, roll2));
    }
    
    public void resolveTrapCard(int firstRoll, int SecondRoll){
        setState(getState().resolveTrapCard(firstRoll, SecondRoll));
    }
    
    public void resolveEventCard(int option){
        setState(getState().resolveEventCard(option));
    }
    
    public void setRestOption(int option){
        setState(getState().setRestOption(option));
    }
   
    public void skip(){
        setState(getState().skip());
    }
    
    public void sellOption(int option){
        setState(getState().sellOption(option));
    }
    
    public void buyOption(int option){
        setState(getState().buyOption(option));
    }
    
    public void endGame(){
        setState(getState().endGame());
    }

    public void nextArenaLevel() {
          setState(getState().skip());
    }
    
    public void resolveCard(String card){
        setState(getState().resolveCard(card));
    }
    
}
