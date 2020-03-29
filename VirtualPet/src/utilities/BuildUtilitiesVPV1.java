package utilities;
import javax.swing.*;
import java.awt.event.*;
import virtualPetInterface.Initialiser;
/**
 * This Class should be left alone -
 * this class is to build and add the elements to a panel
 * @author James Martland
 */
public class BuildUtilitiesVPV1 extends Initialiser {
	public Validate V = new Validate();
	/**
	 * This method is to save characters and is for ease of development
	 * @param message
	 */
	public void optPane(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * This is the constructor that sets the tag for this class
	 */
	public BuildUtilitiesVPV1() {
		setTag( "BuildUtilities" );
	}
	
	/**
	 * This method is to add a button to a panel
	 * @param l
	 * @param toAddTo
	 * @param button
	 * @param x
	 * @param y
	 * @param text
	 * @param sizeX
	 * @param sizeY
	 * @param tooltip
	 */
	public void addButton(ActionListener l, JPanel toAddTo,
			JButton button,
			int x, int y,
			String text, int sizeX,
            int sizeY, String tooltip) {
        printt( "button creation algorithm is running" );
        button.setLocation(x, y);
        button.setSize(sizeX, sizeY);
        printt( "Set Location and Size" );
        button.setOpaque(true);
        button.setVisible(true);
        if (text.equals(null) == true) {
            button.setText("");
        } else {
            button.setText(text);
        }
        printt( "set text" );
        button.addActionListener(l);
        printt( "add actionListener" );
        button.setToolTipText(tooltip);
        printt("\tButton has been created");
        toAddTo.add(button);
    }
	
	/**
	 * This method adds a label to the panel
	 * @param label
	 * @param panel
	 * @param x
	 * @param y
	 * @param text
	 * @param sizeX
	 * @param sizeY
	 */
	public void addLabel(JLabel label, JPanel panel, 
			int x, int y, String text, int sizeX, int sizeY) {
        label.setLocation(x, y);
        label.setSize(sizeX, sizeY);
        label.setOpaque(true);
        label.setText(text);
        panel.add(label);
    }
	
	/**
	 * This method adds a text field to the panel
	 * @param txtfield
	 * @param panel
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	public void addTextField(JTextField txtfield, JPanel panel, 
			int x, int y, int sizeX, int sizeY) {
        txtfield.setLocation(x, y);
        txtfield.setSize(sizeX, sizeY);
        panel.add(txtfield);
    }
	
	/**
	 * This method adds a combobox to the panel
	 * @param combo
	 * @param panel
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	public void addComboBox(JComboBox combo, JPanel panel, int x, int y, int sizeX, int sizeY) {
        combo.setLocation(x, y);
        combo.setSize(sizeX, sizeY);
        combo.setEditable(false);
        combo.setOpaque(true);
        panel.add(combo);
    }
}
