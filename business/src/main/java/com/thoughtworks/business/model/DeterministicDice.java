package com.thoughtworks.business.model;

import java.util.List;

import com.thoughtworks.business.commons.StringParserUtil;

public class DeterministicDice {

	private List<Integer> numberSequence;
	private int rollCount;

	public DeterministicDice(String numberSequence) {
		this.numberSequence = StringParserUtil.parseStringToNumberList(numberSequence);
		this.rollCount = 0;
	}

	public int rollDice() {
		return (numberSequence.get(this.rollCount++) - 1);
	}

}
