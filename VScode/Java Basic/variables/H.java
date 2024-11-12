class H 
{
	public static void m1() 
	{
		System.out.println("Static m1() method is executed");
	}
	public void m2(){
		System.out.println("Non-static m2() method is executed");
	}
}

class I
{
	public static void main(String[] args){
		H.m1(); // calling static method
		
		H h1 = new H();
		h1.m2(); // calling non-ststic meth
	}
}
