package com.thoughtworks.business.model;

import com.thoughtworks.business.commons.StringParserUtil;

public class BusinessBoard {

	private Cell[] cells;

	public BusinessBoard() {
	}

	public void populateBoard(String cellSequence) {
		String[] cellSequenceArray = StringParserUtil.parseString(cellSequence);
		Cell[] cells = new Cell[cellSequenceArray.length];
		int i = 0;
		for (String cellType : cellSequenceArray) {
			cells[i++] = new Cell(CellType.lookUp(cellType), null);
		}
		this.cells = cells;
	}

	public void play(Player player, DeterministicDice dice) {
		int position = player.play(dice);
		Cell cell = cells[position % cells.length];
		cell.applyCellRuleFor(player);
	}
}
