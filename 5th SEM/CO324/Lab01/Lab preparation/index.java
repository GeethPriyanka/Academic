/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;

/**
 *
 * @author Geeth
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    static String sc;
    static String [] switcher;
    public static boolean runTime = true;
	


    public static void main(String[] args) {
		
			try{

                contactList list = new contactList(args[0]);
                
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Malformed csv file!");
            }
        
        while(runTime){

                System.out.println("Usage :\nFor searching:\t\tF[space][First Name] or L[space][Last Name] or N[space][First name][space][Last Name]\nFor adding a record:\tADD[space][First Name][space][Last Name][space][Phone Number][space][Email Address][space][Company Name]\nTo Delete a record : DEL[Space][First Name][space][Last Name]\nTo Exit the Program :\tEXIT");
				Scanner s = new Scanner(System.in);
                sc = s.nextLine();
                switcher = sc.split(" ");

            try{

                if(switcher[0].equals("F")){
                    contactList.getPhoneNumber(switcher,"F");
                }else if(switcher[0].equals("L")) {
                    contactList.getPhoneNumber(switcher, "L");
                }else if(switcher[0].equals("N")){
                    contactList.getPhoneNumber(switcher,"N");
                }else if(switcher[0].equals("ADD")){
                    contactList.addContact(switcher);
                }else if(switcher[0].equals("DEL")){
                    contactList.delContact(switcher);
                }else if(switcher[0].equals("EXIT")){
                    runTime = false;
                }else{
                System.out.println("Usage :\nFor searching:\t\tF[space][First Name] or L[space][Last Name] or N[space][First name][space][Last Name]\nFor adding a record:\tADD[space][First Name][space][Last Name][space][Phone Number][space][Email Address][space][Company Name]\nTo Delete a record : DEL[Space][First Name][space][Last Name]\nTo Exit the Program :\tEXIT");
                }
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                System.out.println("Usage :\nFor searching:\t\tF[space][First Name] or L[space][Last Name] or N[space][First name][space][Last Name]\nFor adding a record:\tADD[space][First Name][space][Last Name][space][Phone Number][space][Email Address][space][Company Name]\nTo Delete a record : DEL[Space][First Name][space][Last Name]\nTo Exit the Program :\tEXIT");
            }

        }
    }
}
