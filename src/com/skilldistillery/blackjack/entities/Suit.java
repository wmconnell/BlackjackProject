package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	Suit() {}
	
	Suit(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}
