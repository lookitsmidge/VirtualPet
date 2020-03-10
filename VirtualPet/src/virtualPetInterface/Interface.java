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
	
	private int activeIndex;
	Animal[] arrayAnimal = new Animal[10];
	
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
		//testing how I am going to store all of the objects for the pets
		
		arrayAnimal[0] = new Dog("Max",  10);
		arrayAnimal[1] = new Hamster("Squeak", 2);
		arrayAnimal[2] = new Cat("Ginger", 3);
		
		//Ref: https://stackoverflow.com/questions/11466441/call-a-child-class-method-from-a-parent-class-object
		((Dog)arrayAnimal[0]).testWorks(); // this is how you call child methods from a parent class
		arrayAnimal[0].speak();
		arrayAnimal[0].eat();
		((Hamster)arrayAnimal[1]).testWorks();
		
		//d.testWorks();
		//commented out to test storage solution for pets
		
		do{
			run = consent();
			
		} while ( run );
	}
	
	//this method need comments vetted DRASTICALLY
	//this method is for when animal is selected - to interact
	public boolean consent() {
		boolean runNext = true;
		//aim is to take input - is it end / finish / stop / close / exit / leave / end it all
		// if command - goes to check command - command has /
		// if conversation text ( not part of list for ending life iteself ) - call other method
		userInput = "";// clears user input so that last input cannot be tainted
		userInput = in.nextLine(); // takes input from the user
		
		//now time to see wft the user decided to input
		userInput = userInput.toLowerCase(); // this should make it easier to 
		//if statement to figure out what is going on - if convo, command, end
		
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
				printt("MAIN", "Commands:\n\thelp\n\tspeak\n\tfeed\n\tplay\n\tsleep\n\twake up");
			} else if ( userInput.equals("speak") ) {
				arrayAnimal[activeIndex].speak();
			} else if ( userInput.equals("feed") ) {
				arrayAnimal[activeIndex].eat();
			} else if ( userInput.equals("play") ) {
				arrayAnimal[activeIndex].play();
			} else if ( userInput.equals("sleep") ) {
				arrayAnimal[activeIndex].sleep();
			} else if ( userInput.equals("wake up") ) {
				arrayAnimal[activeIndex].wake();
			} else {
				printt("MAIN", "Command Not Recognised");
			}
			
		} else {
			//so if it is just an input to the pet
			//now to return the phrase that the pet says, a random amount of times??
		}
		return runNext;
	}
}
