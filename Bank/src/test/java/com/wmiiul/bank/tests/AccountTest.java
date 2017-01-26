package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.noEnoughFundsException;
import com.wmiiul.bank.exceptions.wrongSwiftCodeException;
import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.Bank;
import com.wmiiul.bank.pojo.Client;
import com.wmiiul.bank.pojo.transactions.TransactionEnum;

public class AccountTest {

	
	private static Account account;
	private static Account account2;
	private static Account account3;
	private static Client mockedClient = EasyMock.createMock(Client.class);
	private static Client mockedClient2 = EasyMock.createMock(Client.class);
	private static Client mockedClient3 = EasyMock.createMock(Client.class);

	@BeforeClass
	public static void initObjects() {
		EasyMock.expect(mockedClient.getFirstName()).andReturn("Jacek");
		EasyMock.expect(mockedClient.getLastName()).andReturn("Skoczylas");
		EasyMock.expect(mockedClient.getWireOutValue()).andReturn(0);
		EasyMock.replay(mockedClient);
		EasyMock.expect(mockedClient2.getFirstName()).andReturn("Jakub");
		EasyMock.expect(mockedClient2.getLastName()).andReturn("Nowak");
		EasyMock.replay(mockedClient2);
		EasyMock.expect(mockedClient3.getFirstName()).andReturn("Artur");
		EasyMock.expect(mockedClient3.getLastName()).andReturn("Kowalski");
		EasyMock.replay(mockedClient3);
		account = new Account("100000000000002", "Konto osobiste", "mBank", mockedClient);
		account2 = new Account("100000000000003", "Konto firmowe", "mBank", mockedClient2);
		account3 = new Account("100000000000004", "Konto osobiste", "mBank", mockedClient3);
		
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
		account.doTransaction(TransactionEnum.WIREOUT, "100100000000001", 200.0, "Operation 2",
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
