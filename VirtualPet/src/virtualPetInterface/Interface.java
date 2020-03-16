package virtualPetInterface;

// this should be ONLY how the user interacts with the system NOTHING MORE

/**
 * This is the main interface that will be ran when the pet starts, this takes input and processing of input will be elsewhere
 * if i end up getting around to the gui, this will be here too, but i am hoping to compartmentalise code quite alot
 * @author James Martland 24233781, <insert name and id if you edit code>
 *
 */
import animals.*;
public class Interface extends Initialiser {
	
	AnimalList AL = new AnimalList("AnimalDetails.csv"); // this is animalList, this is where all of the animal array is stored among other things
	// move both of these to Initialiser
	
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
		boolean run = false;// this will determine whether to take another response from the user or not, whether the loop that you will see in a min should end or not
		//testing how I am going to store all of the objects for the pets
//		AL.addToArray( new Dog("Max",  10) );
//		AL.addToArray( new Goose("Squeak", 2) );
//		AL.addToArray( new Cat("Ginger", 3) );
		AL.setActiveIndex(-1); // maybe move this to AnimalList??
		do{
			run = consent();
		} while ( run );
		printt("Shutting Down ... ");
		AL.writeArrayToFile();
		printt( "Shutdown Complete" );
	}
	
	//this method need comments vetted DRASTICALLY
	//this method is for when animal is selected - to interact
	public boolean consent() {
		boolean runNext = true;
		userInput = "";// clears user input so that last input cannot be tainted
		userInput = CP.getInputLC( "Please Make an input - Use / for a command" ); // takes input from the user
		
		//now time to see wft the user decided to input
		//if statement to figure out what is going on - if convo, command, end
		
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
					//make a new animal
					//get type of animal to create
					String type = CP.getInputPartOf("Please Input The Type Of Pet To Create",
							AL.animalTypesLC);
					switch ( type ) {
					case "cat":
						AL.addToArray( new Cat(CP.capitalise( CP.getInputLC("Please Input Name") ), 
								CP.getInputIntRng("Input Pets age",
										0, Integer.MAX_VALUE) ) 
								);
						break;
					case "chicken":
						AL.addToArray( new Chicken(CP.capitalise( CP.getInputLC("Please Input Name") ), 
								CP.getInputIntRng("Input Pets age", 
										0, Integer.MAX_VALUE) )
								);
						break;
					case "dog":
						AL.addToArray( new Dog(CP.capitalise( CP.getInputLC("Please Input Name") ), 
								CP.getInputIntRng("Input Pets age", 
										0, Integer.MAX_VALUE) )
								);
						break;
					case "goat":
						AL.addToArray( new Goat(CP.capitalise( CP.getInputLC("Please Input Name") ), 
								CP.getInputIntRng("Input Pets age", 
										0, Integer.MAX_VALUE) )
								);
						break;
					case "goose":
						AL.addToArray( new Goose(CP.capitalise( CP.getInputLC("Please Input Name") ), 
								CP.getInputIntRng("In age", 
										0, Integer.MAX_VALUE) )
								);
						break;
					default:
						printt( "New Type hasnt been added to Interface.java - Contact An Admin" );
						break;
					}
					
					
				} else if ( userInput.equals("existing") ) {
					// load an existing animal
					
					// use of ids?? random generated??
					// need a search
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
			}
			break;
		default:
			//index is chosen
			// pet is chosen
			//check if command - if so check if end command, if not command then chat mode activate - continue
			if ( CP.isCommand( userInput ) ) {
				//user has inputted a command - starts with a /
				//need to get rid of /
				userInput = userInput.substring( 1, userInput.length() ); //- gets rid of slash
				//Maybe use trim??? to make it get rid of unnecessary info ( punct )
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
				//so if it is just an input to the pet
				//now to return the phrase that the pet says, a random amount of times??
			}
			break;
		}
		
		return runNext;
	}
}
