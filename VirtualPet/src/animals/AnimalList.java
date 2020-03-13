package animals;
/**
 * This class is for all of the listing and storing and reading and shit of the animals, which is great, just great
 * @author James Martland
 *
 */
//NB NB if anyone at all edits this add your name to the author thing, if not the fair doos, but we need to vet these comments desperatly
// 		I am not having a good night and there is a great change that i am going to overcomment this puppy, its not a puppy, puppies are cute,
//		this is brutal.... why do i drink
import Utilities.*;
public class AnimalList extends ProcessorTemplate{

	/**
	 *  this shitty class should have:
	 *  	animal array (partially tested by yours truly)
	 *  	method to populate said array
	 *  	method to delete item from array,
	 *  	add new pet
	 *  	when importing array - find out how many and then add extra 5 spaces to array count to make sure that the user can do what the fudge they want
	 *  		(adding more pets wise)
	 */
	FileUtils FU = new FileUtils();
	//animal array
	Animal[] animalArray;
	private int nextLocation;
	private String filePath;
	
	//make crappy constructor
	public AnimalList(String filePath) {
		this.filePath = filePath;
		printt("ANIMALLIST", "Initialising stuff... this will either be instantanious or take 3 yrs, not decided yet");
		//calls readFromFile method and then populates array
		String animalsFromFile = FU.readFromFile(filePath);
		
		//manipulate animalsFromFile so that it works kinda
		
		String[] arrAnimalsFromFile = animalsFromFile.split("\r");
		
		animalArray = new Animal[ arrAnimalsFromFile.length + 5 ]; // initialsises the array with the amount of space it needs plus 5 for extra comfort
		nextLocation = 0;
		
		for ( int i = 0; i < arrAnimalsFromFile.length; i++ ) {
			//this loop will iterate, add animals from formatting and end life itself - if it is given a chance
			String[] animalTmp = arrAnimalsFromFile[i].split(",");
			if( animalTmp[0].equals("Dog") ) {
				//make a doggo
				Dog dTemp = new Dog( animalTmp[1], Integer.parseInt(animalTmp[2]) );//make this more robust btw you idiot
				addToArray( dTemp );
			} else if ( animalTmp[0].equals("Cat") ) {
				//make a cat
				Cat cTemp = new Cat( animalTmp[1], Integer.parseInt(animalTmp[2]) );
				addToArray( cTemp );
			} else if ( animalTmp[0].equals("Chicken") ) {
				// make a chicken - james you are a chicken
				Chicken chTemp = new Chicken( animalTmp[1], Integer.parseInt(animalTmp[2]) );
				addToArray( chTemp );
			} else if ( animalTmp[0].equals("Goat") ) {
				// make a goat
				Goat gTemp = new Goat( animalTmp[1], Integer.parseInt(animalTmp[2]) );
				addToArray( gTemp );
			} else if ( animalTmp[0].equals("Hamster") ) {
				// make a hamster
				Hamster hTemp = new Hamster( animalTmp[1], Integer.parseInt(animalTmp[2]) );
				addToArray( hTemp );
			} else {
				//the type isnt available
				//just do nothing and notify user
				printt("ANIMALLIST", "The type that was found was not a valid type.... not adding to animal array");
			}
		} // at this point everything should have been made and stuff - added to the array
		
		//all animals should have been added to the array - bc of the for loop
		
		
		//end life.. jk
	}
	
	/**
	 * This method is to add an object to the list of objects
	 * @param animal
	 */
	public void addToArray(Animal animal) {
		if (animalArray.length >= nextLocation ) {
			//the shit show continues
			//add this shit to the array
			
			animalArray[nextLocation] = animal;
			nextLocation++;
			printt("ANIMALLIST", "Animal Added To Array");
		} else {
			//cant add - there isnt space - so fuck you
			// or remake array with more space???
			// Nah, who can be bothered - maybe tomorrow
			printt("ANIMALLIST", "Array Not big enough. Please Restart the Program to try again");
		}
	}
	
	/**
	 * This method is to remove an item from the array
	 * Takes the index of the entry to delete from the array
	 * @param index
	 */
	public void deleteFromArray(int index) {
		//validation of index should have happened before
		//find index
		// again auth??
		// remove
		// cycle items
		
		animalArray[index] = null;
		for ( int i = index; i < nextLocation - 1; i ++ ) {
			animalArray[i] = animalArray[i+1];
		}
		nextLocation--; // decrement nextLocation Variable, as this will make the array smaller??
	}
	
	/**
	 * This method is to retrieve the next location for the array this is used when adding to the array
	 * @return
	 */
	public final int getNextLocation() {
		return nextLocation;
	}
	
	/**
	 * This method is to print out the animal array - this is going to be used for testing whether things work or not - this
	 * will likely be removed for the final version
	 */
	public final void printArray() {
		for (int i=0; i< nextLocation; i++) {
			print("Name: " + animalArray[i].getName() + ", Age: " + animalArray[i].getAge() + ", Type: " + animalArray[i].getType() );
		}
	}
	
	public void writeArrayToFile() {
		// use this.filePath;
		// iterate through array and for each item - toString - write - NL
		
		for ( int i=0; i < nextLocation; i++ ) {
			
		}
		
	}
}
