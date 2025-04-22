package com.Entity.ManyToMany_Mapping.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private int age;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "std_sub", 
			inverseJoinColumns = @JoinColumn(name = "subjects_id") , 
			joinColumns = @JoinColumn(name="students_id"))
	private Set<Subjects> subjects = new HashSet<Subjects>() ;
	//KWDo9z

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(Subjects sub) {
		subjects.add(sub);
		sub.getStudents().add(this);
	}
	
	public void removeSubject(Subjects sub) {
		subjects.remove(sub);
		sub.getStudents().remove(this);
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", age=" + age + ", subjects=" + subjects + "]";
	}
	
	
	
	
}
