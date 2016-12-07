package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.noEnoughFundsException;
import com.wmiiul.bank.exceptions.wrongSwiftCodeException;
import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.Bank;
import com.wmiiul.bank.pojo.transactions.TransactionEnum;

public class AccountTest {

	private static Bank bank;
	private static Bank bank2;
	private static Account account;
	private static Account account2;
	private static Account account3;

	@BeforeClass
	public static void initObjects() {
		bank = new Bank("mBank", "Polska", "123123456456789");
		bank.addAccount("Konto osobiste", "Jacek", "Skoczylas", "94090608312");
		bank.addAccount("Konto firmowe", "Jan", "Kowalski", "69032808354");
		bank.addAccount("Konto osobiste", "Hans", "Guttman", "94082210699");
		account = bank.findAccount("100000000000001");
		account2 = bank.findAccount("100000000000002");
		account3 = bank.findAccount("100000000000003");
		account.setBalance(1000);
		account.doTransaction(TransactionEnum.CHECK, "100000000000002", 300.0, "Check operation");
		account2.doTransaction(TransactionEnum.DEPOSIT, "100000000000001", 300.0, "Deposit operation");
	}
	
	@Test
	public void accountBalanceTest() {
		assertEquals(account2.getBalance(), 300.0, 0.01);
	}
	
	@Test
	public void accountBalanceTest1() {
		assertEquals(account3.getBalance(), 0.0, 0.01);
	}
	
	@Test
	public void operationTest() {
		account.doTransaction(TransactionEnum.CHECK, "100000000000002", 100.0, "Operation 1");
	}
	
	@Test
	public void operationTest2() {
		account.doTransaction(TransactionEnum.WIREOUT, "100100000000001", 200.0, "Payment for printer",
				"Szwajcaria", "ABCVWXYZ");
	}
	
	@Test
	public void operationTest3() {
		account.doTransaction(TransactionEnum.DEPOSIT, "100100000000001", 100.0, "Operation 3");
	}
	
	@Test(expected = noEnoughFundsException.class)
	public void operationTest4() {
		account.doTransaction(TransactionEnum.CHECK, "100000000000002", 1000.0, "Operation 4");
	}
}
