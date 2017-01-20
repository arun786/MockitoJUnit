package com.arun.idols;

import java.util.Arrays;
import java.util.List;

public class PlayerStubImpl implements Players {

	public List<String> getPlayers(String country) {

		if ("India".equals(country)) {
			return Arrays.asList("Sachin", "Dravid", "Sourabh");
		} else if ("Australia".equals(country)) {
			return Arrays.asList("Mark Waugh", "Steven Waugh", "Brett Lee");
		}
		return null;
	}

}
