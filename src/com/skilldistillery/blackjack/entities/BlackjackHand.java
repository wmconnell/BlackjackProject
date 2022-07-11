package com.skilldistillery.blackjack.entities;


public class BlackjackHand extends Hand {

	
	BlackjackHand() {
		
	}
	
	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < hand.size(); i++ ) {
			handValue = handValue + this.hand.get(i).getValue();
			
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			
			return true;
		} else {
			return false;
		}
	}

	
	
	
	
}
