/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Author: KPGP Wimalasiri
E No: E/14/403
Subject code : CO322 (Data Structures And Algorithms) 
*/
public class Block {
    
    private final int x;
    private final int y;
    private final int counter;  // counter keeps the order
    
    public Block(int x, int y, int n){
        this.x = x;             // x coordinate
        this.y = y;             // y coordinate
        this.counter = n;
    }
    int getXCoordinates(){
    return x;
    }
    int getYCoordinates(){
    return y;
    }
}
