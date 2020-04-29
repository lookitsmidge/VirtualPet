package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.event.*;
public class InteractPetPanel extends PanelCommander implements ActionListener, Runnable {
	JPanel interactPetPanel = new JPanel( null );
	
	JButton btnBack = new JButton();
	
	JLabel lblName = new JLabel();
	JLabel lblAge = new JLabel();
	JLabel lblType = new JLabel();
	
	JButton btnSpeak = new JButton();
	JButton btnPlay = new JButton();
	JButton btnFeed = new JButton();
	JButton btnToggleSleepWake = new JButton();
	JButton btnShowLove = new JButton();
	JTextArea txtLogWindow = new JTextArea();
	JScrollPane txtLogWindowScroll = new JScrollPane( txtLogWindow );
	
	private int offset = 30;
		
	/**
	 * This method is the overwritten method for the implementation of Runnable, to make this class a thread
	 */
	@Override
	public void run() {
		printt( "Thread - Building Interact Pet Panel" );
		initInteractPetPanel();
	}
	public void test() {
		printt("hello");
	}
	
	/**
	 * This method is to build the panel that the user will interact with the virtual pet in
	 */
	public void initInteractPetPanel() {
		makeGridX(4);
		makeGridY(6);
		int col1 = getXPos();
		int col2 = nextXPos();
		int col3 = nextXPos();
		int col4 = nextXPos();
		
		addButtonR( this, interactPetPanel, btnBack , col1, getYPos() + offset, "Back", "This button will take the user back to the Existing Pet Panel", 4 );
		
		addLabelR(lblType, interactPetPanel, col2, getYPos() + offset, "Type: " + AL.getActivesType(), 4);
		
		addLabelR(lblAge, interactPetPanel, col3, getYPos() + offset, "Age: " + AL.getActivesAge(), 5 );
		
		addLabelR( lblName, interactPetPanel, col4-40, getYPos() + offset, "Name: " + AL.getActivesName(), 2 );
		
		addScrollPane( txtLogWindowScroll, interactPetPanel, col3, nextYPos() + offset, frameSizeX - col3, frameSizeY - getYPos() );
		
		addButtonR( this, interactPetPanel, btnSpeak, col1, getYPos() + offset, "Speak", "This button will make your pet speak", 4);

		addButtonR( this, interactPetPanel, btnPlay, col2, getYPos() + offset, "Play", "This button will make your pet play", 4);

		addButtonR( this, interactPetPanel, btnFeed, col1, nextYPos() + offset, "Feed", "This button will feed your pet", 4);
		
		addButtonR( this, interactPetPanel, btnToggleSleepWake, col2, getYPos() + offset, "Sleep", "This button will make your pet sleep or wake up", 4);
		
		//showLove
		
		
		//special
	}
	
	/*
	 * This was a test to update - maybe fix? many null pointer exception things
	public void updateVals() {
		printt("updating");
		lblName.setText( "Name: " + AL.getActivesName() );
		lblAge.setText( "Age: " + AL.getActivesAge() );
	}
	*/
	
	public JPanel returnPanel() {
		return this.interactPetPanel;
	}
	
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			toExistingnPetPanel();
			AL.setActiveIndex(-1);
		}
		
		
		
	}
}
