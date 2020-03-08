package virtualPetInterface;
/**
 * This is an abstract class that is to be implemented in Interface, this will help to make interface easier to read and stuff
 * @author James Martland, 24233781 <insert your name and student ID if you edit the document at all>
 *
 */
import java.util.Scanner;
import Utilities.ProcessorTemplate;

public abstract class Initialiser extends ProcessorTemplate {
	String userInput; // this is to reduce cost of taking input
	Scanner in;// this is the way that we are going to take input from the user for the time being. i will switch this to a GUI input if we ever do it, which should be such fun
	//create string array see child class
	String[] arrCloseResponses = { "end", "finish", "stop", "close", "exit", "leave", "end it all" };
	CommandProcessor CP = new CommandProcessor();// this is the class that should do all the checking for the commands for the 
	
	
	/**
	 * This is the constructor for this abstract class, this should aim to initialise anything that is needed in the subclass interface
	 */
	public Initialiser() {
		in = new Scanner(System.in);
	}
	
	/**
	 * This method is to check if the input is a command or not
	 * @param input
	 * @return ( input.charAt(0) == '/' )
	 */
	public boolean isCommand(String input) {
		return ( input.charAt(0) == '/' );
	}
}
