package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> hand = new ArrayList<>();
	
	Hand() {}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void clear() {
		this.hand.clear();
	}
	
	public abstract int getHandValue();


	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	@Override
	public String toString() {
		
		return "" + hand;
	}

	
	
	
}
