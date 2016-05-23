/**
 * 
 */
package Pazaak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Isaac
 *
 */
@SuppressWarnings("serial")
public class TableGUI extends JFrame {
	private final int WINDOW_LENGTH = 400;
	private final int WINDOW_HEIGHT = 500;
	
	private JPanel  main   = new JPanel();
	private JPanel  info   = new JPanel();
	private JPanel  header = new JPanel();
	private JLabel  headerText = new JLabel("Empty Table");
	private PlayerPanel guest  = new PlayerPanel("Guest");
	private PlayerPanel dealer = new PlayerPanel("Dealer");
	
	public TableGUI(TwentyOneGUI mainWindow) {
		main.setLayout(new BorderLayout());
		info.setLayout(new GridLayout(1,2));
		
		header.setBackground(Color.GREEN);		
		header.add(headerText);
		
		main.add(header, BorderLayout.NORTH);
		main.add(info, BorderLayout.CENTER);
		info.add(guest);
		info.add(dealer);
		
		this.add(main);
		this.setSize(WINDOW_LENGTH, WINDOW_HEIGHT);
		this.setLocationRelativeTo(mainWindow);
		this.setLocation((mainWindow.getX() + mainWindow.WINDOW_LENGTH), this.getY());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setHeaderText(String text) {
		headerText.setText(text);
	}
	
	public void reset() {
		headerText.setText("Empty Table");
		dealer.reset();
		guest.reset();
	}
	
	public void updateInfo(Player player) {
		if(player instanceof Dealer) {
			dealer.synchronize(player);
		} else if(player instanceof Guest) {
			guest.synchronize(player);
		}
	}
		
}