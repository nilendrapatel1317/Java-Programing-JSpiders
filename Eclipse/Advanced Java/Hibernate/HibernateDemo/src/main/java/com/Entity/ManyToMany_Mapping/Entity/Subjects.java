package com.Entity.ManyToMany_Mapping.Entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_key" )
	@SequenceGenerator(name = "sub_key", initialValue = 201, allocationSize = 1)
	private int id;
	private String name;
	private int price;
	
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "subjects")
	private Set<Students> students = new HashSet<Students>();
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public Set<Students> getStudents() {
		return students;
	}



	public void setStudents(Set<Students> students) {
		this.students = students;
	}



	public void addStudents(Students std) {
		students.add(std);
		std.getSubjects().add(this);
	}
	
	public void removeStudent(Students std) {
		students.remove(std);
		std.getSubjects().remove(this);
	}



	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
