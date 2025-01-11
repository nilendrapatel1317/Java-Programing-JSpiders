package Java_8.Lambda_Expression;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Perfect_Number {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n = scn.nextInt();
		
		int sum = 0;
		
		Predicate<Integer> p = i -> n%i==0;
		
		for (int i = 1; i <= n/2; i++) {
			if(p.test(i)) {
				sum+=i;
			}
		}
		
		Function<Integer, Boolean> fn = i -> i==n;
		
		Consumer<Integer> c = i -> System.out.println(n+ (fn.apply(i) ? " is a perfect number" : " is not a perfect number"));
		
		c.accept(sum);
;	}
}
