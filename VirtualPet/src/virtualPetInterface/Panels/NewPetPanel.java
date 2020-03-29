package virtualPetInterface.Panels;
import javax.swing.*;

import java.awt.event.*;
public class NewPetPanel extends PanelCommander implements ActionListener, Runnable{
	
	JPanel newPetPanel = new JPanel( null );
	
	JButton btnCancel = new JButton();
	JButton btnSubmit =  new JButton();
	
	//Fields To Fill In
	JLabel lblName = new JLabel();
	JTextField txtName =  new JTextField();
	JLabel lblAge = new JLabel();
	JTextField txtAge = new JTextField();
	
	String[] comboType_data = {"Please Choose", "Cat", "Chicken", "Dog", "Goat", "Goose"};
	JComboBox comboType = new JComboBox(comboType_data);
	
	@Override
	public void run() {
		printt("Thread - Building New Pet Panel" );
		initNewPetPanel();
	}
	public void initNewPetPanel() {
		setTag( "NPPanel" );
		//newPetPanel = new JPanel( null );
		//adding all of the components
		printt( "Building lblName" );
		addLabel(lblName, newPetPanel, 0, 10, "Name Of Pet:", 100, 50 );
		printt( "Building txtName" );
		addTextField(txtName, newPetPanel, 150, 10, 100, 50);
		printt( "Building lblAge" );
		addLabel(lblAge, newPetPanel, 0,60, "Age Of Pet:", 100, 50);
		printt( "Building txtAge" );
		addTextField(txtAge, newPetPanel, 150, 60, 100, 50);
		printt(" Building comboType" );
		addComboBox(comboType, newPetPanel, 20, 110, 120, 50);
		
		printt( "Building btnCancel" );
		addButton(this, newPetPanel, btnCancel, 30, 160, "Cancel", 100, 50, "This button is to cancel creation and go back to home screen" );
		printt( "Building btnSubmit" );
		addButton(this, newPetPanel, btnSubmit, 150, 160, "Submit", 100, 50, "This Button is to save the current pet details as a pet" );
		
		printt( "Finished Panel Creation" );
	}
	public JPanel returnPanel() {
		return this.newPetPanel;
	}
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnCancel) {
			// switch panel back and erase all data in text fields
			toStartPanel();
		}
	}
}
