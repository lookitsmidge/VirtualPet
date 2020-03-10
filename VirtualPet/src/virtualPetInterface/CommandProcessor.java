package virtualPetInterface;

import Utilities.ProcessorTemplate;
import java.util.Scanner;
/**
 * This class is aimed to be the way of processing the commands from the user
 * @author James Martland 24233781
 *
 */
public class CommandProcessor extends ProcessorTemplate {
	Scanner in = new Scanner(System.in);
	public CommandProcessor() {
		
	}
	
	/**
	 * This method is to check if the input is a command or not
	 * @param input
	 * @return ( input.charAt(0) == '/' )
	 */
	public boolean isCommand(String input) {
		return ( input.charAt(0) == '/' );
	}
	
	public boolean checkPartOf(String command, String[] array) {
		boolean temp = false;
		for ( int i=0; i<array.length; i++ ) {
			if ( command.equals(array[i]) ) {
				//found resp
				temp = true;
				break;//no need to do rest of loop as resp is found
			} else { 
				// Next Item
			}
		} // End For
		return temp;
	}
	
	/**
	 * This method is aimed to get an input from the user that has to be an integer
	 * @param text
	 * @return
	 */
	public int getInputInt(String text) {
		printt("INPUT", text);// tell use not to input
		boolean temp = true;
		String input;
		int output = -1;
		do {
			try {
				input = in.nextLine();
				output = Integer.parseInt(input);// this means it is an integer
				temp = false;
			} catch ( NumberFormatException exc) {
				printt("INPUT", "That is not an integer");
			} finally {
				printt("INPUT", "reached Finally");
			}
			
		} while ( temp );
		
		
		return output;
	}
	
}
