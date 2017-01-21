package com.arun.basecode;

import com.arun.exception.EmptyCredentialsException;

public interface ValidateUser {

	public boolean validateUser(String userName, String password) throws EmptyCredentialsException;
	public String display();

}
