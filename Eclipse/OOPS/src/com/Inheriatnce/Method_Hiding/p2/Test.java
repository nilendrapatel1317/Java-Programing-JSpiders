package com.Inheriatnce.Method_Hiding.p2;
class Animal{
	public void sound() {
		System.out.println("Animals Sound Method");
	}
	public static void makeSound() {
		System.out.println("Animal MakeSound method");
	}
}

class Dog extends Animal{
	public void sound() {
		System.out.println("Dog Sound");
	}
	public static void makeSound() {
		System.out.println("Dog MakeSound");
	}
}

public class Test {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.sound();
		
		Animal animal2 = new Dog();
		animal2.sound(); // sound() depend on instance(object) type
		
		Dog dog = new Dog();
		dog.sound();
		
		System.out.println();
		System.out.println("========================");
		System.out.println();
		
		Animal animal3 = new Animal();
		animal3.makeSound();
		
		Animal animal4 = new Dog();
		animal4.makeSound(); // makeSound() depend on reference return type
		
		Dog dog2 = new Dog();
		dog2.makeSound();
	}
}
