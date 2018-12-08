/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class MultiplyMatrix {

    private Integer [][]intA;
    private Integer [][]intB;
    private static int ansInt =0;
    private float [][] floatA;
    private float [][] floatB;
    private static float ansFloat=0;
    private double [][] doubleA;
    private double [][] doubleB;
    private static double ansDouble=0;
   
    
    
    MultiplyMatrix(Integer[][] elementIntA, Integer[][] elementIntB) {
        
        this.intA = elementIntA;
        this.intB = elementIntB;
        Integer[][] intC = new Integer [intA.length][intB[0].length];
        validation(intA,intB);
        
        //////////Matrix multiplying
        for(int row=0;row<intA.length;row++){
            for(int col=0;col<intB[0].length;col++){
                for(int j=0;j<intB.length;j++){
                    ansInt=ansInt+intA[row][j]*intB[j][col]; 
                }
                intC[row][col]=ansInt;
                ansInt = 0;
            }
        }
        /////printing the ans
         for(int j=0;j<intA.length;j++){
            for(int i=0;i<(intB[0].length);i++){
                System.out.print(intC[j][i]+" ");
            }
            System.out.println();
        }
    }
    
    MultiplyMatrix(float [][] elementFloatA, float[][] elementFloatB) {
        
        this.floatA = elementFloatA;
        this.floatB = elementFloatB;
        float[][] floatC = new float [floatA.length][floatB[0].length];
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
                System.out.print(floatC[j][i]+" ");
            }
            System.out.println();
        }
    }
    
    MultiplyMatrix(double[][] elementDoubleA, double[][] elementDoubleB) {
        
        this.doubleA = elementDoubleA;
        this.doubleB = elementDoubleB;
        double[][] doubleC = new double [doubleA.length][doubleB[0].length];
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
                System.out.print(doubleC[j][i]+" ");
            }
            System.out.println();
        }
    }

    private void validation(Integer[][] A, Integer[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
    private void validation(float[][] A, float[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
    private void validation(double[][] A, double[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not matching");
            System.exit(0);
        }
    }
    
    
}
