package DS_Question;

import java.util.HashMap;
import java.util.Map;

public class Occerance1 {
	public static void main(String[] args) {
		Map<Character, String> map = new HashMap<Character, String>();
		String s =  "banana";
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(!map.containsKey(ch)) {
				map.put(ch, i+"");
				System.out.println("1 " + map);
			}
			else {
				String res = map.get(ch);
				System.out.println("2 " + map);
				map.put(ch, res+","+i);
				System.out.println("3 " + map);
			}
		}
		System.out.println(map);
	}
}
