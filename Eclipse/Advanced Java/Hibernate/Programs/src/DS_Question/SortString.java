package DS_Question;

import java.util.Arrays;
import java.util.Comparator;

public class SortString {
	public static void main(String[] args) {
		String[] strArr1 = {"Dog","Apple","Elephant","Cat","Banana","Dig"};
		Arrays.sort(strArr1);
		
		Arrays.sort(strArr1,new lenCom());
		System.out.println(Arrays.toString(strArr1));
	}
}

class lenCom implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return o1.length() - o2.length();
	}
	
}
