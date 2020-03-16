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
	 * This method is to get an input from the user
	 * @param Text
	 * @return userInput - but lowercase
	 */
	public String getInputLC(String Text) {
		//yet to properly validate input for escape characters and commas - would break system
		printt( Text );
		return ( in.nextLine() ).toLowerCase(); // i suppose i could trim / strip it here??
	}
	
	public String getInputPartOf(String text, String[] listOfResponses) {
		String input;
		do {
			input = getInputLC( text );
			if ( checkPartOf(input, listOfResponses) ) {
				//input is part of list
				break;
			} else {
				printt( "These are the responses that are acceptable: " + listOfResponses.toString() );

			}
		} while ( true ); // this will repeat until input is valid
		
		return "notyet";
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
				if ( output < high && output >= low ) {
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
	
	/**
	 * This method is to capitalise words, such as names
	 * https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
	 * @param input
	 * @return input - capitalised
	 */
	public String capitalise(String input) {
		return ( input.substring(0, 1).toUpperCase() + input.substring(1) );
	}
}
