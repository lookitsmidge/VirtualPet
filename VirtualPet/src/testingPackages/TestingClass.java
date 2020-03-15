package testingPackages;
import utilities.*;
import java.io.*;
public class TestingClass extends ProcessorTemplate {
	
	public static void main (String[] args) {
		TestingClass TC = new TestingClass();
		TC.runIt();
	}
	public void runIt() {
		setTag("TEST");
		printt("Sup");
		testWrite();
		testRead();
	}
	public void testWrite() {
		printt("Testing Write Function");
		FileUtils FU = new FileUtils("txtTest.csv");
		try {
			printt("In Try Statement");
			FU.initWrite();
			for (int i=2; i<10; i++) {
				FU.write( "Item " + i );
				printt( "Written Item " + i  );
			}
			FU.finishWrite();
		} catch( IOException e ) {
			printt("Didnt Work");
		}
		
	}
	public void testRead() {
		printt("Testing Read Functions");
		FileUtils FU = new FileUtils( "txtTest.csv" );
		
		printt("READ: " + FU.readFromFile());
	}
}