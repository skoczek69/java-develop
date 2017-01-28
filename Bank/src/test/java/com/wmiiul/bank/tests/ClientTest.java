package com.wmiiul.bank.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wmiiul.bank.exceptions.WrongPeselNumberException;
import com.wmiiul.bank.pojo.Client;

public class ClientTest {

	private static Client client;
	private static Client client2;

	@BeforeClass
	public static void initObjects() {
		client = new Client("Jacek", "Skoczylas", "94090608312");
		client2 = new Client("Marek", "Kowalski", "96061119854");
	}

	@Test
	public void peselValidationTrue() {
		Client client3 = new Client("Jan", "Kowalski", "69032808354");
	}

	@Test(expected = WrongPeselNumberException.class)
	public void peselValidationFalse() {
		Client client3 = new Client("Jan", "Kowalski", "6903280835");
	}

	@Test(expected = WrongPeselNumberException.class)
	public void peselValidationFalse2() {
		Client client3 = new Client("Jan", "Kowalski", "690328083548");
	}

	@Test(expected = WrongPeselNumberException.class)
	public void peselValidationFalse3() {
		Client client3 = new Client("Jan", "Kowalski", "69032G08354");
	}

	@Test(expected = WrongPeselNumberException.class)
	public void peselValidationFalse4() {
		Client client3 = new Client("Jan", "Kowalski", "69032808364");
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
	
	@Test
	public void firstNameChangeTest() {
		client2.setFirstName("Magda");
		assertEquals(client2.getFirstName(), "Magda");
	}

	@Test
	public void lastNameChangeTest() {
		client2.setLastName("Nowak");
		assertEquals(client2.getLastName(), "Nowak");
	}

	@Test
	public void peselChangeTest() {
		client2.setPesel("96061115348");
		assertEquals(client2.getPesel(), "96061115348");
	}

}
