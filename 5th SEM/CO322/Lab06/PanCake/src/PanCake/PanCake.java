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
 */
class PanCake {
    
    PanCake next ;
    PanCake previous;
    int diameter;
    
    public PanCake(){
    
        Random rand = new Random();
        diameter = rand.nextInt(25)+1;
        PanCake next = this.next;
        PanCake previous = this.previous;
        
    }
    
    void nextPrevFlip(){
    
        PanCake tmp;
        tmp = this.next;
        this.next = this.previous;
        this.previous = tmp;
        
    }
    
}
