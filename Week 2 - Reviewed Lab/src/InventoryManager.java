//	InventoryManager.java
//		class to manage bookstore inventory
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class InventoryManager {
	
	private Authors authors = Authors.getInstance();				//	point to authors class
	private Publishers publishers = Publishers.getInstance();		//	point to publishers class
	
	private Map<Integer, Book> items = new HashMap<>();				//	create Map to hold books

//			addBook method	
	public void addBook(String title, String authorFName, String authorLName, String authorCity){
		
		Author author = addAuthor(authorFName, authorLName, authorCity);	//	add author to authors collection
		
		int nextID = items.size() + 1;										//	calc unique ID for item
		Book newBook = new Book(nextID,title, author.getAuthorID());		//	create new book object
		
		itemAdd(nextID,newBook);											//	add book to item collection
	}

//			addMagazine method	
	public void addMagazine(String title, String authorFName, String authorLName, String authorCity, 
			String publisherName, String publisherAddress){
		
		Author author = addAuthor(authorFName, authorLName, authorCity);		//	add author to authors collection
		
		Publisher publisher = addPublisher(publisherName, publisherAddress);	//	add publisher to publishers collection
		
		int nextID = items.size() + 1;											//	calc unique ID for item

		//				create Magazine object
		Magazine newMagazine = new Magazine(nextID, title, author.getAuthorID(), publisher.getPublisherID());
		
		itemAdd(nextID, newMagazine);											//	add magazine to item collection
	}

//			addElectronicBook method
	public void addElectronicBook(String title, String authorFName, String authorLName, String authorCity, 
			String publisherName, String publisherAddress, String dateSent){
		
		Author author = addAuthor(authorFName, authorLName, authorCity);		//	add author to authors collection
		
		Publisher publisher = addPublisher(publisherName, publisherAddress);	//	add publisher to publishers collection	
		
		int nextID = items.size() + 1;											//	calc unique ID  for item

		//				create ElectronicBook object
		Magazine newElectronicBook = new ElectronicBook(nextID, title, author.getAuthorID(), publisher.getPublisherID(),dateSent);
		
		itemAdd(nextID, newElectronicBook);										//	add electronic book to item collection
	}
	
//			addElectronicBook method
	public void addElectronicBook(String title, String authorFName, String authorLName, String authorCity, 
			String publisherName, String publisherAddress){
		
		 String dateSent = new SimpleDateFormat("MM/dd/yyyy").format(new Date());	//	default dateSent is today
		 
		 //						go add electronic book to inventory
		addElectronicBook(title, authorFName, authorLName, authorCity, publisherName, publisherAddress, dateSent);
		
	}
	
//			addAuthor method	
	private Author addAuthor(String authorFName, String authorLName,String authorCity) {
		return authors.addAuthor(authorFName, authorLName, authorCity);
	}
	
//			addPublisher method	
	private Publisher addPublisher(String publisherName, String publisherAddress) {
		return publishers.addPublisher(publisherName, publisherAddress);
	}
	
//			inventoryTotalPrice method get total price of all inventory items
//				PARAMETER
//					none
//				RETURN
//					double	-		-	Total price of the inventory
	public double inventoryTotalPrice(){
		
		double totalPrice = 0.00;					//	init total price
		//		loop through items map
		for(Book book: items.values()){
			totalPrice += book.calculatePrice();	//	add item price to total
		}
		
		return totalPrice;							//	return total to caller
	}
	
//			getPrice - get the price of an individual item
//				PARAMETER
//					Integer - itemID	-	key to item in inventory
//				RETURN
//					double	-			-	item's price
	public double getPrice(Integer itemID){
		Book book = getItem(itemID);
		return book.calculatePrice();
	}
	
//			getItem method
//				PARAMETER
//					Integer	-	iD	-	items map key
//				RETURN
//					BOOK	-		-	Book object that matches iD
	public Book getItem(Integer itemID){
		return items.get(itemID);
	}
	
//			getItems method get a List<Book> containing every item in inventory 
//				PARAMETER
//					none
//				RETURN
//					List<Book>		-	List of all items in inventory
	public List<Book> getItems(){
		return new ArrayList<Book>(items.values()); 
	}
	
//			getItems method get a List<Book> containing every item in inventory with the type requested
//				PARAMETER
//					String	-	itemType	-	item type to return to caller
//				RETURN
//					List<Book>		-	List of all items in inventory
	public List<Book> getItems(String itemType){
		List<Book> list = new ArrayList<>();			//	create return list
		
		//		Loop through items map looking for the type items requested
		for(Book book:items.values()){
			if(book.getItemType().equals(itemType)){	//	TEST  is this the item type the user requested?
				list.add(book);							//	YES - add item to list
			}	//	END of item type test
		}	//	END of for each loop
		
		return list;									//	return list to caller
	}
	
//			itemAdd method add an item to the items map
//				PARAMETERS
//					int		-	nextID	-	item's key
//					Book	-	newItem	-	Book object
//				RETURN
//					void
	private void itemAdd(int nextID, Book newItem) {	
		items.put(nextID, newItem);
	}
	
//			itemTransmit transmit item to customer 
//				NOTE - will only be allowed if item is type Electronic Book
//				PARAMETER
//					Integer	-	itemID	-	items key for book to transmit
//				RETURN
//					boolean	-			-	true - transmittal successful else false transmittal failed or not supported by item
	public boolean itemTransmit(Integer itemID){
		
		Book book = getItem(itemID);
		
		if(book.getItemType().equals("electronicbook")){
			ElectronicBook ebook = (ElectronicBook) book;
			ebook.transmitted();
			return true;
		}
		
		return false;
	}

//			toString method
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer, Book> entry: items.entrySet()){
			sb.append("ietm: " + entry.getKey() + ", ");
			sb.append(entry.getValue() + "\n");
		}
		
		return sb.toString();
		
	}

}	//	END OF InventoryManager.java
