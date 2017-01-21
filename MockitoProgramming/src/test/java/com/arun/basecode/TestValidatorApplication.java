package com.arun.basecode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import com.arun.exception.EmptyCredentialsException;

public class TestValidatorApplication {
	private ValidateUser validateUserMock;
	private ValidatorApplication validatorApplication;
	String userName;
	String password;

	@Before
	public void setUp() {
		validateUserMock = mock(ValidateUser.class);
		validatorApplication = new ValidatorApplication(validateUserMock);

		userName = "arun";
		password = "abc";
	}

	@Test(expected = EmptyCredentialsException.class)
	public void testValidate() throws EmptyCredentialsException {

		when(validateUserMock.validateUser(userName, password)).thenReturn(true);
		assertTrue(validatorApplication.validateUser(userName, password));

		when(validateUserMock.display()).thenReturn(userName);
		assertEquals(userName, validatorApplication.getUserName());

		/* To check whether the method has been called, we user verify */
		verify(validateUserMock).validateUser(userName, password);
		/* The below method will fail since the argument value is different */
		// verify(validateUserMock).validateUser(userName, "abdc");

		/*
		 * The below snipper will be check how many times the method has been
		 * called
		 */
		verify(validateUserMock, times(1)).validateUser(userName, password);
		verify(validateUserMock, atLeastOnce()).validateUser(userName, password);
		verify(validateUserMock, atMost(1)).validateUser(userName, password);
		verify(validateUserMock, atLeast(1)).validateUser(userName, password);

		/* This will fail since the method has been called once */
		// verify(validateUserMock, never()).validateUser(userName, password);

		/* To check the order of the methods in which they are called */

		InOrder inorder = inOrder(validateUserMock);

		inorder.verify(validateUserMock).validateUser(userName, password);
		inorder.verify(validateUserMock).display();

		/*
		 * To throw an exception, we have to use the below code and the
		 * anotation at the begin of the method, expected, if the below code
		 * snippet is not used it will fail
		 */

		when(validatorApplication.validateUser("", "")).thenThrow(new EmptyCredentialsException());
		validatorApplication.validateUser("", "");

	}
}
