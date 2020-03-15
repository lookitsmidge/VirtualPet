package animals;
import utilities.*;
import java.io.IOException;
/**
 * This class holds the animal array & all of its functions
 * and is the way that all of the animals will be accessed
 * @author James Martland
 *
 */
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
	FileUtils FU;
	private Animal[] animalArray;
	private int nextLocation;
	private int activeIndex; // this is the users current pet to interact with
	
	
	/**
	 * This constructor reads from file set in parameter
	 * 		makes new array
	 * 		adds to array from file
	 * 		
	 * @param filePath
	 */
	public AnimalList(String filePath) {
		FU =  new FileUtils(filePath);
		setTag("ANIMALLIST");
		printt("ANIMALLIST", "Initialising stuff... this will either be instantanious or take 3 yrs, not decided yet");
		//calls readFromFile method and then populates array
		String animalsFromFile = FU.readFromFile();
		
		//manipulate animalsFromFile so that it works kinda
		
		String[] arrAnimalsFromFile = animalsFromFile.split("\r");
		
		animalArray = new Animal[ arrAnimalsFromFile.length + 5 ]; // initialsises the array with the amount of space it needs plus 5 for extra comfort
		nextLocation = 0;
		
		//this for loop is to add any animals that are read from array
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
	 * This method is to print out the animal array - this is going to be used for testing whether things work or not - this
	 * will likely be removed for the final version
	 */
	public final void printArray() {
		for (int i=0; i< nextLocation; i++) {
			print("No. " + i + "Name: " + animalArray[i].getName() + ", Age: " + animalArray[i].getAge() + ", Type: " + animalArray[i].getType() );
		}
	}
	
	/**
	 * This method is to write the array that is stored in memory to the file defined
	 */
	public void writeArrayToFile() {
		try {
			FU.initWrite();
			for ( int i=0; i < nextLocation; i++ ) {
				FU.write( animalArray[i].toString() );
			}
			FU.finishWrite();
		} catch ( IOException e ) {
			errPrint( "Error when writing to file: " + e );
		}		
	}
	
	/**
	 * This method is to make the animal at the active index speak
	 */
	public final void speak() {
		animalArray[activeIndex].speak();
	}
	
	/**
	 * This method is to make the animal at the active index eat
	 */
	public final void eat() {
		animalArray[activeIndex].eat();
	}
	
	/**
	 * This method is to make the animal at the active index play
	 */
	public final void play() {
		animalArray[activeIndex].play();
	}
	
	/**
	 * This method is to make the animal at the active index sleep
	 */
	public final void sleep() {
		animalArray[activeIndex].sleep();
	}
	
	/**
	 * This method is to make the animal at the active index wake
	 */
	public final void wake() {
		animalArray[activeIndex].wake();
	}
	
	/**
	 * This method is to retrieve the next location for the array this is used when adding to the array
	 * @return
	 */
	public final int getNextLocation() {
		return nextLocation;
	}
	
	/**
	 * This is a method to retrieve the value of the class variable activeIndex
	 * @return
	 */
	public final int getActiveIndex() {
		return this.activeIndex;
	}
	
	/**
	 * This method is to set the value of the class variable activeIndex
	 * @param index
	 */
	public final void setActiveIndex(int index) {
		this.activeIndex = index;
	}
	
	/**
	 * This method is to get the value of the animals name and return it
	 * @return name
	 */
	public final String getActivesName() {
		return animalArray[activeIndex].getName();
	}
}