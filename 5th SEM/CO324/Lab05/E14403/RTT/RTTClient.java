// UDPClient.java: A simple UDP client program.

import java.net.*;
import java.io.*;

public class RTTClient {

    static String data = "Hello there!";
    final static int PORT = 12345;
    final static int BUFSIZE = 1024;
    final static int LOOPSIZE = 100;

    public static void main(String args[]) {
    	long rttList [] = new long [LOOPSIZE];
    	for(int i=0;i<LOOPSIZE;i++)
        try ( DatagramSocket aSocket = new DatagramSocket();) {
            InetAddress aHost = InetAddress.getByName(args[0]);
            long timeStamp = System.currentTimeMillis();
            //data = args[1];
            String time = String.valueOf(timeStamp);
            byte[] dataArray = (time+";"+data).getBytes();
            DatagramPacket requestPacket = new DatagramPacket(dataArray, dataArray.length, aHost, PORT);
            aSocket.send(requestPacket);

            byte[] buffer = new byte[dataArray.length];
            DatagramPacket recievePacket = new DatagramPacket(buffer, buffer.length);
            //System.out.println();
            aSocket.receive(recievePacket);
            String recievedData[] = (new String(recievePacket.getData())).split(";");
            String timeRec = recievedData[0];
            long timeRecL = Long.parseLong(timeRec);
            //System.out.println(timeRecL);
            long currTime = System.currentTimeMillis();
            long rtt = currTime - timeRecL;
            //System.out.println(rtt);
            rttList[i] = rtt;
            //System.out.println();
            /*for(int i=0;i<13;i++){
            	System.out.println(dataRec[i]);
            }*/
            //System.out.println("Reply:" + new String(recievePacket.getData()));
        } catch (Exception e) {
            System.out.println("Socket: " + e.getMessage());
        } 
        long count=0;
        for(int i=0;i<LOOPSIZE;i++){
        	count = count+rttList[i];
        }
        float avg = (float)count/LOOPSIZE;
        System.out.println("Average RTT is "+avg);

    }
}
