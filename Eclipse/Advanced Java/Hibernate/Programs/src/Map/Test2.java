package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test2 {
	public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Java");
        hashMap.put(3, "C++");
        hashMap.put(2, "Python");
        System.out.println("HashMap: " + hashMap); // Unordered
        
        for (Map.Entry<Integer,String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}

//        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(hashMap);
//        System.out.println("LinkedHashMap: " + linkedHashMap); // Insertion order
//
//        Map<Integer, String> treeMap = new TreeMap<>(hashMap);
//        System.out.println("TreeMap: " + treeMap); // Sorted order
    }
	
	
}
