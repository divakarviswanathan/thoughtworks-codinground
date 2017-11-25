package com.thoughtworks.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.business.model.Player;
import com.thoughtworks.business.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	private Map<String, Player> playerData = new HashMap<>();

	@Override
	public void populatePlayers(List<String> names, double initialAmount) {
		for (String name : names) {
			playerData.put(name, new Player(name, initialAmount, 0));
		}
	}

	@Override
	public Player getPlayerByName(String name) {
		return playerData.get(name);
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<>();
		for (Entry<String, Player> player : playerData.entrySet()) {
			players.add(player.getValue());
		}
		return players;
	}

}
