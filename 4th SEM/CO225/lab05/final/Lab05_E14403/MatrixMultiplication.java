
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth    E/14/403
 */
public class MatrixMultiplication {
    
   private static String fileA = "_A.txt";
   private static final String fileB = "_B.txt";
   private static int i;
   private static int start;
   private static int end;
   private static int noOfThreads;    //Actual number of threads
   public static double[][]A;
   public static double[][]B;
   public static double[][]C ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            
            System.out.print("Enter the number of threads :");
            Scanner scanThreads = new Scanner(System.in);
            Scanner scanTest = new Scanner(System.in);
            int noOfThreadsAsked = scanThreads.nextInt();      //Number of threads given by the user
            String TestNumber = scanTest.nextLine();
            long startTime = System.currentTimeMillis();
            
            /*          Matrices given in the text files are converted into 2D arrays in this class "MatrixScan"            */
                MatrixScan scanA = new MatrixScan(TestNumber+fileA);
                MatrixScan scanB = new MatrixScan(TestNumber+fileB);
                
            /*          Method "validation" is used to check whether given matrices are compatible to multiply --->(m x p).(p x n)   */
                MatrixMultiplication.validation(scanA.getMatrix(), scanB.getMatrix());
                
                A = new double [scanA.getMatrix().length][scanA.getMatrix()[0].length];
                B = new double [scanB.getMatrix().length][scanB.getMatrix()[0].length];
                C = new double [A.length][B[0].length]; 
                A=scanA.getMatrix();     //2D array of file A is assign to A array
                B=scanB.getMatrix();     //2D array of file B is assign to B array
                
                if(noOfThreadsAsked==1){
                	noOfThreads=1;
                    Thread t1 = new ElementCalculation(0,A.length);
                    t1.start();
                    t1.join();
                }else if(noOfThreadsAsked==0){
                    System.out.println("Number of threads should be greater than 0");
                    System.exit(1);
                    
                    /* If the number of threads are asked by the user is greater than the number of rows of matrix A then number of threads reduced to 
                        the number of rows and each row is handelled by one thread*/
                }else if(noOfThreadsAsked>=A.length){       
                    noOfThreads = A.length;
                    ElementCalculation [] mul = new ElementCalculation[noOfThreads];

                    for(int i=0;i<noOfThreads;i++){
                        mul[i] = new ElementCalculation(i,i+1);
                        mul[i].start();
                    }
                                 
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].join();              // join is done to avoid printing values of the answer(main thread) before calculation
                    }
                
                }else{
                    int remainder = A.length%noOfThreadsAsked;
                    int gap = (A.length-remainder)/noOfThreadsAsked;    // gap of rows between two rows handelled by different threads
                    if(remainder==0){
                        noOfThreads = noOfThreadsAsked;
                    }else{
                        noOfThreads = noOfThreadsAsked+1;               // additional thread is to run remain rows
                    }
                    int stopPoint=0;
                    ElementCalculation [] mul = new ElementCalculation[noOfThreads];
                    for(int i=0;i<noOfThreads-1;i++){
                        mul [i] = new ElementCalculation(stopPoint, stopPoint+gap);
                        stopPoint=stopPoint+gap;
                    }
                    mul [noOfThreads-1] = new ElementCalculation(stopPoint,A.length);    //Thread to run the remain rows
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].start();
                    }
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].join();                  // join is done to avoid printing values of the answer(main thread) before calculation
                    }
                }
                long endTime = System.currentTimeMillis();
                
               /*   Printing the solution matrix    */
               
                for(int j=0;j<scanA.getMatrix().length;j++){
                    for(int i=0;i<(scanB.getMatrix()[0].length);i++){
                        System.out.print(C[j][i]+"\t");
                    }
                    System.out.println();
                }
                
                
                System.out.println();
                System.out.println(TestNumber);
                System.out.println();
                System.out.println("Number of rows in Matrix A :\t"+A.length+"\nNumber of columns in Matrix A :\t"+A[0].length);
                System.out.println("Number of rows in Matrix B :\t"+B.length+"\nNumber of columns in Matrix B :\t"+B[0].length);
                System.out.println("Number of threads used :\t"+noOfThreads);

                System.out.println("Time spent for calculation :\t"+ (endTime-startTime)+"ms");
                
        }catch(NumberFormatException en){
            System.out.println("Use d(double) or f(float) types");
        }catch(NullPointerException ep){
          
        }catch(IOException ei){
        
        }catch(InputMismatchException ea){
            System.out.println("Number of threads should be an integer");
        } catch (InterruptedException ex) {
           Logger.getLogger(MatrixMultiplication.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        
       
        
    }

    /*          Method "validation" is used to check whether given matrices are compatible to multiply              */
    public static void validation(double[][] A, double[][] B) {
        if(A[0].length==B.length){
            
        }else{
            System.out.println("Matrix dimensions are not compatible to multiply");
            System.exit(0);
        }
    }
}
