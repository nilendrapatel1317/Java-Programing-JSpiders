package DS_Question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueString {
	public static void main(String[] args) {
		String[] strArr1 = {"Nilendra","Rahul","Nilendra","Pawan","Sunita"};
		String[] strArr2 = {"Sunita","Rahul","Archna","Pawan","Vikash"};
		
		Set<String> uniqueStrings = new HashSet<>();
		
		uniqueStrings.addAll(Arrays.asList(strArr1));
		uniqueStrings.addAll(Arrays.asList(strArr2));
		
		System.out.println(uniqueStrings);
	}
}
