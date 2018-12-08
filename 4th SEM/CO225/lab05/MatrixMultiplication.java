
import java.io.IOException;
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
 * @author Geeth
 */
public class MatrixMultiplication {
    
   private static final String A = "A.txt";
   private static final String B = "B.txt";
   private static int i;
   private static float j;
   private static double k;
   private static int start;
   private static int end;
   public static int [][]C ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            int noOfThreads;

            
            System.out.print("Enter the number of threads :");
            Scanner scan = new Scanner(System.in);
            int noOfThreadsAsked = scan.nextInt();

            if("i".equals(args[0])){
                MatrixScan scanA = new MatrixScan(A,i);
                MatrixScan scanB = new MatrixScan(B,i);
                MultiplyMatrixInt.validation(scanA.getMatrixInt(), scanB.getMatrixInt());
                int[][] A= new int[scanA.getMatrixInt().length][scanA.getMatrixInt()[0].length];
                int[][] B= new int[scanB.getMatrixInt().length][scanB.getMatrixInt()[0].length];
                C = new int [A.length][B[0].length]; 
                A=scanA.getMatrixInt();
                B=scanB.getMatrixInt();
                
                if(noOfThreadsAsked==1){
                    Thread t1 = new MultiplyMatrixInt(A,B,0,A.length);
                    t1.start();
                    t1.join();
                }else if(noOfThreadsAsked==0){
                    System.out.println("Number of threads should be greater than 0");
                    System.exit(1);
                }else if(noOfThreadsAsked>=scanA.getMatrixInt().length){
                    noOfThreads = scanA.getMatrixInt().length;
                    MultiplyMatrixInt [] mul = new MultiplyMatrixInt[noOfThreads];

                    for(int i=0;i<noOfThreads;i++){
                        mul[i] = new MultiplyMatrixInt(A,B, i, i+1);
                        
                    }
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].start();
                    }                    
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].join();
                    }
                
                }else{
                    int remainder = scanA.getMatrixInt().length%noOfThreadsAsked;
                    int gap = (scanA.getMatrixInt().length-remainder)/noOfThreadsAsked;
                    if(remainder==0){
                        noOfThreads = noOfThreadsAsked;
                    }else{
                        noOfThreads = noOfThreadsAsked+1;
                    }
                    int stopPoint=0;
                    MultiplyMatrixInt [] mul = new MultiplyMatrixInt[noOfThreads];
                    for(int i=0;i<noOfThreads-1;i++){
                        mul [i] = new MultiplyMatrixInt(scanA.getMatrixInt(), scanB.getMatrixInt(), stopPoint, stopPoint+gap);
                        stopPoint=stopPoint+gap;
                    }
                    mul [noOfThreads-1] = new MultiplyMatrixInt(scanA.getMatrixInt(), scanB.getMatrixInt(), scanA.getMatrixInt().length-remainder,scanA.getMatrixInt().length);
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].start();
                    }
                    for(int i=0;i<noOfThreads;i++){
                        mul[i].join();
                    }
                }
                
               
                for(int j=0;j<scanA.getMatrixInt().length;j++){
                    for(int i=0;i<(scanB.getMatrixInt()[0].length);i++){
                        System.out.print(C[j][i]+"\t");
                    }
                    System.out.println();
                }

            }else if("f".equals(args[0])){
                MatrixScan scanA = new MatrixScan(A,j);
                MatrixScan scanB = new MatrixScan(B,j);

                MultiplyMatrixFloat mul = new MultiplyMatrixFloat(scanA.getMatrixFloat(),scanB.getMatrixFloat(),start, end);

            }else if("d".equals(args[0])){
                MatrixScan scanA = new MatrixScan(A,k);
                MatrixScan scanB = new MatrixScan(B,k);   

                MultiplyMatrixDouble mul = new MultiplyMatrixDouble(scanA.getMatrixDouble(),scanB.getMatrixDouble(),start,end);

            }else{
                System.out.println("Usage : java MatrixMultiplication [type]\ntypes:'i' for integer 'f' for float and 'd' for double");
            }

       
            //matrixMultiply(scanA.getElements());

        }catch(NumberFormatException en){
            System.out.println("Use d(double) or f(float) types");
        }catch(NullPointerException ep){
            System.out.println("File is missing!");
        }catch(IOException ei){
        
        }catch(ArrayIndexOutOfBoundsException ea){
            System.out.println("Usage : java MatrixMultiplication [type]\ntypes:'i' for integer 'f' for float and 'd' for double");
        } catch (InterruptedException ex) {
           Logger.getLogger(MatrixMultiplication.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }

   
}
