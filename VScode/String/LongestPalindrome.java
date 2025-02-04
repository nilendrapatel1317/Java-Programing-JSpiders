public class LongestPalindrome {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("aaaabbaa"));
  }
  public static String longestPalindrome(String s) {
		int max = 0;
		String longestStr = "";
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					String s1 = s.substring(i, j + 1);
					int lengthCount = s1.length();
					if (max < lengthCount) {
						max = lengthCount;
						longestStr = s1;
					}
				}
			}
		}
		return longestStr;
	}

	static boolean isPalindrome(String s, int start, int end) {
		s.toLowerCase();
		int i = start;
		int j = end;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}