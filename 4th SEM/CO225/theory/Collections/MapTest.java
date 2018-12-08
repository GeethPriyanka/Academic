// asithab@ce.pdn.ac.lk

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String,Integer> itemlist = new HashMap<>();
		
		itemlist.put("Shirts", 150);
		itemlist.put("Trousers", 67);
		itemlist.put("T-Shirts", 98);
		itemlist.put("Jeans", 34);
		itemlist.put("Shoes", 83);
		
		System.out.println("Total itemlist: " + itemlist.size());
		
		// Iterate over all itemlist, using the keySet method.
		for(String key: itemlist.keySet())
			System.out.println(key + " - " + itemlist.get(key));
		System.out.println();
		
		String searchKey = "Shirts";
		if(itemlist.containsKey(searchKey))
			System.out.println("Found total " + itemlist.get(searchKey) + " "
					+ searchKey + "\n");
		
		Integer newShoes = 12;
		System.out.println("Got " + newShoes + " shoes\n");
		itemlist.put("Shoes", itemlist.get("Shoes") + newShoes);
		
		// Iterate over all itemlist, using the EntrySet method.
		for (Entry<String,Integer> e : itemlist.entrySet())
		    System.out.println(e.getKey() + ": " + e.getValue());
		System.out.println();
		
		
		// Clear all values.
		itemlist.clear();
		System.out.println("After clear operation, size: " + itemlist.size()); 
	}
}