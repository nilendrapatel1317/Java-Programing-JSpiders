package one_Dimenstional;

public class NumToWord {
	public static void pw(int num , String s) {
		String[] one = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" ,"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    String[] two = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    
	    if(num <=19) {
	    	System.out.println(one[num]);
	    }
	    else {
	    	System.out.println(two[num/10]+" "+ one[num%10]);
	    }
	    if(num != 0) {
	    	System.out.println(s);
	    }
	}
	
	
	public static void main(String[] args) {
		int num = 10325;
		pw(num/10000000, "Core");
		pw((num/100000)%100, "Lakhs");
		pw((num/1000)%100, "Thousand");
		pw((num/100)%10, "Hundred");
		pw(num%100, "");
	}
}
