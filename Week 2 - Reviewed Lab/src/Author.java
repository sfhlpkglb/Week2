import java.util.ArrayList;
import java.util.List;

//	Author.java
//		Author 
public class Author {
	
	private int	authorID;			//	Unique author ID
	private String firstName;		//	Author's first name
	private String lastName;		//	Author's last name
	private String city;			//	Author's city

//			CONSTRUCTOR
	public Author(int authorID, String firstName, String lastName, String city) {

		this.authorID = authorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

//	===== METHODS =====
//			GETTERS an SETTERS
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAuthorID() {
		return authorID;
	}

	//		toString override
	@Override
	public String toString() {
		return "firstName: " + getFirstName() + ", lastName: " + getLastName()+ ", city: " + getCity();
	}

//	equals override
//		compare first name, last name and city
	@Override
	public boolean equals(Object obj) {
		
		//	Compare to itself
		if(obj == this){
			return true;
		}
		
		//	make sure obj is an author
       if (!(obj instanceof Author)) {
            return false;
       }
	       
	   Author author = (Author) obj;
	   
	   if((author.getFirstName().equals(firstName)) && 
			   (author.getLastName().equals(lastName)) && 
			   (author.getCity().equals(city))){
		   return true;
	   } else {
		   return false;
	   }
	       
	}	//	END OF equals override
	
}	//	END OF Author.java
