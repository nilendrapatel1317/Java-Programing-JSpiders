package com.array;

class Animal{
	public Animal m1() {
		return new Animal();
	}
}
class Dog extends Animal{
	@Override
	public Dog m1() {
		return new Dog();
	}
}


public class Test6 {
	public static void main(String[] args) {
		Animal a=new Dog();
		System.out.println(a.m1());
	}
}
