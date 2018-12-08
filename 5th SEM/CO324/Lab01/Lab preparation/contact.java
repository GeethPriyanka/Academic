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

    private final String Lname;
    private final String Fname;
    private final String PhoneNo;
    private final String Email;
    private final String id;

    public contact(String id, String Fname, String Lname, String PhoneNo, String Email, String company ){

        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.PhoneNo = PhoneNo;
        this.Email = Email;
   
    }

    public String getId(){
        return id;
    }

    public String getLname() {
        return Lname;
    }

    public String getFname() {
        return Fname;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getEmail(){
        return Email;
    }

}
