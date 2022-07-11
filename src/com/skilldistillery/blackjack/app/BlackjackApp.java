package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Dealer;

public class BlackjackApp {
	
	Dealer dealer = new Dealer();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	
	}
	
	public void run() {
		dealer();
	}
	
}
