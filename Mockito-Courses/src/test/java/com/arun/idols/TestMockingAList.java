package com.arun.idols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class TestMockingAList {

	@Test
	public void TestmockListSize() {
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size()); /* First Call */
		assertEquals(3, listMock.size()); /* Second Call */
		assertEquals(3, listMock.size()); /* Third Call */
	}
	
	@Test
	public void TestmockListGetMethod(){
		List<String> listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Hello World");
		assertEquals("Hello World", listMock.get(0));
		assertNull(listMock.get(1));
	}
	
	@Test
	public void TestmockListGetWithAny(){
		List<String> listMock = mock(List.class);
		/*Argument Matcher*/
		when(listMock.get(Mockito.anyInt())).thenReturn("Hello World");
		assertEquals("Hello World",listMock.get(4));
	}
	
	@Test(expected=RuntimeException.class)
	public void TestMockThrowRunTimeException(){
		List<String> listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Invalid operations"));
		listMock.get(0);
	}

}
