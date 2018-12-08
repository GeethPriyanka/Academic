

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth	E/14/403
 */
public class index {

    /**
     * @param args the command line arguments
     */
    
    static String sc;
    static String [] switcher;
    
    
    public static void main(String[] args) {
        
        try{
        contactList list = new contactList();
        System.out.println("Enter First name after F: or Enter Last name after L:");
        Scanner s = new Scanner(System.in);
        sc = s.nextLine();
        switcher = sc.split(":");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Malformed csv file!");
        }
        
        try{
        
            if(switcher[0].equals("F")){
                contactList.getPhoneNumber(switcher[1],"F");
            }else if(switcher[0].equals("L")){
                contactList.getPhoneNumber(switcher[1],"L");
            }else{
                System.out.println("usage: F:[First Name] or L:[Last Name]");
            }
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println("usage: F:[First Name] or L:[Last Name]");
        }
       
    }
    
}

