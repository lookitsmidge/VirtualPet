package utilities;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
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
	
}
