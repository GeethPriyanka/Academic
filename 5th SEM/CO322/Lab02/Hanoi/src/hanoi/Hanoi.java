/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hanoi;

/**
 *
 * @author Geeth
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        try{
        
            int numberOfDisks =Integer.parseInt(args[0]);
            if(numberOfDisks==0){
                System.out.println("\nInvalid usage\nUsage :[Number of disk<Positive int>] [From<String>] [to<String>] [via<String>]");
            }
            String src = args[1];
            String dest = args[2];
            String station = args[3];
            
            //making stacks for each tower
            Stack from = new Stack(numberOfDisks);      
            Stack to = new Stack(numberOfDisks);
            Stack via = new Stack(numberOfDisks);

            Process(numberOfDisks,from,to,via,src,dest,station);

        }catch(NumberFormatException | ArrayIndexOutOfBoundsException |NegativeArraySizeException e1){
            System.out.println("\nInvalid usage\nUsage :[Number of disk<Positive int>] [From<String>] [to<String>] [via<String>]");
        }
        
    }

    private static void Process(int numberOfDisks, Stack from, Stack to, Stack via,String src1,String dest1,String station1) {
        
        String src = src1;
        String dest = dest1;
        String station = station1;
        String tmp;
        int numberOfMoves = (int)(Math.pow(2, numberOfDisks)-1);        //calculating the total number of moves 
        
        //System.out.println(numberOfMoves);
        
        for(int i=0;i<numberOfDisks;i++){
            from.push(numberOfDisks-i);                 // filling Disks from 4(bottom) to 1(top)
            //System.out.println(numberOfDisks-i);
        }
        
        if(numberOfDisks%2==0){         //If the number of disk is even, 'dest' tower and 'station' tower should be interchanged
            tmp = station;
            station = dest;
            dest = tmp;
        }
        for(int i=0;i<numberOfMoves;i++){
            if(i%3==0){
                moveDisk(from,to,src,dest);         //move disk from source to destination
            }else if(i%3==1){
                moveDisk(from,via,src,station);     //move disk from source to station
            }else if(i%3==2){
                moveDisk(via,to,station,dest);      //move disk from station to destination
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void moveDisk(Stack from, Stack to, String src, String dest) {
        
        int towerSrc = from.pop();       //take the top disk number of source tower
        int towerDest = to.pop();         //take the top disk number of destination tower
         
        if(towerSrc==Integer.MIN_VALUE){         //if the source tower is empty
            from.push(towerDest);                 
            System.out.println("Move disk "+towerDest+" from "+dest+" to "+src);
        }else if(towerDest==Integer.MIN_VALUE){   //if the destination tower is empty
            to.push(towerSrc);                      
            System.out.println("Move disk "+towerSrc+" from "+src+" to "+dest);
        }else if(towerSrc>towerDest){      //if the disk number in source tower is greater than the disk number in destination tower
            from.push(towerSrc);            
            from.push(towerDest);
            System.out.println("Move disk "+towerDest+" from "+dest+" to "+src);
        }else{                             //if the number of disks in destination tower is greater than the number of disks in source tower
            to.push(towerDest);
            to.push(towerSrc);
            System.out.println("Move disk "+towerSrc+" from "+src+" to "+dest);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
