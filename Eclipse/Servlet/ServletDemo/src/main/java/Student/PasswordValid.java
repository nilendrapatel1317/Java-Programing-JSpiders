package Student;

public class PasswordValid {
	public static void main(String[] args) {
		String pwd = "Nile@123";

		if (isValidPassword(pwd)) {
			System.out.println("Valid Password");
		} else {
			System.out.println("Invalid Password");
		}
	}

	static boolean isValidPassword(String pwd) {
		int uc = 0, lc = 0, dc = 0, sc = 0;
		int length = 0;

		try {
			while (true) {
				char ch = (char) pwd.getBytes()[length];
				length++;

				if (ch >= 'A' && ch <= 'Z')
					uc++;
				else if (ch >= 'a' && ch <= 'z')
					lc++;
				else if (ch >= '0' && ch <= '9')
					dc++;
				else
					sc++;
			}
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}

		return (length == 8 && uc >= 1 && lc >= 1 && dc == 3 && sc >= 1);
	}

}

// Atleast 1 Capital Letter
// Atleast 1 Small Letter
// Atleast 1 Special Character
// total 3 digits
