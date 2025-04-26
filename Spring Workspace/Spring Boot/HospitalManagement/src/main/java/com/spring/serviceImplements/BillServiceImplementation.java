package com.spring.serviceImplements;

import java.util.ArrayList;
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
	public Optional<Bill> getBillById(String id) {
		return billRepository.findById(id);
	}

	// Add Bill 
	@Override
	public Bill addBill(Bill bill) {
	    try {
	        // 1. Generate unique ID manually
	        bill.setId(generateID());

	        // 2. Validation: paidAmount should not exceed totalAmount
	        if (bill.getTotalAmount() < bill.getPaidAmount()) {
	            return null;
	        }

	        // 3. Fetch Patient from DB
	        String patientId = bill.getPatient().getId();
	        Patient patient = patientRepository.findById(patientId).orElse(null);
	        if (patient == null) return null;

	        // 4. Set patient in bill (owning side)
	        bill.setPatient(patient);

	        // 5. Set remaining amount and status
	        bill.setRemainingAmount(bill.getTotalAmount() - bill.getPaidAmount());
	        bill.setStatus(bill.getRemainingAmount() == 0);

	        // 6. Save bill first (avoid attaching unsaved bill to patient directly)
	        Bill savedBill = billRepository.save(bill);

	        // 7. Attach saved bill to patient side (inverse side), then save patient if needed
	        List<Bill> list = patient.getBills();
			list.add(bill);
			patient.setBills(list);

	        return savedBill;
	    } catch (Exception e) {
	        System.out.println("Error message: " + e.getMessage());
	        return null;
	    }
	}

	private String generateID() {
		String lastIdStr = billRepository.findLastId().orElse("BILL-100");
		int lastNum = Integer.parseInt(lastIdStr.split("-")[1]);
		String newId = "BILL-" + (lastNum + 1);
		return newId;
	}


	// Edit Bill by ID
	@Override
	public Bill updateBill(String id, Bill updateBill) {
		try {
			if (billRepository.existsById(id)) {
				Bill existBill = billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found !!"));

				if (existBill.getRemainingAmount() > 0) {
					existBill.setPaidAmount(existBill.getPaidAmount() + updateBill.getRemainingAmount());
					existBill.setRemainingAmount(existBill.getRemainingAmount() - updateBill.getRemainingAmount());
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
	public String deleteBillById(String id) {
	    Bill bill = billRepository.findById(id).orElse(null);
	    if (bill != null) {
	        billRepository.delete(bill);
	        return "Bill deleted successfully.";
	    }
	    return "Bill not found.";
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
