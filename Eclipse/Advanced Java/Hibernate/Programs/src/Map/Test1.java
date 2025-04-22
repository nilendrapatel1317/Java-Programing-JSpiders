package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(null, "John");
		map.put(null, "Alice");
		map.put(103, "Bob");
		map.putIfAbsent(104, "Nilendra");
		
		System.out.println(map);

		// Get a value using key
		System.out.println("\nName with ID 102: " + map.get(104));

		// Check if a key exists
		System.out.println("\nContains key 105? " + map.containsKey(105));

		// Remove an entry
		map.remove(101);
		System.out.println("\nAfter removing 101: " + map);

		System.out.println();
		// Using forEach loop on entrySet()
		for (Map.Entry<Integer,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}

		System.out.println();
		// Using Java 8 forEach() method
		map.forEach((key, value) -> System.out.println(key + " -> " + value));

		// Check if a value exists
		System.out.println("\nContains value Nilendra? " + map.containsValue((Object)"John"));
		
		System.out.println(map);
//		map.clear();
		System.out.println(map);
		
		System.out.println();
		map.forEach((key,value)-> System.out.println(key + "->"+value));
		
		
		Set<Integer> keys = map.keySet(); // All keys
		Collection<String> values = map.values(); // All values
		Set<Map.Entry<Integer, String>> entries = map.entrySet(); // Key-value pairs

		System.out.println();
		System.out.println(map);
		System.out.println();
		System.out.println(keys);
		System.out.println();
		System.out.println(values);
		System.out.println();
		System.out.println(entries);
		System.out.println();
	

	}
}
