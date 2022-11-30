/**
 * 
 */
package latondeuse001;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
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
		
		java.net.URL url = ClassLoader.getSystemResource("prod.properties");

        try  {
            properties.load(url.openStream());
        } catch (FileNotFoundException fie) {
            fie.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        log.info("testFileName");
        log.info(properties.getProperty("testResultFileName"));
        PrepareAndRun runIt = new PrepareAndRun(properties.getProperty("testFileName") , properties.getProperty("testResultFileName"));
		
		runIt.toString();
		
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
        	log.info(key + " - " + properties.getProperty(key));
        }
    }
}