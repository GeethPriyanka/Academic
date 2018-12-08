import java.util.*;

public class SetToList{
    public static void main(String[] arg) {
 	String[] a = {"ClubsA","SpadeK","HeartsQ","DiamondJ",
		      "Clubs10","Spade9","Hearts8","Diamond7",
		      "Clubs6","Spade5","Hearts4","Diamond3",
		      "Clubs6","Spade4", "Hearts6"};// broken: duplicates

	Set<String>tmp = new LinkedHashSet<String>(Arrays.asList(a));
	System.out.println("Deck: " + tmp);

	List<String> deck = new ArrayList<String>(tmp);

	System.out.println("the List: " + deck);
    }
}
