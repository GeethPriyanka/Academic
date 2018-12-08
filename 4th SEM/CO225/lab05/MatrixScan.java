
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class MatrixScan {
    
    private BufferedReader reader = null;
    private String line = null;
    private int [][] elementInt ;
    private double [][] elementDouble;
    private float [][] elementFloat;
    private String [] rowElement;
    private List<Integer> listInt = new ArrayList<>();
    private List<Float> listFloat = new ArrayList<>();
    private List<Double> listDouble = new ArrayList<>();
    private int rowLength = 0;
   
    
    public MatrixScan(String A, int n) throws IOException{
        try {
            reader = new BufferedReader(new FileReader(A));
            
            while((line = reader.readLine())!=null){
                rowElement = line.split(" ");
                for(int a = 0;a<rowElement.length;a++){
                    listInt.add(Integer.parseInt(rowElement[a]));
                }
                rowLength++;
            }
            //System.out.println(list);
            
            if(rowLength*rowElement.length == listInt.size()){
                elementInt = new int[rowLength][rowElement.length];
                for(int j=0;j<rowLength;j++){
                    for(int i=0;i<rowElement.length;i++){
                        elementInt[j][i]=listInt.get((rowElement.length*j)+i);
                    }
                }
           // printArray(elementInt);
            }else{
                System.out.println("Wrong Matrix data");
                System.exit(0);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is missing!");
        }
    }
    
    public MatrixScan(String A, float n) throws IOException{
        try {
            reader = new BufferedReader(new FileReader(A));
            
            while((line = reader.readLine())!=null){
                rowElement = line.split(" ");
                for(int a = 0;a<rowElement.length;a++){
                    listFloat.add(Float.parseFloat(rowElement[a]));
                }
                rowLength++;
            }
            //System.out.println(list);
            
            if(rowLength*rowElement.length == listFloat.size()){
                elementFloat = new float[rowLength][rowElement.length];
                for(int j=0;j<rowLength;j++){
                    for(int i=0;i<rowElement.length;i++){
                        elementFloat[j][i]=listFloat.get((rowElement.length*j)+i);
                    }
                }
            //printArray(elementFloat);
            }else{
                System.out.println("Wrong Matrix data");
                System.exit(0);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is missing!");
        }
    }
        
    public MatrixScan(String A, double n) throws IOException{
        try {
            reader = new BufferedReader(new FileReader(A));
            
            while((line = reader.readLine())!=null){
                rowElement = line.split(" ");
                for(int a = 0;a<rowElement.length;a++){
                    listDouble.add(Double.parseDouble(rowElement[a]));
                }
                rowLength++;
            }
            //System.out.println(list);
            
            if(rowLength*rowElement.length == listDouble.size()){
                elementDouble = new double[rowLength][rowElement.length];
                for(int j=0;j<rowLength;j++){
                    for(int i=0;i<rowElement.length;i++){
                        elementDouble[j][i]=listDouble.get((rowElement.length*j)+i);
                    }
                }
           // printArray(elementDouble);
            }else{
                System.out.println("Wrong Matrix data");
                System.exit(0);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is missing!");
        }
    } 

    public int[][] getMatrixInt() {
        return elementInt;
    }

    public double[][] getMatrixDouble() {
        return elementDouble;
    }

    public float[][] getMatrixFloat() {
        return elementFloat;
    }
    
    public void printArray(float array[][]){
    
        for(int j=0;j<rowLength;j++){
            for(int i=0;i<rowElement.length;i++){
                System.out.print(elementFloat[j][i]+"\t");
            }
            System.out.println();
        }
        
    }
   
    public void printArray(Integer array[][]){
    
        for(int j=0;j<rowLength;j++){
            for(int i=0;i<rowElement.length;i++){
                System.out.print(elementInt[j][i]+"\t");
            }
            System.out.println();
        }
        
    }
    
    public void printArray(double array[][]){
    
        for(int j=0;j<rowLength;j++){
            for(int i=0;i<rowElement.length;i++){
                System.out.print(elementDouble[j][i]+"\t");
            }
            System.out.println();
        }
        
    }
}
