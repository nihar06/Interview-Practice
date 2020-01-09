package whiteBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum card_design {

	HEARTS, SPADE, DIAMONDS, CLUB;
}

enum cards_number {
	A, J, Q, K, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;

}

class Card {
	private card_design cardDesign;
	private cards_number cardNumber;

	public card_design getCardDesign() {
		return cardDesign;
	}

	public cards_number getCardNumber() {
		return cardNumber;
	}

	Card(card_design cardDesign, cards_number cardNumber) {
		this.cardDesign = cardDesign;
		this.cardNumber = cardNumber;
	}
}

public class Deck {
	static List<Card> deck;

	public static List<Card> genetateDeck() {
		deck = new ArrayList<>();
		for (cards_number cardNum : cards_number.values()) {
			deck.add(new Card(card_design.HEARTS, cardNum));
			deck.add(new Card(card_design.SPADE, cardNum));
			deck.add(new Card(card_design.DIAMONDS, cardNum));
			deck.add(new Card(card_design.CLUB, cardNum));
		}
		return deck;
	}

	public static void shuffle(List<Card> deck) {
		for (int i = 0; i < deck.size(); i++) {
			int rand = (int) (Math.random() * 51);
			Collections.swap(deck, i, rand);

		}
	}

	public static void main(String args[]) {

		List<Card> deck = genetateDeck();
		print(deck);
		shuffle(deck);
		print(deck);
	}

	public static void print(List<Card> deck) {
		for (Card card : deck) {
			System.out.print(card.getCardDesign() + "  " + card.getCardNumber() + "   ");
		}
		System.out.println("\n");
	}
}
