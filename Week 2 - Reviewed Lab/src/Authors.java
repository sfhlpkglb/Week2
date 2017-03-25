//	Authors.java
//		class to manage author collection
//			SINGLETON CLASS
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authors {

	private Map<Integer, Author> authors = new HashMap<>();			//	define Map to hold author objects
	
	private static Authors instance = new Authors();				//	only one copy of Authors
	
//		CONSTRUCTOR - private to prevent multiple authors classes
	private Authors(){
	}

//		getInstance method - share one copy of Authors class	
	public static Authors getInstance(){
		return instance;
	}
	
//		addAuthor method
	public Author addAuthor(String firstName, String lastName,String city){
		Integer nextID = authors.size() + 1;								//	create unique row ID 
		Author newAuthor = new Author(nextID, firstName, lastName, city);	//	create new Author object
		Author returnAuthor = getAuthor(newAuthor);							//	look Author up in authors
		
		if(returnAuthor==null){												//	TEST - is this a new author?
			authors.put(nextID, newAuthor);									//	YES - Add the author to authors
			returnAuthor = newAuthor;										//	point to new author
		}
		
		return returnAuthor;												//	RETURN Author to caller
	}
	
//		getAuthor using unique row ID
//			Operands:
//				Integer	-	ID
//			Return
//				Author object
	public Author getAuthor(Integer iD){
		return authors.get(iD);
	}	//	END OF getAuthor
		
//		getAuthor using Author object
//			Operands:
//				Author	-	testAuthor
//			Return
//				Author object
	public Author getAuthor(Author testAuthor){
		return lookupAuthor(testAuthor); 
	}	//	END OF getAuthor
	
//		getAuthor using Author object
//			Operands:
//				String	-	first name
//				String	-	last name
//				String	-	city
//			Return
//				Author object	
	public Author getAuthor(String firstName, String lastName, String city ){
		
		return lookupAuthor(new Author(0, firstName, lastName, city));	
	}	//	END OF getAuthor
	
//		lookupAuthor - iterate through authors looking for matching author
//			Operands:
//				Author	-	author
//			Return
//				Author object	
	private Author lookupAuthor(Author author){

		Author returnAuthor = null;											//	init return Author object
		
		for(Author testAuthor : authors.values()){							//	iterate through authors collection looking for matching author
			
			if(testAuthor.equals(author)){									//	TEST - does author info match
				returnAuthor = testAuthor;									//	YES - load return author from current author
				break;														//	break out of loop
			} 																//	END OF TEST
		}
		
		return returnAuthor;												//	return to caller, either author or null when not found

	}	//	END OF lookupAuthor
	
//		getAuthors method	-	Get list of all authors 	
//			NO PARAMETERS
//			return	-	List<Author>
	public List<Author> getAuthors(){
		return new ArrayList<Author>(authors.values());		
	}
	
//		toString - Authors
//			NO PARAMETERS
//			return	-	String	- each contestants information	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(Author author : authors.values() ) {
			sb.append(author + "\n");			
		}
		
		return sb.toString();
	}
	
	
}	//	END OF Authors.java
