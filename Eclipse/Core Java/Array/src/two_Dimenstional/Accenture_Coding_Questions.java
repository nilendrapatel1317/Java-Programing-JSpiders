package two_Dimenstional;

public class Accenture_Coding_Questions {
	public static void main(String[] args) {
//		int[] a = { 2, 8, 3, 5, 1 };
//		int result = p1(7, 2, a, a.length);
//		int result1 = solve(7, 2, a, a.length);
//		System.out.println(result);
//		System.out.println(result1);

		String string = "0C1A1B1C1C1B0A0";
		System.out.println(operationsBinaryString(string));

	}

	public static int p1(int r, int unit, int[] arr, int n) {
		if (n <= 0)
			return -1;

		int total = r * unit;
		int count = 0;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			count++;
			if (sum >= total)
				break;
		}
		if (total > sum)
			return 0;

		return count;
	}

	public static int solve(int r, int unit, int arr[], int n) {
		if (arr == null)
			return -1;
		int res = r * unit;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			count++;
			if (sum >= res)
				break;
		}
		if (sum < res)
			return 0;
		return count;
	}

	public static int operationsBinaryString (String str)
	  {
	    if (str == null)
	      return -1;
	    int res = str.charAt (0) - '0';
	    for (int i = 1; i < str.length ();)
	      {
		char prev = str.charAt (i);
		  i++;
		if (prev == 'A')
		  res = res & (str.charAt (i) - '0');
		else if (prev == 'B')
		  res = res | (str.charAt (i) - '0');
		else
		    res = res ^ (str.charAt (i) - '0');
		  i++;
	      }
	    return res;
	  }

}
