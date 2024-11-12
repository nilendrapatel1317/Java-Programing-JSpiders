class D 
{
	static int i ;
	static double d;
	static char c;
	static String s;
	static boolean b;
	public static void main(String[] args) 
	{
		System.out.println("Static value for int : " + D.i);
		System.out.println("Static value for double : " + D.d);
		System.out.println("Static value for char : " + D.c);
		System.out.println("Static value for String : " + D.s);
		System.out.println("Static value for boolean : " + D.b);
	}
}



/* Output:
Static value for int : 0
Static value for double : 0.0
Static value for char :
Static value for String : null
Static value for boolean : false
*/



/* 
-> Anybody can change the value of static varible and update it and use it from any method.
-> If value is not initial by developer then java will initialize the default value.

*/
