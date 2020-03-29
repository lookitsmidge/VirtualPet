package virtualPetInterface;
/**
 * This is an abstract class that is to be implemented in Interface, this will help to make interface easier to read and stuff
 * @author James Martland, 24233781 <insert your name and student ID if you edit the document at all>
 *
 */

import utilities.*;
import virtualPetInterface.Panels.*;
public abstract class Initialiser extends ProcessorTemplate {
	String userInput; // this is to reduce cost of taking input
	//create string array see child class
	String[] arrCloseResponses = { "end", "shutdown", "finish", "stop", "close", "exit", "leave", "end it all" };
	CommandProcessor CP = new CommandProcessor();// this is the class that should do all the checking for the commands for the 
	private int runTime;
	private FileUtils runAccumulator = new FileUtils("logNo.txt");
	
	PanelCommander PC;
	
	/**
	 * This is the constructor for this abstract class, this should aim to initialise anything that is needed in the subclass interface
	 */
	public void initInitialiser() {
		printt( "Running Initialiser" );
		setTag( "INIT" );
		logAttemptStart();
		PC = new PanelCommander();
		PC.startPanelCommander();
		
	}
	
	public void logAttemptStart() {
		
		printt( "Trying Log" );
		
		try {
			this.runTime = Integer.parseInt( runAccumulator.readFromFile().trim() );
			//I had to use trim - I kept getting errors 
			this.runTime++;
			printt( "Run No." + runTime );
		} catch ( Exception exc) {
			exc.printStackTrace();
		}
	}
}
