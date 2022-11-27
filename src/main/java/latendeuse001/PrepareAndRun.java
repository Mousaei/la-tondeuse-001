/**
 * 
 */
package latendeuse001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * @author vahidmousaei
 *
 */
public class PrepareAndRun {
	
	Mower aMower = new Mower();
	
	/**
	 * @param resource 
	 * @param resultResource 
	 * @throws IOException 
	 * 
	 */
	public PrepareAndRun(String resource, String resultResource) throws IOException {
		// TODO Auto-generated constructor stub
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
		      System.out.println(sb.toString());
	          
		      
		      
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
		        		
		        		// finds resource with the given name
		        	    URL url = getClass().getClassLoader().getResource(resultResource);
		        	    System.out.println("Value = " + url);
		        		
		        		
  		                File file = new File(resultResource);

  		                // true if file does no exist and was created successfully.
  		                // false if file is already exists
  		                if (file.createNewFile()) {
  		                    System.out.println("File is created!");
  		                } else {
  		                    System.out.println("File already exists.");
  		                }

  		                FileWriter fw = new FileWriter(resultResource, true);
  		                BufferedWriter bw = new BufferedWriter(fw);
  		                bw.write(aMower.getCoord_x() + " " + aMower.getCoord_y() + " " + aMower.getOrientation());
  	              
  		                bw.newLine();
  		                bw.close();
  		          

  		            } catch (IOException e) {
  		                e.printStackTrace();
  		            }
		        	
		        }
		        
		        compteur++;
		        		  
		      }
		      
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		      finally {
		            System.out.println ("Finally Block::");
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
		    // code block
		
		}
		
		i++;
		}
	
	}
	
}