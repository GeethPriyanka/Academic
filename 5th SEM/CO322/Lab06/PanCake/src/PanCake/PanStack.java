/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PanCake;

/**
 *
 * @author Geeth
 */
class PanStack {

    public PanStack(int size) {
        
        PanCake tmpNext;
        PanCake panTail;
        PanCake panHead = new PanCake();
        PanCake sortedHead;
        tmpNext = panHead;
        tmpNext.previous = null;
        for(int i=0;i<size-1;i++){
            PanCake pan1 = new PanCake();
            tmpNext.next = pan1;
            pan1.previous = tmpNext;
            tmpNext = pan1;
        }
        tmpNext.next = null;
        panTail = tmpNext;
        
        forwardPrint(panHead);
        System.out.println("--------------");
        //backwardPrint(panTail);
        sortedHead = sortPanStack(panHead,size);
        
    }

    private void forwardPrint(PanCake panHead) {
        //////forward printing
        PanCake tmp;
        tmp = panHead;
        System.out.println(tmp.diameter);
        do{
            tmp = tmp.next;
            System.out.println(tmp.diameter);
            
        }while(tmp.next!=null);
    }

    private void backwardPrint(PanCake panTail) {
        //////backward printing
        PanCake tmp;
        tmp = panTail;
        System.out.println(tmp.diameter);
        do{
            tmp = tmp.previous;
            System.out.println(tmp.diameter);
            
        }while(tmp.previous!=null);
    }

    private PanCake sortPanStack(PanCake panHead, int size) {
        
        PanCake largestCake,tmpHead,largestToTopHead;
        int index;
        
//        largestCake = getLargest(panHead,2);
//        System.out.println("----------> "+getIndex(largestCake,panHead));
//        panHead = bottomToTop(panHead,4);
        tmpHead = panHead;
        for(int i=0;i<size;i++){
            largestCake = getLargest(tmpHead,size-i);
            
            index = getIndex(largestCake,tmpHead);
            if(index != size-i){
                if(index!=1){
                    tmpHead = bottomToTop(tmpHead,index);
                    System.out.println("Flip from Cake number "+index);

                }
                if(size-i!=1){
                    tmpHead = bottomToTop(tmpHead,size-i);
                    System.out.println("Flip from cake number "+(size-i));
                }
            }
            if(isSorted(tmpHead)){
                break;
            }
            
        }
        return panHead;
    }

    private PanCake getLargest(PanCake panHead, int bottomLimit) {
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

    private PanCake bottomToTop(PanCake panHead,int positionToBreak) {
        PanCake pointToBreak = getPosition(positionToBreak,panHead);
        PanCake tmp;
        tmp = panHead;
        if(tmp==pointToBreak){
            tmp.nextPrevFlip();
            //System.out.println("Maximum --> "+tmp.diameter);
        }else{
            tmp.nextPrevFlip();
            while(tmp.previous!=pointToBreak){
                tmp = tmp.previous;
                tmp.nextPrevFlip();
            }
            //System.out.println("Maximum --> "+tmp.previous.diameter);
            
            tmp = tmp.previous;
            tmp.nextPrevFlip();
            
            panHead.next = tmp.previous;
            if(tmp.previous!=null){
                tmp.previous.previous = panHead;
                tmp.previous = null;
            }
            
            
            
            panHead = tmp;
            
        }
        //forwardPrint(panHead);
        return panHead;
    }
    
    private PanCake getPosition(int index,PanCake head){
    
        PanCake tmp = head;
        
         for(int i=0;i<index-1;i++){
             tmp = tmp.next;
         }
         
         return tmp;
    }

    private int getIndex(PanCake largestCake, PanCake panHead) {
        
           PanCake tmp = panHead;
           int counter = 1;
           while(largestCake!=tmp){
               counter++;
               tmp = tmp.next;
           }
           
        return counter;
    }

    private boolean isSorted(PanCake head) {
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
