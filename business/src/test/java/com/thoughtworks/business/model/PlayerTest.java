package com.thoughtworks.business.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

	private Player playerObj;

	private DeterministicDice dice;

	@Before
	public void setUp() {
		playerObj = new Player("Test", 1000.0, 0);
		dice = new DeterministicDice("2,3");
	}

	@Test
	public void testcanBuyCellFor() {
		assert (playerObj.canBuyCellFor(250));
	}

	@Test
	public void testPlay() {
		Assert.assertTrue(playerObj.play(dice) == 1);
	}

	@Test
	public void testAddMoney() {
		playerObj.addMoney(50);
		Assert.assertTrue(playerObj.finalStandings().equals("Test has total worth 1050.0"));
	}

	@Test
	public void testDeductMoney() {
		playerObj.deductMoney(50);
		Assert.assertTrue(playerObj.finalStandings().equals("Test has total worth 950.0"));
	}

}
