package utilities;
import javax.swing.*;

import java.awt.Rectangle;
import java.awt.event.*;
import virtualPetInterface.Initialiser;
/**
 * This Class should be left alone -
 * this class is to build and add the elements to a panel
 * @author James Martland
 */
public class BuildUtilitiesVPV1 extends Initialiser {
	public Validate V = new Validate();
	
	//EXPERIMENTAL MKGRID
	int xPos;
	int yPos;
	int spacerx;
	int spacery;
	
	//END EXPERIMENTAL DECLARATION
	
	//This is for responsive Layout
	
	protected Rectangle recFrame;
	static protected int frameSizeX;
	protected int tmpFrameSizeX;
	static protected int frameSizeY;
	protected int tmpFrameSizeY;
		
	/*
	 * This method is to get the size of buttons based on the size of the frame
	 */
	public static int getBtnSizeXLarge() {
		return (int) Math.round( (0.333)*frameSizeX - (0.05)*frameSizeX );
	}
	
	/*
	 * This method is to get the size of buttons based on the size of the frame
	 */
	public static int getBtnSizeXSmall() {
		return (int) Math.round( (0.25)*frameSizeX - (0.05)*frameSizeX );
	}
	
	/**
	 * This method is to get the size of the buttons based on the size of the frame
	 * @return
	 */
	public int getBtnSizeYLarge() {
		return (int) Math.round( (0.167) * frameSizeY );
	}
	
	/**
	 * This method is to get the size of the buttons based on the size of the frame
	 * @return
	 */
	public int getBtnSizeYSmall() {
		return (int) Math.round( (0.125) * frameSizeY );
	}
	
	//end of responsive Layout options
	
	
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
	 * This method is to add a button to a panel using the responsiveLayout sizes
	 * can do this as most of the buttons are going to be the same sizes
	 * @param l
	 * @param toAddTo
	 * @param button
	 * @param x
	 * @param y
	 * @param text
	 * @param tooltip
	 */
	public void addButtonL(ActionListener l, JPanel toAddTo,
			JButton button,
			int x, int y,
			String text, String tooltip) {
        button.setLocation(x, y);
        button.setSize(getBtnSizeXLarge(), getBtnSizeYLarge());

        button.setOpaque(true);
        button.setVisible(true);
        if (text.equals(null) == true) {
            button.setText("");
        } else {
            button.setText(text);
        }
        button.addActionListener(l);
        button.setToolTipText(tooltip);
        printt("\tButton has been created");
        toAddTo.add(button);
    }
	
	/**
	 * This method is to add a button to a panel using the responsiveLayout sizes
	 * can do this as most of the buttons are going to be the same sizes
	 * @param l
	 * @param toAddTo
	 * @param button
	 * @param x
	 * @param y
	 * @param text
	 * @param tooltip
	 */
	public void addButtonR(ActionListener l, JPanel toAddTo,
			JButton button,
			int x, int y,
			String text, String tooltip, int btnAmount) {
        button.setLocation(x, y);
        button.setSize(frameSizeX/btnAmount - ( btnAmount*5), getBtnSizeYLarge());

        button.setOpaque(true);
        button.setVisible(true);
        if (text.equals(null) == true) {
            button.setText("");
        } else {
            button.setText(text);
        }
        button.addActionListener(l);
        button.setToolTipText(tooltip);
        printt("\tButton has been created");
        toAddTo.add(button);
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
        button.setLocation(x, y);
        button.setSize(sizeX, sizeY);

        button.setOpaque(true);
        button.setVisible(true);
        if (text.equals(null) == true) {
            button.setText("");
        } else {
            button.setText(text);
        }
        button.addActionListener(l);
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
	 * This method adds a label to the panel
	 * @param label
	 * @param panel
	 * @param x
	 * @param y
	 * @param text
	 */
	public void addLabelL(JLabel label, JPanel panel, 
			int x, int y, String text) {
        label.setLocation(x, y);
        label.setSize(getBtnSizeXLarge(), getBtnSizeYLarge());
        label.setOpaque(true);
        label.setText(text);
        panel.add(label);
    }
	
	/**
	 * This method adds a label to the panel
	 * @param label
	 * @param panel
	 * @param x
	 * @param y
	 * @param text
	 */
	public void addLabelR(JLabel label, JPanel panel, 
			int x, int y, String text, int lblAmount) {
        label.setLocation(x, y);
        label.setSize(frameSizeX/lblAmount - ( lblAmount*5), getBtnSizeYLarge());
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
	 * This method adds a text field to the panel
	 * @param txtfield
	 * @param panel
	 * @param x
	 * @param y
	 */
	public void addTextFieldL(JTextField txtfield, JPanel panel, 
			int x, int y) {
        txtfield.setLocation(x, y);
        txtfield.setSize( getBtnSizeXLarge(), getBtnSizeYLarge() );
        panel.add(txtfield);
    }
	
	/**
	 * This method adds a ComboBox to the panel
	 * @param combo
	 * @param panel
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	@SuppressWarnings("rawtypes")
	public void addComboBox(JComboBox combo, JPanel panel, int x, int y, int sizeX, int sizeY) {
        combo.setLocation(x, y);
        combo.setSize(sizeX, sizeY);
        combo.setEditable(false);
        combo.setOpaque(true);
        panel.add(combo);
    }
	
	/**
	 * This method adds a ComboBox to the panel
	 * @param combo
	 * @param panel
	 * @param x
	 * @param y
	 */
	@SuppressWarnings("rawtypes")
	public void addComboBoxL(JComboBox combo, JPanel panel, int x, int y ) {
        combo.setLocation(x, y);
        combo.setSize( getBtnSizeXLarge(), getBtnSizeYLarge() );
        combo.setEditable(false);
        combo.setOpaque(true);
        panel.add(combo);
    }
	
	/**
	 * This method adds a scroll Pane to the panel
	 * @param pane
	 * @param panel
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	public void addScrollPane( JScrollPane pane, JPanel panel, int x, int y, int sizeX, int sizeY) {
		pane.setLocation(x, y);
		pane.setSize(sizeX, sizeY);
		panel.add(pane);
	}
	
	/**
	 * These two methods are polymorphic, this is to lessen the chance of errors later down the line
	 * @param input
	 * @return int value of input
	 */
	public int makeInt( Double input ) {
		return (int) Math.round( input );
	}
	public int makeInt( int input ) {
		return (int) Math.round( input );
	}
	
	/**
	 * This is experimental
	 */
	public void makeGridX( int cols) {
		int spacePerCell = makeInt( frameSizeX / cols );
		int roomPerCell = makeInt( spacePerCell - getBtnSizeXLarge() );
		this.spacerx = makeInt( roomPerCell / 2 );
		this.xPos = makeInt( (frameSizeX / cols) - spacerx - getBtnSizeXLarge() );
	}
	
	public int getXPos() {
		return this.xPos;
	}
	public int nextXPos() {
		this.xPos += getBtnSizeXLarge() + 2 * spacerx;
		return this.xPos;
	}
	
	public void makeGridY( int rows ) {

		int spacePerCell = makeInt( frameSizeY / rows );
		int roomPerCell = spacePerCell - getBtnSizeYLarge();
		this.spacery = makeInt( roomPerCell / 4 );
		this.yPos = this.spacery;
	}
	public int getYPos() {
		return this.yPos;
	}
	public int nextYPos() {
		this.yPos += getBtnSizeYLarge() + spacery;
		printt("\t\tNextY: " + yPos );
		return this.yPos;
	}
	
	
}
