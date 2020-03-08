package virtualPetInterface;

// this should be ONLY how the user interacts with the system NOTHING MORE

/**
 * This is the main interface that will be ran when the pet starts, this takes input and processing of input will be elsewhere
 * if i end up getting around to the gui, this will be here too, but i am hoping to compartmentalise code quite alot
 * @author James Martland 24233781, <insert name and id if you edit code>
 *
 */
import animals.Dog;
public class Interface extends Initialiser {
	
	public static void main(String[] args) {
		printstatic("MAIN", "Running Startup");
		Interface I = new Interface();
		I.startSystem();
	}
	/**
	 * This method is the main method which everything should be ran by
	 */
	public void startSystem() {
		boolean run = false;// this will determine whether to take another response from the user or not, whether the loop that you will see in a min should end or not
		
		Dog d = new Dog("Max", 10);
		
		d.testWorks();
		while ( run ) {
			run = consent();
		}
	}
	
	//this method need comments vetted DRASTICALLY
	public boolean consent() {
		//aim is to take input - is it end / finish / stop / close / exit / leave / end it all
		// if command - goes to check command - command has /
		// if conversation text ( not part of list for ending life iteself ) - call other method
		userInput = "";// clears user input so that last input cannot be tainted
		userInput = in.nextLine(); // takes input from the user
		
		//now time to see wft the user decided to input
		userInput = userInput.toLowerCase(); // this should make it easier to 
		//if statement to figure out what is going on - if convo, command, end
		
		//check if command - if so check if end command, if not command then chat mode activate - continue
		if ( isCommand( userInput ) ) {
			//user has inputted a command - starts with a /
			//need to get rid of /
			userInput = userInput.substring( 1, userInput.length() ); //- gets rid of slash
			//Maybe use trim??? to make it get rid of unnecessary info ( punct )
			//now userInput should be plain text to be processed
			
		} else {
			//so if it is just an input to the pet
			//now to return the phrase that the pet says, a random amount of times??
		}
		return false;
	}
}
