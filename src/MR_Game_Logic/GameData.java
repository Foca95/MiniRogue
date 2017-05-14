/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.Cards.*;
import static MR_Game_Logic.Constants.CASUAL;
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
    private boolean fight;
    private int arenaLevel;
    private String uiText;
    private String currentCard;
    private int column;
    
    
    public GameData(){
        dice = new Dice();
        dungeon = new Dungeon();
        player = new Player();
        arena = 1;
        difficulty = CASUAL;
    }
    
    public boolean initialize(){
        level = 1;
        numDices = 1;
        arena = 1;
        arenaLevel = 0;
        fight = false;
        column = 1;
        dungeon.createDungeon();
        player = new Player(difficulty, player.getName());
        currentCard = getDungeon().currentCard(arena, level, arenaLevel);
        uiText = "";
        return true;
    }
    
    public boolean initializeOnArea(int area){
        arena = area;
        arenaLevel = 0;
        setLevelByArena(area);
        numDices = 1;
        fight = false;
        column = 1;
        dungeon.createDungeon();
        currentCard = getDungeon().currentCard(arena, level, arenaLevel);
        player = new Player(difficulty, player.getName());
        uiText = "";
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
        if(player.getRank()== 4){
            player.setHp(player.getHp() + 1);
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
    
    public boolean skillCheck(int dice){
        if(dice <= player.getRank()){
            return true;
        }
        return false;
    }
    
    public void checkCardEnd() {
        if (column == 2) {
            if(arenaLevel == 1)
                setArenaLevel(getArenaLevel() + 2);
            else
                setArenaLevel(getArenaLevel() + 1);
            setColumn(getColumn() + 1);
            return;
        }
        if (column == 4 && arena == 4 ||column == 4 && arena == 7 ||column == 4 && arena == 10 ||column == 4 && arena == 14) {
            //falta boss-monster
        }
        if (column == 4){
            if (player.getFood() == 0) {
                player.setHp(player.getHp() - 2);
            } else {
                player.setFood(player.getFood() - 1);
            }
            setArena(getArena() + 1);
            setArenaLevel(0);
            setColumn(1);
            return;
        }
        setArenaLevel(getArenaLevel() + 1);
        setColumn(getColumn() + 1);
    }
    
    public void removesSpell(){
        int rand = (int)(Math.random() * 2 + 1);
        List<Spells> spells = player.getSpells();
        if(rand == 1){
            spells.remove(0);
        }else 
            spells.remove(1);
        player.setSpells(spells);
    }
    
    public void setArenaBellow(int area){
        switch(area){
            case 1:
                setArena(3);
                setLevel(2);
                break;
            case 2:
                setArena(4);
                setLevel(2);
                break;
            case 3:
                setArena(5);
                setLevel(3);
                break;
            case 4:
                setLevel(3);
                setArena(6);
                break;
            case 5:
                setLevel(4);
                setArena(8);
                break;
            case 6:
                setArena(9);
                setLevel(4);
                break;
            case 7:
                setArena(10);
                setLevel(4);
                break;
            case 8:
                setArena(11);
                setLevel(5);
                break;
            case 9:
                setArena(12);
                setLevel(5);
                break;
            case 10:
                setArena(13);
                setLevel(5);
                break;
        }
    }
    
    public void setLevelByArena(int area){
        if(area >= 1 && area <= 2){
            setLevel(1);
        }
        if(area >= 3 && area <= 4){
            setLevel(2);
        }
        if(area >= 5 && area <= 7){
            setLevel(3);
        }
        if(area >= 8 && area <= 10){
            setLevel(4);
        }
        if(area >= 11 && area <= 14){
            setLevel(5);
        }
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

    public int getArenaLevel() {
        return arenaLevel;
    }

    public void setArenaLevel(int arenaLevel) {
        this.arenaLevel = arenaLevel;
    }
    
    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public String getUiText() {
        return uiText;
    }

    public void setUiText(String uiText) {
        this.uiText = uiText;
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(String currentCard) {
        this.currentCard = currentCard;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    

}
