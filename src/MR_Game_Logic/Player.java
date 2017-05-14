/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedri
 */
public class Player implements Constants{
    public int hp;
    public int gold;
    public int food;
    public int armor;
    public List<Spells> spells;
    public int rank;
    public int xp;
    public String name;
    public int dmg;
    
    public Player(){
        
    }
    
    public String playerToString(){
       
        String stats ="";
        
        stats = "NAME " + name + "|HP " + hp + "|GOLD " + gold + "|FOOD " + food + "|ARMOR " + armor + "|RANK " + rank + "|XP " 
                + xp;
        return stats;
    }
    public Player(int difficulty, String name){
        switch(difficulty){
            case NORMAL:
                this.name = name;
                this.hp = 5;
                this.armor = 0;
                this.gold = 3;
                this.food = 6;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                break;
            case HARD:
                this.name = name;
                this.hp = 4;
                this.armor = 0;
                this.gold = 2;
                this.food = 5;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                break;
            case IMPOSSIBLE:
                this.name = name;
                this.hp = 3;
                this.armor = 0;
                this.gold = 1;
                this.food = 3;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                break;
            default: //CASUAL
                this.name = name;
                this.hp = 5;
                this.armor = 1;
                this.gold = 5;
                this.food = 6;
                this.rank = 1;
                this.xp = 0;
                this.spells = new ArrayList<>();
                break;
        }
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public List<Spells> getSpells() {
        return spells;
    }

    public void setSpells(List<Spells> spells) {
        this.spells = spells;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    
    
}
