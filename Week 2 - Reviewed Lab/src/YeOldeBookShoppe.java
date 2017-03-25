
public class YeOldeBookShoppe {

	static InventoryManager im = new InventoryManager();		//	instantiate Inventory Manager
	
	//		main method
	public static void main(String[] args) {
		
		// 		Build Inventory of books, magazines and electronic books
		im.addBook("The Tell-Tale Heart", "Edger Allan", "Poe", "London England");
		im.addBook("White Death", "Clive", "Cussler", "Las Vegas");
		im.addMagazine("Time", "Nancy", "Gibbs", "New York", "Time Life", "New York City");
		im.addMagazine("Rider", "Mark", "Tuttle", "Camarillo", "Paisano Publications", "Agoura Hills, CA");
		im.addElectronicBook("Easy Coder", "Roger", "Man", "Phoenix", "Five Star Publications", "Chandler, AZ");
		im.addElectronicBook("Titanic", "Susan", "Love", "Waterbury", "Poisoned Pen Press", "Scottsdale, AZ", "8/10/2016");
		
		//	list inventory
		System.out.println(im);
		
		//	price of inventory
		System.out.printf("Current price of ineventory is: %.02f%n",im.inventoryTotalPrice());
		
		//	transmit an electronic book
		if(im.itemTransmit(5)){
			System.out.println("Book Transmitted " + im.getItem(5) + "\n");
		} else {
			System.out.println("Book not Transmitted " + im.getItem(5) + "\n");
		}
		
		//	transmit a magazine
		if(im.itemTransmit(3)){
			System.out.println("Book Transmitted " + im.getItem(3) + "\n");
		} else {
			System.out.println("Book not Transmitted " + im.getItem(3) + "\n");
		}
		
		//	List all books in inventory
		for(Book book:im.getItems("book")){
			System.out.println(book.getTitle());
		}
		
	}

}
