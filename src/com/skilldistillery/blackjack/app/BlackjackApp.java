package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();
	Deck deck = new Deck();

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();

	}

	public void run() {

		boolean keepPlaying = true;

		while (keepPlaying) {
			dealer.shuffle(dealer.getDeck());

			startMenu();

				dealer.deal(player.getPlayerBlackJackHand());
				dealer.deal(dealer.getDealerBlackJackHand());
				dealer.deal(player.getPlayerBlackJackHand());
				dealer.deal(dealer.getDealerBlackJackHand());
				

			System.out.println("Player\'s hand is: " + player.getPlayerBlackJackHand().toString());
			System.out.println("Dealer\'s hand is: " + "(First card is upside down), "
					+ dealer.getDealerBlackJackHand().getHand().get(1));
			System.out.println();
			if (player.getPlayerBlackJackHand().getHandValue() < 21) {

				playerGameMenu();

				if (player.getPlayerBlackJackHand().getHandValue() != 0 && player.getPlayerBlackJackHand().isBust() == false) {
					dealerGameMenu();
				}
			} else if (player.getPlayerBlackJackHand().getHandValue() == 21) {
				System.out.println("Blackjack! The dealer will now reveal his cards: ");
				System.out.println("Dealer\'s hand is: " + dealer.getDealerBlackJackHand().toString());
				if (dealer.getDealerBlackJackHand().getHandValue() == 21) {
					System.out.println("You both have blackjack! Push!!!");
				} else {
					System.out.println("Dealer does not have blackjack! You win!!!");
					endGameMenu();
				}
			} else {
				System.out.println("You bust! You lose!!!");
				endGameMenu();
			}

		}

	}

	public void startMenu() {
		System.out.println("Get ready to play BlackJack!");
		System.out.println();
		System.out.println("----- Dealer has shuffled -----");
		System.out.println();
		System.out.println();
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
			case "hit":
				dealer.deal(player.getPlayerBlackJackHand());
				if (player.getPlayerBlackJackHand().isBust()) {
					System.out.println(
							"The total value of your cards is: " + player.getPlayerBlackJackHand().getHandValue());
					System.out.println("You bust! You lose!!!");

					isGoing = false;
					endGameMenu();
				} else if (player.getPlayerBlackJackHand().isBlackjack()) {
					System.out.println("You got 21! Now it's the dealer's turn!");
					System.out.println();
					isGoing = false;
				} else {
					System.out.println("Player\'s hand is now: " + player.getPlayerBlackJackHand().toString());
				}
				break;
			case "STAY":
			case "stay":
				System.out.println("It is now the dealer's turn.");
				System.out.println();
				isGoing = false;
				break;
			default:
				System.out.println("Please type HIT or STAY");
			}
		}
	}

	public void dealerGameMenu() {
		System.out.println("** Dealer flips over upside down card **");

		boolean isGoing = true;
		while (isGoing) {
			System.out.println("Dealer\'s hand is: " + dealer.getDealerBlackJackHand().toString());
			System.out.println();
			System.out.println(
					"The total value of the dealer\'s cards is: " + dealer.getDealerBlackJackHand().getHandValue());
			System.out.println();

			if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& player.getPlayerBlackJackHand().getHandValue() >= 17 && dealer.getDealerBlackJackHand()
							.getHandValue() == player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("You both have the same score! Push!!!");
				isGoing = false;
			}

			else if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& dealer.getDealerBlackJackHand().getHandValue() < 21 && dealer.getDealerBlackJackHand()
							.getHandValue() > player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("Dealer has the better hand! You lose!!!");
				isGoing = false;
			} else if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& dealer.getDealerBlackJackHand().getHandValue() < 21 && dealer.getDealerBlackJackHand()
							.getHandValue() < player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("You have the better hand! You win!!!");
				isGoing = false;
			} else if (dealer.getDealerBlackJackHand().getHandValue() >= 17
					&& dealer.getDealerBlackJackHand().getHandValue() < 21 && dealer.getDealerBlackJackHand()
							.getHandValue() == player.getPlayerBlackJackHand().getHandValue()) {
				System.out.println("You both have the same score! Push!!!");
			}

			if (dealer.getDealerBlackJackHand().isBust()) {
				System.out.println("Dealer busts! You win!!!");
				isGoing = false;

			} else if (dealer.getDealerBlackJackHand().isBlackjack()) {
				System.out.println("Dealer got 21! You lose!!!");
				isGoing = false;
			} else if (dealer.getDealerBlackJackHand().getHandValue() < 17) {
				System.out.println("Dealer hits!");
				System.out.println();
				dealer.deal(dealer.getDealerBlackJackHand());

			}
		}
		endGameMenu();
	}

	public void endGameMenu() {
		System.out.println("Would you like to play again? (Y/N)");
		String yesOrNo = sc.nextLine();

		switch (yesOrNo) {
		case "Y":
		case "y":
			player.getPlayerBlackJackHand().clear();
			dealer.getDealerBlackJackHand().clear();
			dealer = new Dealer();
			break;

		case "N":
		case "n":
			System.out.println("Thanks for playing!");
			System.exit(0);
			break;
		default:
			System.out.println("Please type Y or N");
		}
	}
}
