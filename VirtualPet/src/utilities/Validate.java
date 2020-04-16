package utilities;
import javax.swing.*;

public class Validate extends ProcessorTemplate {
	
	String[] illegalChars = { ",", ".", "/", "\\", "\b", 
			"\t", "\n", "\f", "\r", "\"", "\'", "!", "`", 
			"£", "$", "%", "^", "&", "*", "(", ")", "-", 
			"_", "+", "=", "|", "¬", "[", "]", "{", "}", 
			"<", ">", ":", ";", "@", "'", "~", "#"};
	
	/**
	 * This is the constructor that sets up the tag for this class
	 */
	public Validate() {
		setTag("VALIDATE");
	}
	
	/**
	 * This is the method that will check users inputs for illegal characters being input
	 * @param parameter
	 * @return true (if there is no illegal characters )
	 */
	public boolean illegalCharCheck(String parameter) {
		boolean tmpBool = true;
		for( int i = 0; i < illegalChars.length; i++) {
			if( parameter.contains(illegalChars[i]) ) {
				tmpBool = false;
			} else {
				
			}
		}
		return tmpBool;
	}
	
	/**
	 * This is the method that will check if a string value is an integer
	 * @param parameter
	 * @return true ( if value is an integer )
	 */
	public boolean isInt(String parameter) {
        boolean tmpBool;
        try {
            Integer.parseInt(parameter);
            tmpBool = true;
            printt("isInt passed on parameter: " + parameter);
        } catch (NumberFormatException exc) {
            tmpBool = false;
            printt("isInt failed on parameter: " + parameter);
        }
        return tmpBool;
    }
    
	/**
	 * This method checks if the contents of a textfield is an integer
	 * @param txtTemp
	 * @return true ( if the text field input is an integer )
	 */
    public boolean isInt(JTextField txtTemp) {
        boolean tmpBool;
        try {
            Integer.parseInt(txtTemp.getText());
            tmpBool = true;
            printt("isInt passed on parameter: " + txtTemp.getText());
        } catch (NumberFormatException exc) {
            tmpBool = false;
            printt("isInt failed on parameter: " + txtTemp.getText());
        }
        return tmpBool;
    }
	
    /**
     * This method checks if a textfield is empty or not
     * @param txtTemp
     * @return true ( if the text field has a value in it )
     */
	public boolean presenceCheck(JTextField txtTemp){
        // will return true if there is something in there
        // this is due to the not operator '!'
		return !(txtTemp.getText().isEmpty());
    }
}
