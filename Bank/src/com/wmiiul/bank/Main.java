package com.wmiiul.bank;

import com.wmiiul.bank.dao.Bank;
import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.TransactionEnum;

public class Main {

	public static void main(String[] args) {

		Bank ing = new Bank("ING", "Polska", "ABCDEFGH");
		Bank ubs = new Bank("UBS", "Szwajcaria", "ABCVWXYZ");

		ing.addAccount("12345678901234567890123456", "Konto osobiste", "Jacek", "Skoczylas", "94090608312");
		ing.addAccount("11223344556677889900112233", "Konto firmowe", "Jan", "Kowalski", "69032808354");
		ubs.addAccount("54671588785761997433549765", "Konto osobiste", "Hans", "Guttman", "89110204333");

		Account jacek = ing.findAccount("12345678901234567890123456");
		Account jan = ing.findAccount("11223344556677889900112233");
		Account hans = ubs.findAccount("54671588785761997433549765");

		jan.doTransaction(TransactionEnum.CHECK, "12345678901234567890123456", 800.0, "Zaplata za monitor");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "11223344556677889900112233", 800.0, "Zaplata za monitor");

		jacek.doTransaction(TransactionEnum.CHECK, "11223344556677889900112233", 450.0, "Zaplata za telefon");
		jan.doTransaction(TransactionEnum.DEPOSIT, "12345678901234567890123456", 450.0, "Zaplata za telefon");

		jan.doTransaction(TransactionEnum.CHECK, "12345678901234567890123456", 300.0, "Zaplata za klawiature");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "11223344556677889900112233", 300.0, "Zaplata za klawiature");

		jacek.doTransaction(TransactionEnum.CHECK, "11223344556677889900112233", 160.0, "Rekompensata za pomoc");
		jan.doTransaction(TransactionEnum.DEPOSIT, "12345678901234567890123456", 160.0, "Rekompensata za pomoc");

		hans.doTransaction(TransactionEnum.WIREOUT, "12345678901234567890123456", 100.0, "Payment for keyboard", "Polska",
				"ABCDEFGH");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "54671588785761997433549765", 100.0, "Payment for keyboard");

		jacek.doTransaction(TransactionEnum.WIREOUT, "54671588785761997433549765", 200.0, "Payment for printer", "Szwajcaria",
				"ABCVWXYZ");
		hans.doTransaction(TransactionEnum.DEPOSIT, "12345678901234567890123456", 200.0, "Payment for printer");

		hans.doTransaction(TransactionEnum.WIREOUT, "12345678901234567890123456", 300.0, "Payment for computer game", "Polska",
				"ABCDEFGH");
		jacek.doTransaction(TransactionEnum.DEPOSIT, "54671588785761997433549765", 300.0, "Payment for computer game");

		jacek.amountInfo();
		jan.amountInfo();
		hans.amountInfo();

		jacek.showTransactions();
		hans.showTransactions();
	}
}
