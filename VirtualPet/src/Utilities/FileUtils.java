package Utilities;
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
	//animal has age, name, type (happiness and fitness but nah) - also id???
	//method to write to a file (CSV)
	
	//method to read from a file (CSV) - same CSV
	public FileUtils(String filePath) {
		printt( "FILEUTILS", "Running Constructor" );
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
			//error occurred - log error
		}
		// - autonomous file opening
	}
	public String readFromFile() {
		in = null;//sets it to be nothing
		// use stringbuilder to make it more efficient
		
		StringBuilder contents = new StringBuilder();
		try {
			in = new BufferedReader( new FileReader(this.filePath) );
			//Oh my! a nested Try - im not funny, i know :(
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
			//the file wasnt found, well done genius - maybe you should make the file then.....
			//initialise the array with blank data - nothing
		} catch ( IOException e ) {
			//just in case anything else in my life breaks
		}
		return contents.toString();
	}
	
	/**
	 * This method Initialises the filereader
	 * @param toWrite
	 * @throws IOException 
	 */
	public void initWrite() throws IOException {
		printt( "FILEUTILS", "File is being set up" );
		if ( !this.fileWriteOnline ) {			
			
		} else if ( this.fileWriteOnline ) {
			// Filewriter already init-ed - close and re init
			this.writer = null;
			
		} else {
			//dunno
		}
		this.writer = new FileWriter(this.filePath);
		this.fileWriteOnline = true;
		printt( "FILEUTILS", "File has been set up");
	}
	
	/**
	 * This method is used to write to the file
	 * @param item
	 * @throws IOException
	 */
	public void write(String item) throws IOException {
		printt( "FILEUTILS", "Writing: " + item );
		if ( this.fileWriteOnline ) {
			//write ok
			writer.write(item);
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
			printt("FILEUTILS", "File has been successfully written to");
		} else {
			//file not opened
		}
	}
}
