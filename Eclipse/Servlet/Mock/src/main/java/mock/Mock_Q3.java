package mock;

interface Calculator {
	double calculate(double a, double b);
	public static Calculator getDefault() {
		return (a,b)->a+b;
	}
}


public class Mock_Q3 {
	public static void main(String[] args) {
		Calculator addCal = Calculator.getDefault();
		double sum = addCal.calculate(5, 3);
		System.out.println("Addition of Two number is :"+sum);

		Calculator multiply = (a,b)->a*b;
		double multi = multiply.calculate(5, 3);
		System.out.println("Multiplication of Two number is :"+multi);
		
		
	}
}
