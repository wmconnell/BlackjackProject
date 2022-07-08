package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards = new ArrayList<>(); 

	
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				deckOfCards.add(card);
			}
		}
		
	}
	
	public int checkDeckSize() {
		return deckOfCards.size();
	}
	
	public Card dealCard() {
		Card card = deckOfCards.remove(0);
		return card;
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
}
