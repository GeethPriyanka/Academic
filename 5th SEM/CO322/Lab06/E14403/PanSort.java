/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PanCake;

/**
 *
 * @author Geeth
 * E/14/403
 */
public class PanSort {

    public static void main(String[] args) {
        
        int size;
        try{
            size = Integer.parseInt(args[0]);       //getting the size of the pancake stack
            PanStack pan = new PanStack(size);      //Creating a pancake stack and sorting
        
        }catch(ArrayIndexOutOfBoundsException e){       //check for command line arguments
            System.out.println("Usage :java PanSort [number of cakes needed]");
            return;
        }catch(NullPointerException e1){        //it is assumed that stack should contain atleast 2 cakes
            System.out.println("Number of cakes needed should be greater than 1");
            return;
        }
        
        
        
    }
    
}
