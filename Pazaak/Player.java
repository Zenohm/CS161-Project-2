/**
 * 
 */
package Pazaak;

/**
 * @author Isaac
 *
 */
public abstract class Player {
	protected Card[] hand = new Card[12];
	protected Deck deck;
	
	public Player(Deck deck) {
		this.deck = deck;
		for(int card=0; card<hand.length; card++) {
			hand[card] = new Card();
		}
	}
	
	/**
	 * Player accepts current value as final value
	 * @return
	 */
	public abstract boolean stand();
	
	/**
	 * Get the total value of the cards in the player's hand
	 * @return
	 */
	public abstract int valueOf();
	
	public void clearHand() {
		for(int card=0; card<hand.length; card++) {
			if(!hand[card].isEmpty()) {
				deck.returnCard(hand[card]);
				hand[card] = new Card();
			}
		}
	}
	
	/**
	 * Player goes over limit
	 * @return
	 */
	public boolean bust() {
		int sum = 0;
		for(Card card : hand) {
			sum += card.valueOf();
		}
		return sum > 21;
	}
	
	/**
	 * Add a card to player's hand
	 */
	public void hit() {
		for(int card=0; card<hand.length; card++) {
			if(hand[card].isEmpty()) {
				hand[card] = deck.dealCard();
				break;
			}
		}
	}
	
	/**
	 * Play until end condition
	 */
	public void play() {
		// Play until the player stands or busts.
		while(!bust() && !stand()) {
			hit();
		}
	}
	
}
