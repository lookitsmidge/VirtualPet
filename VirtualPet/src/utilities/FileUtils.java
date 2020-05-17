package utilities;
/**
 * The aim of this method is to enable me to read and write animals to a file and back from a file
 * @author James Martland 24233781
 */
import java.io.*;
public class FileUtils extends ProcessorTemplate {
	
	private BufferedReader in;
	private String filePath;
	private boolean fileWriteOnline; // this var is to tell the program if the writer has been set up correctly
	private FileWriter writer;
	private String spacer;
	//method to write to a file (CSV)
	
	/**
	 * This is a constructor that sets up FileUtils to be used
	 * @param filePath
	 */
	public FileUtils(String filePath) {
		String nmeFilePath = filePath.substring(0, filePath.length()-4); // this should make it easier to track what is happening
		setTag( "FILEUTILS_" + nmeFilePath );
		printt( "Running Constructor" );
		printt( "[CONF] Default Spacer Set to: NewLine" );
		this.spacer = "\r";
		this.filePath = filePath;
		this.fileWriteOnline = false;
		try {
			File details = new File(this.filePath);
			if ( details.createNewFile() ) {
				// the file has been created
				//this is ran if the file is empty, as this stops arrayIndexOutOfBounds Exception
				otWrite("Dog,Max,4" + spacer + "Cat,Toffee,2");
				// continue
			} else {
				//file already exists
			}
		} catch ( IOException exc ) {
			//error occurred - log error?
		}
	}
	
	/**
	 * This method is to read the items stored in the file that is set up
	 * this will return this
	 * @return contents from file
	 */
	public String readFromFile() {
		printt( "Starting Read From: " + this.filePath );
		in = null;//sets it to be nothing
		
		StringBuilder contents = new StringBuilder();
		try {
			in = new BufferedReader( new FileReader(this.filePath) );
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
			printt( "File Was Not Found" );
			//the file wasn't found,
			contents.append("EMPTY");
			//initialise the array with blank data - nothing
		} catch ( IOException e ) {
			printt( "An Error Occurred During Read: " + e );
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
	 * This method Initialises the FileReader
	 * @param toWrite
	 * @throws IOException 
	 */
	public void initWrite() throws IOException {
		printt( "File is being set up" );
		if ( !this.fileWriteOnline ) {			
			
		} else if ( this.fileWriteOnline ) {
			// FileWriter already started - close and restart
			this.writer = null;
			
		} else {
			// continue
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
			//write OK
			writer.write(item);
			writer.write(this.spacer);
			printt("\tWritten");
		} else {
			// Doesn't Work
			finishWrite();
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
	
	/**
	 * This method is to write an item to a file but only write one file
	 * @param item
	 * @throws IOException
	 */
	public void otWrite (String item){
		printt( "Logged Amount" );
		try {
		FileWriter otWriter = new FileWriter(this.filePath);
		otWriter.write( item );
		otWriter.close();
		} catch (IOException e) {
			errPrint( "An Error Occurred when writing: " + e );
		}
	}
}
