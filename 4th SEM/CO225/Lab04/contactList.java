
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
 * @author Geeth	E/14/403
 */
public class contactList {
    
    private FileReader FileName = null;
    private BufferedReader reader = null;
    private String line = null;
    private String [] splittedLine;
    private static List<contact> cntList = new ArrayList<>();
    private static String switcher;
    private static String Identifier;
    protected static boolean noMatch = true;
    
   public contactList(){
    
    
        try{
            reader = new BufferedReader(new FileReader("name_list.csv"));
            
            while((line = reader.readLine()) != null){
                splittedLine = line.split(",");
                contact cnt= new contact(splittedLine[0],splittedLine[1],splittedLine[2]);
                cntList.add(cnt);
            }
        }catch(FileNotFoundException e1){
            System.out.println("Contact file doesn't exist!");
            System.exit(0);
        }catch(IOException e2){
            System.out.println("Some I/O Exception");
            System.exit(0);
        }
        
    }
   
    static void getPhoneNumber(String switcher, String Identifier) {
        
        System.out.println();
        contactList.switcher = switcher;
        contactList.Identifier = Identifier;
        if(Identifier=="L"){
            for (contact cntList1 : cntList) {
                if (cntList1.getLname().equals(switcher)) {
                    System.out.print("Name :\t"+cntList1.getFname() + " " + cntList1.getLname() + "\n");
                    System.out.println("Phone Number :\t"+cntList1.getPhoneNo());  
                    System.out.println();
                    noMatch = false;
                }
            }
        }else if(Identifier=="F"){
            for (contact cntList1 : cntList) {
                if (cntList1.getFname().equals(switcher)) {
                    System.out.print("Name :\t"+cntList1.getFname() + " " + cntList1.getLname() + "\n");
                    System.out.println("Phone Number :\t"+cntList1.getPhoneNo());  
                    System.out.println();
                    noMatch = false;
                }
            }
        }
        
        if(noMatch){
            System.out.println("No matching contacts found");
        }
        
    }

}
