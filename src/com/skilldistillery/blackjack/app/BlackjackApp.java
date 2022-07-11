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
		System.out.println("Dealer\'s hand is: " + "(First card is upside down), "
				+ dealer.getDealerBlackJackHand().getHand().get(1));
		System.out.println();
		playerGameMenu();
		dealerGameMenu();

	}

	public void startMenu() {
		System.out.println("Welcome to BlackJack!");
		System.out.println("----- Dealer is dealing -----");
		System.out.println();

	}

	public void playerGameMenu() {
		System.out.println("Player's turn");
		boolean isGoing = true;
		while (isGoing) {
			System.out.println();
			System.out.println("The total value of your cards is: " + player.getPlayerBlackJackHand().getHandValue());
			System.out.println();
			System.out.println("Would you like to HIT or STAY?");
			String hitOrStay = sc.nextLine();

			switch (hitOrStay) {

			case "HIT":
				dealer.deal(player.getPlayerBlackJackHand());
				if (player.getPlayerBlackJackHand().isBust()) {
					System.out.println("You lose!");
					isGoing = false;

				} else if (player.getPlayerBlackJackHand().isBlackjack()) {
					System.out.println("You got 21! Now it's the dealer's turn!");
					isGoing = false;
				} else {
					System.out.println("Player\'s hand is now: " + player.getPlayerBlackJackHand().toString());
				}
				break;
			case "STAY":
				System.out.println("It is now the dealer's turn.");
				isGoing = false;
			}
		}
	}

	public void dealerGameMenu() {
		System.out.println("** Dealer flips over upside down card **");

		boolean isGoing = true;
		while (isGoing) {
			System.out.println("Dealer\'s hand is: " + dealer.getDealerBlackJackHand().toString());

			if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& dealer.getDealerBlackJackHand().getHandValue() < 21 && dealer.getDealerBlackJackHand()
							.getHandValue() > player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("Dealer has the better hand! You lose!!!");
				isGoing = false;
			} else if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& dealer.getDealerBlackJackHand().getHandValue() < 21 && dealer.getDealerBlackJackHand()
							.getHandValue() < player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("You have the better hand! You win!!!");
				isGoing = false;
			}

			if (dealer.getDealerBlackJackHand().isBust()) {
				System.out.println("You busts! You win!!!");
				isGoing = false;

			} else if (dealer.getDealerBlackJackHand().isBlackjack()) {
				System.out.println("Dealer got 21! You lose!!!");
				isGoing = false;
			} else {
//				System.out.println("Dealer\'s hand is now: " + dealer.getDealerBlackJackHand().toString());

			}
		}
	}
}
