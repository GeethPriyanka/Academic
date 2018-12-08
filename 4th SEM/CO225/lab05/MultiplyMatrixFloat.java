/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class MultiplyMatrixFloat extends Thread{
private float [][] floatA;
private float [][] floatB;
private static float [][] floatC;
private static float ansFloat=0;

private static int start;
private static int end;
   


MultiplyMatrixFloat(float [][] elementFloatA, float[][] elementFloatB,int start, int end) {
        
        this.floatA = elementFloatA;
        this.floatB = elementFloatB;
        this.start = start;
        this.end = end;
        floatC = new float [floatA.length][floatB[0].length];
        validation(floatA,floatB);
        
        //////////Matrix multiplying
        for(int row=0;row<floatA.length;row++){
            for(int col=0;col<floatB[0].length;col++){
                for(int j=0;j<floatB.length;j++){
                    ansFloat=ansFloat+floatA[row][j]*floatB[j][col]; 
                }
                floatC[row][col]=ansFloat;
                ansFloat = 0;
            }
        }
        /////printing the ans
         for(int j=0;j<floatA.length;j++){
            for(int i=0;i<(floatB[0].length);i++){
                System.out.print(floatC[j][i]+"\t");
            }
            System.out.println();
        }
    }

    public static void validation(float[][] A, float[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
    
    public static float [][] getMatrixCFloat(){
    return floatC;
    }
       
    
}

