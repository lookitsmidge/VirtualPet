package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.event.*;
public class StartPanel extends PanelCommander  implements ActionListener, Runnable{
	
	private JButton btnExisting = new JButton();
	private JButton btnNew = new JButton();
	JPanel startPanel = new JPanel( null );
	
	@Override
	public void run() {
		initStartPanel();
		// use (threadName).join; in other class		
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
		//build other button and add it
		printt( "Finished panel Creation" );
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
			toNewPetPanel();
		}
	}
}
