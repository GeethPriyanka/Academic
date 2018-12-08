/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class MultiplyMatrixInt extends Thread{

    private int [][]intA;
    private int [][]intB;
    
    private static int ansInt =0;

    private static int start;
    private static int end;
   
    
    
    MultiplyMatrixInt(int[][] elementIntA, int[][] elementIntB,int start,int end) {
        
        this.intA = elementIntA;
        this.intB = elementIntB;
        this.start = start;
        this.end = end;
             
        //////////Matrix multiplying,
        
        }
  
    @Override
    public void run(){

        for(int row=0;row<intA.length;row++){
            for(int col=0;col<intB[0].length;col++){
                for(int j=0;j<intB.length;j++){
                    ansInt=ansInt+intA[row][j]*intB[j][col]; 
                }
                MatrixMultiplication.C[row][col]=ansInt;
                ansInt = 0;
            }
        }

    }

    
    
    

    public static void validation(int[][] A, int[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
    
   
}
