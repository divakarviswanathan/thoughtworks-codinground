package com.thoughtworks.business.model;

import java.util.HashMap;
import java.util.Map;

public enum CellType {
	EMPTY(0, 0, false), JAIL(-150, 0, false), TREASURE(200, 0, false), HOTEL(200, 50, true);

	private final double value;
	private final boolean buyable;
	private final double subValue;

	CellType(double value, double subValue, boolean buyable) {
		this.value = value;
		this.buyable = buyable;
		this.subValue = subValue;
	}

	public double getValue() {
		return this.value;
	}

	public boolean isBuyable() {
		return this.buyable;
	}

	public double getSubValue() {
		return this.subValue;
	}

	private static Map<String, CellType> lookUpMap = new HashMap<>();
	static {
		lookUpMap.put("E", EMPTY);
		lookUpMap.put("J", JAIL);
		lookUpMap.put("T", TREASURE);
		lookUpMap.put("H", HOTEL);
	}

	public static CellType lookUp(String cellTypeStr) {
		return lookUpMap.get(cellTypeStr);
	}
}
