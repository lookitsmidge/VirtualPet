package virtualPetInterface.Panels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

/**
 * This class contains everything to do with the Existing pet panel, including the thread that builds it.
 * to use, create object of type ExistingPetPanel, then create a runnable of type EPP, then .start()
 * later .join()
 * 
 * this class handles its own actionListeners.
 * @author James Martland 24233781
 */
public class ExistingPetPanel extends PanelCommander implements ActionListener, Runnable{
	//where I declare all of my components
	JPanel existingPetPanel = new JPanel( null );
	
	JButton btnBack = new JButton();
	
	// Setting up the table to store the pets in to view them
	static String[] headingsPet = {"Type", "Name", "Age"}; // If time try and add button on the end of each row - need to write own cell renderer apparently
	static String[][] petTableData = new String[0][0];
	static DefaultTableModel petTableModel = new DefaultTableModel(petTableData, headingsPet);
	JTable tablePet = new JTable(petTableModel);
	JScrollPane petTableScroll = new JScrollPane(tablePet);
	
	
	String[] comboPet_Data = new String[0];
	static int tmpxLocxForComboBox;
	static int tmpLocyForComboBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboChoosePet = new JComboBox(comboPet_Data);
	
	JButton btnSelect = new JButton();
	
	//Threads
	/**
	 * The aim of these threads is to make the two components fill up quicker
	 */
	private Thread popTbl = new Thread( 
			new Runnable() {
				public void run() {
					printt( "THREAD: popTbl: Running" );
					populateTable();
					printt( "THREAD: popTbl: Finished" );
				}
			}
		);
	private Thread popCmbo = new Thread(
			new Runnable() {
				public void run() {
					printt( "THREAD: popCmbo: Running" );
					updateComboBox();
					printt( "THREAD: popCmbo: Finished" );
				}
			}
		);
	
	//End of Threads
	/**
	 * This is the Overridden function that is used to run the thread
	 */
	@Override
	public void run() {
		printt( "Thread - Building Existing Pet Panel" );
		initExistingPetPanel();
	}
	
	/**
	 * This method is to build this panel and its components
	 */
	public void initExistingPetPanel() {
		setTag( "ExistingPetPnl" );
		int offset = 30;
		makeGridX( 2 );
		makeGridY( 5 );
		
		tmpxLocxForComboBox = getXPos();
		addButtonL(this, existingPetPanel, btnBack, getXPos(), getYPos() + offset, "Back", "This button will take you back to the home screen");

		addScrollPane(petTableScroll, existingPetPanel, 5, nextYPos() + offset, frameSizeX - 10, makeInt( frameSizeY/2 ) );
		nextYPos();
		nextYPos();
		addButtonL(this, existingPetPanel, btnSelect, nextXPos(), nextYPos() + offset, "Select", "This Button is to select the animal currently in the combo box");
		tmpLocyForComboBox = getYPos();
		updateGUI();
	}
	
	/**
	 * This method is to update the table and combo box - this uses threads
	 */
	public void updateGUI() {
		
		popTbl.start();
		popCmbo.start();
		try {
			popTbl.join();
			popCmbo.join();
		} catch( InterruptedException e ) {
			errPrint( "An error Occurred when populating ExistingPetPanel" + e );
		} finally {
			printt( "Finished Populating" );			
		}
	}
	
	/**
	 * This method is to update the combo box - this should be called whenever a pet is added
	 * Called From Thread
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateComboBox() {
		printt( "Updating Combo Box" );
		comboPet_Data = new String[AL.getNextLocation()];
		for( int i = 0; i < AL.getNextLocation(); i++) {
			comboPet_Data[i] = AL.getAnimalLoc(i).toString();
		}
		comboChoosePet = new JComboBox(comboPet_Data);
		addComboBoxL(comboChoosePet, existingPetPanel, tmpxLocxForComboBox, tmpLocyForComboBox + 30 );
	}
	
	/**
	 * This method is to update the table - this should be called whenever a pet is added
	 * Called From Thread
	 */
	public void populateTable() {
		printt( "Populating Table" );
		petTableModel.setRowCount(0);
		for( int i=0; i < AL.getNextLocation(); i++ ) {
			String[] dataToAdd = { AL.getAnimalLoc(i).getType(), 
					AL.getAnimalLoc(i).getName(), 
					AL.getAnimalLoc(i).getAge() + "" };
			petTableModel.addRow(dataToAdd);
		}
	}
	
	/**
	 * This method is to return the panel that has been created
	 * @return
	 */
	public JPanel returnPanel() {
		return this.existingPetPanel;
	}
	
	/**
	 * This method is to handle the ActionEvents that are caused by the button presses
	 */
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			//go back to home screen
			//this should clear the comboBox too
			toStartPanel();
			comboChoosePet.setSelectedIndex(0);
		}
		if( e.getSource() == btnSelect ) {
			//combo selected index will be the same as the animal location in the array
			printt( "Selected: " + (String) comboChoosePet.getSelectedItem() );
			AL.setActiveIndex( comboChoosePet.getSelectedIndex() );
			toInteractPanel();			
		}
	}
		
}
