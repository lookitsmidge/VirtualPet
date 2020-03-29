package utilities;
import javax.swing.*;
import java.awt.event.*;
/**
 * This Class should be left alone -
 * this class is to build and add the elements to a panel
 * @author James Martland
 */
public class BuildUtilitiesVPV1 extends ProcessorTemplate {
	public BuildUtilitiesVPV1() {
		setTag( "BuildUtilities" );
	}
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
	public void addLabel(JLabel label, JPanel panel, 
			int x, int y, String text, int sizeX, int sizeY) {
        label.setLocation(x, y);
        label.setSize(sizeX, sizeY);
        label.setOpaque(true);
        label.setText(text);
        panel.add(label);
    }
	public void addTextField(JTextField txtfield, JPanel panel, 
			int x, int y, int sizeX, int sizeY) {
        txtfield.setLocation(x, y);
        txtfield.setSize(sizeX, sizeY);
        panel.add(txtfield);
    }
	public void addComboBox(JComboBox combo, JPanel panel, int x, int y, int sizeX, int sizeY) {
        combo.setLocation(x, y);
        combo.setSize(sizeX, sizeY);
        combo.setEditable(false);
        combo.setOpaque(true);
        panel.add(combo);
    }
}
