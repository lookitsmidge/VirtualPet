package Utilities;

public abstract class ProcessorTemplate {
	/**
	 * This method is to make printing msgs to the command line more bearable with a tag
	 * @param text
	 */
	public void printt(String tag, String text) {
		System.out.println( "[" + tag + "] " + text );
	}
	
	/**
	 * This method is the custom print method that will be used to effectivley print things to command line
	 * @param text
	 */
	public void print(String text) {
		System.out.println(text);
	}
	/**
	 * This method is to make printing errors more bearable
	 * @param errMsg
	 */
	public void errPrint(String tag, String errMsg) {
		System.out.println( "[ERR] [" + tag + "] " + errMsg );
	}
	
	/**
	 * This method is to print to the command line in a static context
	 * @param text
	 */
	public static void printstatic(String tag, String text) {
		System.out.println( "[STATIC] [" + tag + "] " + text );
	}
}
