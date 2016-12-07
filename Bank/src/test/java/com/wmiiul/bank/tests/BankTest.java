package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.wrongSwiftCodeException;
import com.wmiiul.bank.pojo.Bank;

public class BankTest {

	private static Bank bank;
	private static Bank bank2;

	@BeforeClass
	public static void initObjects() {
		bank = new Bank("mBank", "Polska", "123123456456789");
		bank2 = new Bank("Eurobank", "Polska", "123456789000000");
	}

	@Test
	public void swiftCodeValidationTrue() {
		Bank ing = new Bank("ING", "Polska", "123456789012345");
	}

	@Test(expected = wrongSwiftCodeException.class)
	public void swiftCodeValidationFalse() {
		Bank ing = new Bank("ING", "Polska", "1234567890123456");
	}

	@Test(expected = wrongSwiftCodeException.class)
	public void swiftCodeValidationFalse2() {
		Bank ing = new Bank("ING", "Polska", "123R567890123456");
	}

	@Test
	public void accountNumberTest() {
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
	public void accountNumberPrefixTest() {
		assertEquals(bank.getAccountNumberPrefix(), "1000");
	}

	@Test
	public void accountNumberPrefixTest2() {
		assertEquals(bank2.getAccountNumberPrefix(), "1001");
	}

}
