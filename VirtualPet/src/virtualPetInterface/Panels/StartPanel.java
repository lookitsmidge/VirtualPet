package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilities.BuildUtilitiesVPV1;
public class StartPanel extends BuildUtilitiesVPV1  implements ActionListener, Runnable{
	JButton btnExisting = new JButton();
	JButton btnNew = new JButton();
	JPanel startPanel;
	boolean panelBuilt = false;
	
	@Override
	public void run() {
		initStartPanel();
		// use (threadName).join; in other class
	}
	//make this a thread
	
	public StartPanel() {
		super();
	}
	public void initStartPanel() {
		setTag( "STARTPANEL" );
		startPanel = new JPanel( null );
		
		// this is where all of the code that builds the panel will be 
		printt( "building btnExisting" );
		addButton(this, startPanel, btnExisting,
				40, 40, "Existing", 100, 50,
				"This Button is to pick a pet that is already stored" );
		printt( "building btnNew" );
		addButton(this, startPanel, btnNew,
				150, 40, "New", 100, 50,
				"This Button is to create a new pet");
		//build button and add it
		panelBuilt = true;
		//build other button and add it
	}
	/**
	 * This is how I am going to return the panel that is being built
	 * @return startPanel
	 */
	public JPanel returnPanel() {
		return this.startPanel;
	}
	
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnExisting ) {
			printt( "btnExisting Pressed" );
		}
		if( e.getSource() == btnNew ) {
			printt( "btnNew Pressed" );
		}
	}
}
