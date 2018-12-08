/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
public class contact {

    private final String Name;
    private final String PhoneNo;
    private final String Email;

    public contact(String Name, String PhoneNo, String Email){
       
        this.Name = Name;
        this.PhoneNo = PhoneNo;
        this.Email = Email;
   
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getEmail(){
        return Email;
    }

}
