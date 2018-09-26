package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.database.DbUtil;
import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository{

	private HashSet<BankAccount> bankAccounts;
	@Autowired
	DbUtil dbutil;
	/*public BankAccountRepositoryImpl() {
		super();
		bankAccounts=new HashSet<>();
		bankAccounts.add(new BankAccount(1234,"John Doe","SAVINGS",34000));
		bankAccounts.add(new BankAccount(2343,"John Dhee","CURRENT",56000));
		bankAccounts.add(new BankAccount(3996,"Alex Browning","SAVINGS",89000));

	}*/

	@Override
	public double getBalance(long accountId) {
		String getBalance ="select accountbalance from springbankdata where accountId=?";
		/*for(BankAccount bankAccount: bankAccounts)
		{
			if(bankAccount.getAccountId()== accountId)
			{
				return bankAccount.getAccountBalance();
			}
		}
		return -1;*/
		try(Connection connection=dbutil.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(getBalance);) {
			preparedStatement.setInt(1,(int) accountId);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next())
			{
				return (double) result.getLong(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for(BankAccount bankAccount: bankAccounts)
		{
			if(bankAccount.getAccountId()== accountId)
			{
				 bankAccount.setAccountBalance(newBalance);
				 return true;
			}
		}
		return false;
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount upBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		// TODO Auto-generated method stub
		return false;
	}

}
