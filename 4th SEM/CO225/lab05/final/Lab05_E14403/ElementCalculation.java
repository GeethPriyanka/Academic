/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth    E/14/403
 */
/*  Element-wise calculations of matrix multiplying are done here   */
class ElementCalculation extends Thread{
    private int start;
    private int end;
   
    ElementCalculation(int start,int end) {
        
        this.start = start;
        this.end = end;
           
    }
  
    @Override
    public void run(){
        /*  In here starting point and the ending point of the for loop is specified for each thread    */
        for(int row=start;row<end;row++){
            for(int col=0;col<MatrixMultiplication.B[0].length;col++){
                for(int j=0;j<MatrixMultiplication.B.length;j++){
                    MatrixMultiplication.C[row][col]+=MatrixMultiplication.A[row][j]*MatrixMultiplication.B[j][col]; 
                }
            }
        }

    }
    
}
