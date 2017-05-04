/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import MR_Game_Logic.Cards.Boss_Monster;
import MR_Game_Logic.Cards.Event;
import MR_Game_Logic.Cards.Merchant;
import MR_Game_Logic.Cards.Monster;
import MR_Game_Logic.Cards.Resting;
import MR_Game_Logic.Cards.Trap;
import MR_Game_Logic.Cards.Treasure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pedri
 */
public class Card implements Serializable{
    public String name;
    public List<Card> cards;
    public List<Card> cardsBoss;
    
    public Card(){
        cards = new ArrayList<>();
        cardsBoss = new ArrayList<>();
        fillDeck();
    }
    
    public String getName(){
        return name;
    }
    
    public List<Card> getCards(){
        shuffleCards();
        return cards;
    }
    
    public List<Card> getCardsBoss(int level){
        shuffleCardsBoss(level);
        return cardsBoss;
    }
    
    public void fillDeck(){
        cards.add(new Event());
        cards.add(new Merchant());
        cards.add(new Monster());
        cards.add(new Resting());
        cards.add(new Trap());
        cards.add(new Treasure());
        cardsBoss.add(new Event());
        cardsBoss.add(new Merchant());
        cardsBoss.add(new Monster());
        cardsBoss.add(new Resting());
        cardsBoss.add(new Trap());
        cardsBoss.add(new Treasure());
    }
    
    public void shuffleCards(){
       long seed = System.nanoTime();
       Collections.shuffle(cards, new Random(seed));
    }
    
    public void shuffleCardsBoss(int level){
       long seed = System.nanoTime();
       Collections.shuffle(cardsBoss, new Random(seed));
       if(cardsBoss.contains(x)){
           cardsBoss.remove(x);
       }
       cardsBoss.add(new Boss_Monster(level));
    }
}
