package com.mobile_java_project;

public class Mobile {
	private String name;
	private int ram;
	private int rom;
	private double price;
	private String color;
	
	public String getName() {
		return name;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	public double getPrice() {
		return price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Mobile(String name, int ram, int rom, double price, String color) {
		super();
		this.name = name;
		this.ram = ram;
		this.rom = rom;
		this.price = price;
		this.color = color;
	}
	
	public void display() {
		System.out.println("--------------");
		System.out.println("Mobile Details");
		System.out.println("--------------");
		System.out.println("-> Name  = "+ name);
		System.out.println("-> RAM   = "+ ram);
		System.out.println("-> ROM   = "+ rom);
		System.out.println("-> Price = "+ price);
		System.out.println("-> Color = "+ color);
	}
}
