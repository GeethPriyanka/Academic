/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Created by e14403 on 1/26/18.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class contactList {
   
    private FileReader FileName = null;
    private BufferedReader reader = null;
    private String line = null;
    private String [] splittedLine;
    private static List<contact> cntList = new ArrayList<>();
    private static String[] switcher;
    private static String Identifier;
    protected static boolean noMatch = true;
    private String fileName;
    private static int delID;

    public contactList(String fileName){

	this.fileName = fileName;

        try{
            reader = new BufferedReader(new FileReader(fileName));

            while((line = reader.readLine()) != null){
                splittedLine = line.split(",");
                contact cnt= new contact(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3],splittedLine[4],splittedLine[5]);
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

    static void getPhoneNumber(String[] switcher, String Identifier) {

        System.out.println();
        contactList.switcher = switcher;
        contactList.Identifier = Identifier;
        if(Identifier=="L"){
            for (contact cntList1 : cntList) {
                if (cntList1.getLname().equals(switcher[1])) {
                    System.out.print("Name :\t"+cntList1.getFname() + " " + cntList1.getLname() + "\n");
                    System.out.println("Phone Number :\t"+cntList1.getPhoneNo());
                    System.out.println("Email address :\t"+cntList1.getEmail());
                    System.out.println();
                    noMatch = false;
                }
            }
        }else if(Identifier=="F"){
            for (contact cntList1 : cntList) {
                if (cntList1.getFname().equals(switcher[1])) {
                    System.out.print("Name :\t"+cntList1.getFname() + " " + cntList1.getLname() + "\n");
                    System.out.println("Phone Number :\t"+cntList1.getPhoneNo());
                    System.out.println("Email address :\t"+cntList1.getEmail());
                    System.out.println();
                    noMatch = false;
                }
            }
        }else if(Identifier=="N"){
            for (contact cntList1 : cntList) {
                if ((cntList1.getFname().equals(switcher[1]))&&(cntList1.getLname().equals(switcher[2]))) {
                    System.out.print("Name :\t"+cntList1.getFname() + " " + cntList1.getLname() + "\n");
                    System.out.println("Phone Number :\t"+cntList1.getPhoneNo());
                    System.out.println("Email address :\t"+cntList1.getEmail());
                    System.out.println();
                    noMatch = false;
                }
            }
        }

        if(noMatch){
            System.out.println("No matching contacts found");
        }
		noMatch = true;
    }
    
    static void addContact(String [] switcher) {
        contact finalContact = cntList.get(cntList.size()-1);
        int finalID = Integer.parseInt(finalContact.getId());
        contact newContact = new contact(String.valueOf(finalID+1),switcher[1],switcher[2],switcher[3],switcher[4],switcher[5]);
        cntList.add(newContact);
        System.out.println("Successfully added..!");
    }
    
    static void delContact(String[] switcher) {
        for (contact cntList1 : cntList) {
                if ((cntList1.getFname().equals(switcher[1]))&&(cntList1.getLname().equals(switcher[2]))) {
                    delID = Integer.parseInt(cntList1.getId());
                    noMatch = false;
                }
        }
		
		if(noMatch){
            System.out.println("No matches found..!");
        }else{
			cntList.remove(delID);
			System.out.println("Deleted successfully..!");
			noMatch = true;
		}
        
		
    }
        
    }