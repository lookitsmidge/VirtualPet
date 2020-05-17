package animals;
import utilities.*;
import java.io.IOException;

/**
 * This class holds the animal array & all of its functions
 * and is the way that all of the animals will be accessed
 * @author James Martland 24233781
 */
public class AnimalList extends ProcessorTemplate{

	static FileUtils FU;
	private Animal[] animalArray;
	private int nextLocation;
	private int activeIndex; // this is the users current pet to interact with
	public String[] animalTypesLC = {"dog", "cat", "chicken", "goat", "goose"};
	
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
		printt("Initialising stuff... this will either be instantanious or take 3 yrs, not decided yet");

		String[] arrAnimalsFromFile = FU.toArray( FU.readFromFile() );
		
		// Initialises the array with the amount of space it needs plus 5 for extra comfort
		animalArray = new Animal[ arrAnimalsFromFile.length + 5 ]; 
		nextLocation = 0;
		
		//this for loop is to add any animals that are read from array
		for ( int i = 0; i < arrAnimalsFromFile.length; i++ ) {
			//this loop will iterate, add animals from formatting and end life itself - if it is given a chance
			String[] animalTmp = arrAnimalsFromFile[i].split(",");
			
			//I changed this to be a switch - this is much more efficient than the if statement that was here before
			animalSwitch( animalTmp[0], animalTmp[1], Integer.parseInt(animalTmp[2]) );
		}
		printArray();
		
		setActiveIndex(-1); // this is the rogue value
	}
	
	/**
	 * This method is to replace the switch that was in two locations, It is more efficient than an if statement
	 * @param type - type of animal it is
	 * @param name - name of the animal - string
	 * @param age - age of the animal - must be integer
	 */
	public void animalSwitch(String type, String name, int age ) {
		print("Running AnimalSwitch");
		switch ( type ) {
		case "Dog":
			addToArray( new Dog( name, age ) );
			break;
		case "Cat":
			addToArray( new Cat( name, age ) );
			break;
		case "Chicken":
			addToArray( new Chicken( name, age ) );
			break;
		case "Goat":
			addToArray( new Goat( name, age ) );
			break;
		case "Goose":
			addToArray( new Goose( name, age ) );
			break;
		default :
			printt("The type that was found was not a valid type, Please check spelling or as an admin");
			break;
		}
	}
	
	/**
	 * This method is to add an object to the list of objects
	 * @param animal
	 */
	public void addToArray(Animal animal) {
		if (animalArray.length >= nextLocation ) {
			
			this.animalArray[nextLocation] = animal;
			this.nextLocation++;
			printt("ANIMALLIST", "Animal Added To Array");
		} else {
			printt("ANIMALLIST", "Array Not big enough. Please Restart the Program to try again");
		}
	}
	
	/**
	 * This method is to remove an item from the array
	 * Takes the index of the entry to delete from the array
	 * @param index
	 */
	public void deleteFromArray(int index) {
		
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
			print("No. " + i + " Name: " + animalArray[i].getName() + ", Age: " + animalArray[i].getAge() + ", Type: " + animalArray[i].getType() );
		}
	}
	
	/**
	 * This method is to write the array that is stored in memory to the file defined
	 */
	public void writeArrayToFile() {
		try {
			FU.initWrite();
			for ( int i=0; i < this.nextLocation; i++ ) {
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
	public final String speak() {
		return animalArray[activeIndex].speak();
	}
	
	/**
	 * This method is to make the animal at the active index eat
	 */
	public final String eat() {
		return animalArray[activeIndex].eat();
	}
	
	/**
	 * This method is to make the animal at the active index play
	 */
	public final String play() {
		return animalArray[activeIndex].play();
	}
	
	/**
	 * This method is to make the animal at the active index sleep
	 */
	public final String sleep() {
		return animalArray[activeIndex].sleep();
	}
	
	/**
	 * This method is to make the animal at the active index wake
	 */
	public final String wake() {
		return animalArray[activeIndex].wake();
	}
	
	/**
	 * This method is to make the animal do something special
	 */
	public final String special() {
		return animalArray[activeIndex].special();
	}
	
	/**
	 * This method is to make the animal eat
	 */
	public final String feed() {
		return animalArray[activeIndex].eat();
	}
	
	/**
	 * This method is to show the pet love
	 * @return
	 */
	public final String showLove() {
		return animalArray[activeIndex].showLove();
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
		try {
			printt( "Active Index set to: " + index + "\n\t" + animalArray[index].toString() );
		} catch ( ArrayIndexOutOfBoundsException e ) {
			//do nothing
		}
	}
	
	/**
	 * This method is to get the value of the animals name and return it
	 * @return name
	 */
	public final String getActivesName() {
		if ( this.activeIndex == -1 ) {
			return "NONE SELECTED";
		} else {
			return this.animalArray[this.activeIndex].getName();
		}
	}
	
	/**
	 * This method is to get the value of the animals age and return it
	 * @return age
	 */
	public final int getActivesAge() {
		if ( this.activeIndex == -1 ) {
			return -1;
		} else {
			return this.animalArray[this.activeIndex].getAge();
		}
	}
	
	/**
	 * This method is to get the type of the active animal
	 * @return
	 */
	public final String getActivesType() {
		if ( this.activeIndex == -1 ) {
			return "NONE SELECTED";
		} else {
			return this.animalArray[this.activeIndex].getType();
		}
	}
	
	/**
	 * This method is to see if the name input is listed in the array
	 * @param name
	 * @return index ( of the name that is found or -1 )
	 */
	public int findNme(String name) {
		int index = -1;
		for ( int i = 0; i < this.nextLocation; i++ ) {
			if ( animalArray[i].getName().toLowerCase().equals( name.toLowerCase() ) ) {
				index = i;
				break;
			} else {
				//nextVal
			}
		}
		return index;
	}
	
	/**
	 * This method retrieved the animal at the location that is the parameter
	 * @param i
	 * @return animal at location i
	 */
	public Animal getAnimalLoc( int i ) {
		return animalArray[i];
	}
}