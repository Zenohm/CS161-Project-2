/**
 * 
 */
package Pazaak;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Isaac
 *
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	private String[] values = {"Ace", "2", "3", "4", "5", "6", "7","8", "9", "10", "Jack", "Queen", "King"};
	
	public Deck() {		
		for(int suit=0; suit<suits.length; suit++) {
			for(int value=0; value<values.length; value++) {
				deck.add(new Card(values[value], suits[suit]));
			}
		}
	}
	
	/**
	 * Shuffle the cards
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Take the top card off the deck
	 * @return
	 */
	public Card dealCard() {
		Card topCard = deck.get(0);
		deck.remove(0);
		return topCard;
	}
	
	/**
	 * Put a card on the deck
	 * @param card
	 */
	protected void returnCard(Card card) {
		deck.add(card);
	}
	
}
