package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Bill;
import com.spring.models.Doctor;
import com.spring.models.Patient;
import com.spring.repositories.BillRepository;
import com.spring.repositories.DoctorRepository;
import com.spring.repositories.PatientRepository;
import com.spring.services.BillService;

@Service
public class BillServiceImplementation implements BillService {

	private final DoctorRepository doctorRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private PatientRepository patientRepository;

	BillServiceImplementation(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	// Fetch All Bills
	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	// Fetch Bill by ID
	@Override
	public Optional<Bill> getBillById(Long id) {
		return billRepository.findById(id);
	}

	// Add Bill 
	@Override
	public Bill addBill(Bill bill) {
		try {
			if(bill.getTotalAmount() >= bill.getPaidAmount()) {
				// 1. Set Patient Object
				Patient patient = patientRepository.findById(bill.getPatient().getId())
						.orElseThrow(() -> new RuntimeException("Patient not found !!"));
				bill.setPatient(patient);
				
				// 2. set remaining amount
				bill.setRemainingAmount(bill.getTotalAmount() - bill.getPaidAmount());
				
				// 3. set status according to paid amount
				if(bill.getTotalAmount() == bill.getPaidAmount()) {
					bill.setStatus(true);
				}
				else {
					bill.setStatus(false);
				}
				
				return billRepository.save(bill);
			}
			else return null;
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Edit Bill by ID
	@Override
	public Bill updateBill(Long id, Bill updateBill) {
		try {
			if (billRepository.existsById(id)) {
				Bill existBill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found !!"));

				if (existBill.getRemainingAmount() >= 0 && existBill.getRemainingAmount() >= updateBill.getPaidAmount()) {
					existBill.setPaidAmount(existBill.getPaidAmount() + updateBill.getPaidAmount());
					existBill.setRemainingAmount(existBill.getRemainingAmount() - updateBill.getPaidAmount());
					if (existBill.getTotalAmount() <= existBill.getPaidAmount()) {
						existBill.setStatus(true);
					} else {
						existBill.setStatus(false);
					}
				}
				return billRepository.save(existBill);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Delete Bill by ID
	@Override
	public String deleteBillById(Long id) {
		try {
			if (billRepository.existsById(id)) {
				System.out.println(billRepository.existsById(id));
				billRepository.deleteById(id);
				return "Bill Deleted Successfully !!";
			} else {
				System.out.println(billRepository.existsById(id));
				return "Bill not deleted !!";
			}
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
			return e.getMessage();
		}
	}

	// Delete All Bills
	@Override
	public String deleteAllBill() {
		try {
			billRepository.deleteAll();
			return "All Bills Deleted Successfully !!";
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
			return e.getMessage();
		}
	}

}
