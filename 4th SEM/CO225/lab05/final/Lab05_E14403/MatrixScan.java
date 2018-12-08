
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
 * @author Geeth    E/14/403
 */
class MatrixScan {
    
    private BufferedReader reader = null;
    private String line = null;
    private double [][] element;
    private String [] rowElement;
    private List<Double> listDouble = new ArrayList<>();
    private int rowLength = 0;
   
    /*  Here method overloading is done in order to create 2D matrices of different types   */
   
    public MatrixScan(String A) throws IOException{
        try {
            reader = new BufferedReader(new FileReader(A));     //reading data from the file
            
            while((line = reader.readLine())!=null){            //read the file line by line and taking values into a arraylist(as the size is unknown)
                rowElement = line.split("\t");
                for(int a = 0;a<rowElement.length;a++){
                    listDouble.add(Double.parseDouble(rowElement[a]));
                }
                rowLength++;
            }
           
            
            if(rowLength*rowElement.length == listDouble.size()){       // check whether each row has same number of elements in the file
                element = new double[rowLength][rowElement.length];
                for(int j=0;j<rowLength;j++){
                    for(int i=0;i<rowElement.length;i++){
                        element[j][i]=listDouble.get((rowElement.length*j)+i);        // Arraylist data ---> 2D matrix
                    }
                }
          
            }else{
                System.out.println("Wrong Matrix data");
                System.exit(0);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File is missing!");
        }
    } 

  
    public double[][] getMatrix() {
        return element;
    }

    
  
}
