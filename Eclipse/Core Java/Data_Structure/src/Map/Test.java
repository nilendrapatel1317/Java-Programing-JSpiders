package Map;

import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(7, "Thala");
		map.put(18, "Kinguuu");
		map.put(23, "Nilendra");
		map.put(2, "Nilofer");
		System.out.println(map.toString());
		
		
		
		for (Map.Entry<Integer,String> en : map.entrySet()) {
//			System.out.println(en);
			System.out.println(en.getKey()+" = "+en.getValue());
		}
	}
}
