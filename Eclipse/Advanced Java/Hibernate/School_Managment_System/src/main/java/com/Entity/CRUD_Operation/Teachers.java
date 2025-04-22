package com.Entity.CRUD_Operation;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_key")
	@SequenceGenerator(name = "teacher_key", initialValue = 101, allocationSize = 1)
	private int id;
	private String name;
	private int salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private School school;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Teachers [id=" + id + ", name=" + name + ", salary=" + salary + ", school=" + school + "]";
	}
	
	
	
}
