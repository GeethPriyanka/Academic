

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
   
    private BufferedReader reader = null;
    private String line = null;
    private String [] splittedLine;
    public static List<contact> cntList = new ArrayList<>();
    static String name;
    protected static boolean noMatch = true;

    public contactList(String fileName){

        try{
            reader = new BufferedReader(new FileReader(fileName));

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

}