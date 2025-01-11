package two_Dimenstional;

public class Spral_Number {
	public static void main(String[] args) {
		int[][] a = spiral(5);

		for (int[] temp : a) {
			for (int n : temp) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] spiral(int size) {
		int[][] a = new int[size][size];

		int len = a.length - 1;

		int r = 0;
		int c = -1;

		int dir = 'r';
		for (int i = 0; i < size * size; i++) {

			switch (dir) {
			case 'r':
				c++;
				a[r][c] = i + 1;
				if (c > len - 1 || a[r][c+1] != 0)
					dir = 'd';
				break;

			case 'd':
				r++;
				a[r][c] = i + 1;
				if (r > len - 1 || a[r+1][c] != 0)
					dir = 'l';
				break;

			case 'l':
				c--;
				a[r][c] = i + 1;
				if (c == 0 || a[r][c-1] != 0)
					dir = 'u';
				break;
			
			case 'u':
				r--;
				a[r][c] = i+1;
				if(a[r-1][c] != 0) dir='r';
				break;
				

			default:
				break;
			}

		}

		return a;
	}
}
