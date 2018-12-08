/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geturl;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Geeth
 */
public class GetURL {

    /**
     * @param args the command line arguments
     */
    
    public static String address;
    public static String out;
            
    public static void main(String[] args) throws MalformedURLException, IOException {
        GetURL.address = args[0];
        try{
            URL myURL = new URL(address);
            InputStream in = myURL.openStream();
            DataInputStream DataIn = new DataInputStream(new BufferedInputStream(in));
            while((out = DataIn.readLine())!= null){
                System.out.println(out);
            }
            System.out.println("\n----------------Following are the metadata of this paricular site-----------------\n");
            
            System.out.println("protocol = " + myURL.getProtocol());
            System.out.println("authority = " + myURL.getAuthority());
            System.out.println("host = " + myURL.getHost());
            System.out.println("port = " + myURL.getPort());
            System.out.println("path = " + myURL.getPath());
            System.out.println("query = " + myURL.getQuery());
            System.out.println("filename = " + myURL.getFile());
            System.out.println("ref = " + myURL.getRef());
        }catch(MalformedURLException e){
            System.out.println("Error URL");
            System.exit(1);
        }catch(IOException e1){
            System.out.println("Error IO Exception");
            System.exit(1);
        }finally{
            try{
                in.close();
            }catch(IOException e2){
                System.out.println("Error while closing");
            }
        }
        
        //System.out.println(address);
    }
    
}
