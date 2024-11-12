import java.util.*;

class A 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter some text:");
		String word = scanner.next(); // next() Reads a single token(word)
		System.out.println("You entered: " + word);
	}
}

class B
{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a line of text:");
		String line = scanner.nextLine(); // nextLine() Reads an entire line
		System.out.println("You entered: " + line);
	}
}
