package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class builds the interact pet panel 
 * @author James Martland 24233781
 *
 */
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
	JButton btnSpecial = new JButton();
	
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
	
	/**
	 * This method is to build the panel that the user will interact with the virtual pet in
	 */
	public void initInteractPetPanel() {
		// making a grid
		makeGridX(4);
		makeGridY(6);
		int col1 = getXPos();
		int col2 = nextXPos();
		int col3 = nextXPos();
		int col4 = nextXPos();
		
		addButtonR( this, interactPetPanel, btnBack , col1, getYPos() + offset, "Back", "This button will take the user back to the Existing Pet Panel", 4 );
		
		addLabelR( lblType, interactPetPanel, col2, getYPos() + offset, "Type: " + AL.getActivesType(), 4);
		
		addLabelR( lblAge, interactPetPanel, col3, getYPos() + offset, "Age: " + AL.getActivesAge(), 5 );
		
		addLabelR( lblName, interactPetPanel, col4-40, getYPos() + offset, "Name: " + AL.getActivesName(), 2 );
		
		txtLogWindow.setEditable(false);// making it so that the box isnt editable
		addScrollPane( txtLogWindowScroll, interactPetPanel, col3, nextYPos() + offset, frameSizeX - col3, frameSizeY - getYPos() );
		
		addButtonR( this, interactPetPanel, btnSpeak, col1, getYPos() + offset, "Speak", "This button will make your pet speak", 4);

		addButtonR( this, interactPetPanel, btnPlay, col2, getYPos() + offset, "Play", "This button will make your pet play", 4);

		addButtonR( this, interactPetPanel, btnFeed, col1, nextYPos() + offset, "Feed", "This button will feed your pet", 4);
		
		addButtonR( this, interactPetPanel, btnToggleSleepWake, col2, getYPos() + offset, "Sleep", "This button will make your pet sleep or wake up", 4);
		
		addButtonR( this, interactPetPanel, btnShowLove, col1, nextYPos() + offset, "Love", "This Button will show the pet that you love them", 4 );
		
		addButtonR( this, interactPetPanel, btnSpecial, col2, getYPos() + offset, "Special", "This button will activate the pets special ability", 4);
	}
	
	/**
	 * This returns the panel to PanelCommander
	 * @return interactPetPanel
	 */
	public JPanel returnPanel() {
		return this.interactPetPanel;
	}
	
	/**
	 * This method is the implemented actionPerformed method
	 * each button links to its corresponding method in the AnimalList
	 */
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			toExistingnPetPanel();
			AL.setActiveIndex(-1);
		}
		if( e.getSource() == btnSpeak ) {
			if( btnToggleSleepWake.getText().equals("Wake") ) {
				// its awake
				txtLogWindow.append( AL.getActivesName() + " is Asleep, please wake them first" );
			} else {
				// is asleep
				txtLogWindow.append( AL.speak() );	
			}
			txtLogWindow.append( "\n");
		}
		if( e.getSource() == btnFeed ) {
			if( btnToggleSleepWake.getText().equals("Wake") ) {
				// its awake
				txtLogWindow.append( AL.getActivesName() + " is Asleep, please wake them first" );
			} else {
				// is asleep
				txtLogWindow.append( AL.feed() );
			}
			txtLogWindow.append( "\n");
		}
		if( e.getSource() == btnPlay ) {
			if( btnToggleSleepWake.getText().equals("Wake") ) {
				// its awake
				txtLogWindow.append( AL.getActivesName() + " is Asleep, please wake them first" );
			} else {
				// is asleep
				txtLogWindow.append( AL.play() );
			}
			txtLogWindow.append( "\n");
		}
		if( e.getSource() == btnToggleSleepWake ) {
			if( btnToggleSleepWake.getText().equals("Sleep") ) {
				btnToggleSleepWake.setText("Wake");
				txtLogWindow.append(AL.getActivesName() + " is asleep" );
			} else {
				btnToggleSleepWake.setText( "Sleep" );
				txtLogWindow.append(AL.getActivesName() + " Woke up" );
			}
			txtLogWindow.append( "\n");
		}
		if( e.getSource() == btnShowLove ) {
			if( btnToggleSleepWake.getText().equals("Wake") ) {
				// its awake
				txtLogWindow.append( AL.getActivesName() + " is Asleep, please wake them first" );
			} else {
				// is asleep
				txtLogWindow.append( AL.showLove() );
			}
			txtLogWindow.append( "\n");
		}
		if( e.getSource() == btnSpecial ) {
			if( btnToggleSleepWake.getText().equals("Wake") ) {
				// its awake
				txtLogWindow.append( AL.getActivesName() + " is Asleep, please wake them first" );
			} else {
				// is asleep
				txtLogWindow.append( AL.special() );
			}
			txtLogWindow.append( "\n");
		}
	}
}