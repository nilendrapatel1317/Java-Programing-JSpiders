package com.spring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    private double totalAmount;
    private double paidAmount;
    private double remainingAmount;
    private boolean status;
    
    public String getId() {
		return id;
	}

	public void setId(String newId) {
		this.id = newId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", patientID=" + patient.getId() + ", totalAmount=" + totalAmount + ", paidAmount=" + paidAmount
				+ ", remainingAmount=" + remainingAmount + ", status=" + status + "]";
	}
	
	
   
}
