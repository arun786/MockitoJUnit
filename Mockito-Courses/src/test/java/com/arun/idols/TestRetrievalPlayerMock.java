package com.arun.idols;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.arun.idolsImp.RetrievePlayersBasedOnCountry;

public class TestRetrievalPlayerMock {

	@Test
	public void getPlayer() {
		Players players = mock(Players.class);
		when(players.getPlayers("India")).thenReturn(Arrays.asList("Sachin", "Rahul", "Sourabh"));
		RetrievePlayersBasedOnCountry player = new RetrievePlayersBasedOnCountry(players);
		List<String> ls = player.getPlayers("India");
		assertEquals(Arrays.asList("Sachin", "Rahul", "Sourabh"), ls);
	}

}
