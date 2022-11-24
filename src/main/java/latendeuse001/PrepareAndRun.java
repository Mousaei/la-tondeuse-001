/**
 * 
 */
package latendeuse001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author vahidmousaei
 *
 */
public class PrepareAndRun {
	
	Tendeuse uneTendeuse;
	
	/**
	 * 
	 */
	public PrepareAndRun() {
		// TODO Auto-generated constructor stub
		try {
		      File testFile = new File("TestResource");
		      Scanner myReader = new Scanner(testFile);
		      int compteur = 0;
		      
		      try {
		          File resulktFile = new File("ResultTestResource");
		          if (resulktFile.createNewFile()) {
		            System.out.println("File created: " + resulktFile.getName());
		          } else {
		            System.out.println("File already exists.");
		          }
		        } catch (IOException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      while (myReader.hasNextLine() && compteur >0) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        
		        StringTokenizer str = 
		                new StringTokenizer("data", " ");
		        if( compteur%2 == 1 ) {
		        	int caracCompteur = 0;
		        	
		        	while(str.hasMoreTokens()){
					
		        		if(caracCompteur == 0)
		        			uneTendeuse.setCoord_x(Integer.parseInt(str.nextToken()));
		        		if(caracCompteur == 1)
		        			uneTendeuse.setCoord_y(Integer.parseInt(str.nextToken()));
		        		if(caracCompteur == 2)
		        			uneTendeuse.setOrientation(str.nextToken().charAt(0));
		        	
					}
		        
		        }
		        
		        if( compteur%2 == 0 ) {
		        	int caracCompteur = 0;
		        	
		        	while(str.hasMoreTokens()){
		        		
		        		char action = str.nextToken().charAt(caracCompteur);
					
		        		switch(action) {
		        		  case 'G':
		        		    if(uneTendeuse.getOrientation()=='N')
		        		    	uneTendeuse.setOrientation('O');
		        		    if(uneTendeuse.getOrientation()=='O')
		        		    	uneTendeuse.setOrientation('S');
		        		    if(uneTendeuse.getOrientation()=='S')
		        		    	uneTendeuse.setOrientation('E');
		        		    if(uneTendeuse.getOrientation()=='E')
		        		    	uneTendeuse.setOrientation('N');
		        		    break;
		        		    
		        		  case 'D':
		        		    if(uneTendeuse.getOrientation()=='N')
		        		    	uneTendeuse.setOrientation('E');
		        		    if(uneTendeuse.getOrientation()=='E')
		        		    	uneTendeuse.setOrientation('S');
		        		    if(uneTendeuse.getOrientation()=='S')
		        		    	uneTendeuse.setOrientation('O');
		        		    if(uneTendeuse.getOrientation()=='O')
		        		    	uneTendeuse.setOrientation('N');
		        		    break;
		        		    
		        		  case 'A':
		        			  if(uneTendeuse.getOrientation()=='N')
			        		    	uneTendeuse.setCoord_y(uneTendeuse.getCoord_y() + 1);
			        		    if(uneTendeuse.getOrientation()=='O')
			        		    	uneTendeuse.setCoord_x(uneTendeuse.getCoord_x() - 1);
			        		    if(uneTendeuse.getOrientation()=='S')
			        		    	uneTendeuse.setCoord_y(uneTendeuse.getCoord_y() - 1);
			        		    if(uneTendeuse.getOrientation()=='E')
			        		    	uneTendeuse.setCoord_x(uneTendeuse.getCoord_x() + 1);
			        		    break;
		        		  
		        		  default:
		        		    // code block
		        		}
		        		caracCompteur++;
					}
		        	
		        	try {
		        	      FileWriter myWriter = new FileWriter("ResultTestResource");
		        	      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		        	      myWriter.close();
		        	      System.out.println("Successfully wrote to the file.");
		        	    } catch (IOException e) {
		        	      System.out.println("An error occurred.");
		        	      e.printStackTrace();
		        	    }
		        
		        }
		        
		        compteur++;
		  
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	
	
}
