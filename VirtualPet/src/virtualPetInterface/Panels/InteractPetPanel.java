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
		//code to build panel
		addButton( this, interactPetPanel, btnBack , 0, 0 + offset, "Back", 100, 50, "This button will take the user back to the Existing Pet Panel" );
		
		addLabel( lblName, interactPetPanel, 150, 0 + offset, "Name: " + AL.getActivesName(), 100, 50 );
		
		addLabel(lblAge, interactPetPanel, 250, 0 + offset, "Age: " + AL.getActivesAge(), 100, 50);
		
		//addLabel(lblType, interactPetPanel, x, y, text, sizeX, sizeY);
		/*
		printt( "Building Speak Button" );
		
		printt( "Building Play Button" );
		
		printt( "Building Feed Button" );
		
		printt( "Building toggleSleepWake Button" );
		
		printt( "Building Text Area" );
		*/
	}
	
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
