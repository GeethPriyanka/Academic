
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*********************************************
 * CO322: Data structures and algorithms
 * Implementation of the hashTable
 *********************************************/
class HashTableImp implements HashTable {


    /* Put your code here */
    private final int buckets;
    private String key;
    private int initValue;
    private int index;
    private final int codeNo=Integer.parseInt(HashTableMain.codeNo);
    private final node [] nodeList;
    private static int [] count ;
    private int maximum, minimum;
    private static float totCount;
    
   

    public HashTableImp(int buckets) {
	
        this.buckets = buckets;             // create a open hash table with given number of buckets 
        nodeList = new node [buckets];     // declaring the number of buckets
        count = new int [buckets];          //array to store number of nodes in each bucket
        Arrays.fill(count, 0);              // array is initialized
        
    }// end of constructor

    @Override
    //inserting items to the hash list
    public void insert(String key) {
        this.key = key;
        index = getHashCode(key,codeNo);
        initValue = 1;              // value is set for 1 initially(number of iterations)
        
        node tmp1;
        node tmp2;
        
        if(nodeList[index]==null){      //check whether there are existing nodes in the bucket
            
            node node1 = new node(key,initValue);   //new node
            nodeList[index] = node1;      //adding the first node
            node1 = null;
            
        }else{
         
            tmp1 = nodeList[index];
            
            while(tmp1.next!=null && !(tmp1.key.equals(key))){         //iterate through the linked list untill a match is found

                tmp2 = tmp1.next;           //passing the tmp1 node's next link to tmp2
                tmp1 = tmp2;                //make tmp1, as the link to the next node

            }//end of while loop
            
            if(tmp1.key.equals(key)){
                (tmp1.value)++;             //incrementing the value when a match is found
                
            }else{
                node node1 = new node(key,initValue);   //new node
                tmp1.next = node1;              //adding the new node link to the end of the current linked list
                
            }
                
            
        }
    }// end of insert method

    @Override
    public int search(String key) {
        node tmp1;
        node tmp2;
        int foundValue =0;
        index = getHashCode(key,codeNo);
        tmp1 = nodeList[index];
        
        while(tmp1.next!=null && !(tmp1.key.equals(key))){         //iterate through the linked list untill a match is found

            tmp2 = tmp1.next;           //passing the tmp1 node's next link to tmp2
            tmp1 = tmp2;                //make tmp1, as the link to the next node

        }//end of while loop
        
        if(tmp1.key.equals(key)){
            foundValue = tmp1.value;    //the value refered to the key
            System.out.println(tmp1.key+"\t\t"+tmp1.value);     //printing the value according to the search key
        }else{
            System.out.println("No matches found");

        }
        
        return foundValue;               
    }
    

    public int getHashCode(String key, int codeNo) {    //method to generate hash code for a given key
        
        int code = 0;
        
        if(codeNo==1){      //hash code 1
        
            char [] charKey = key.toCharArray();    //splitting the String into chars
            for(int i=0;i<key.length();i++){
                code = code + (charKey[i])*(int)(pow(10,i));
            }
            if(code<0){
                code *=-1;          //making the code >0
            }
            return code%buckets;    //returning the hash code
            
        }else if(codeNo==2){    //hash code 2
            char [] charKey = key.toCharArray();       //splitting the String into chars
            for(int i=0;i<key.length();i++){
                code = code + charKey[i];
            }
            if(code<0){
                code *=-1;          //making the code >0
            }
            return code%buckets;    //returning the hash code
        }else{
            System.out.println("Hash code number should be 1 or 2");
            return 0;
        }
    }

    void nodeCounter() {        //method to print the output of distribution
        
        node counterNode;
        node counterNode2;
        float avg;
        float sd = 0;
        
        for(int i=0;i<nodeList.length;i++){     
        
            counterNode = nodeList[i];      //iterating through the bucket list
            
            if(counterNode!=null){
                count[i]++;
                while(counterNode.next!=null){      //iterating through the linked list(nodes)
                    counterNode2 = counterNode.next;
                    counterNode = counterNode2;
                    count[i]++;                     //counting the number of nodes
                }
                minimum = count[i];         //declaring an existing value for minimum value
            }else{
                minimum = 0;                //declaring minimum value as 0 if no node is found in a bucket
            }
        }//end of for loop
        
        System.out.println();
        System.out.println("----------Node distribution for hash code no:"+codeNo+"--->"+HashTableMain.fileName+"----------\n");
        maximum = 0;            //declaring maximum as 0
        totCount = 0;           //declaring total count as 0
        for(int i=0;i<nodeList.length;i++){
            System.out.println("bucket"+(i+1)+"        "+count[i]); //printing the number of nodes in each bucket
            totCount = totCount+count[i];                           //counting the total number of nodes

            if(count[i]>maximum){
                maximum = count[i];     //finding the max
            }
            if(count[i]<minimum){
                minimum = count[i];     //finding the min
            }
            
        }
        avg = totCount/nodeList.length;         //average calculating
        for(int i=0;i<nodeList.length;i++){
            sd += Math.pow((count[i]-avg),2)/nodeList.length;   //standard deviation calculation
        }
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.printf("Maximum number of nodes   =   "+maximum+"\nMinimum number of nodes   =   "+minimum+"\nAverage number of nodes   =   "+"%.3f"+"\nStandard deviation        =   "+"%.3f\n",avg,Math.sqrt(sd));
        System.out.println("---------------------------------------");
        System.out.println();
        
        
    }
    
   


}// end HashTableImp 
