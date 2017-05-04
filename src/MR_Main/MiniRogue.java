/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Main;

import MR_Game_Logic.MR_Game;
import MR_Text_UI.TextUI;

/**
 *
 * @author pedri
 */
public class MiniRogue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        TextUI textUI = new TextUI(new MR_Game());
        textUI.run();
    
    }
    
    
}
