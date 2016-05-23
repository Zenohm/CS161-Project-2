/**
 * 
 */
package Pazaak;

import javax.swing.ImageIcon;

/**
 * @author Isaac
 *
 */
public class Card {
	private String suit;
	private String name;
	private String fullName;
	private String imagePath;
	public ImageIcon image;
	private boolean empty;
	
	/**
	 * Empty card.
	 */
	public Card() {
		this.name = "";
		this.suit = "";
		this.fullName = "";
		this.imagePath = "";
		this.empty = true;
	}
	
	/**
	 * Card with info.
	 * @param name
	 * @param suit
	 */
	public Card(String name, String suit) {
		this.name = name;
		this.suit = suit;
		this.fullName = name + " of " + suit;
		this.imagePath = "cards/" + name + "_of_" + suit + ".png";
		this.image = new ImageIcon(this.imagePath);
		this.empty = false;
	}
	
	/**
	 * Return the card's numeric value.
	 * @return
	 */
	public int valueOf() {
		int value = 0;
		
		if(this.name.length() == 1) {
			value = Integer.parseInt(this.name);
		} else {
			switch(name) {
				case "Ace":
					value = 1;
					break;
				case "Jack":
					value = 10;
					break;
				case "Queen":
					value = 10;
					break;
				case "King":
					value = 10;
					break;
				case "10":
					value = 10;
					break;
				case "":
					value = 0;
					break;
			}
		}
		
		return value;
	}
	
	/**
	 * Is it a blank card
	 * @return
	 */
	public boolean isEmpty() {
		return this.empty;
	}
	
	/**
	 * Return the card's name.
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the card's suit.
	 * @return
	 */
	
	public String getSuit() {
		return this.suit;
	}
	
	@Override
	public String toString() {
		return this.fullName;
	}

}
