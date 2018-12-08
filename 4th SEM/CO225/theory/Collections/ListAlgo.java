// from asitha@ce.pdn.ac.lk 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListAlgo{
    public static void main(String[] arg) {
 	String[] a = {"ClubsA","SpadeK","HeartsQ","DiamondJ",
		      "Clubs10","Spade9","Hearts8","Diamond7",
		      "Clubs6","Spade5","Hearts4","Diamond3"};
	
	List<String> deck = new ArrayList<String>(Arrays.asList(a));
	System.out.println("Sort the Deck");
	Collections.sort(deck);
	System.out.println(deck);
	
	System.out.println("\nReverse the deck");
	Collections.reverse(deck);
	System.out.println(deck);
	
	System.out.println("\nShuffle the deck");
	Collections.shuffle(deck);
	System.out.println(deck);
	
	System.out.println("\nShuffle it again");
	Collections.shuffle(deck);
	System.out.println(deck);
    }
}
