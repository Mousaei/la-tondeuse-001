/**
 * 
 */
package latendeuse001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vahidmousaei
 *
 */
public class TheMowerTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	 */
	/**
	 * 
	 */
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	
	/**
	 * @throws FileNotFoundException
	 */
	@Test  
	 public void testResultAndTestResources() throws FileNotFoundException{
		 
		 try {
		      try {
		    	  File resultFile = new File("src/test/resources/ResultTestResource/");
		          if (resultFile.createNewFile()) {
		            System.out.println("File created: " + resultFile.getName());
		          } else {
		            System.out.println("File already exists.");
		          }
		        } catch (IOException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		 }
		 catch (Exception e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	     }
	 }
	 
	 /**
	 * 
	 */
}
