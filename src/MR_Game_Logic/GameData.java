/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.Cards.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pedri
 */
public class GameData {
    private Player player;
    private Dungeon dungeon;
    private int level;
    private int arena;
    private int numDices;
    private int difficulty;
    private Dice dice;
    
    public GameData(){
        dice = new Dice();
        dungeon.createDungeon();
    }
    
    public boolean initialize(){
        arena = 1;
        level = 1;
        numDices = 1;
        player = new Player(difficulty, player.getName());
        return true;
    }
    
    public boolean initializeOnArea(int area){
        arena = area;
        level = 1;
        numDices = 1;
        player = new Player(difficulty, player.getName());
        return true;
    }
    
    public boolean checkLevelUp(){
        if(player.getXp() >= 6 && player.getRank() == 1){
            player.setXp(player.getXp() - 6);
            player.setRank(2);
            numDices = 2;
            return true;
        }
        if(player.getXp() >= 12 && player.getRank() == 2){
            player.setXp(player.getXp() - 12);
            player.setRank(3);
            numDices = 3;
            return true;
        }
        if(player.getXp() >= 18 && player.getRank() == 3){
            player.setXp(player.getXp() - 18);
            player.setRank(4);
            numDices = 4;
            return true;
        }
        return false;
    }
    
    public boolean isDead(){
        if(player.getHp() <= 0){
            return true;
        }
        return false;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArena() {
        return arena;
    }

    public void setArena(int arena) {
        this.arena = arena;
    }

    public int getNumDices() {
        return numDices;
    }

    public void setNumDices(int numDices) {
        this.numDices = numDices;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    String dungeoToString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
