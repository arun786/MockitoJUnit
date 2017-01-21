package com.arun.basecode;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.arun.exception.EmptyCredentialsException;

@RunWith(MockitoJUnitRunner.class)
public class TestValidatorApplicationUsingAnnotation {

	@Mock
	private ValidateUser validateUserMock;
	@InjectMocks
	private ValidatorApplication validateApplication;
	
	@Test
	public void TestValidatorApplication() throws EmptyCredentialsException{
		String userName = "arun";
		String password ="abc";
		
		when(validateUserMock.validateUser(userName, password)).thenReturn(true);
		assertEquals(validateApplication.validateUser(userName, password), true);
		
		when(validateUserMock.display()).thenReturn(userName);
		assertEquals(userName, validateApplication.getUserName());
		
		verify(validateUserMock, timeout(10)).validateUser(userName, password);
	}
}
