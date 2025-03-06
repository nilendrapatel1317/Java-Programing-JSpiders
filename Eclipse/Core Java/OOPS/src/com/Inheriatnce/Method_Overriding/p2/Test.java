package com.Inheriatnce.Method_Overriding.p2;

class Animal{
	void sound() {
		System.out.println("Sound of Animal");
	}
}

class Dog extends Animal{
	@Override
	void sound() {
//		super.sound();
		System.out.println("Bow Bowwwwwww");
	}
}

class BabyDog extends Dog{
	@Override
	void sound() {
//		super.sound();
		System.out.println("Weeping........");
	}
}

class Cat extends Animal{
	@Override
	void sound() {
//		super.sound();
		System.out.println("Meowwwwww");
	}
}

public class Test {
	public static void main(String[] args) {
		Animal an1 = new Dog();
		an1.sound();
		
		Animal an2 = new BabyDog();
		an2.sound();
		
		Animal an3 = new Cat();
		an3.sound();
	}

}
