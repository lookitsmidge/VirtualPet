package virtualPetInterface;
import animals.*;

/**
 * This is the main command line interface that will be ran when the pet starts, this is the secondary way to communicate with the program
 * @author James Martland 24233781
 */
public class Interface extends Initialiser{
	
	String[] arrCloseResponses = { "end", "shutdown", "finish", "stop", "close", "exit", "leave", "end it all" };
	String userInput; // this is to reduce cost of taking input
	
	/**
	 * This is the constructor for Interface, this initialises its parent class
	 */
	public Interface() {
		printt( "Starting interface" );
		initInitialiser();
		printt( "Init complete" );
	}
	
	/**
	 * This is the main method, this is what needs to be ran
	 * @param args
	 */
	public static void main(String[] args) {
		printstatic("MAIN", "Running Startup");		
		Interface I = new Interface();
		I.startSystem();
	}
	
	/**
	 * This method is the main method which everything should be ran by
	 */
	public void startSystem() {
		setTag("MAIN");
		printt("Startup Complete");
		run = false;// this will determine whether to take another response from the user or not, in the command line whether the loop should end or not
		
		AL.setActiveIndex(-1);
		do{
			run = consent();
		} while ( run );
		turnOff();
	}
	
	/**
	 * This is the method that takes the users input from command line
	 * @return run
	 */
	public boolean consent() {
		boolean runNext = true;
		userInput = "";// clears user input so that last input cannot be tainted
		userInput = CP.getInputLC( "Please Make an input - Use / for a command" ); // takes input from the user
		
		switch (AL.getActiveIndex()) {
		case -1:
			//no pet selected
			//command is select pet - create pet
			if (CP.isCommand( userInput ) ) {
				//getting rid of the slash
				userInput = userInput.substring( 1, userInput.length() );
				
				if ( CP.checkPartOf(userInput, arrCloseResponses) ) {
					runNext = false;
				} else if ( userInput.equals("create") ) {
					// make a new animal
					// get type of animal to create
					// had to add the capitalise as when the animal is made the subclass sets the type to for
					//	example Dog - which has a capital letter at the start
					String type = CP.capitalise( CP.getInputPartOf("Please Input The Type Of Pet To Create",
							AL.animalTypesLC) );
					// I transferred the animal switch that was used here and in the constructor in AnimalList
					AL.animalSwitch( type, CP.capitalise( CP.getInputLC("Please Input A Name") ),
							CP.getInputIntRng("Input Pets age", 0, Integer.MAX_VALUE) );					
					
				} else if ( userInput.equals("existing") ) {
					// load an existing animal

					AL.printArray();
					AL.setActiveIndex( CP.getInputIntRng( "Which Animal do you want to load?",
							0, AL.getNextLocation() ) );
					printt( "You have chosen: " + AL.getActivesName() );
				} else if ( userInput.equals("help") ) {
					printt( "Please Either use /create or /existing" );
				} else {
					printt( "Command Not Recognised" );
				}
			} else {
				// inputs not a command
				CP.notCommand(AL);
			}
			break;
		default:
			// index is chosen
			// pet is chosen
			// check if command - if so check if end command, if not command then chat mode activate - continue
			if ( CP.isCommand( userInput ) ) {
				//user has inputed a command - starts with a /
				//need to get rid of /
				userInput = userInput.substring( 1, userInput.length() ); //- gets rid of slash
				
				//now userInput should be plain text to be processed
				if ( CP.checkPartOf(userInput, arrCloseResponses) ) {
					runNext = false;
				} else if ( userInput.equals("help") ) {
					printt("Commands:\n\thelp\n\tspeak\n\tfeed\n\tplay\n\tsleep\n\twake up\n\tspecial\n\tlog out");
				} else if ( userInput.equals("speak") ) {
					AL.speak();
				} else if ( userInput.equals("feed") ) {
					AL.eat();
				} else if ( userInput.equals("play") ) {
					AL.play();
				} else if ( userInput.equals("sleep") ) {
					AL.sleep();
				} else if ( userInput.equals("wake up") ) {
					AL.wake();
				} else if ( userInput.equals("special") ) {
					AL.special();
				} else if ( userInput.equals("log out") ) {
					printt( "Logging out of pet" );
					AL.setActiveIndex(-1);
					//this should go back to the other case
				} else {
					printt("Command Not Recognised");
				}
			} else {
			}
			break;
		}
		return runNext;
	}
}
