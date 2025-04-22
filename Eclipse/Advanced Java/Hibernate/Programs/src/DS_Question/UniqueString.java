package DS_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueString {
	public static void main(String[] args) {
		String[] strArr1 = {"Nilendra","Rahul","Nilendra","Pawan","Sunita"};
		String[] strArr2 = {"Sunita","Rahul","Archna","Pawan","Vikash"};
		
		by_using_set(strArr1, strArr2);
		
		by_using_list(strArr1,strArr2);
	}

	private static void by_using_list(String[] strArr1, String[] strArr2) {
		List<String> uniqueStrings = new ArrayList<String>();
		for (String string : strArr1) {
			if(!uniqueStrings.contains(string)) {
				uniqueStrings.add(string);
			}
		}
		for (String string : strArr2) {
			if(!uniqueStrings.contains(string)) {
				uniqueStrings.add(string);
			}
		}
		System.out.println(uniqueStrings);
	}

	private static void by_using_set(String[] strArr1, String[] strArr2) {
		Set<String> uniqueStrings = new HashSet<>();
		
		uniqueStrings.addAll(Arrays.asList(strArr1));
		uniqueStrings.addAll(Arrays.asList(strArr2));
		
		System.out.println(uniqueStrings);
	}
}
