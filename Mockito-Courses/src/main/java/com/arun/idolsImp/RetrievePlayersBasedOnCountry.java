package com.arun.idolsImp;

import java.util.List;

import com.arun.idols.Players;

public class RetrievePlayersBasedOnCountry {
	private Players player;

	public RetrievePlayersBasedOnCountry(Players player) {
		super();
		this.player = player;
	}

	public List<String> getPlayers(String country) {
		List<String> lstPlayerBasedOnCountry = player.getPlayers(country);
		return lstPlayerBasedOnCountry;
	}

}
