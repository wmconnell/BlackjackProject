package com.skilldistillery.blackjack.entities;

public class Player {
	
	private BlackjackHand playerBlackJackHand = new BlackjackHand();

	
	public Player() {
	}

	public BlackjackHand getPlayerBlackJackHand() {
		return playerBlackJackHand;
	}

	public void setPlayerBlackJackHand(BlackjackHand blackJackHand) {
		this.playerBlackJackHand = blackJackHand;
	}
	
	
	
	
	
	
}
