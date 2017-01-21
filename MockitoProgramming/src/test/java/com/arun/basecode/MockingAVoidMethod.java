package com.arun.basecode;

import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.arun.exception.NoAuthenticateException;

@RunWith(MockitoJUnitRunner.class)
public class MockingAVoidMethod {

	@Mock
	private ValidateUser validateUserMock;
	@InjectMocks
	private ValidatorApplication validateApp;

	@Test(expected=NoAuthenticateException.class)
	public void ToTestAVoidMethod() throws NoAuthenticateException {
		
		String userName = "arun";
		String password ="abc";
		
		doThrow(new NoAuthenticateException()).when(validateUserMock).validateUserAgain(userName, password);
		
		validateApp.validateUserAgain(userName, password);
	}

}
