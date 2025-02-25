package mock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mock_Q2 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).sorted((a, b) -> b - a)
				.collect(Collectors.toList());

		System.out.println(evenNumbers); // Output: [10, 8, 98, 32]
	}
}
