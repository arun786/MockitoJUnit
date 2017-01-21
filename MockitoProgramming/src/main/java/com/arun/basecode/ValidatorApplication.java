package com.arun.basecode;

public class ValidatorApplication {
	private ValidateUser validateUser;

	public ValidatorApplication(ValidateUser validateUser) {
		super();
		this.validateUser = validateUser;
	}

	public boolean validateUser(String userName, String password) {
		return validateUser.validateUser(userName, password);
	}

	public String getUserName() {
		return validateUser.display();
	}

}
