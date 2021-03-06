package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class is the panel that is loaded when the program is started - this is the first screen that the user should see
 * ( other than the Command Line - that logs everything )
 * This class runs in a thread - you need to use the .join command in the calling class and then returnPanel
 * create an object
 * @author James Martland 24233781
 *
 */
public class StartPanel extends PanelCommander  implements ActionListener, Runnable{
	
	private JButton btnExisting = new JButton();
	private JButton btnNew = new JButton();
	JPanel startPanel = new JPanel( null );
	
	
	/**
	 * This is the override method for running the thread
	 */
	@Override
	public void run() {
		printt( "Thread - Building Start panel" );
		initStartPanel();
		printt( "Thread - Finished panel Creation" );
	}
	
	/**
	 * This is the method to create the panel
	 */
	public void initStartPanel() {
		setTag( "STARTPANEL" );
		startPanel = new JPanel( null );
		
		makeGridX(2);
		makeGridY(2);
		addButtonL( this, startPanel, btnExisting,
				getXPos(), nextYPos(), "Existing",
				"This Button is to pick a pet that is already stored" );

		addButtonL( this, startPanel, btnNew,
				nextXPos(), getYPos(), "New",
				"This Button is to create a new pet" );
	}
	
	/**
	 * This is how I am going to return the panel that is being built
	 * @return startPanel
	 */
	public JPanel returnPanel() {
		return this.startPanel;
	}
	
	/**
	 * This is the action event code for this panel
	 */
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnExisting ) {
			printt( "btnExisting Pressed" );
			toExistingnPetPanel();
		}
		if( e.getSource() == btnNew ) {
			printt( "btnNew Pressed" );
			toNewPetPanel();
		}
	}
}
