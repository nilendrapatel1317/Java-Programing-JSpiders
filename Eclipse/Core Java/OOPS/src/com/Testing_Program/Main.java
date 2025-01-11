package com.Testing_Program;
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // Overriding the equals() method for content comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    // Overriding the hashCode() method
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        System.out.println(p1.toString()); // Output: Person{name='Alice', age=30}
        System.out.println(p1.equals(p2)); // Output: true
        System.out.println(p1.hashCode()); // Output: a unique hash code
    }
}
