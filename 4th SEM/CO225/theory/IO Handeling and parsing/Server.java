import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server { 
    
    public static final int BASE_PORT = 1250;     
    
    private static ServerSocket serverSocket; 
    private static int socketNumber; 

    Auth authInfo; 

    public Server(int socket) throws IOException { 
	serverSocket = new ServerSocket(socket); 
	socketNumber = socket; 
	authInfo = new StudentDB("e14.csv", 
				 "RegNo", /* E number */
				 "Name"); 
    }

   
    public void server_loop() throws IOException { 
	while(true) { 
	    Socket socket = serverSocket.accept(); 	    
	    CommServer worker = new CommServer(socket, authInfo); 
	    worker.start(); 
	}
    }

    public static void main(String [] args) throws IOException { 
	Server server = new Server(BASE_PORT);
	server.server_loop(); 
    }
}


