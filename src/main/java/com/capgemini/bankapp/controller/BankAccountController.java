package com.capgemini.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.exceptions.LowBalanceException;
import com.capgemini.bankapp.service.BankAccountService;
@Controller
public class BankAccountController implements BankAccountService{
	@Autowired
	private BankAccountService bankAccountService;
	
	/*public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService=bankAccountService;
	}*/
	
	
	@Override
	public double getBalance(long accountId) {
		
		return bankAccountService.getBalance(accountId);
	}
	/*@Autowired
	private BankAccountController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}*/

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		return bankAccountService.withdraw(accountId, amount);
	}

	@Override
	public double deposit(long accountId, double amount) {
		return bankAccountService.deposit(accountId, amount);
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException {
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}
}
