package com.wmiiul.bank;

import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.Bank;
import com.wmiiul.bank.pojo.transactions.TransactionEnum;

public class Main {

	public static void main(String[] args) {

		Bank ing = new Bank("ING", "Polska", "123456789012345");
		Bank ubs = new Bank("UBS", "Szwajcaria", "123451234512345");

		ing.addAccount("Konto osobiste", "Jacek", "Skoczylas", "94090608312");
		ing.addAccount("Konto firmowe", "Jan", "Kowalski", "69032808354");
		ubs.addAccount("Konto osobiste", "Hans", "Guttman", "94082210699");
		
		Account jacek = ing.findAccount("100000000000001");
		jacek.setBalance(800);
		Account jan = ing.findAccount("100000000000002");
		jan.setBalance(900);
		Account hans = ubs.findAccount("100100000000001");
		hans.setBalance(500);

		jan.doTransaction(TransactionEnum.CHECK, "100000000000001", 800.0, "Zaplata za monitor");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "100000000000002", 800.0, "Zaplata za monitor");

		jacek.doTransaction(TransactionEnum.CHECK, "100000000000002", 450.0, "Zaplata za telefon");
		jan.doTransaction(TransactionEnum.DEPOSIT, "100000000000001", 450.0, "Zaplata za telefon");

		jan.doTransaction(TransactionEnum.CHECK, "100000000000001", 300.0, "Zaplata za klawiature");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "100000000000002", 300.0, "Zaplata za klawiature");

		jacek.doTransaction(TransactionEnum.CHECK, "100000000000002", 160.0, "Rekompensata za pomoc");
		jan.doTransaction(TransactionEnum.DEPOSIT, "100000000000001", 160.0, "Rekompensata za pomoc");

		hans.doTransaction(TransactionEnum.WIREOUT, "100000000000001", 100.0, "Payment for keyboard",
				"Polska", "ABCDEFGH");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "100100000000001", 100.0, "Payment for keyboard");

		jacek.doTransaction(TransactionEnum.WIREOUT, "100100000000001", 200.0, "Payment for printer",
				"Szwajcaria", "ABCVWXYZ");
		hans.doTransaction(TransactionEnum.DEPOSIT, "100000000000001", 200.0, "Payment for printer");

		hans.doTransaction(TransactionEnum.WIREOUT, "100000000000001", 300.0, "Payment for computer game",
				"Polska", "ABCDEFGH");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "100100000000001", 300.0, "Payment for computer game");

		jacek.amountInfo();
		jan.amountInfo();
		hans.amountInfo();

		jacek.showTransactions();
		hans.showTransactions();
	}
}
