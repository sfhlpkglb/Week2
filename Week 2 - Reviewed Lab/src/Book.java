//	Book.java
//		attributes and methods for book 
//			This is Parent class 
public class Book {
	
	protected String itemType;								//	type of inventory item
	private int bookID;										//	Unique item ID
	private String title;									//	Book title
	private int authorID;									//	author key in authors 
	
	private Authors authors = Authors.getInstance();		//	point to authors class
	
//			CONSTRUCTOR	
	public Book(int bookID, String title, int authorID) {
		this.bookID = bookID;
		this.title = title;
		this.authorID = authorID;
		this.itemType = "book";
	}
	
//		===== METHODS =====
//		GETTERS an SETTERS
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookID() {
		return bookID;
	}

	public int getAuthorID() {
		return authorID;
	}

	public String getItemType(){
		return itemType;
	}
	
	
//		toString override
	@Override
	public String toString() {
		Author author = authors.getAuthor(getAuthorID());
		return "title: " + title + ", author name: " + author.getFirstName() + " " + author.getLastName() + 
				", price: " + String.format("%.2f", calculatePrice());
	}
	
//		calculatePrice method length of author's first name plus length of author's last name
	public double calculatePrice(){
		
		Author author = authors.getAuthor(authorID);								//	get author
		
		int price = author.getFirstName().length() + author.getLastName().length();	//	calculate price
		
		return (double) price;														//	return price to caller
	}

}	//	END OF Book.java
