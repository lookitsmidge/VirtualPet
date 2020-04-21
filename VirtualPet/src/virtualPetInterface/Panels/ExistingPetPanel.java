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
 *
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
		printt( "Building btnBack" );
		addButton(this, existingPetPanel, btnBack, 0, 0 + offset, "Back", 100, 50, "This button will take you back to the home screen");
		print( "Building petTableScroll" );
		addTable(petTableScroll, existingPetPanel, 0, 60 + offset, 300, 100);
		print( "" );
		addButton(this, existingPetPanel, btnSelect, 150, 170 + offset, "Select", 100, 50, "This Button is to select the animal currently in the combo box");
		updateGUI();
	}
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateComboBox() {
		// Reinitialises the variable
		printt( "Updating Combo Box" );
		comboPet_Data = new String[AL.getNextLocation()];
		for( int i = 0; i < AL.getNextLocation(); i++) {
			comboPet_Data[i] = AL.getAnimalLoc(i).toString();
			printt( "Added: " + comboPet_Data[i] );
		}
		comboChoosePet = new JComboBox(comboPet_Data);
		addComboBox(comboChoosePet, existingPetPanel, 10, 170 + 30, 130, 50);
	}
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
	
	public JPanel returnPanel() {
		return this.existingPetPanel;
	}
	
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			//go back to home screen
			//this should clear the comboBox too
			toStartPanel();
		}
		if( e.getSource() == btnSelect ) {
			//combo selected index will be the same as the animal location in the array
		}
	}
		
}
