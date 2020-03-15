package virtualPetInterface;

import java.util.Scanner;

import utilities.ProcessorTemplate;
/**
 * This class is aimed to be the way of processing the commands from the user
 * @author James Martland 24233781
 *
 */
public class CommandProcessor extends ProcessorTemplate {
	Scanner in = new Scanner(System.in);
	public CommandProcessor() {
		setTag("COMMPROCESSOR");
	}
	
	/**
	 * This method is to check if the input is a command or not
	 * @param input
	 * @return ( input.charAt(0) == '/' )
	 */
	public boolean isCommand(String input) {
		return ( input.charAt(0) == '/' );
	}
	
	/**
	 * This method is to check if a specific item is listed in an array
	 * @param command
	 * @param array
	 * @return
	 */
	public boolean checkPartOf(String item, String[] array) {
		boolean temp = false;
		for ( int i=0; i<array.length; i++ ) {
			if ( item.equals(array[i]) ) {
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
				// test with in.nextInt();
				
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
	
	/**
	 * This method is aimed to get an input from the user that has to be an integer
	 * @param text
	 * @return
	 */
	public int getInputIntRng(String text, int low, int high) {
		printt("INPUT_RNG", text);// tell use not to input
		boolean temp = true;
		String input;
		int output = -1;
		do {
			try {
				// test with in.nextInt();
				
				input = in.nextLine();
				output = Integer.parseInt(input);// this means it is an integer
				//now to test the range conditions
				//the or equal to is for the array - as it starts at 0 - so length is not inclusive
				if ( output <= high && output > low ) {
					//meets conditions
					temp = false;
				} else {
					//doesnt meet conditions
					printt("INPUT_RNG", "Int Input must be between values: " + low + " and " + high );
				}
				
			} catch ( NumberFormatException exc) {
				printt("INPUT_RNG", "That is not an integer");
			} finally {
				printt("INPUT_RNG", "reached Finally");
				//dont really need this i think
			}
			
		} while ( temp );
		
		
		return output;
	}
	
}
