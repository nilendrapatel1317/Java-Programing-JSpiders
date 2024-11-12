class A {
	public static void main(String[] args) {
		int a = 10;
		Integer b = 20;
		m1(a,b);
		m1(b,a);
		m2(a);
	}

	public static void m1(Integer a, int b) {
		System.out.println(a,valueOf(b));
	}

	public static void m1(int a, Integer b) {
		System.out.println(a);
	}

	public static int m2(int a) {
		return  a;
	}

}
