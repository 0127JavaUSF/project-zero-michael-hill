package com.revature.view;

import com.revature.account.Account;
import com.revature.dao.AccountDao;
import com.revature.utll.Input;

public class LoggedInView implements View {

	AccountDao accountDao = new AccountDao();
	
	private Account account;
	
	
	public LoggedInView(Account account) {
		this.account = account;
	}

	@Override
	public void showMenu() {
		System.out.println("0. Log out and return to main menu");
		System.out.println("1. View eisting bank account");
		System.out.println("2. Create new savings account");
		System.out.println("3. Create new checking account");
	}

	@Override
	public View selectOption() {
		int selection = Input.getIntInRange(0, 2);
		switch (selection) {
		case 1: loadAccounts();
		case 2: createSavingsAccount();
		case 3: createCheckingAccount();
		default:
		case 0: return new MainMenu();
		}
	}
	
	private void loadAccounts() {
		/*
		 * System.out.println("Please enter username: "); String userName =
		 * Input.getNextString();
		 * 
		 * System.out.println("Please enter password: "); String password =
		 * Input.getNextString();
		 * 
		 * Account account = accountDao.getAccount(userName, password);
		 * 
		 * System.out.println("welcome back, "+userName);
		 */}
	
	private void createSavingsAccount() {
		/*
		 * System.out.println("Please enter building name: "); String userName =
		 * Input.getNextString();
		 * 
		 * System.out.println("Please enter apartment number: "); String password =
		 * Input.getNextString();
		 * 
		 * Account account = new Account(0, userName, password); account =
		 * accountDao.createAccount(account); System.out.println(account);
		 */
	}
	
	private void createCheckingAccount() {
		/*
		 * System.out.println("Please enter building name: "); String userName =
		 * Input.getNextString();
		 * 
		 * System.out.println("Please enter apartment number: "); String password =
		 * Input.getNextString();
		 * 
		 * Account account = new Account(0, userName, password); account =
		 * accountDao.createAccount(account); System.out.println(account);
		 */

}
}
