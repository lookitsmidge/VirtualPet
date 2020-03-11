package Utilities;
/**
 * The aim of this method is to enable me to read and write animals to a file and back from a file
 * @author James Martland
 *
 */
import java.io.*;
public class FileUtils {
	
	BufferedReader in;
	//animal has age, name, type (happiness and fitness but nah) - also id???
	//method to write to a file (CSV)
	
	//method to read from a file (CSV) - same CSV
	
	public String readFromFile(String filepath) {
		in = null;//sets it to be nothing
		// use stringbuilder to make it more efficient
		
		StringBuilder contents = new StringBuilder();
		try {
			in = new BufferedReader( new FileReader(filepath) );
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
}
