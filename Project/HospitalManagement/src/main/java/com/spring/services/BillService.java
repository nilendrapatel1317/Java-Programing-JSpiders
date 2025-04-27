package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.models.Bill;

public interface BillService {

	public List<Bill> getAllBills();

	public Optional<Bill> getBillById(String id);

	public Bill addBill(Bill bill);

	public Bill updateBill(String id, Bill bill);
	
	public String deleteBillById(String id);

	public String deleteAllBill();
	
}
