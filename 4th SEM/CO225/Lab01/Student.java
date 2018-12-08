/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
public class Student {
    private final String name;
    private final int attendance;
    private static double total = 0;
    
    public Student(String name, int attendance){
        this.name = name;
        this.attendance = attendance;
    }
    
        
        public double getTheAttendance(){
            return (attendance*100)/45;
        }
        
        public static double displayAverage(Student [] stlist){
            for(int i=0;i<61;i++){
        
            	total=total+stlist[i].getTheAttendance();
        
        	}
        	return total/61;
        }

        public String getName() {
            return name;
        }
        
    }

