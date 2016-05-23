/**
 * 
 */
package Pazaak;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author Isaac
 *
 */
@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	private JLabel[] info = new JLabel[13];
	
	/**
	 * 
	 */
	public PlayerPanel(String playerName) {
		this.setLayout(new GridLayout(13,1));
		this.setBorder(new TitledBorder(playerName + " Hand"));
		this.initialize();
	}
	
	/**
	 * Reset the display
	 */
	public void reset() {
		info[0].setText("Sum = 0");
		for(int row=1; row<info.length; row++) {
			info[row].setText("Empty");
			info[row].setIcon(null);
		}
	}
	
	/**
	 * Start the display
	 */
	private void initialize() {
		for(int row=0; row<info.length; row++) {
			this.add((info[row] = new JLabel("Empty", JLabel.CENTER)));
		}
		info[0].setText("Sum = 0");
	}
	/**
	 * Take the information from the player's hand
	 * and display it in the appropriate player panel.
	 * @param player
	 */
	public void synchronize(Player player) {
		for(int card=0; card<player.hand.length; card++) {
			// Displays images instead of text for each card.
			//info[card+1].setIcon(player.hand[card].image);
			//info[card+1].setText("");
			// Displays text instead of an image for each card
			info[card+1].setText(player.hand[card].toString());
		}
		info[0].setText("Sum = " + player.valueOf());
	}


}
