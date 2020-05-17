package virtualPetInterface;
/**
 * This is an abstract class that is to be implemented in Interface, this will help to make interface easier to read and stuff
 * @author James Martland 24233781
 */
import animals.AnimalList;
import utilities.*;
import virtualPetInterface.Panels.*;
public abstract class Initialiser extends ProcessorTemplate {
	private int runTime;
	private FileUtils runAccumulator = new FileUtils("logNo.txt");
	
	//AL has to be static so that the multiple threads accessing it have the same AL
	protected static AnimalList AL = new AnimalList("AnimalDetails.csv"); // this is animalList, this is where all of the animal array is stored among other things
	protected boolean run; // might not need this when GUI is built
	CommandProcessor CP = new CommandProcessor();// this is the class that should do all the checking for the commands for the 
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
	
	/**
	 * This is the method that starts logging the run number of the program
	 */
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
	
	/**
	 * This is the method that will enable delays to be used within the program
	 * @param millis
	 */
	public void delay( int millis ) {
		printt( "Delaying" );
		try {
			Thread.sleep(millis);
		} catch ( InterruptedException e ) {
			//an error occurred
		}
	}
	
	/**
	 * This is the method that is called to turn off the system, this has to be placed here,
	 * because the way the user interacts with the system inherits from this class,
	 * this method makes sure that the details are saved before the user terminates
	 * ( doesn't protect from unexpected power failure )
	 */
	public void turnOff() {
		run = false;
		printt("Shutting Down ... ");
		AL.writeArrayToFile();
		runAccumulator.otWrite( this.runTime + "" );
		printt( "Shutdown Complete" );
		System.exit(0);
	}
}
