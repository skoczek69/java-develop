package com.wmiiul.warehouse.pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wmiiul.warehouse.exceptions.NoEnoughFreeSpaceException;

public class Warehouse {

	private static Logger logger = Logger.getLogger(Warehouse.class.getName());

	private Package[][][] space;
	private int maxWidth = 0;
	private int maxDepth = 0;
	private int maxHeight = 0;
	private List<Integer> coordinate;
	private List<String> shiftHistory;

	public Warehouse(int maxWidth, int maxDepth, int maxHeight) {
		this.maxWidth = maxWidth;
		this.maxDepth = maxDepth;
		this.maxHeight = maxHeight;
		space = new Package[maxDepth][maxWidth][maxHeight];
	}

	public Package[][][] getSpace() {
		return space;
	}
	
	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void insertPackage(Package pack){
		coordinate = findFreePlace(pack, null, null);
		if (coordinate == null) {
			throw new NoEnoughFreeSpaceException();
		}
		logger.trace("[" + pack.getPackageNumber() + "] " + coordinate.get(0) + " " + coordinate.get(1) + " "
				+ coordinate.get(2) + " - PACKAGE LOCATED");
	}

	public List<Integer> findFreePlace(Package pack, Integer ignoreX, Integer ignoreY) {
		for (int i = 0; i < maxDepth; i++) {
			for (int j = 0; j < maxWidth; j++) {
				if (ignoreX != null && ignoreY != null && j == ignoreX.intValue() && i == ignoreY.intValue()) {
					continue;
				}
				boolean isFreePlace = true;
				for (int k = maxHeight - 1; k > -1; k--) {
					if (space[i][j][k] != null) {
						isFreePlace = false;
						if (space[i][j][k].getPriority() > pack.getPriority()) {
							break;
						} else {
							if (k < maxHeight - 1) {
								space[i][j][k + 1] = pack;
								pack.setCoordinate(j, i, k + 1);
								pack.increaseAmountOfMovements();
								return pack.getCoordinate();
							}
							break;
						}
					}
				}
				if (isFreePlace == true) {
					space[i][j][0] = pack;
					pack.setCoordinate(j, i, 0);
					pack.increaseAmountOfMovements();
					return pack.getCoordinate();
				}
			}
		}
		return null;
	}

	public List<Integer> findPackageByNumber(int packageNumber) {
		for (int i = 0; i < maxDepth; i++) {
			for (int j = 0; j < maxWidth; j++) {
				for (int k = maxHeight - 1; k > -1; k--) {
					if (space[i][j][k] != null && space[i][j][k].getPackageNumber() == packageNumber) {
						return space[i][j][k].getCoordinate();
					}
				}
			}
		}
		return null;
	}

	public List<Package> findPackageByType(EnumTypeOfPackage enumTypeOfPackage) {
		logger.trace("\nList of packages with type [" + enumTypeOfPackage.name() + "]:");
		List<Package> packageList = new ArrayList<Package>();
		for (int i = 0; i < maxDepth; i++) {
			for (int j = 0; j < maxWidth; j++) {
				for (int k = maxHeight - 1; k > -1; k--) {
					if (space[i][j][k] != null && space[i][j][k].getTypeOfPackage() == enumTypeOfPackage) {
						packageList.add(space[i][j][k]);
						logger.trace("[" + space[i][j][k].getPackageNumber() + "] " + j + " " + i + " " + k);
					}
				}
			}
		}
		return packageList;
	}

	public void showAllPackages() {
		logger.trace("\nList of all packages:");
		for (int i = 0; i < maxDepth; i++) {
			for (int j = 0; j < maxWidth; j++) {
				for (int k = maxHeight - 1; k > -1; k--) {
					if (space[i][j][k] != null) {
						logger.trace("[" + space[i][j][k].getPackageNumber() + "] " + j + " " + i + " " + k);
					}
				}
			}
		}
	}

	public void getPackageByNumber(String packageNumber) {
		shiftHistory = new ArrayList<String>();
		List<Integer> removedPackage = findPackageByNumber(Integer.parseInt(packageNumber));
		if (removedPackage == null) {
			logger.trace("\nPackage [" + packageNumber + "] not found");
		} else {
			int x = removedPackage.get(0);
			int y = removedPackage.get(1);
			int z = removedPackage.get(2);
			for (int i = maxHeight - 1; i > z; i--) {
				if (space[y][x][i] != null) {
					coordinate=space[y][x][i].getCoordinate();
					findFreePlace(space[y][x][i], x, y);
					Package pack = space[y][x][i];
					space[y][x][i] = null;
					shiftHistory.add("Package ["+pack.getPackageNumber()+"] moved from ("+coordinate.get(0)+" "+coordinate.get(1)+" "+coordinate.get(2)+") to ("+pack.getX()+" "+pack.getY()+" "+pack.getZ()+")");
				}
			}
			space[y][x][z] = null;
			logger.trace("\n[" + packageNumber + "] " + x + " " + y + " " + z + " - PACKAGE REMOVED");
		}
	}

	public void getShiftHistory() {
		logger.trace("\nHistory of the last shift:");
		for (String shift : shiftHistory) {
			logger.trace(shift);
		}
	}
}
