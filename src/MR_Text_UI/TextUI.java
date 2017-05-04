package MR_Text_UI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedri
 */
import MR_Game_Logic.MR_Game;
import MR_Game_Logic.States.AwaitBeginning;
import MR_Game_Logic.States.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TextUI 
{
    private MR_Game game;
    private boolean quit = false;

    public TextUI(MR_Game game) 
    {
        this.game = game;
    }

    public void uiAwaitBeginning() 
    {
        Scanner sc = new Scanner(System.in);
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String option;
        char c;
        int num;
        String name;
        
        while (true) 
        {    
            do
            {               
                System.out.println();
                System.out.println("0 - Quit");
                System.out.println("1 - Set difficulty");
                System.out.println("2 - Set the name of the player");
                System.out.println("3 - Set the starting area");
                System.out.println("4 - Start");
                System.out.print("\nYour option : ");
                option = sc.next();
                
                if(option.length() >= 1)
                    c = option.charAt(0);
                else
                    c = ' ';
                
            } while(c < '0' || c > '4');
            
            switch(c)
            {    
                case '0':
                    quit = true;
                    return;

                case '1':
                    char o;
                    do
                    {       
                        System.out.println("Set difficulty: ");
                        System.out.println("1 - Casual ");
                        System.out.println("2 - Normal ");
                        System.out.println("3 - Hard ");
                        System.out.println("4 - Impossible ");
                        System.out.print("\nYour option : ");
                        num = sc.nextInt();

                    } while(num < 1 || num > 4);
                    
                    switch(num){
                        case 1:
                            System.out.print("Difficulty Casual");
                            game.setDifficulty(num);
                            break;
                        case 2:
                            System.out.print("Difficulty Normal");
                            game.setDifficulty(num);
                            break;
                        case 3:
                            System.out.print("Difficulty Hard");
                            game.setDifficulty(num);
                            break;
                        case 4:
                            System.out.print("Difficulty Impossible");
                            game.setDifficulty(num);
                            break;
                            
                    }
                    
                    return;
                
                case '2':
                    System.out.print("Enter the name of the player : ");
                    
                    try
                    {    
                        System.out.print("\nYour name : ");
                        name = bin.readLine();
                        
                        game.getPlayer().setName(name);
                        
                        System.out.println("\nName: " + name);
                        
                    }catch (IOException | NumberFormatException ex) {System.out.println(ex);}
                                        
                    return;
                
                case '3':
                    do
                    {       
                        System.out.println("Set starting area between 1 and 14: ");  
                        System.out.print("\nYour option : ");
                        num = sc.nextInt();                      
                    } while(num < 1 || num > 14);
                    
                    game.setStartingArea(num);
                    System.out.println("Starting area: " + num);
                    return;
                    
                case '4': 
                    System.out.println("Game started");
                    game.startGame();
                    return;
                    
                default:
                    return;
                    
            } //switch
            
        } //while
    
    } //uiWaitBeginning    

    public void uiAWaitCardSelection()
    {
        Scanner sc = new Scanner(System.in);
        int flipCard;
        game.getDice().roll();
        String card;
        card = game.getDungeon().currentCard(game.getArena(), game.getLevel(), game.getArenaLevel());
        int roll = game.getDice().getRoll();
        System.out.println(game.getUiText());
        System.out.println("\nFlip next card ?");
        System.out.println("\n1 - Yes");
        System.out.println("\n2 - No");
        System.out.print("\nYour option : ");
        flipCard = sc.nextInt();
        if(flipCard == 2){
            quit=true;
        }
        else{
        System.out.println();
        System.out.println("\n=== Card === \n");
        System.out.println(card);
        System.out.println("\n============ \n");
        if(card == "Trap"){
            System.out.println("First Roll : " + roll);
            game.getDice().roll();
            int skill = game.getDice().getRoll();
            System.out.println("Skill Check Roll : " + skill);
            
            System.out.println("1 - Mold Miasma (-1 Food)");
            System.out.println("2 - Tripwire (-1 Gold) ");
            System.out.println("3 - Acid Mist (-1 Armor) ");
            System.out.println("4 - Spring Blades (-1 Hp) ");
            System.out.println("5 - Moving Walls (-1 Xp) ");
            System.out.println("6 - Pit ");
            
            game.resolveTrapCard(roll, skill);
        }
        if(card == "Event"){
            System.out.println("Roll : " + roll);
            System.out.println("1 - Found Ration (+1 Food)");
            System.out.println("2 - Found Health Potion (+2 Health) ");
            System.out.println("3 - Found Loot (+2 Gold) ");
            System.out.println("4 - Found Whetstone (+2Xp) ");
            System.out.println("5 - Found Armor (+1 Armor) ");
            System.out.println("6 - Monster ");
            game.resolveEventCard(roll);
        }
        if(card == "Treasure"){
                System.out.println("Roll : " + roll);
                game.getDice().roll();
                int roll2 = game.getDice().getRoll();
                if (roll >= 5) {
                    System.out.println("Roll maior que 5, recebe um item");
                    System.out.println("Second Roll : " + roll2);
                    System.out.println("1 - Armor Piece (+1 Armor)");
                    System.out.println("2 - Better Weapon (+2 Xp) ");
                    System.out.println("3 - Firebal Spell ");
                    System.out.println("4 - Ice Spell ");
                    System.out.println("5 - Poison Spell ");
                    System.out.println("6 - Healing Spell ");
                    game.resolveTreasureCard(roll, roll2);
                }else
                    game.resolveTreasureCard(roll, roll2);
            }
        game.resolveCard(card);
        }
    }
    
    public void uiAWaitRest() 
    {       
        int num;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Select Option: ");
            System.out.println("1 - Reinforce Your Weapon +1Xp ");
            System.out.println("2 - Search For Ration +1Food ");
            System.out.println("3 - Heal +2Hp ");
            System.out.print("\nYour option : ");
            num = sc.nextInt();
        } while (num < 1 || num > 3);
        game.setRestOption(num);
    }
    
    public void uiAWaitTrading() 
    {        
         int num;
         int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Select Option: ");
            System.out.println("1 - Buy ");
            System.out.println("2 - Sell ");
            System.out.println("3 - Skip ");
            System.out.print("\nYour option : ");
            num = sc.nextInt();

        } while (num < 1 || num > 3);

        switch (num) {
            case 1:
                System.out.println("|=========Buy Menu========|");
                System.out.println("1 - Ration: +1 Food / -1 Gold");
                System.out.println("2 - Health Potion: +1 Hp / -1 Gold");
                System.out.println("3 - Big Health Potion: +4 Hp / -3 Gold");
                System.out.println("4 - Armor Piece: +1 Armor / -6 Gold");
                System.out.println("5 - Any 1 Spell / -8 Gold");
                System.out.print("\nYour option : ");
                option = sc.nextInt();
                game.buyOption(option);
                break;
            case 2:
                System.out.println("|=========Sell Menu========|");
                System.out.println("1 - 1 Armor Piece: -1 Armor / +3 Gold");
                System.out.println("2 - Any 1 Spell / +4 Gold");
                System.out.print("\nYour option : ");
                option = sc.nextInt();
                game.sellOption(option);
                break;
            case 3:
                System.out.println("|=========Card Skipped========|");
                game.skip();
                break;
        }
    }
    
    public void run() 
    {
        while (!quit) 
        {    
            IStates state = game.getState();
           
            if (state instanceof AwaitBeginning) 
            {
                uiAwaitBeginning();
            } 
            else if (state instanceof AwaitCardSelection) 
            {
                uiAWaitCardSelection();
            } 
            else if (state instanceof AwaitRest) 
            {
                uiAWaitRest();
            }
            else if (state instanceof AwaitTrading) 
            {
                uiAWaitTrading();
            }           
        }
    }
}

