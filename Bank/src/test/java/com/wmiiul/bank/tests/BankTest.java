package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.BankAccountNotExistException;
import com.wmiiul.bank.exceptions.WrongSwiftCodeException;
import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.Bank;
import com.wmiiul.bank.pojo.Client;

public class BankTest {

	private static Bank bank;
	private static Bank bank2;

	@BeforeClass
	public static void initObjects() {
		bank = new Bank("mBank", "Polska", "123123456456789");
		bank2 = new Bank("Eurobank", "Polska", "123456789000000");
		bank.addAccount("Konto osobiste", "Jacek", "Skoczylas", "94090608312");
	}

	@Test
	public void swiftCodeValidationTrue() {
		Bank ing = new Bank("ING", "Polska", "123456789012345");
	}

	@Test(expected = WrongSwiftCodeException.class)
	public void swiftCodeValidationFalse() {
		Bank ing = new Bank("ING", "Polska", "1234567890123456");
	}

	@Test(expected = WrongSwiftCodeException.class)
	public void swiftCodeValidationFalse2() {
		Bank ing = new Bank("ING", "Polska", "123R56789012345");
	}

	@Test
	public void accountNameTest() {
		assertEquals(bank.getName(), "mBank");
	}

	@Test
	public void countryTest() {
		assertEquals(bank.getCountry(), "Polska");
	}

	@Test
	public void swiftCodeTest() {
		assertEquals(bank.getSwift(), "123123456456789");
	}
	
	@Test
	public void accountNameChangeTest() {
		bank2.setName("Deutsche Bank");
		assertEquals(bank2.getName(), "Deutsche Bank");
	}

	@Test
	public void countryChangeTest() {
		bank2.setCountry("Niemcy");
		assertEquals(bank2.getCountry(), "Niemcy");
	}

	@Test
	public void swiftCodeChangeTest() {
		bank2.setSwift("123456789000001");
		assertEquals(bank2.getSwift(), "123456789000001");
	}

	@Test
	public void accountNumberPrefixTest() {
		assertEquals(bank.getAccountNumberPrefix(), "1000");
	}

	@Test
	public void accountNumberPrefixTest2() {
		assertEquals(bank2.getAccountNumberPrefix(), "1001");
	}
	
	@Test(expected = BankAccountNotExistException.class)
	public void findAccountFalse() {
		bank.findAccount("123123456456789");
	}
	
	@Test
	public void findAccountTrue() {
		Account account = bank.findAccount("100000000000001");
		assertEquals(account.getAccountNumber(), "100000000000001");
	}
	
	@Test
	public void findClientFalse() {
		Client client = bank.findClient("96061119854");
		assertEquals(client, null);
	}
	
	@Test
	public void findClientTrue() {
		Client client = bank.findClient("94090608312");
		assertEquals(client.getPesel(), "94090608312");
	}
	

}
