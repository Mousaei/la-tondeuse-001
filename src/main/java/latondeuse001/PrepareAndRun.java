/**
 * 
 */
package latondeuse001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * @author vahidmousaei
 *
 */
public class PrepareAndRun {
	
	//Get the Logger object.
	private static Logger log = Logger.getLogger(PrepareAndRun.class.getCanonicalName());
	
	Mower aMower = new Mower();
	
	/**
	 * @param resource 
	 * @param resultResource 
	 * @throws IOException 
	 * 
	 */
	public PrepareAndRun(String resource, String resultResource) throws IOException {
		// TODO Auto-generated constructor stub
		
		//logger messages
		log.info("Log4j info message from PrepareAndRun");
				
		try {
		      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
		    
		      
		      //creating an InputStreamReader object
		      InputStreamReader isReader = new InputStreamReader(inputStream);
		      //Creating a BufferedReader object
		      BufferedReader reader = new BufferedReader(isReader);
		      StringBuffer sb = new StringBuffer();
		      String str="1";
		      while((str = reader.readLine())!= null){
		    	  
		         sb.append(str + ";" );
		      }
		      log.info(sb.toString());
	          
		      StringTokenizer st= new StringTokenizer(sb.toString(), ";");
		      
		      int compteur = 0;
		      
		      
		      while (st.hasMoreTokens() ) {
		    	
		        String myStr = st.nextToken().toString();
		        
		    	StringTokenizer st2 = new StringTokenizer( myStr , " ");
		    	
		    	if( compteur%2 == 1 && compteur > 0 ) {
		        	
		        	//Set the mower position
		        	setPosition(str, st2);
		        
		        }
		        
		        if( compteur%2 == 0 && compteur > 0 ) {
		        	
		        	
		        	while(st2.hasMoreTokens()){
		        		
		        		String theStr = st2.nextToken().toString().trim();
		        		
		        		String action  = "";
		        		int i = 0;
		        		
		        		//Move the mower
		        		moveMower(action, theStr, i);
		        	
		        	}
		        	try {
		        		
		        		try {
  		                	
  			        		FileWriter fw = new FileWriter(resultResource, true);
  			        		BufferedWriter bw = new BufferedWriter(fw);
  			        		bw.write(aMower.getCoord_x() + " " + aMower.getCoord_y() + " " + aMower.getOrientation());
  	              
  			        		bw.newLine();
  			        		bw.close();
  				        
  		                } catch (IOException e) {
  		                	log.info("An error occurred.");
  				          e.printStackTrace();
  				        }
  		               
  		            } catch (Exception e) {
  		                e.printStackTrace();
  		            }
		        	
		        }
		        
		        compteur++;
		        		  
		      }
		      
		    } catch (Exception e) {
		    	log.info("An error occurred.");
		      e.printStackTrace();
		    }
		      finally {
		    	  log.info("Finally Block::");
		        } 
	
		  }
	
	/**
	 * Set the mower position
	 * @param str
	 * @param st2
	 */
	private void setPosition(String str, StringTokenizer st2) {
		
	int caracCompteur = 0;
	
		while(st2.hasMoreTokens()){
		
			String theStr = st2.nextToken().toString().trim();
		
			if(caracCompteur == 0)
				aMower.setCoord_x(Integer.parseInt(theStr));
			if(caracCompteur == 1)
				aMower.setCoord_y(Integer.parseInt(theStr));
			if(caracCompteur == 2)
				aMower.setOrientation(theStr.charAt(0));
		
			caracCompteur++;
	
		}
	}
	
	
	/**
	 * Move the mower
	 * @param action
	 * @param theStr
	 * @param i
	 */
	private void moveMower(String action, String theStr, int i) {
		
	while(true && i<theStr.length()) {
		
		if(!theStr.substring(i, i+1).equalsIgnoreCase("A"))
			action = theStr.substring(i, i+1) + aMower.getOrientation();
		else
			action = "A";
	
		switch(action) {
		
		  case "GN":{
		    aMower.setOrientation('O');
		    break;
		  }
		  case "GO":{
			  aMower.setOrientation('S');
			  break;
		  }
		  case "GS":{
			  aMower.setOrientation('E');
			  break;
	  		}
		  case "GE":{
			  aMower.setOrientation('N');
			  break;
				}
		  
		  case "DN":{
			  aMower.setOrientation('E');
			  break;
				}
		  case "DE":{
			  aMower.setOrientation('S');
			  break;
				}
		  case "DS":{
			  aMower.setOrientation('O');
			  break;
				}
		  case "DO":{
			  aMower.setOrientation('N');
			  break;
			}
		    
			    
		  case "A":
			  
			  if(aMower.getOrientation()=='N') {
    		    	aMower.setCoord_y(aMower.getCoord_y() + 1);
    		    	
    		  }
    		    if(aMower.getOrientation()=='O') {
    		    	aMower.setCoord_x(aMower.getCoord_x() - 1);
    		    	
    		    }
    		    if(aMower.getOrientation()=='S') {
    		    	aMower.setCoord_y(aMower.getCoord_y() - 1);
    		    	
    		    }
    		    if(aMower.getOrientation()=='E') {
    		    	aMower.setCoord_x(aMower.getCoord_x() + 1);
    		    	
    		    }
    		    
    	default:
		}
		
		i++;
		}
	
	}
	
}