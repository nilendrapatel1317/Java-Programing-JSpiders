package com.Tester;

import java.util.ArrayList;
import java.util.List;

import com.Entity.ManyToOne_Mapping.Account;
import com.Entity.ManyToOne_Mapping.Bank;
import com.Service.Service;

public class ManyToOneTester {
	public static void main(String[] args) {
//		Bank bank1 = new Bank();
//		bank1.setName("SBI");
//		bank1.setLocation("Bengaluru");
//		
//		Account account1 = new Account();
//		account1.setAccountNumber(998878);
//		account1.setHolderName("Rahul");
//		account1.setBank(bank1);
//		
//		
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(account1);
//
//		bank1.setAccount(accounts);
//		
		Service service = new Service();
//		service.insertMTO(bank1);
//		System.out.println(bank1.toString());
		
		Bank bank = service.fetchMTO(1);
		if (bank != null) {
			System.out.println(bank);
		}else {
			System.out.println("Data not found !!");
		}
//		System.out.println(service.deleteMTO(bank));
		
	}
}
