package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();

	}

	public void run() {

		startMenu();

		dealer.shuffle(dealer.getDeck());

		dealer.deal(player.getPlayerBlackJackHand());
		dealer.deal(dealer.getDealerBlackJackHand());
		dealer.deal(player.getPlayerBlackJackHand());
		dealer.deal(dealer.getDealerBlackJackHand());

		System.out.println("Player\'s hand is: " + player.getPlayerBlackJackHand().toString());
		System.out.println("Dealer\'s hand is: " + "(First card is upside down), " + dealer.getDealerBlackJackHand().getHand().get(1));
	}

	public void startMenu() {
		System.out.println("Welcome to BlackJack!");
		System.out.println("----- Dealer is dealing -----");

	}
	
	public void gameMenu() {
		System.out.println();
	}
}
