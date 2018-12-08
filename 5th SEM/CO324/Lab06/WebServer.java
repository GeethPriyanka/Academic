/*
E14403	KPGP WIMALASIRI	CO324	LAB 06
*/


import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Date;
import java.util.logging.Logger;

public class WebServer extends Thread {
    static final int PORT = 8888;			//port 8888
    Socket socket;
    
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for requests on port :"+PORT);
        while (!Thread.interrupted())						//loop runs while thread interrupt
        try(ServerSocket ss = new ServerSocket(PORT);) {
            
            new WebServer(ss.accept()).start();			// starting a new thread to server the request
        } 
        
    }

    WebServer(Socket s) {
        socket = s;
    }        

    @Override
    public void run() {			//run method of thread class
        
        try( OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream() ) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));            
                String request = br.readLine();
                PrintStream printOut = new PrintStream(out);
                String req = null;
                if(request.length()<14 || !(request.startsWith("GET")) || !(request.endsWith("HTTP/1.1"))){
                    System.out.println("Bad request...!!!");				//check for errornous request
                }else{
                    req = request.substring(5, request.length()-9).trim();		//trimming the path from request
                    System.out.println(req);
                } 
                
                byte [] data = Files.readAllBytes(Paths.get(req));		//making requsted data into bytes
                printOut.print("HTTP/1.0 200 OK\r\n" +					//sending headers
                        "Content-Type: " + contentType(req) + "\r\n" +
                        "Date: " + new Date() + "\r\n" +
                        "Server: CO324 Server\r\n\r\n");
                printOut.write(data);						//send data to the client
                System.out.println("Served..!");
                printOut.flush();
                printOut.close();					//closing the connection
                
                
        } catch (IOException e) {
//            out.write("400 ERROR".getBytes());
            Logger.getGlobal().severe(e.getMessage());
        }
    }
    
    private static String contentType(String path){				//choosing type 
        if (path.endsWith(".html")||path.endsWith(".htm")) 
            return "text/html";
        else if (path.endsWith(".jpg")||path.endsWith(".jpeg"))
            return "image/jpeg";
        else if (path.endsWith(".gif")) 
            return "image/gif";
        else if (path.endsWith(".txt")||path.endsWith(".java")) 
            return "text/plain";
        else if (path.endsWith(".class"))
            return "application/octet-stream";
        else if (path.endsWith(".pdf"))
            return "application/pdf";
        else    
            return "text/plain";
    }

}