package com.thoughtworks.business.service;

import java.util.List;

import com.thoughtworks.business.model.Player;

public interface PlayerService {

	public void populatePlayers(List<String> names, double initialAmount);

	public Player getPlayerByName(String name);

	public List<Player> getAllPlayers();
}
