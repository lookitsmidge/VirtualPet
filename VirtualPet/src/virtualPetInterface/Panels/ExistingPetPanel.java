package virtualPetInterface.Panels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

/**
 * 
 * @author James
 *
 */
public class ExistingPetPanel extends PanelCommander implements ActionListener, Runnable{
	//where I declare all of my components
	JPanel existingPetPanel = new JPanel( null );
	
	JButton btnBack = new JButton();
	
	// Setting up the table to store the pets in to view them
	String[] headingsPet = {"Type", "Name", "Age"}; // If time try and add button on the end of each row - need to write own cell renderer apparently
	String[][] petTableData = new String[0][0];
	DefaultTableModel petTableModel = new DefaultTableModel(petTableData, headingsPet);
	JTable tablePet = new JTable(petTableModel);
	JScrollPane petTableScroll = new JScrollPane(tablePet);
	
	
	String[] comboPet_Data = new String[0];
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboChoosePet = new JComboBox(comboPet_Data);
	
	@Override
	public void run() {
		printt( "Thread - Building Existing Pet Panel" );
	}
	
	public void initExistingPetPanel() {
		setTag( "ExistingPetPnl" );
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateComboBox() {
		// Reinitialises the variable
		comboPet_Data = new String[AL.getNextLocation()];
		for( int i = 0; i < AL.getNextLocation(); i++) {
			comboPet_Data[i] = AL.getAnimalLoc(i).toString();
		}
		comboChoosePet = new JComboBox(comboPet_Data);
	}
	
	public void actionPerformed( ActionEvent e ) {
		
	}
		
}
