package com.Entity.OneToOne_Mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Engine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reference_key")
	@SequenceGenerator(name = "reference_key", initialValue = 101, allocationSize = 1)
//					   [ generator == name ] , initial value is 101, incremented by 1
	private int id;
	private String type;
	private int cc;

	@OneToOne(mappedBy = "engine")
	private Car car;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", type=" + type + ", cc=" + cc + ", car=" + car + "]";
	}

}
