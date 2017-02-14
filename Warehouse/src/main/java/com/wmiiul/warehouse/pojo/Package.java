package com.wmiiul.warehouse.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Package {

	private int packageNumber;
	private EnumTypeOfPackage typeOfPackage;
	private String description;
	private Date dateOfAdding = new Date();
	private int amountOfMovements = -1;
	private int priority;
	private int x;
	private int y;
	private int z;

	public Package() {

	}

	public Package(int packageNumber, EnumTypeOfPackage typeOfPackage, String description, int priority) {
		this.packageNumber = packageNumber;
		this.typeOfPackage = typeOfPackage;
		this.description = description;
		this.priority = priority;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public EnumTypeOfPackage getTypeOfPackage() {
		return typeOfPackage;
	}


	public String getDescription() {
		return description;
	}

	public Date getDateOfAdding() {
		return dateOfAdding;
	}

	public int getAmountOfMovements() {
		return amountOfMovements;
	}

	public void increaseAmountOfMovements() {
		amountOfMovements++;
	}

	public int getPriority() {
		return priority;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public List<Integer> getCoordinate() {
		List<Integer> coordinate = new ArrayList<Integer>();
		coordinate.add(x);
		coordinate.add(y);
		coordinate.add(z);
		return coordinate;
	}

	public void setCoordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;

	}

}
