
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
public class RandomGen {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{

            List<Integer> listInt = new ArrayList<>();
            List<Float> listFloat = new ArrayList<>();
            List<Double> listDouble = new ArrayList<>();
            int [][]intArray;
            float [][] floatArray;
            double [][] doubleArray;
            
            int min = 0;
            int max = 100000;

            int Row;
            int Col;

            Scanner scanRow = new Scanner(System.in);
            Scanner scanCol = new Scanner(System.in);
            Random randInt = new Random();
            Random randFloat = new Random();
            Random randDouble = new Random();

            System.out.println("Enter the number of rows :");
            Row = scanRow.nextInt();
            System.out.println("Enter the number of columns :");
            Col = scanCol.nextInt();

            intArray = new int [Row][Col];
            floatArray = new float[Row][Col];
            doubleArray = new double[Row][Col];

            if("i".equals(args[0])){
                for(int i=0;i<Col*Row;i++){
                    listInt.add(randInt.nextInt(max)+min);
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        intArray[i][j] = listInt.get((i*Col)+j);
                    }
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        System.out.print(intArray[i][j]+"\t");
                    }
                    System.out.println();
                }

            }else if("f".equals(args[0])){
                
                for(int i=0;i<Col*Row;i++){
                    listFloat.add(min+(max-min)*randFloat.nextFloat());
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        floatArray[i][j] = listFloat.get((i*Col)+j);
                    }
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        System.out.print(floatArray[i][j]+"\t");
                    }
                    System.out.println();
                }


            }else if("d".equals(args[0])){
                
                for(int i=0;i<Col*Row;i++){
                    listDouble.add(min+(max-min)*randDouble.nextDouble());
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        doubleArray[i][j] = listDouble.get((i*Col)+j);
                    }
                }
                for(int i=0;i<Row;i++){
                    for(int j=0;j<Col;j++){
                        System.out.print(doubleArray[i][j]+"\t");
                    }
                    System.out.println();
                }

            }else{
                System.out.println("usage : java RandomGen [type]\ntypes --> 'i' or 'f' or 'd'");
            }
        
        }catch(InputMismatchException e1){
            System.out.println("Enter number of rows and columns");
        }catch(ArrayIndexOutOfBoundsException e2){
        	System.out.println("usage : java RandomGen [type]\ntypes --> 'i' or 'f' or 'd'");
        }
    }
}
