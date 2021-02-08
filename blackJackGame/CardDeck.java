package com.blackJackGame;

import java.util.*;

//Deck builder 

public class CardDeck {

//Array of the cards in the deck 
	private ArrayList<Card> cards;

//CardDeck constructor 	
	public CardDeck() {
		// New deck of cards created
		this.cards = new ArrayList<Card>();
	}

// Deck filler
	public void fillDeck() {
		// Creating cards and assigning suits and values
		for (CardSuit C_suit : CardSuit.values()) {

			for (CardValue C_Value : CardValue.values()) {

				// Adding in the new cards created
				this.cards.add(new Card(C_suit, C_Value));

			}

		}

	}

// shuffling the deck of cards 
	public void shuffle() {
		// new Array list of cards to temporary hold the deck of cards
		ArrayList<Card> Shuf_Deck = new ArrayList<Card>();
		// using random method to shuffle deck
		Random random = new Random();
		int randomIndexCard = 0;
		// Maintain the original deck size
		int deckOriginalSize = this.cards.size();

		for (int i = 0; i < deckOriginalSize; i++) {
			// Random generator ((MAX-MIN)+1)
			randomIndexCard = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			// Loading the Shuf_Deck
			Shuf_Deck.add(this.cards.get(randomIndexCard));
			// Removing card from deckOrginalSize
			this.cards.remove(randomIndexCard);
		}
		// placing shuffled cards into temporary deck
		this.cards = Shuf_Deck;
	}

//Getters and Setters 
	// Card removed from deck
	public void cardRemove(int i) {
		this.cards.remove(i);
	}

	public Card cardGet(int i) {
		return this.cards.get(i);
	}

	// adding card to deck
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}

	// Card draw from the top of deck
	public void drawCard(CardDeck drawFrom) {
		// Add incoming card
		this.cards.add(drawFrom.cardGet(0));
		// Incoming card removed from where came
		drawFrom.cardRemove(0);
	}

	// Prints deck
	public String toString() {
		String cardOutPutList = "";
		int i = 0;
		for (Card listedCard : this.cards) {
			cardOutPutList += "\n" + listedCard.toString();
			i++;
		}
		return cardOutPutList;
	}

	// Card returner
	public void returnCardstoDeck(CardDeck sendCardTo) {
		int sizeOfThisDeckSize = this.cards.size();

		// move card into moveTo deck

		for (int i = 0; i < sizeOfThisDeckSize; i++) {
			sendCardTo.addCard(this.cardGet(i));
		}

		// emptying the deck

		for (int i = 0; i < sizeOfThisDeckSize; i++) {
			this.cardRemove(0);
		}
	}

	public int cardDeckSize() {
		return this.cards.size();
	}

	// Returns value of card's value
	public int deckCardValue() {
		int totalCardValue = 0;
		int aces = 0;

		for (Card c_Value : this.cards) {
			switch (c_Value.getValue()) {
			case Two:
				totalCardValue += 2;
				break;

			case Three:
				totalCardValue += 3;
				break;

			case Four:
				totalCardValue += 4;
				break;

			case Five:
				totalCardValue += 5;
				break;

			case Six:
				totalCardValue += 6;
				break;

			case Seven:
				totalCardValue += 7;
				break;

			case Eight:
				totalCardValue += 8;
				break;

			case Nine:
				totalCardValue += 9;
				break;

			case Ten:
				totalCardValue += 10;
				break;

			case Jack:
				totalCardValue += 10;
				break;

			case Queen:
				totalCardValue += 10;
				break;

			case King:
				totalCardValue += 10;
				break;

			case Ace:
				aces += 1;
				break;
			}
		}
		// Change the value of ace to 1 if totalCardValue is greater than 10
		for (int i = 0; i < aces; i++) {

			if (totalCardValue > 10) {
				totalCardValue += 1;
			} else {
				totalCardValue += 11;
			}
		}

		return totalCardValue;
	}
}
