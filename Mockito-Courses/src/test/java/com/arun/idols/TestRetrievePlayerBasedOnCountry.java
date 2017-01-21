package com.arun.idols;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arun.idolsImp.RetrievePlayersBasedOnCountry;

public class TestRetrievePlayerBasedOnCountry {
	private Players player;
	private RetrievePlayersBasedOnCountry playerImpl;

	@Before
	public void setUp() {
		player = new PlayerStubImpl(); /*Here we are using stub*/
		playerImpl = new RetrievePlayersBasedOnCountry(player);
	}

	@Test
	public void getPlayer() {
		List<String> lstPlayers = playerImpl.getPlayers("India");
		assertEquals(Arrays.asList("Sachin", "Dravid", "Sourabh"), lstPlayers);
	}

}
