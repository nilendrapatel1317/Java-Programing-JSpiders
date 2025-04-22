package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortMapValues {
	public static void main(String[] args) {
//		sort_Map_By_Using_List();
		
//		sort_String_Array_By_Using_Map_List();
		
		sort_String_Array_By_Using_Only_List();
		
	}

	private static void sort_String_Array_By_Using_Only_List() {
		String[] strArr = {"Nilu", "Appu","Zepu","Lepu","Neelu","Aap","Nilt","Nilz"};
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strArr.length; i++) {
			list.add(strArr[i]);
		}
		System.out.println(list);
		Collections.sort(list); // Sort in ASC order
//		list.sort((a,b)-> a.compareTo(b)); // ASC : a.compareTo(b) || For DESC : b.compareTo(a)
		System.out.println(list);
	}

	private static void sort_String_Array_By_Using_Map_List() {
		String[] strArr = {"Nilu", "Appu","Zepu","Lepu","Neelu","Aap","Nilt","Nilz"};
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i = 0; i < strArr.length; i++) {
			map.put(i, strArr[i]);
		}
		
		List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
		list.sort((a,b) ->  a.getValue().compareTo(b.getValue()));
		
		for (Map.Entry<Integer, String> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
	}

	private static void sort_Map_By_Using_List() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "Nilu");
		map.put("B", "Lilu");
		map.put("C", "Pilu");
	
		
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
		
		list.sort((a,b) ->  a.getValue().compareTo(b.getValue()));
		
		for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
	}
}
