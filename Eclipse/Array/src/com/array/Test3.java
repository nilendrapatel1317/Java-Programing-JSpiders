package com.array;

class Circle {
int radius ;
	
	Circle(int r){
		radius = r;
	}
	
	public String toString() {
		return "Circle [ radius = "+radius+" ]";
	}
}

public class Test3 {
	public static void main(String[] args) {
		Circle[] arr = new Circle[5];
		arr[0] = new Circle(10);
		arr[1] = new Circle(20);
		arr[2] = new Circle(30);
		arr[3] = new Circle(40);
		arr[4] = new Circle(50);
		
		for (Circle c : arr) {
			System.out.println(c);
		}
	}
}
