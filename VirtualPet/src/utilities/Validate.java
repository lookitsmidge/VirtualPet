package utilities;
import javax.swing.*;

public class Validate extends ProcessorTemplate {
	
	String[] illegalChars = { ",", ".", "/", "\\", "\b", 
			"\t", "\n", "\f", "\r", "\"", "\'", "!", "`", 
			"£", "$", "%", "^", "&", "*", "(", ")", "-", 
			"_", "+", "=", "|", "¬", "[", "]", "{", "}", 
			"<", ">", ":", ";", "@", "'", "~", "#"};
	
	public Validate() {
		setTag("VALIDATE");
	}
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
	
	public boolean presenceCheck(JTextField txtTemp){
        // will return true if there is something in there
        // this is due to the not operator '!'
		return !(txtTemp.getText().isEmpty());
    }
}
