
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathasha
 */

//Logic for your address book
public class AddressBook {
    
    protected static boolean noMatch = true;
    public static String nameLast;
    public static String phoneNumber;
    public static String email;
    
    //read from file and create Address Book
    public static void initAddressBook(String fileName){
        /*TODO*/
        //Create your address book
        try{
            contactList list = new contactList(fileName);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Malformed csv file!");
        }
    }
    
    //search details of the requested contact in the address book
    public static String search(String  name){
	
        /*TODO*/
        System.out.println();
        contactList.name = name;
        
            for (contact cntList1 : contactList.cntList) {
                if (cntList1.getName().equals(name)) {
                    nameLast = cntList1.getName();
                    phoneNumber = cntList1.getPhoneNo();
                    email = cntList1.getEmail();
                    noMatch = false;
                }
            }
        
        if(noMatch){
            return "noMatch";
        }else{
            noMatch = true;
            return nameLast+"\n"+phoneNumber+"\n"+email;
        }
        
    }
    
}


