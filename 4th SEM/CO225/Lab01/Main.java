/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */

import java.math.*; 
import java.util.Random; // for random 
import java.io.*; // for file IO

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        BufferedReader descriptor = null; 
	String line = null; 
	String [] names = new String[61]; // 61 names 
	try { 
	    descriptor = new BufferedReader(
            new FileReader("co225-classlist.txt"));

	    for(int i=0; i < names.length; i++) // assume file has 61 lines 
            names[i] = descriptor.readLine(); 

	    descriptor.close(); 

	} catch(IOException e) { 
	    // IOException is more generic (FileNotFound is a type of a 
	    // IOException, so catching only that is sufficient 
	    System.out.println("Bad things happen, what do you do!" + e);
	    return; 
	}
        int MAX = 45;
        Random randomGen = new Random(); 
		Student studentlist[] =new Student[61];
        for(int i=0;i<names.length;i++){
        
            studentlist[i] = new Student(names[i],randomGen.nextInt(MAX));
        
        }
         
        for(int i=0;i<names.length;i++){
        
            if(studentlist[i].getTheAttendance()<80){
            	System.out.println(studentlist[i].getName()+ "---"+ studentlist[i].getTheAttendance());
            }
        	
        
        }

        System.out.println("Average"+Student.displayAverage(studentlist));
        
    }
        
   
    
    
}
