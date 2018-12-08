/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
public class MultiplyMatrixDouble extends Thread{
    
    private double [][] doubleA;
    private double [][] doubleB;
    private static double[][] doubleC;
    private static double ansDouble=0;
    
    private static int start;
    private static int end;
   
    
        MultiplyMatrixDouble(double[][] elementDoubleA, double[][] elementDoubleB,int start,int end) {
        
        this.doubleA = elementDoubleA;
        this.doubleB = elementDoubleB;
        this.start = start;
        this.end = end;
        doubleC = new double [doubleA.length][doubleB[0].length];
        validation(doubleA,doubleB);
        
        //////////Matrix multiplying
        
        for(int row=0;row<doubleA.length;row++){
            for(int col=0;col<doubleB[0].length;col++){
                for(int j=0;j<doubleB.length;j++){
                    ansDouble=ansDouble+doubleA[row][j]*doubleB[j][col]; 
                }
                doubleC[row][col]=ansDouble;
                ansDouble = 0;
            }
        }
        /////printing the ans
         for(int j=0;j<doubleA.length;j++){
            for(int i=0;i<(doubleB[0].length);i++){
                System.out.print(doubleC[j][i]+"\t");
            }
            System.out.println();
        }
    }

    public static void validation(double[][] A, double[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
        
    public static double [][] getMatrixCDouble(){
    return doubleC;
    }
        
}
