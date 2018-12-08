/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PanCake;

import java.util.Random;

/**
 *
 * @author Geeth
 * E/14/403
 */
class PanCake {
    
    PanCake next ;
    PanCake previous;
    int diameter;
    
    public PanCake(){       //creating pancake node with diameter, next nodes link and previous nodes link
    
        Random rand = new Random();
        diameter = rand.nextInt(25)+1;          //randomly generate diameter 1-25
        PanCake next = this.next;
        PanCake previous = this.previous;
        
    }
    
    void nextPrevFlip(){        //interchanging next and previous addresses
    
        PanCake tmp;
        tmp = this.next;
        this.next = this.previous;
        this.previous = tmp;
        
    }
    
}
