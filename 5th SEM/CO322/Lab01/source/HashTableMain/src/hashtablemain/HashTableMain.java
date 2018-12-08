


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Geeth
 */
public class HashTableMain {

    /**
     * @param args the command line arguments
     */
    
    public static String [] switcher;
    public static String sc;
    public static boolean runtime=true;
    public static BufferedReader br;
    public static HashTableImp table1;
    public static String fileName;
    public static String codeNo;
    
    
    public static void main(String[] args){
        // TODO code application logic here
        String line;
        String processedLine=null;
        String [] wordLine=null;
        int i=0;
        int buckets = Integer.parseInt(args[0]);
        fileName = args[2];    
        codeNo = args[1];
        try{
            table1 = new HashTableImp(buckets);             //declaring a set of bucket
            br = new BufferedReader(new FileReader(fileName));  //reading the file
        
        
            while((line = br.readLine()) != null){          //reading the file line by line till the end

                processedLine = line.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase().replaceAll("\\s+","_");       //removing punctuational marks and make the text lowercase
                wordLine = processedLine.split("_");        //Splitting the line into words

                while(wordLine.length>i){       //reading word by word

                    table1.insert(wordLine[i]);     //inserting words to the table
                    i++;
                }//end of while loop

                i=0;
            }//end of while loop
        
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e1){
            System.out.println(e1);
        }
        
        
        table1.nodeCounter();       //calling the method for printing the output
        
        while(runtime){     //make the program run continuosly

            try{
                System.out.println("usage :\nTo insert an element :\t[i] [element]\nTo search an element :\t[s] [element]\nTo Exit :[exit]");
                Scanner s = new Scanner(System.in);     
                sc = s.nextLine();              //scan for command arguments
                switcher = sc.split(" ");       //splitting the argument into elements

                if("i".equals(switcher [0])){   //switching to the insert method
                    table1.insert(switcher [1]);
                    System.out.println("Successfully inserted...!");
                    System.out.println();
                }else if("s".equals(switcher [0])){     //switching to the search method
                    table1.search(switcher [1]);
                }else if("exit".equals(switcher [0])){      //switching to exit
                    runtime= false;
                }else{
                }
            }catch(ArrayIndexOutOfBoundsException e1){
                System.out.println("usage :\nTo insert an element :\t[i] [element]\nTo search an element :\t[s] [element]\nTo Exit :[exit]");
                runtime= false;
            }
        }
        
        
    }
    
    
    
}
