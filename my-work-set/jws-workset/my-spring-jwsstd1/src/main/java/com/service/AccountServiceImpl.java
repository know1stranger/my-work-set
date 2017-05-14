package com.service;

public class AccountServiceImpl implements AccountService {

	private String accountType;

	@Override
	public String getTesting() {
		String responseStr = "Here is the impl for " + accountType;
		System.out.println(responseStr);
		return responseStr;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
