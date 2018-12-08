
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class buttonListener implements ActionListener{
     
    private final int buttonNo;
    private final JButton button;
    private static int count = 0;
    private String sign;
    private static int [] v2 = new int[9];
    private static int [] v1 = new int[9];
    private static int [] end = new int[9];
    private int counter;

    
         public buttonListener(int buttonNo, JButton button){
          this.buttonNo = buttonNo;
          this.button = button;
          button.setFont(new Font("Arial",Font.PLAIN,40));
          for(int i=0; i<9; i++){
              v2[i] = 0;
          }
          for(int i=0; i<9; i++){
              v1[i] = 0;
          }
          for(int i=0; i<9; i++){
              end[i] = 1;
          }
      }
      
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        count++;
        
        if(count%2==0){
            sign="2";
        }else{
            sign="1";
        }        
        
       if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 1)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
          
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 2)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
          
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 3)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
          
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 4)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }

       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 5)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
           
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 6)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
           
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 7)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
           
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 8)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
           
       }else if(((v2[buttonNo-1]==0)&&(v1[buttonNo-1]==0))&&(buttonNo == 9)){
           button.setText(sign);
           if(count%2==0){
                v2[buttonNo-1] = 1;
           }else{
               v1[buttonNo-1] = 1;
           }
           
       }else{
           count--;
       }
       
       checkForWin(v2,v1);
       
    }
    
    private void checkForWin(int [] v2, int [] v1){
        
          
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
      
        
        if(arrayCompare(v1)==1){
            tictactoe.result(1);
           // System.out.println("141 was called");
        }else if(arrayCompare(v2)==1){
            tictactoe.result(2);  
           // System.out.println("144 was called");
        }else if((arrayCompare(v1)==2)||(arrayCompare(v2)==2)){
            tictactoe.result(3);
        }
    
    }
    
    private int arrayCompare(int [] a ){
        counter = 0;
        for(int x=0;x<9;x++){
            if(a[x]==1){
                counter++;
            }
        }
        
        if((a[0] ==1)&&(a[1] ==1)&&(a[2] ==1)){
            return 1;
        }else if((a[3] ==1)&&(a[4] ==1)&&(a[5] ==1)){
            return 1;
        }else if((a[6] ==1)&&(a[7] ==1)&&(a[8] ==1)){
            return 1;
        }else if((a[0] ==1)&&(a[3] ==1)&&(a[6] ==1)){
            return 1;
        }else if((a[1] ==1)&&(a[4] ==1)&&(a[7] ==1)){
            return 1;
        }else if((a[2] ==1)&&(a[5] ==1)&&(a[8] ==1)){
            return 1;
        }else if((a[2] ==1)&&(a[4] ==1)&&(a[6] ==1)){
            return 1;
        }else if((a[0] ==1)&&(a[4] ==1)&&(a[8] ==1)){
            return 1;
        }else if(counter==5){
            return 2;
        }else{
            return 0;
        }
        
    }
    
 }

  
