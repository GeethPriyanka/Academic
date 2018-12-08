
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
public class TokenBucket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int size = 10;
        try {
            Bucket buck = new Bucket(size);
        } catch (InterruptedException ex) {
            Logger.getLogger(TokenBucket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stream str = new Stream();
    }
    
}
