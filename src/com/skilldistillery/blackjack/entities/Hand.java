package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	List<Card> hand = new ArrayList<>();
	
	Hand() {}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void clear() {
		
	}
	
	public int getHandValue() {
		return 0;
	}


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
