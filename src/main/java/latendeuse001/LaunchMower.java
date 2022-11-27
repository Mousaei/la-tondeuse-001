/**
 * 
 */
package latendeuse001;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author vahidmousaei
 *
 */
public class LaunchMower {
	
	//Get the Logger object.
	private static Logger log = Logger.getLogger(LaunchMower.class.getCanonicalName());

	/**
	 * 
	 */
	public LaunchMower() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//logger messages
		log.info("Log4j info message from LaunchMower");
		
		Properties properties = new Properties();
		
		properties.setProperty("testFileName" , "TestResource");
		
		properties.setProperty("testResultFileName" , "ResultTestResource");
		
		
		PrepareAndRun runIt = new PrepareAndRun(properties.getProperty("testFileName") , properties.getProperty("testResultFileName"));
		
	}

}