/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth	E/14/403
 */
public class contact{

    private final String Lname;
    private final String Fname;
    private final String PhoneNo;
        
    public contact(String Fname, String Lname, String PhoneNo){
        
        this.Fname = Fname;
        this.Lname = Lname;
        this.PhoneNo = PhoneNo;
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
}
