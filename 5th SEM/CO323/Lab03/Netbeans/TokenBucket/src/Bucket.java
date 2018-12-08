
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class Bucket {
    int size;
    int [] bucketBuffer;
    int pointer;
    public Bucket(int size) throws InterruptedException{
        size = this.size;
        bucketBuffer = new int [size];
        Arrays.fill(bucketBuffer,0);            //initializing the array buffer to 0
        pointer= 0;                               //points to the top 
        while(true){
            bucketBuffer[pointer]=1;                  //marking tokenss
            TimeUnit.SECONDS.sleep(1);          //wait for a second
            pointer++;
            if(pointer==size){                        // if token bucket gets full make the counter constant
                pointer--;
            }
        }
        
    }
    
    int issueToken(int numOfTokens){
        if(pointer<numOfTokens){
            System.out.println("number of tokens are limited");
            return pointer;
        }else{
            for(int i=pointer;i>pointer-numOfTokens;i--){
                bucketBuffer[i]=0;
            }
            pointer = pointer-numOfTokens;
            return numOfTokens;
        }
    }
    
}
