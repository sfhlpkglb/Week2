//	ElectronicBook.java
//		attributes and methods for a electronic book
//			child class of Magazine
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElectronicBook extends Magazine implements Transmitted{
	
	private Authors authors = Authors.getInstance();						//	point to authors class
	private Publishers publishers = Publishers.getInstance();				//	point to publishers class
	
	private Date dateSent; 													//	date sent field
	
//	CONSTRUCTORS
	public ElectronicBook(int bookID, String title, int authorID, int publisherID, String dateSent) {
		
		super(bookID, title, authorID, publisherID);
		
		setDateSent(dateSent);
		
		this.itemType = "electronicbook";

	}
	
//			===== METHODS =====
//			GETTERS an SETTERS
	public String getDateSent() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(dateSent);
	}
	
	private void setDateSent(String dateSent) {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			this.dateSent = formatter.parse(dateSent);
		} catch (ParseException e) {
			System.out.println("Date format error occured");
		}
	}
	
	
//		toString override
	@Override
	public String toString() {
		Author author = authors.getAuthor(getAuthorID());
		Publisher publisher = publishers.getPublisher(getPublisherID());
		return "title: " + getTitle() + ", author name: " + author.getFirstName() + " " + author.getLastName() + 
				 ", publisher name: " + publisher.getName() + ", publisher address " + publisher.getAddress() + 
				 ", datesent: " + getDateSent() + ", price: " + String.format("%.2f", calculatePrice());
	}

//		calculatePrice method 1 dollar
	public double calculatePrice(){
		return 1.00; 														//	return price to caller
	}
	
//		transmitted method
	@Override
	public void transmitted(){
		System.out.println("transmitted");
	}

}	//	END OF ElectronicBook.java

