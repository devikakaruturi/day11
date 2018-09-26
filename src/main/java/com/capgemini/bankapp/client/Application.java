package com.capgemini.bankapp.client;

import java.sql.DriverManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.exceptions.LowBalanceException;

public class Application {
//	DriverManager
	
	public static void main(String[] args) throws LowBalanceException {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController= context.getBean("bankAccountController",BankAccountController.class);
		
		System.out.println(bankAccountController.getBalance(1234));
		//System.out.println(bankAccountController.deposit(2343, 100));
		//System.out.println(bankAccountController.withdraw(2343, 50));
		//System.out.println(bankAccountController.fundTransfer(2343, 1234, 100));
//		JdbcTemplate
	}

}
