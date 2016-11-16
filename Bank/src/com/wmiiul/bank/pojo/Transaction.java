package com.wmiiul.bank.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {

	private String account;
	private double amount;
	private Date date;
	private String description;
	private int operationNumber;
	private TransactionEnum transactionType;

	public Transaction(TransactionEnum transactionType, String account, double amount, String description,
			int operationNumber) {
		this.account = account;
		this.amount = amount;
		this.date = new Date();
		this.description = description;
		this.operationNumber = operationNumber;
		this.transactionType = transactionType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(int operationNumber) {
		this.operationNumber = operationNumber;
	}

	public TransactionEnum getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionEnum transactionType) {
		this.transactionType = transactionType;
	}

	public String transactionInfo() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date).toString() + " Transakcja nr " + operationNumber + " - ";
	}

}
