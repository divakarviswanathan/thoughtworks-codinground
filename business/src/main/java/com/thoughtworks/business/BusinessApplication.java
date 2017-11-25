package com.thoughtworks.business;

import java.util.Arrays;

import com.thoughtworks.business.model.BusinessBoard;
import com.thoughtworks.business.model.DeterministicDice;
import com.thoughtworks.business.model.Player;
import com.thoughtworks.business.service.PlayerService;
import com.thoughtworks.business.service.impl.PlayerServiceImpl;

public class BusinessApplication {

	public static void main(String[] args) {
		String boardOrientation = args[0];
		String diceSequence = args[1];
		int numberOfTurns = Integer.parseInt(args[0]);
		PlayerService playerService = new PlayerServiceImpl();
		playerService.populatePlayers(Arrays.asList("Player1", "Player2", "Player3"), 1000.0);
		BusinessBoard board = new BusinessBoard();
		board.populateBoard("E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E");
		DeterministicDice dice = new DeterministicDice(
				"4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12");
		for (int i = 0; i < numberOfTurns; i++) {
			board.play(playerService.getPlayerByName("Player1"), dice);
			board.play(playerService.getPlayerByName("Player2"), dice);
			board.play(playerService.getPlayerByName("Player3"), dice);
		}

		for (Player player : playerService.getAllPlayers()) {
			System.out.println(player.finalStandings());
		}

	}
}
