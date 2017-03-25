
public class Publisher {

	private int publisherID;		//	publisher ID
	private String name;			//	publisher name
	private String address;			//	publisher address
	
//			CONSTRUCTOR
	public Publisher(int publisherID, String name, String address) {

		this.publisherID = publisherID;
		this.name = name;
		this.address = address;
	}

//		===== METHODS =====
//			GETTERS an SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPublisherID() {
		return publisherID;
	}

//	toString override
	@Override
	public String toString() {
		return "name: " + getName() + ", address: " + getAddress();
	}
	
	
//		equals override
//			compare publisher name and address
	@Override 
	public boolean equals(Object obj) {
		
		//	Compare to itself
		if(obj == this){
			return true;
		}
		
		//	make sure obj is an author
       if (!(obj instanceof Publisher)) {
            return false;
       }
	       
	   Publisher publisher = (Publisher) obj;
	   
	   if((publisher.getName().equals(name) && (publisher.getAddress().equals(address)))){
		   return true;
	   } else {
		   return false;
	   }
	       
	}	//	END OF equals override
	
}	//	END OF Publisher.java
