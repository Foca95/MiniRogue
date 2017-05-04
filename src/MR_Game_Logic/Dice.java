/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MR_Game_Logic;

import java.io.Serializable;

/**
 *
 * @author pedri
 */
public class Dice implements Serializable{
    Integer roll;

    public Dice(){
        roll = 0;
    }
    
    public void roll(){
        roll = (int)(Math.random() * 6 + 1);
    }

    public Integer getRoll(){
        return roll;
    }
}