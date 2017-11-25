package com.thoughtworks.business.model;

public class Cell {
	private CellType cellType;
	private Player ownedBy;

	public Cell(CellType cellType, Player ownedBy) {
		this.cellType = cellType;
		this.ownedBy = ownedBy;
	}

	// TODO: method name to be renamed
	public void applyCellRuleFor(Player player) {
		if(cellType.isBuyable()) {
			if(this.ownedBy != null) {
				this.ownedBy.addMoney(this.cellType.getSubValue());
				player.deductMoney(this.cellType.getSubValue());
			} else {
				if(player.canBuyCellFor(cellType.getValue())) {
					player.deductMoney(cellType.getValue());
					this.ownedBy = player;
				} else {
					player.deductMoney(cellType.getSubValue());
				}
			}
		} else {
			player.addMoney(this.cellType.getValue());
		}
	}
}
