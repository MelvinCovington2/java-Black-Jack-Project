package com.blackJackGame;

//Building the card 
public class Card {

	private CardSuit suit;
	private CardValue value;

//Card constructor 
	public Card(CardSuit suit, CardValue value) {

		this.value = value;
		this.suit = suit;
	}

//Prints out the value of the card to a String 
	public String toString() {
		return this.suit.toString() + "-" + this.value.toString() + "\n";
	}

//Returns value of card  	
	public CardValue getValue() {

		return this.value;
	}
}
