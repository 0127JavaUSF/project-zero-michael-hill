package com.revature.view;

import com.revature.account.Account;
import com.revature.dao.AccountDao;
import com.revature.utll.Input;

public class AccountView implements View {


	AccountDao accountDao = new AccountDao();
	
	@Override
	public void showMenu() {
		System.out.println("1. Load House");
		System.out.println("2. Create House");
		System.out.println("0. Back");
	}

	@Override
	public View selectOption() {
		int selection = Input.getIntInRange(0, 2);
		switch (selection) {
		case 1: loadHouse(); return this;
		case 2: createHouse(); return this;
		default:
		case 0: return new MainMenu();
		}
	}

	private void loadHouse() {
		System.out.println("Please enter building name: ");
		String userName = Input.getNextString();
		
		System.out.println("Please enter apartment number: ");
		String password = Input.getNextString();
		
		Account account = accountDao.getAccount(userName, password);
				
		System.out.println(account);
	}
	
	private void createHouse() {
		System.out.println("Please enter building name: ");
		String userName = Input.getNextString();
		
		System.out.println("Please enter apartment number: ");
		String password = Input.getNextString();
		
		Account account = new Account(0, userName, password);
		account = accountDao.createAccount(account);
		System.out.println(account);
		
	}
}