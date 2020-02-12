package com.revature.view;

import com.revature.account.Account;
import com.revature.dao.AccountDao;
import com.revature.utll.Input;

public class AccountView implements View {


	AccountDao accountDao = new AccountDao();
	Account account = null;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public void showMenu() {
		System.out.println("1. Log into exist accound");
		System.out.println("2. Create new account");
		System.out.println("0. Back");
	}

	@Override
	public View selectOption() {
		int selection = Input.getIntInRange(0, 2);
		switch (selection) {
		case 1: loadAccount();
		if(account != null)
			return new LoggedInView(getAccount());
		else {
			System.out.println("Incorrect username or password");
			return this;
		}
		case 2: createAccount(); return this;
		default:
		case 0: return new MainMenu();
		}
	}

	private void loadAccount() {
		System.out.println("Please enter username: ");
		String userName = Input.getNextString();
		
		System.out.println("Please enter password: ");
		String password = Input.getNextString();
		
		Account account = accountDao.getAccount(userName, password);
				if(account == null) {
				System.out.println("Account not found");
				
				
				}
		setAccount(account);
		//System.out.println("welcome back, "+userName);

	}
		
		
	
	private void createAccount() {
		System.out.println("Please enter username: ");
		String userName = Input.getNextString();
		
		System.out.println("Please enter password: ");
		String password = Input.getNextString();
		
		Account account = new Account(0, userName, password);
		account = accountDao.createAccount(account);
		System.out.println(account);
		
	}
}