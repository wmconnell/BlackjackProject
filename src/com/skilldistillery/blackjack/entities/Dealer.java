package com.skilldistillery.blackjack.entities;

public class Dealer {

	Deck deck = new Deck();
	BlackjackHand dealerBlackJackHand = new BlackjackHand();

	public Dealer() {
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public BlackjackHand getDealerBlackJackHand() {
		return dealerBlackJackHand;
	}

	public void setDealerBlackJackHand(BlackjackHand dealerBlackJackHand) {
		this.dealerBlackJackHand = dealerBlackJackHand;
	}

	public void deal(Hand hand) {
		Card card = this.deck.dealCard();
		hand.addCard(card);

	}

	public void shuffle(Deck deck) {
		deck.shuffle();
	}

//	@Override
//	public String toString() {
//		return "First card is upside down" + dealerBlackJackHand.getHand().get(1);
//	}
//	
	

}
