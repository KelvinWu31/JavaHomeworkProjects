/* Name: Kelvin Wu
 * CISC 3130 TY2 
 * 02/18/2020
 * Assignment #1
 * 
 * Program Description: This Java Program was intended to read in a .txt file of artist names and sort them by alphabetical order
 * through the ArrayList and calling the collections' sort and reverse alphabetizing them. The ArrayList is then implemented into 
 * a Linked List by a insert method inside TopStreamingArtists backwards.
 * 
 * Errors:
 * - I had problems from the very beginning from reading the file to the actual output not showing up when I print it from the ArrayList
 * - Due to this Error, I had to manually separate the artist names from the file and could only read 75 artist names from the US Play List.
 * 
 * Output:
 * Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.Scanner.throwFor(Scanner.java:937)
	at java.base/java.util.Scanner.next(Scanner.java:1478)
	at StreamingArtist.main(StreamingArtist.java:58) 
 * 
 */
import java.util.*;
import java.io.*;
import java.lang.String;

public class StreamingArtist {

	public static void main(String[] args) throws Exception {	
		
		  ArrayList<String> unsortedUSArtist = new ArrayList<String>(); // created an ArrayList of strings to sort the artist names
		  ArrayList<String> unsortedGlobalArtist = new ArrayList<String>();
		  
		  LinkedList<String> sortedUSArtist = new LinkedList<String>(); //created an LinkedList of Strings to store the sorted artist names
		  LinkedList<String> sortedGlobalArtist = new LinkedList<String>(); 
		  
		 
		  String [][] myList = new String [74][1];                     //using an 2d array allows me to read the file USArtist.txt and temporarily store it
		  String [][] myList2 = new String [77][1];
		    Scanner scanner = new Scanner(new File("USArtist.txt"));  // called the scanner object to read in the .txt file 
		    Scanner scanner2 = new Scanner(new File("GlobalArtist.txt"));
		    scanner.useDelimiter(",");                              // using the scanner's useDelimiter method allows me to separate the artist names by comma
		   
		    while(scanner.hasNext()){                               // while loop is used to  keep reading from the file while there is still data 
		      for (int row = 0; row < myList.length; row++) {       // using a double nested loop, I can read the file into the 2d array and keeps looping 
		        for(int col = 0; col < myList[row].length; col++) {  // until it runs out of the array  
		          myList[row][col] = scanner.next();                  // scanner.next(); holds the data and it's being read into the array of myList
		          myList2[row][col] = scanner2.next();
		          
		          unsortedUSArtist.add(myList[row][col]);              // the array element is then added to the ArrayList of unsortedArtist for further processing
		          unsortedGlobalArtist.add(myList2[row][col]);
		        } //end of col loop
		      } //end of row loop
		       {
		      }
		    } // end of while loop
		    
		    Collections.sort(unsortedUSArtist, Collections.reverseOrder());           // Calling the sort Method of Collections, the ArrayList is then sorted alphabetically backwards Z to A.
		    Collections.sort(unsortedGlobalArtist, Collections.reverseOrder());
	          																	    // This allows for each artist name to be implemented first allowing A to be in the beginning and Z at the end.
		    for (String counter: unsortedUSArtist) {                      
		    	sortedUSArtist.add(counter);                                         // adds in the sorted artist names in the array list into the LinkedList with a enhanced for loop
		    }
		    System.out.println(sortedUSArtist);   // prints it out 
		    
		    for(String counter2: unsortedGlobalArtist) {
		    	sortedGlobalArtist.add(counter2);
		    }
		    System.out.println(sortedGlobalArtist); 
		   
		scanner.close();
		scanner2.close();
	} // end of main method
}
 // end of public class 
