package Pazaak;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TwentyOneGUI extends JFrame {
	public final int WINDOW_LENGTH = 500;
	public final int WINDOW_HEIGHT = 200;
	
	private TableGUI tableGUI;
	private Deck d;
	private Guest guest;
	private Dealer dealer;
	
	private NewGameHandler newGameHandle = new NewGameHandler();
	private DealGuestHandler dealGuestHandle = new DealGuestHandler();
	private DealDealerHandler dealDealerHandle = new DealDealerHandler();
	private ExitButtonHandler exitButtonHandle = new ExitButtonHandler();
	
	private JPanel  mainPanel = new JPanel();
	private JPanel  buttonsLeft = new JPanel();
	private JPanel  buttonsRight = new JPanel();
	
	private JPanel  guestInfo = new JPanel();
	private JPanel  dealerInfo = new JPanel();	
	private JLabel  guestText = new JLabel("Guest Wins", JLabel.CENTER);
	private JLabel  dealerText = new JLabel("Dealer Wins", JLabel.CENTER);
	private JLabel  guestScore = new JLabel("0", JLabel.CENTER);
	private JLabel  dealerScore = new JLabel("0", JLabel.CENTER);
	private JButton button_Start = new JButton("Start Game");
	private JButton button_LeaveTable = new JButton("Leave Table");
	private JButton button_DealGuest = new JButton("Deal Guest Cards");
	private JButton button_DealDealer = new JButton("Deal Dealer Cards");
	
	private int guestWins;
	private int dealerWins;
	
	public TwentyOneGUI() {		
		this.setLocationRelativeTo(null);
		this.setLocation(this.getX() - WINDOW_LENGTH, this.getY() - WINDOW_HEIGHT);
		
		tableGUI = new TableGUI(this);
		
		mainPanel.setLayout(new GridLayout(2,2));
		mainPanel.add(guestInfo);
		mainPanel.add(dealerInfo);
		mainPanel.add(buttonsLeft);
		mainPanel.add(buttonsRight);
		
		guestInfo.setLayout(new GridLayout(2,1));
		guestInfo.setBackground(Color.MAGENTA);
		guestInfo.add(guestText);
		guestInfo.add(guestScore);
		
		dealerInfo.setLayout(new GridLayout(2,1));
		dealerInfo.setBackground(Color.CYAN);
		dealerInfo.add(dealerText);
		dealerInfo.add(dealerScore);
		
		buttonsLeft.setLayout(new GridLayout(2,1));
		buttonsLeft.add(button_Start);
		buttonsLeft.add(button_DealGuest);
		
		buttonsRight.setLayout(new GridLayout(2,1));
		buttonsRight.add(button_LeaveTable);
		buttonsRight.add(button_DealDealer);
		
		button_DealGuest.setEnabled(false);
		button_DealDealer.setEnabled(false);
		
		button_Start.addActionListener(newGameHandle);
		button_LeaveTable.addActionListener(exitButtonHandle);
		button_DealGuest.addActionListener(dealGuestHandle);
		button_DealDealer.addActionListener(dealDealerHandle);
		
		this.add(mainPanel);
		this.setTitle("Score Board");
		this.setSize(WINDOW_LENGTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private class NewGameHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			d = new Deck();
			guest = new Guest(d);
			dealer = new Dealer(d);
			guestWins = 0;
			dealerWins = 0;
			guestScore .setText("0");
			dealerScore.setText("0");
			d.shuffle();
			tableGUI.reset();
			tableGUI.setHeaderText("Good Luck!");
			button_DealGuest.setEnabled(true);
		}
		
	}
	
	private class DealGuestHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			guest.clearHand();
			d.shuffle();
			guest.play();
			tableGUI.updateInfo(guest);
			int handSum = guest.valueOf(); // handSumDVL
			if(handSum <= 21) {
				tableGUI.setHeaderText("Guest hand = " + handSum);
				button_DealGuest.setEnabled(false);
				button_DealDealer.setEnabled(true);
			} else {
				tableGUI.setHeaderText("Guest bust!");
				++dealerWins;
			}
			guestScore .setText(String.valueOf(guestWins));
			dealerScore.setText(String.valueOf(dealerWins));
		}
		
	}
	
	private class DealDealerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dealer.clearHand();
			d.shuffle();
			dealer.play();
			tableGUI.updateInfo(dealer);
			button_DealGuest.setEnabled(true);
			button_DealDealer.setEnabled(false);
			int dealerSum = dealer.valueOf();
			if(dealerSum <= 21) {
				// TODO Add greater than checking.
				int guestSum = guest.valueOf();
				if(dealerSum < guestSum) {
					tableGUI.setHeaderText("Guest wins!");
					++guestWins;
				} else if(dealerSum > guestSum) {
					tableGUI.setHeaderText("Dealer wins!");
					++dealerWins;
				} else {
					tableGUI.setHeaderText("Game pushed");
					++dealerWins;
					++guestWins;
				}
			} else {
				tableGUI.setHeaderText("Dealer bust => Guest wins!");
				++guestWins;
			}
			guestScore .setText(String.valueOf(guestWins));
			dealerScore.setText(String.valueOf(dealerWins));
			
			// TODO Finish action button functionality
		}
		
	}

	private class ExitButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}


}


