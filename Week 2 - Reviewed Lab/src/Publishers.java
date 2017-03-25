//	Publishers.java
//		class to manage publisher collection
//			SINGLETON class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publishers {

	private Map<Integer, Publisher> publishers = new HashMap<>();			//	define Map to hold publisher objects
	
	private static Publishers instance = new Publishers();					//	only one copy of publishers class

//			CONSTRUCTOR - private to prevent multiple authors classes
	private Publishers(){													
	}

//		getInstance method - share one copy of Publishers class	
	public static Publishers getInstance(){
		return instance;
	}
	
//		addPublisher method
	public Publisher addPublisher(String name, String address){
		Integer nextID = publishers.size() + 1;								//	create unique row ID 
		Publisher newPublisher = new Publisher(nextID, name, address);		//	create new Publisher object
		Publisher returnPublisher = getPublisher(newPublisher);				//	look Publisher up in publishers
		
		if(returnPublisher==null){											//	TEST - is this a new publisher?
			publishers.put(nextID, newPublisher);							//	YES - Add the publisher to publishers
			returnPublisher = newPublisher;									//	point to new publisher
		}
		
		return returnPublisher;												//	RETURN Publisher to caller
	}
	
//		getPublisher using unique row ID
//			Operands:
//				Integer	-	ID
//			Return
//				Publisher object
	public Publisher getPublisher(Integer iD){
		return publishers.get(iD);
	}	//	END OF getPublisher
		
//		getPublisher using Publisher object
//			Operands:
//				Publisher	-	testPublisher
//			Return
//				Publisher object
	public Publisher getPublisher(Publisher testPublisher){
		return lookupPublisher(testPublisher); 
	}	//	END OF getPublisher
	
//		getPublisher using Publisher object
//			Operands:
//				String	-	name
//				String	-	address
//			Return
//				Publisher object	
	public Publisher getPublisher(String name, String address){
		
		return lookupPublisher(new Publisher(0, name, address));	
	}	//	END OF getPublisher
	
//		lookupPublisher - iterate through publishers looking for matching Publisher
//			Operands:
//				Publisher	-	publisher
//			Return
//				Publisher object	
	private Publisher lookupPublisher(Publisher publisher){

		Publisher returnPublisher = null;									//	init return Publisher object
		
		for(Publisher testPublisher : publishers.values()){					//	iterate through publishers collection looking for matching publisher
			
			if(testPublisher.equals(publisher)){							//	TEST - does publisher info match
				returnPublisher = testPublisher;							//	YES - load return publisher from current publisher
				break;														//	break out of loop
			} 																//	END OF TEST
		}
		
		return returnPublisher;												//	return to caller, either publisher or null when not found

	}	//	END OF lookupPublisher
	
//		getPublishers method	-	Get list of all publishers 	
//			NO PARAMETERS
//			return	-	List<Publisher>
	public List<Publisher> getPublishers(){
		return new ArrayList<Publisher>(publishers.values());		
	}
	
//		toString - Publishers
//			NO PARAMETERS
//			return	-	String	- each publishers information	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for(Publisher publisher : publishers.values() ) {
			sb.append(publisher + "\n");			
		}
		
		return sb.toString();
	}
	
	
}	//	END OF Publishers.java
