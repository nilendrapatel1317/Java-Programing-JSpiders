package com.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.Bill;
import com.spring.services.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService billService;
	
	// Fetch All Bills
	@GetMapping("/findAll")
	public List<Bill> getAllBills() {
		return billService.getAllBills();
	}

	// Fetch Bill by ID
	@GetMapping("/find/{id}")
	public Optional<Bill> getAllBills(@PathVariable Long id) {
		return billService.getBillById(id);
	}
	
	// Add Bill
	@PostMapping("/add")
	public Bill addBill(@RequestBody Bill bill) {
		return billService.addBill(bill);
	}
	
	// Edit Bill by ID
	@PutMapping("/edit/{id}")
	public Bill updateBill(@PathVariable Long id, @RequestBody Bill bill) {
		
		return billService.updateBill(id,bill);
	}
	
	// Delete Bill
	@DeleteMapping("/delete/{id}")
	public String deleteBill(@PathVariable Long id) {
		return billService.deleteBillById(id);
	}

	// Delete All Bills
	@DeleteMapping("/deleteAll")
	public String deleteAllBill() {
		return billService.deleteAllBill();
	}
}

