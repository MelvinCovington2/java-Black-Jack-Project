package com.blackJackGame;

import java.util.*;

public class BlackJackGameDriver {

	public static void main(String[] args) {
		// Ready Message

		Scanner userInput = new Scanner(System.in);
		String playAgain;

		do {

			System.out.println("Ready to Play Black Jack?!");

			// The deck the will be played from
			CardDeck playing_deck = new CardDeck();
			playing_deck.fillDeck();
			playing_deck.shuffle();

			// Player Hand build
			CardDeck handPlayer = new CardDeck();
			// the amount of money player has to start
			double moneyPlayer = 100.0;

			// Dealer's hand
			CardDeck handDealer = new CardDeck();

			// Scanner for user input
			// Scanner userInput = new Scanner(System.in);

//Start the playing game 
			while (moneyPlayer > 0) {

				// Player places bet
				System.out.println("You have $" + moneyPlayer + ", what amount of money do you want to wager?");
				boolean endOfRound = false;
				double betPlayer = userInput.nextDouble();
				// player tries to bet more money than they have
				if (betPlayer > moneyPlayer) {
					System.out.println("whoa there big spender!! You don't have that type of cash!");
					break;
				}

				System.out.println("Deal the cards");
				// Two cards are drawn by player
				handPlayer.drawCard(playing_deck);
				handPlayer.drawCard(playing_deck);

				// Two cards are drawn by Dealer
				handDealer.drawCard(playing_deck);
				handDealer.drawCard(playing_deck);

				// Loop for drawing new cards
				while (true) {
					// Show player hand
					System.out.println("You are holding:" + handPlayer.toString());

					// value of hand
					System.out.println("The value of your hand is" + " " + handPlayer.deckCardValue());

					// dealer hand

					System.out.println(
							"The value of dealer hand is" + " " + handDealer.cardGet(0).toString() + "Face down card");

					// Player what do you want to do
					System.out.println("Would you like to (1) Hit or (2) Stand");
					int response = userInput.nextInt();

					// Hit option
					if (response == 1) {
						handPlayer.drawCard(playing_deck);
						System.out.println("You draw a" + handPlayer.cardGet(handPlayer.cardDeckSize() - 1).toString());
						// if over 21, player bust
						if (handPlayer.deckCardValue() > 21) {
							System.out.println("You Busted, currently valued at" + " " + handPlayer.deckCardValue());
							moneyPlayer -= betPlayer;
							endOfRound = true;
							break;
						}
					}
					// Stand Option
					if (response == 2) {

						break;
					}
				}

				// show dealer hand
				System.out.println("Deal's hand:" + " " + handDealer.toString());
				// See if dealer hand beats player's hand
				if ((handDealer.deckCardValue() > handPlayer.deckCardValue()) && endOfRound == false) {
					System.out.println("House wins");
					moneyPlayer -= betPlayer;

				}

				// Dealer hit and stand choice
				while ((handDealer.deckCardValue() < 17) && endOfRound == false) {
					handDealer.drawCard(playing_deck);
					System.out.println("Dealer draws" + handDealer.cardGet(handDealer.cardDeckSize() - 1).toString());
				}
				// Total value of dealer hand
				System.out.println("The dealer's hand is:" + " " + handDealer.deckCardValue());

				// Determine who wins
				if (handDealer.deckCardValue() > 21) {
					System.out.println("Dealer busted, You won the round");
					moneyPlayer += betPlayer;
					endOfRound = true;
				}
				if (handPlayer.deckCardValue() == handDealer.deckCardValue() && endOfRound == false) {
					System.out.println("Draw");
					endOfRound = true;
				}

				if ((handPlayer.deckCardValue() > handDealer.deckCardValue()) && endOfRound == false) {
					System.out.println("Player wins");
					moneyPlayer += betPlayer;
					endOfRound = true;
				}

				if ((handPlayer.deckCardValue() < handDealer.deckCardValue()) && endOfRound == false) {
					System.out.println("House wins");
					moneyPlayer -= betPlayer;
					endOfRound = true;
				}

				// return cards after round
				handPlayer.returnCardstoDeck(playing_deck);
				handDealer.returnCardstoDeck(playing_deck);
				System.out.println("End of hand");
			}
			System.out.println("Game over, do you want to play again?");
			playAgain = userInput.next();
		} while (playAgain.equalsIgnoreCase("Y"));

	}

}