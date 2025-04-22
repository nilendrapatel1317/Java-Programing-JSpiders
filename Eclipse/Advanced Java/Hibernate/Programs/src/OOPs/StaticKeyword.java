package OOPs;

public class StaticKeyword {
	static int i = 20;
	
	public static void main(String[] args) {
		int i = 30;
		System.out.println(i);
		System.out.println(StaticKeyword.i);
	}
	static void m1() {
//		System.out.println(this.i);
	}
}
