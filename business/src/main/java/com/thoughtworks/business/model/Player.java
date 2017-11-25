package com.thoughtworks.business.model;

import com.thoughtworks.business.commons.BusinessGameConstants;

public class Player {

	private String name;
	private double amountInHand;
	private int positionOnBoard;

	public Player(String name, double initialAmount, int positionOnBoard) {
		this.name = name;
		this.amountInHand = initialAmount;
		this.positionOnBoard = positionOnBoard;
	}

	public void movePlayer(int bySteps) {
		this.positionOnBoard += bySteps;
	}

	public String finalStandings() {
		StringBuffer buffer = new StringBuffer(this.name);
		buffer.append(BusinessGameConstants.HAS_WORTH).append(this.amountInHand);
		return buffer.toString();
	}

	public int play(DeterministicDice dice) {
		int stepCount = dice.rollDice();
		movePlayer(stepCount);
		return this.positionOnBoard;
	}

	public boolean canBuyCellFor(double amount) {
		if (this.amountInHand >= amount) {
			return true;
		}
		return false;
	}

	public void addMoney(double amount) {
		this.amountInHand += amount;
	}

	public void deductMoney(double amount) {
		this.amountInHand -= amount;
	}
}
