/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PanCake;

/**
 *
 * @author Geeth
 * E/14/403
 */
class PanStack {

    public PanStack(int size) {
        
        PanCake tmpNext;
        PanCake panTail;
        PanCake panHead = new PanCake();    //creating a new node
        PanCake sortedHead;
        tmpNext = panHead;
        tmpNext.previous = null;            //making head node's previous null
        for(int i=0;i<size-1;i++){          //Creating the linked list
            PanCake pan1 = new PanCake();
            tmpNext.next = pan1;
            pan1.previous = tmpNext;
            tmpNext = pan1;
        }
        tmpNext.next = null;            //making tail node's next null
        panTail = tmpNext;
        System.out.println("");
        System.out.println("Diameters of pancakes in the order of the stack");
        System.out.println("--------------");
        forwardPrint(panHead);
        System.out.println("--------------");
        System.out.println("Instructions to sort");
        System.out.println("");
        //backwardPrint(panTail);
        sortedHead = sortPanStack(panHead,size);    //sorting the stack and generating instructions
        
    }

    private void forwardPrint(PanCake panHead) {    // method to iterate through the linked list from head to tail and print
        //////forward printing
        PanCake tmp;
        tmp = panHead;
        System.out.println(tmp.diameter);
        do{
            tmp = tmp.next;
            System.out.println(tmp.diameter);
            
        }while(tmp.next!=null);
    }

    private void backwardPrint(PanCake panTail) {   //method to iterate through the linked list from tail to head and print
        //////backward printing
        PanCake tmp;
        tmp = panTail;
        System.out.println(tmp.diameter);
        do{
            tmp = tmp.previous;
            System.out.println(tmp.diameter);
            
        }while(tmp.previous!=null);
    }

    private PanCake sortPanStack(PanCake panHead, int size) {   //sorting and generating instructions
        
        PanCake largestCake,tmpHead,largestToTopHead;
        int index;
        
        tmpHead = panHead;
        for(int i=0;i<size;i++){                        
            largestCake = getLargest(tmpHead,size-i);       //getting the largest diameter cake from the given range
            
            index = getIndex(largestCake,tmpHead);          //getting the index of largest cake top-->1 bottom-->n
            if(index != size-i){                            //check whether the largest cake is at the bottom
                if(index!=1){                               //check whether the number of unsorted cakes is 1
                    tmpHead = bottomToTop(tmpHead,index);           //making the largest to the top
                    System.out.println("Flip from Cake number "+index);

                }
                if(size-i!=1){                                  //check whether the number of unsorted cakes is 1
                    tmpHead = bottomToTop(tmpHead,size-i);      //making the stack upside down for given range
                    System.out.println("Flip from cake number "+(size-i));
                }
            }
            if(isSorted(tmpHead)){                              //check whether the stack is sorted
                System.out.println("");
                System.out.println("Pancakes are sorted...!");
                break;                                          //stop sorting if sorted
            }
            
        }
        return panHead;
    }

    private PanCake getLargest(PanCake panHead, int bottomLimit) {      //getting the largest cake out of the stack
        PanCake tmp, largestCake;
        tmp = panHead;
        int max ;
        max = tmp.diameter;
        largestCake = tmp;
        
        for(int i=0;i<bottomLimit-1;i++){
            tmp = tmp.next;
            if(tmp.diameter>max){
                max = tmp.diameter;
                largestCake = tmp;
            }
        }

        return largestCake;
    }

    private PanCake bottomToTop(PanCake panHead,int positionToBreak) {      //flip the stack from the given point
        PanCake pointToBreak = getPosition(positionToBreak,panHead);        //return the node for given point
        PanCake tmp;
        tmp = panHead;
        if(tmp==pointToBreak){              //check for single element case 
            tmp.nextPrevFlip();
            //System.out.println("Maximum --> "+tmp.diameter);
        }else{
            tmp.nextPrevFlip();                     //changing the next previous addresses of given node
            while(tmp.previous!=pointToBreak){
                tmp = tmp.previous;
                tmp.nextPrevFlip();
            }
            //System.out.println("Maximum --> "+tmp.previous.diameter);
            
            tmp = tmp.previous;
            tmp.nextPrevFlip();                 //changing the next previous addresses of final node
            
            panHead.next = tmp.previous;            //connecting old head with breaking point
            if(tmp.previous!=null){                 //check for final node
                tmp.previous.previous = panHead;
                tmp.previous = null;
            }
            
            
            
            panHead = tmp;                  //making the new head
            
        }
        //forwardPrint(panHead);
        return panHead;
    }
    
    private PanCake getPosition(int index,PanCake head){        //given the index cake node is returned
    
        PanCake tmp = head;
        
         for(int i=0;i<index-1;i++){
             tmp = tmp.next;
         }
         
         return tmp;
    }

    private int getIndex(PanCake largestCake, PanCake panHead) {        //given the cake node index is returned
        
           PanCake tmp = panHead;
           int counter = 1;
           while(largestCake!=tmp){
               counter++;
               tmp = tmp.next;
           }
           
        return counter;
    }

    private boolean isSorted(PanCake head) {        //check whether the staack is sorted
        PanCake tmp = head;
        while(tmp.next!=null){
            if(tmp.diameter>tmp.next.diameter){
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }


}
