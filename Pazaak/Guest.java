/**
 * 
 */
package Pazaak;

/**
 * @author Isaac
 *
 */
public class Guest extends Player {

	public Guest(Deck deck) {
		super(deck);
		// TODO Implement method.
	}

	@Override
	public boolean stand() {
		boolean stand = false;
		int value = this.valueOf();
		if(value > 18) {
			stand = true;
		} else if(value >= 16){
			stand = Math.random() < 0.5;
		}
		return stand;
	}

	@Override
	public int valueOf() {
		int sum = 0;
		for(Card card : hand) {
			sum += card.valueOf();
		}
		return sum;
	}

}
