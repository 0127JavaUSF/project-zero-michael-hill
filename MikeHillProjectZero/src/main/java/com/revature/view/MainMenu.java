package com.revature.view;

import com.revature.utll.Input;

public class MainMenu implements View {

	@Override
	public void showMenu() {
		System.out.println("Ahoy matey, Welcome to the bank of Nassau");
		System.out.println("1. To Start Application");

	}

	@Override
	public View selectOption() {
		int selection = Input.getIntInRange(0, 2);
		// User selects something - should be reusable
		// Do something with their selection, custom to this class
		switch(selection) {
			case 0: System.out.println("Blimey, that isn't a valid input, Try again you filthy landlubber!");
			case 1: return new AccountView();
			case 2: System.out.println("Blimey, that isn't a valid input, Try again you filthy landlubber!");
			default: return null;
		}
		
	}
}
	