//	Magazine.java
//		attributes and methods for a magazine
//			child class of Book.java
public class Magazine extends Book{
	
	private Authors authors = Authors.getInstance();					//	point to authors class
	private Publishers publishers = Publishers.getInstance();			//	point to publishers class
	
	private int publisherID;											//	publisher key in publishers	map

//				CONSTRUCTOR	
	public Magazine(int bookID, String title, int authorID, int publisherID) {
		super(bookID, title, authorID);
		this.publisherID = publisherID;
		this.itemType = "magazine";
	}
	
	
//		===== METHODS =====
//		GETTERS an SETTERS
	public int getPublisherID() {
		return publisherID;
	}
	
//	toString override
	@Override
	public String toString() {
		Author author = authors.getAuthor(getAuthorID());
		Publisher publisher = publishers.getPublisher(getPublisherID());
		return "title: " + getTitle() + ", author name: " + author.getFirstName() + " " + author.getLastName() + 
				 ", publisher name: " + publisher.getName() + ", publisher address " + publisher.getAddress() + 
				 ", price: " + String.format("%.2f", calculatePrice());
	}

//		calculatePrice method book calculation times 12
	public double calculatePrice(){
		
		return super.calculatePrice() * 12.00; 														//	return price to caller
	}

}	//	END OF Magazine.java