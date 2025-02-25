package DS_Question;

public class EmailValid {
	public static void main(String[] args) {
		String email = "s@s.gf";
		if (isEmailValid(email)) {
			System.out.println("Valid Email !!");
		} else {
			System.out.println("Invalid Email !!");
		}
	}

	public static boolean isEmailValid(String email) {

		int length = 0;

		int atCount = 0;
		int dotCount = 0;

		boolean charBeforeAt = false;
		boolean charAfterAt = false;
		boolean dotAfterAt = false;
		boolean charAfterDot = false;

		char[] chars = email.toCharArray();

		for (char ch : chars) {
			length++;

			if (ch == '@') {
				atCount++;
				if (length > 1)
					charBeforeAt = true;
			}

			if (atCount == 1 && ch == '.') {
				dotCount++;
				dotAfterAt = true;
			}

			if (atCount == 1 && ch != '@' && ch != '.') {
				charAfterAt = true;
			}
			if (atCount == 1 && dotCount == 1 && ch != '@' && ch != '.') {
				charAfterDot = true;
			}

		}
		return (atCount == 1 && charBeforeAt && charAfterAt && dotAfterAt && charAfterDot);

	}
}
