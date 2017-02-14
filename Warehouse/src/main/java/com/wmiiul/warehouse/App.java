package com.wmiiul.warehouse;

import org.apache.log4j.Logger;

import com.wmiiul.warehouse.pojo.EnumTypeOfPackage;
import com.wmiiul.warehouse.pojo.Package;
import com.wmiiul.warehouse.pojo.Warehouse;

public class App {
	private static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args){

		Warehouse warehouse = new Warehouse(4, 3, 5);
		Package pack = new Package(1, EnumTypeOfPackage.TOYS, "Opis", 1);
		warehouse.insertPackage(pack);
		Package pack2 = new Package(2, EnumTypeOfPackage.FURNITURES, "Opis", 2);
		warehouse.insertPackage(pack2);
		Package pack3 = new Package(3, EnumTypeOfPackage.FOODS, "Opis", 2);
		warehouse.insertPackage(pack3);
		Package pack4 = new Package(4, EnumTypeOfPackage.FOODS, "Opis", 1);
		warehouse.insertPackage(pack4);
		Package pack5 = new Package(5, EnumTypeOfPackage.CLOTHES, "Opis", 3);
		warehouse.insertPackage(pack5);
		Package pack6 = new Package(6, EnumTypeOfPackage.COMPUTER_PARTS, "Opis", 2);
		warehouse.insertPackage(pack6);
		Package pack7 = new Package(7, EnumTypeOfPackage.COMPUTER_PARTS, "Opis", 3);
		warehouse.insertPackage(pack7);
		Package pack8 = new Package(8, EnumTypeOfPackage.CAR_PARTS, "Opis", 1);
		warehouse.insertPackage(pack8);
		Package pack9 = new Package(9, EnumTypeOfPackage.COMPUTER_PARTS, "Opis", 1);
		warehouse.insertPackage(pack9);
		Package pack10 = new Package(10, EnumTypeOfPackage.CAR_PARTS, "Opis", 1);
		warehouse.insertPackage(pack10);
		Package pack11 = new Package(11, EnumTypeOfPackage.TOYS, "Opis", 1);
		warehouse.insertPackage(pack11);
		Package pack12 = new Package(12, EnumTypeOfPackage.CAR_PARTS, "Opis", 1);
		warehouse.insertPackage(pack12);
		Package pack13 = new Package(13, EnumTypeOfPackage.TOYS, "Opis", 1);
		warehouse.insertPackage(pack13);
		Package pack14 = new Package(14, EnumTypeOfPackage.CLOTHES, "Opis", 2);
		warehouse.insertPackage(pack14);
		Package pack15 = new Package(15, EnumTypeOfPackage.CLOTHES, "Opis", 3);
		warehouse.insertPackage(pack15);
		Package pack16 = new Package(16, EnumTypeOfPackage.COMPUTER_PARTS, "Opis", 2);
		warehouse.insertPackage(pack16);
		Package pack17 = new Package(17, EnumTypeOfPackage.FURNITURES, "Opis", 3);
		warehouse.insertPackage(pack17);
		Package pack18 = new Package(18, EnumTypeOfPackage.FURNITURES, "Opis", 2);
		warehouse.insertPackage(pack18);
		Package pack19 = new Package(19, EnumTypeOfPackage.FOODS, "Opis", 3);
		warehouse.insertPackage(pack19);
		Package pack20 = new Package(20, EnumTypeOfPackage.CAR_PARTS, "Opis", 2);
		warehouse.insertPackage(pack20);
		Package pack21 = new Package(21, EnumTypeOfPackage.CAR_PARTS, "Opis", 1);
		warehouse.insertPackage(pack21);
		Package pack22 = new Package(22, EnumTypeOfPackage.COMPUTER_PARTS, "Opis", 1);
		warehouse.insertPackage(pack22);
		Package pack23 = new Package(23, EnumTypeOfPackage.FOODS, "Opis", 2);
		warehouse.insertPackage(pack23);
		Package pack24 = new Package(24, EnumTypeOfPackage.FOODS, "Opis", 3);
		warehouse.insertPackage(pack24);
		Package pack25 = new Package(25, EnumTypeOfPackage.CAR_PARTS, "Opis", 3);
		warehouse.insertPackage(pack25);
		Package pack26 = new Package(26, EnumTypeOfPackage.TOYS, "Opis", 2);
		warehouse.insertPackage(pack26);
		Package pack27 = new Package(27, EnumTypeOfPackage.FURNITURES, "Opis", 1);
		warehouse.insertPackage(pack27);
		Package pack28 = new Package(28, EnumTypeOfPackage.TOYS, "Opis", 1);
		warehouse.insertPackage(pack28);
		Package pack29 = new Package(29, EnumTypeOfPackage.FOODS, "Opis", 2);
		warehouse.insertPackage(pack29);
		Package pack30 = new Package(30, EnumTypeOfPackage.FOODS, "Opis", 3);
		warehouse.insertPackage(pack30);

		warehouse.findPackageByType(EnumTypeOfPackage.FOODS);
		warehouse.getPackageByNumber("8");
		warehouse.getShiftHistory();
		warehouse.showAllPackages();
		warehouse.getPackageByNumber("16");
		warehouse.getShiftHistory();
		warehouse.showAllPackages();
		warehouse.getPackageByNumber("27");
		warehouse.getShiftHistory();
		warehouse.showAllPackages();
		warehouse.getPackageByNumber("31");
		logger.trace("\nShift amount for package [" + pack7.getPackageNumber() + "]: " + pack7.getAmountOfMovements());
		logger.trace("\nShift amount for package [" + pack18.getPackageNumber() + "]: " + pack18.getAmountOfMovements());
		logger.trace("\nShift amount for package [" + pack12.getPackageNumber() + "]: " + pack12.getAmountOfMovements());
	}
}
