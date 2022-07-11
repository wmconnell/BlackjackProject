package com.skilldistillery.blackjack.entities;

public class Dealer {

	Deck deck = new Deck();
	
//	public Card deal() {
//		Hand playerHand = new BlackjackHand();
//		Hand dealerHand = new BlackjackHand();
//		Card card = deck.dealCard();
		
		
		
	}
	
	public void deal(Hand hand) {
//		Hand playerHand = new BlackjackHand();
//		Hand dealerHand = new BlackjackHand();
		Card card = this.deck.dealCard();
		hand.addCard(card);
		
		
	}
	
}
