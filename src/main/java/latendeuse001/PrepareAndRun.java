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
import java.util.StringTokenizer;

/**
 * @author vahidmousaei
 *
 */
public class PrepareAndRun {
	
	Tendeuse uneTendeuse = new Tendeuse();
	
	/**
	 * @throws IOException 
	 * 
	 */
	public PrepareAndRun() throws IOException {
		// TODO Auto-generated constructor stub
		try {
		      InputStream inputStream = getClass().getClassLoader().getResourceAsStream("TestResource");
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
		    	
		    	System.out.println("myStr " + myStr);
		    	
		       
		       
		        if( compteur%2 == 1 && compteur > 0 ) {
		        	int caracCompteur = 0;
		        	
		        	while(st2.hasMoreTokens()){
		        		
		        		String theStr = st2.nextToken().toString().trim();
		        		
		        		System.out.println("theStr: " + theStr);
		        		
		        		if(caracCompteur == 0)
		        			uneTendeuse.setCoord_x(Integer.parseInt(theStr));
		        		if(caracCompteur == 1)
		        			uneTendeuse.setCoord_y(Integer.parseInt(theStr));
		        		if(caracCompteur == 2)
		        			uneTendeuse.setOrientation(theStr.charAt(0));
		        		
		        		caracCompteur++;
		        	
					}
		        
		        }
		        
		        if( compteur%2 == 0 && compteur > 0 ) {
		        	
		        	while(st2.hasMoreTokens()){
		        		
		        		String theStr = st2.nextToken().toString().trim();
		        		
		        		System.out.println("theStr: " + theStr);
		        		
		        		String action  = "";
		        		int i = 0;
		        		while(true && i<theStr.length()) {
		        			
		        		
		        		if(!theStr.substring(i, i+1).equalsIgnoreCase("A"))
		        			action = theStr.substring(i, i+1) + uneTendeuse.getOrientation();
		        		else
		        			action = "A";
					
		        		switch(action) {
		        		
		        		  case "GN":{
		        		    uneTendeuse.setOrientation('O');
		        		    break;
		        		  }
		        		  case "GO":{
		        			  uneTendeuse.setOrientation('S');
		        			  break;
		        		  }
		        		  case "GS":{
		        			  uneTendeuse.setOrientation('E');
		        			  break;
	        		  		}
		        		  case "GE":{
		        			  uneTendeuse.setOrientation('N');
		        			  break;
      		  				}
		        		  
		        		  case "DN":{
		        			  uneTendeuse.setOrientation('E');
		        			  break;
    		  				}
		        		  case "DE":{
		        			  uneTendeuse.setOrientation('S');
		        			  break;
		  					}
		        		  case "DS":{
		        			  uneTendeuse.setOrientation('O');
		        			  break;
	  						}
		        		  case "DO":{
		        			  uneTendeuse.setOrientation('N');
		        			  break;
							}
		        		    
		        			  
		        			  

		        		    
		        		  case "A":
		        			  
		        			  if(uneTendeuse.getOrientation()=='N') {
			        		    	uneTendeuse.setCoord_y(uneTendeuse.getCoord_y() + 1);
			        		    	
			        		  }
			        		    if(uneTendeuse.getOrientation()=='O') {
			        		    	uneTendeuse.setCoord_x(uneTendeuse.getCoord_x() - 1);
			        		    	
			        		    }
			        		    if(uneTendeuse.getOrientation()=='S') {
			        		    	uneTendeuse.setCoord_y(uneTendeuse.getCoord_y() - 1);
			        		    	
			        		    }
			        		    if(uneTendeuse.getOrientation()=='E') {
			        		    	uneTendeuse.setCoord_x(uneTendeuse.getCoord_x() + 1);
			        		    	
			        		    }
			        		    
			        		    
		        		  
		        		  default:
		        		    // code block
		        		}
		        		i++;
		        	}
		        	
		        	}
		        	try {
  			        	
  			        	String fileName = "src/main/resources/ResultTestResource";

  		                File file = new File(fileName);

  		                // true if file does no exist and was created successfully.
  		                // false if file is already exists
  		                if (file.createNewFile()) {
  		                    System.out.println("File is created!");
  		                } else {
  		                    System.out.println("File already exists.");
  		                }

  		                FileWriter fw = new FileWriter(fileName, true);
  		                BufferedWriter bw = new BufferedWriter(fw);
  		                bw.write(uneTendeuse.getCoord_x() + " " + uneTendeuse.getCoord_y() + " " + uneTendeuse.getOrientation());
  	              
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
		            System.out.println (":: Finally Block::");
		            System.out.println ("No Exception::finally block executed");
		        } 
	
		  }

	
}
