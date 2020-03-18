package utilities;
/**
 * The aim of this method is to enable me to read and write animals to a file and back from a file
 * @author James Martland
 *
 */
import java.io.*;
public class FileUtils extends ProcessorTemplate {
	
	BufferedReader in;
	private String filePath;
	private boolean fileWriteOnline; // this var is to tell the program if the writer has been set up correctly
	private FileWriter writer;
	private String spacer;
	//animal has age, name, type (happiness and fitness but nah) - also id???
	//method to write to a file (CSV)
	
	//method to read from a file (CSV) - same CSV
	public FileUtils(String filePath) {
		setTag( "FILEUTILS" );
		printt( "Running Constructor" );
		printt( "[CONF] Default Spacer Set to: NewLine" );
		this.spacer = "\r";
		//try statement to make a file and stuff
		this.filePath = filePath;
		this.fileWriteOnline = false;
		//create File and open
		try {
			File details = new File(this.filePath);
			if ( details.createNewFile() ) {
				// the file has been created
				// move on
			} else {
				//file already exists
			}
			
			
		} catch ( IOException exc ) {
			//error occurred - log error?
		}
		// - autonomous file opening
	}
	
	/**
	 * This method is to read the items stored in the file that is set up
	 * this will return this
	 * @return contents from file
	 */
	public String readFromFile() {
		in = null;//sets it to be nothing
		// use stringbuilder to make it more efficient
		
		StringBuilder contents = new StringBuilder();
		try {
			in = new BufferedReader( new FileReader(this.filePath) );
			//Oh my! a nested Try
			try {
				String currentLine = "";
				while ( (currentLine = in.readLine()) != null ) {
					contents.append( currentLine + "\r" );
				}
			} catch ( IOException e ) {
				
			} finally {
				in.close();
			}
		} catch ( FileNotFoundException e ) {
			//the file wasnt found, maybe you should make the file then.....
			//initialise the array with blank data - nothing
		} catch ( IOException e ) {
			//just in case anything breaks
		}
		return contents.toString();
	}
	
	/**
	 * This method is to modify the spacer that is used when writing to the file
	 * @param input - what to set spacer to
	 */
	public void setSpacer(String input) {
		if (spacer.contentEquals(",") ) {
			printt( "[CONF] Cannot set Spacer to comma, comma already used" );
		} else {
			this.spacer = input;
			printt( "[CONF] Spacer Set To: " + input );
		}
	}
	
	/**
	 * This method is to be used with the read function to output an array of data items that are correlated based on the spacer
	 * @param input
	 * @return input - but split into string array by spacer
	 */
	public String[] toArray(String input) {
		return input.split(this.spacer);
	}
	
	/**
	 * This method Initialises the filereader
	 * @param toWrite
	 * @throws IOException 
	 */
	public void initWrite() throws IOException {
		printt( "File is being set up" );
		if ( !this.fileWriteOnline ) {			
			
		} else if ( this.fileWriteOnline ) {
			// Filewriter already init-ed - close and re init
			this.writer = null;
			
		} else {
			//dunno
		}
		this.writer = new FileWriter(this.filePath, false);
		this.fileWriteOnline = true;
		printt( "File has been set up");
	}
	
	/**
	 * This method is used to write to the file
	 * @param item
	 * @throws IOException
	 */
	public void write(String item) throws IOException {
		printt( "Writing: " + item );
		if ( this.fileWriteOnline ) {
			//write ok
			writer.write(item);
			writer.write(this.spacer);
			printt("\tWritten");
		} else {
			// Doesnt Work
			finishWrite();// test this
		}
	}
	
	/**
	 * The method is used to close the file
	 * @throws IOException
	 */
	public void finishWrite() throws IOException {
		if ( this.fileWriteOnline ) {
			//ready for closing file
			writer.close();
			this.fileWriteOnline = false;
			printt("File has been successfully written to");
		} else {
			//file not opened
		}
	}
}
