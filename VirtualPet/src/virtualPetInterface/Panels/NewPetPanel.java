package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.event.*;

/**
 * This Class will be where the panel is built that is for the user to make a new pet
 * @author James Martland 24233781
 */
public class NewPetPanel extends PanelCommander implements ActionListener, Runnable{
	
	JPanel newPetPanel = new JPanel( null );
	
	JButton btnCancel = new JButton();
	JButton btnSubmit =  new JButton();
	
	//Fields To Fill In
	JLabel lblName = new JLabel();
	JTextField txtName =  new JTextField();
	JLabel lblAge = new JLabel();
	JTextField txtAge = new JTextField();
	
	JLabel lblType = new JLabel();
	String[] comboType_data = {"Please Choose", "Cat", "Chicken", "Dog", "Goat", "Goose"};
	
	// this is because Eclipse was annoying me about this ComboBox
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboType = new JComboBox(comboType_data);
	
	
	/**
	 * This is the overridden method for running the thread
	 */
	@Override
	public void run() {
		printt("Thread - Building New Pet Panel" );
		initNewPetPanel();
	}
	
	/**
	 * This is the method that is to build the panel
	 * 
	 * NB validate so frame cannot get too small
	 */
	public void initNewPetPanel() {
		setTag( "NPPanel" );
		
		//adding all of the components
		int offset = 30; // because this panel messes up due to the Tabbed pane ( ignore )
				
		makeGridX( 2 );
		int col1 = getXPos();
		int col2 = nextXPos();
		makeGridY( 4 );
				
		addLabelL(lblName, newPetPanel, col1, getYPos() + offset, "Name Of Pet:");

		addTextFieldL(txtName, newPetPanel, col2, getYPos() + offset);

		addLabelL(lblAge, newPetPanel, col1, nextYPos() + offset, "Age Of Pet:");

		addTextFieldL(txtAge, newPetPanel, col2, getYPos() + offset);
		
		addLabelL(lblType, newPetPanel, col1, nextYPos() + offset, "Type Of Pet:");
		
		addComboBoxL(comboType, newPetPanel, col2, getYPos() + offset);
		

		addButtonL(this, newPetPanel, btnCancel, col1, nextYPos() + offset, "Cancel", "This button is to cancel creation and go back to home screen" );

		addButtonL(this, newPetPanel, btnSubmit, col2, getYPos() + offset, "Submit", "This Button is to save the current pet details as a pet" );
		
		printt( "Finished Panel Creation" );
	}
	
	/**
	 * This returns the panel that is created in the thread
	 * @return
	 */
	public JPanel returnPanel() {
		return this.newPetPanel;
	}
	
	/**
	 * This is the required method that is used for all of the buttons
	 */
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
				if ( V.illegalCharCheck(name) ) { // checks the input for Illegal Characters
					String age = txtAge.getText().trim();
					String type = (String) comboType.getSelectedItem();
					if ( AL.findNme(name) == -1 ) {
						//name doesn't already exist
						if ( V.isInt( age ) ) {
							// push all answers through
							AL.animalSwitch( type, name, Integer.parseInt(age) );
							//clear all fields
							txtName.setText("");
							txtAge.setText("");
							comboType.setSelectedIndex(0);
							optPane( "Pet Has Been Added" );
							newPetAdded = true;
							toStartPanel();
						} else {
							printt( "age must be an integer" );
							optPane( "Age Must Be An Integer" );
						}
					} else {
						//if name is found in array
						printt("Found name - you cant input a name that exists");
						optPane( "You Can't Use A Name That Already Exists" );
					}
				} else {
					printt( "You have used an illegal character" );
					optPane( "You Must Not Use Illegal Characters" );
				}
			}
		}
	}
}
