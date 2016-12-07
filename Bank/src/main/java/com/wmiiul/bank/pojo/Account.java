package com.wmiiul.bank.pojo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wmiiul.bank.exceptions.noEnoughFundsException;
import com.wmiiul.bank.exceptions.wrongOperationTypeException;
import com.wmiiul.bank.pojo.transactions.Check;
import com.wmiiul.bank.pojo.transactions.Deposit;
import com.wmiiul.bank.pojo.transactions.Transaction;
import com.wmiiul.bank.pojo.transactions.TransactionEnum;
import com.wmiiul.bank.pojo.transactions.Wireout;

public class Account {

	private static Logger logger = Logger.getLogger(Account.class.getName());

	private String accountNumber;
	private String description;
	private String bankName;
	private String country;
	private String swift;
	private Client client;
	private double balance = 0;
	private int checkCounter = 99;
	private int depositCounter = 9999;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String accountNumber, String description, String bankName, String country, String swift,
			Client client) {
		this.accountNumber = accountNumber;
		this.description = description;
		this.bankName = bankName;
		this.country = country;
		this.swift = swift;
		this.client = client;
		logger.info("Utworzono nowe konto w banku: " + bankName + ", o numerze: " + accountNumber + ", dla klienta: "
				+ client.getFirstName() + " " + client.getLastName());
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int checkValue() {
		checkCounter++;
		return checkCounter;
	}

	public int depositValue() {
		depositCounter++;
		return depositCounter;
	}

	public void doTransaction(TransactionEnum transactionType, String accountNumber, double amount,
			String description) {
		switch (transactionType) {
		case CHECK:
			substractFunds(amount);
			Check check = new Check(transactionType, accountNumber, amount, description, checkValue());
			transactions.add(check);
			break;
		case DEPOSIT:
			addFunds(amount);
			Deposit deposit = new Deposit(transactionType, accountNumber, amount, description, depositValue());
			transactions.add(deposit);
			break;
		default:
			throw new wrongOperationTypeException();

		}
	}

	public void doTransaction(TransactionEnum transactionType, String accountNumber, double amount, String description,
			String country, String swift) {
		switch (transactionType) {
		case WIREOUT:
			substractFunds(amount);
			Wireout wipeout = new Wireout(transactionType, accountNumber, amount, description, client.getWireOutValue(),
					country, swift);
			transactions.add(wipeout);
			break;
		default:
			throw new wrongOperationTypeException();
		}
	}

	private void addFunds(Double amount) {
		balance += amount;
	}

	private void substractFunds(Double amount) {
		if (balance < amount) {
			throw new noEnoughFundsException();
		}
		balance -= amount;
	}

	public void amountInfo() {
		logger.info("Stan konta o numerze: " + accountNumber + ", wynosi: " + balance + " zl");
	}

	public void showTransactions() {
		logger.info("Lista transakcji dla konta o numerze: " + getAccountNumber());
		for (Transaction transaction : transactions) {
			switch (transaction.getTransactionType()) {
			case CHECK:
				logger.info(((Check) transaction).transactionInfo());
				break;
			case DEPOSIT:
				logger.info(((Deposit) transaction).transactionInfo());
				break;
			case WIREOUT:
				logger.info(((Wireout) transaction).transactionInfo());
				break;
			}
		}
	}
}
