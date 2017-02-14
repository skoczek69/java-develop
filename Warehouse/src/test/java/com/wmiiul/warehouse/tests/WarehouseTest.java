package com.wmiiul.warehouse.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wmiiul.warehouse.exceptions.NoEnoughFreeSpaceException;
import com.wmiiul.warehouse.pojo.EnumTypeOfPackage;
import com.wmiiul.warehouse.pojo.Package;
import com.wmiiul.warehouse.pojo.Warehouse;

public class WarehouseTest {

	private Warehouse warehouse;
	private Warehouse warehouse2;
	private Warehouse warehouse3;
	private Package pack;
	private Package pack2;
	private Package pack3;
	private Package pack4;
	private Package pack5;
	private Package pack6;
	private Package pack7;
	private Package pack8;
	private Package pack9;
	private Package pack10;

	@Before
	public void initObjects() {
		warehouse = new Warehouse(4, 3, 5);
		warehouse2 = new Warehouse(1, 1, 1);
		warehouse3 = new Warehouse(3, 1, 5);
		pack = new Package(1, EnumTypeOfPackage.TOYS, "Package 1", 1);
		pack2 = new Package(2, EnumTypeOfPackage.FURNITURES, "Package 2", 2);
		pack3 = new Package(3, EnumTypeOfPackage.FOODS, "Package 3", 2);
		pack4 = new Package(4, EnumTypeOfPackage.FOODS, "Package 4", 1);
		pack5 = new Package(5, EnumTypeOfPackage.CLOTHES, "Package 5", 3);
		pack6 = new Package(6, EnumTypeOfPackage.COMPUTER_PARTS, "Package 6", 2);
		pack7 = new Package(7, EnumTypeOfPackage.COMPUTER_PARTS, "Package 7", 3);
		pack8 = new Package(8, EnumTypeOfPackage.CAR_PARTS, "Package 8", 1);
		pack9 = new Package(9, EnumTypeOfPackage.COMPUTER_PARTS, "Package 9", 1);
		pack10 = new Package(10, EnumTypeOfPackage.CAR_PARTS, "Package 10", 1);
	}

	@Test
	public void warehouseWidthTest() {
		assertEquals(warehouse.getMaxWidth(), 4);
	}

	@Test
	public void warehouseDepthTest() {
		assertEquals(warehouse.getMaxDepth(), 3);
	}

	@Test
	public void warehouseHeightTest() {
		assertEquals(warehouse.getMaxHeight(), 5);
	}

	@Test
	public void getPackageTest() {
		placePackageInWarehouse();
		Package[][][] warehouseAfterShift = new Package[3][4][5];
		warehouseAfterShift[0][0][0] = pack;
		warehouseAfterShift[0][2][3] = pack3;
		warehouseAfterShift[0][1][0] = pack4;
		warehouseAfterShift[0][1][3] = pack5;
		warehouseAfterShift[0][1][1] = pack6;
		warehouseAfterShift[0][1][2] = pack7;
		warehouseAfterShift[0][2][0] = pack8;
		warehouseAfterShift[0][2][1] = pack9;
		warehouseAfterShift[0][2][2] = pack10;
		warehouse.getPackageByNumber("2");
		Package[][][] testedWarehouse = warehouse.getSpace();
		assertEquals(testedWarehouse, warehouseAfterShift);
	}

	@Test
	public void findPackageTest() {
		placePackageInWarehouse();
		List<Package> computerPartsPackageList = new ArrayList<Package>();
		computerPartsPackageList.add(pack7);
		computerPartsPackageList.add(pack6);
		computerPartsPackageList.add(pack9);
		assertEquals(warehouse.findPackageByType(EnumTypeOfPackage.COMPUTER_PARTS), computerPartsPackageList);
	}

	@Test(expected = NoEnoughFreeSpaceException.class)
	public void NoEnoughFreeSpaceExceptionTest() {
		Package pack = new Package(1, EnumTypeOfPackage.COMPUTER_PARTS, "Package 1", 1);
		Package pack2 = new Package(2, EnumTypeOfPackage.CAR_PARTS, "Package 2", 1);
		warehouse2.insertPackage(pack);
		warehouse2.insertPackage(pack2);
	}

	@Test
	public void shiftNumberTest() {
		warehouse3.insertPackage(pack);
		warehouse3.insertPackage(pack2);
		warehouse3.insertPackage(pack3);
		warehouse3.insertPackage(pack4);
		warehouse3.insertPackage(pack5);
		warehouse3.insertPackage(pack6);
		warehouse3.insertPackage(pack7);
		warehouse3.getPackageByNumber("1");
		warehouse3.getPackageByNumber("4");
		warehouse3.getPackageByNumber("3");
		warehouse3.getPackageByNumber("5");
		assertEquals(pack7.getAmountOfMovements(), 3);
	}
	
	 @Test
	 public void packageNumberTest() {
	 assertEquals(pack10.getPackageNumber(), 10);
	 }
	 
	 @Test
	 public void packageTypeTest() {
	 assertEquals(pack10.getTypeOfPackage(), EnumTypeOfPackage.CAR_PARTS);
	 }
	 
	 @Test
	 public void packagePriorityTest() {
	 assertEquals(pack10.getPriority(), 1);
	 }
	 
	 @Test
	 public void packageDescritpionTest() {
	 assertEquals(pack10.getDescription(), "Package 10");
	 }

	@Test
	public void packageAllocationTest() {
		placePackageInWarehouse();
		List<Integer> coordinate = new ArrayList<Integer>();
		coordinate.add(2);
		coordinate.add(0);
		coordinate.add(2);
		assertEquals(pack10.getCoordinate(), coordinate);
	}

	public void placePackageInWarehouse() {
		warehouse.insertPackage(pack);
		warehouse.insertPackage(pack2);
		warehouse.insertPackage(pack3);
		warehouse.insertPackage(pack4);
		warehouse.insertPackage(pack5);
		warehouse.insertPackage(pack6);
		warehouse.insertPackage(pack7);
		warehouse.insertPackage(pack8);
		warehouse.insertPackage(pack9);
		warehouse.insertPackage(pack10);
	}
}
