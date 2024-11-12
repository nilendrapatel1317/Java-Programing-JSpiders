class F 
{
	public void main(String[] args) 
	{
		System.out.println("Non Static method is executed");
	}
}

class G
{
	public static void main(String[] args){
		F f1 = new F();
		f1.main(null);
	}
}