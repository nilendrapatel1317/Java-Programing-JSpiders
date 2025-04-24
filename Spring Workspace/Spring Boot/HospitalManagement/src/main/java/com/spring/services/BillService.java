package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.models.Bill;

public interface BillService {

	public List<Bill> getAllBills();

	public Optional<Bill> getBillById(Long id);

	public Bill addBill(Bill bill);

	public Bill updateBill(Long id, Bill bill);

	public String deleteBillById(Long id);

	public String deleteAllBill();
	
}
