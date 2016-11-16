package com.wmiiul.StringBuffer;

import org.apache.log4j.Logger;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		StringBuffer string = new StringBuffer("Jeden");
		StringBuffer string2 = new StringBuffer("Dwa");
		string.append(" ");
		string.append(string2);
		logger.info(string.toString());
		string.appendCodePoint(64);
		logger.info(string.toString());
		logger.info(string.capacity());
		logger.info(string.charAt(9));
		logger.info(string.codePointAt(9));
		logger.info(string.codePointBefore(9));
		logger.info(string.codePointCount(0, 9));
		string.delete(5, 1000);
		logger.info(string);
		string.deleteCharAt(0);
		logger.info(string);
		string.ensureCapacity(60);
		logger.info(string.capacity());
		char[] charTable = new char[2];
		string.getChars(1, 3, charTable, 0);
		string.append("ascie");
		logger.info(string.toString());
		logger.info(string.indexOf("as"));
		string.insert(0, "J");
		logger.info(string);
		logger.info(string.lastIndexOf("e"));
		logger.info(string.length());
		logger.info(string.capacity());
		logger.info(string.offsetByCodePoints(1, 3));
		string.replace(0, 4, "Czter");
		logger.info(string);
		string.reverse();
		logger.info(string);
		string.reverse();
		string.setCharAt(4, '4');
		logger.info(string);
		string.setLength(7);
		logger.info(string);
		logger.info(string.subSequence(0, 3));
		logger.info(string.substring(3));
		logger.info(string.capacity());
		string.trimToSize();
		logger.info(string.capacity());

	}

}
