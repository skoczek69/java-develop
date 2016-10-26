package com.wmiiul.bank;

import org.apache.log4j.Logger;

import com.wmiiul.bank.dao.Bank;
import com.wmiiul.bank.pojo.Account;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		Bank ing = new Bank("ING","Polska","ABCDEFGH");
		Bank ubs = new Bank("UBS","Szwajcaria","ABCDEFGH");
		
		ing.addAccount("12345678901234567890123456", "Konto osobiste", "Jacek", "Skoczylas", "94090608312");
		ing.addAccount("11223344556677889900112233", "Konto firmowe", "Jan", "Kowalski", "69032808354");
		ubs.addAccount("54671588785761997433549765", "Konto osobiste", "Hans", "Guttman", "89110204333");
		
		Account jacek = ing.findAccount("12345678901234567890123456");
		Account jan = ing.findAccount("11223344556677889900112233");
		Account hans = ubs.findAccount("54671588785761997433549765");
		
		jan.doTransaction("CHECK", 800.0, "Pensja");
		jacek.doTransaction("DEPOSIT", 800.0, "Pensja");
		
		jacek.doTransaction("CHECK", 450.0, "Pensja");
		jan.doTransaction("DEPOSIT", 450.0, "Pensja");
		
		jan.doTransaction("CHECK", 300.0, "Pensja");
		jacek.doTransaction("DEPOSIT", 300.0, "Pensja");
		
		jacek.doTransaction("CHECK", 160.0, "Pensja");
		jan.doTransaction("DEPOSIT", 160.0, "Pensja");
		
		hans.doTransaction("WIPEOUT", 100.0, "Pensja");
		jacek.doTransaction("DEPOSIT", 100.0, "Pensja");
		
		hans.doTransaction("WIPEOUT", 200.0, "Pensja");
		jacek.doTransaction("DEPOSIT", 200.0, "Pensja");
		
		hans.doTransaction("WIPEOUT", 300.0, "Pensja");
		jacek.doTransaction("DEPOSIT", 300.0, "Pensja");
		
		jacek.amountInfo();
		jan.amountInfo();
		hans.amountInfo();
		
//		Account account = new Account("12345678902345", "Konto osobiste", "ING", "Jan Nowak");
		
//		DaoFactory df = DaoFactory.getInstance();
//		df.setSource(EDaoFactory.DB);
//		logger.trace(df.getPersonByID(10).toString());
//		df.setSource(EDaoFactory.WS);
//		logger.trace(df.getPersonByID(10).toString());
//		df.setSource(EDaoFactory.XML);
//		logger.trace(df.getPersonByID(10).toString());
//		logger.info("Number of persons : "+Person.getCount());
	}
}
