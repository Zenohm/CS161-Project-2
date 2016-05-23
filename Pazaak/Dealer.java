/**
 * 
 */
package Pazaak;

/**
 * @author Isaac
 *
 */
public class Dealer extends Player {

	/**
	 * 
	 */
	
	public Dealer(Deck deck) {
		super(deck);
		// TODO Implement method.
	}

	@Override
	public boolean stand() {
		return this.valueOf() > 16;
	}

	@Override
	public int valueOf() {
		int sum = 0;
		for(Card card : hand) {
			sum += card.valueOf();
			if(card.getName().equals("Ace")) {
				if(sum < 12) {
					sum += 10;
				}
			}
		}
		return sum;
	}

}
