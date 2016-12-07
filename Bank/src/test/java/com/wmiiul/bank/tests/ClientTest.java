package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.wrongPeselNumberException;
import com.wmiiul.bank.pojo.Client;

public class ClientTest {

	private static Client client;

	@BeforeClass
	public static void initObjects() {
		client = new Client("Jacek", "Skoczylas", "94090608312");
	}

	@Test
	public void peselValidationTrue() {
		Client client2 = new Client("Jan", "Kowalski", "69032808354");
	}

	@Test(expected = wrongPeselNumberException.class)
	public void peselValidationFalse() {
		Client client2 = new Client("Jan", "Kowalski", "6903280835");
	}

	@Test(expected = wrongPeselNumberException.class)
	public void peselValidationFalse2() {
		Client client2 = new Client("Jan", "Kowalski", "690328083548");
	}

	@Test(expected = wrongPeselNumberException.class)
	public void peselValidationFalse3() {
		Client client2 = new Client("Jan", "Kowalski", "69032G08354");
	}

	@Test(expected = wrongPeselNumberException.class)
	public void peselValidationFalse4() {
		Client client2 = new Client("Jan", "Kowalski", "69032808364");
	}
	
	@Test
	public void firstNameTest() {
		assertEquals(client.getFirstName(), "Jacek");
	}

	@Test
	public void lastNameTest() {
		assertEquals(client.getLastName(), "Skoczylas");
	}

	@Test
	public void peselTest() {
		assertEquals(client.getPesel(), "94090608312");
	}

}
