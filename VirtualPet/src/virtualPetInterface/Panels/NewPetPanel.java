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
		
		//adding all of the components
		int offset = 30; // bc this panel messes up due to the tabbed pane ( ignore )
		printt( "Building lblName" );
		addLabel(lblName, newPetPanel, 0, 0+ offset, "Name Of Pet:", 100, 50 );
		printt( "Building txtName" );
		addTextField(txtName, newPetPanel, 150, 0+ offset, 100, 50);
		printt( "Building lblAge" );
		addLabel(lblAge, newPetPanel, 0, 50+ offset, "Age Of Pet:", 100, 50);
		printt( "Building txtAge" );
		addTextField(txtAge, newPetPanel, 150, 50+ offset, 100, 50);
		printt(" Building comboType" );
		addComboBox(comboType, newPetPanel, 20, 100+ offset, 120, 50);
		
		printt( "Building btnCancel" );
		addButton(this, newPetPanel, btnCancel, 30, 160+ offset, "Cancel", 100, 50, "This button is to cancel creation and go back to home screen" );
		printt( "Building btnSubmit" );
		addButton(this, newPetPanel, btnSubmit, 150, 160+ offset, "Submit", 100, 50, "This Button is to save the current pet details as a pet" );
		
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
		if ( e.getSource() == btnSubmit) {
			//get strings from boxes
			if ( comboType.getSelectedIndex() == 0 ) {
				printt( "You Must Select A Type" );
				optPane( "You Must Select A Type" );
			} else {
				//next is lookup check
				String name = txtName.getText().trim();
				if ( V.illegalCharCheck(name) ) {
					String age = txtAge.getText().trim();
					String type = (String) comboType.getSelectedItem();
					if ( AL.findNme(name) == -1 ) {
						//name doesnt already exist
						if ( V.isInt( age ) ) {
							// push all answers through
							AL.animalSwitch( type, name, Integer.parseInt(age) );
							txtName.setText("");
							txtAge.setText("");
							comboType.setSelectedIndex(0);
						} else {
							printt( "age must be an integer" );
							optPane( "Age Must Be An Integer" );
						}
					} else {
						//if it is found
						printt("found name - you cant input a name that exists");
						optPane( "You Can't Use A Name That Already Exists" );
					}
				} else {
					printt( "You have used an illegal character" );
					optPane( "You Must Not Use Illegal Characters" );
				}
			}			
			
			// check name doesnt exist - lookup check
			
			//check for illegal characters
			
			//check type has been selected
			
			//create pet
			
			//clear fields
			
			
		}
	}
}
