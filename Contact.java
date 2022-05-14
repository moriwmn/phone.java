package ex2;
import java.util.Comparator;

public class Contact {

	private String name;
	private String number;
	
	//constructor:
	public Contact(String new_name, String new_number) { 
		this.name = new_name;
		this.number = new_number;
	}
	//getters & setter:
	
	public String get_name() {
		return this.name;
	}
	
	public String get_number() {
		return this.number;
	}
	
	public void set_contact(String new_name, String new_number) {
		this.name = new_name;
		this.number = new_number;
	}
	
	//sort:
	
	//define comparator methods for Contact.name and Contact.number
	//in order to sort Arraylist by object fields
	//uses by Collections.sort 
	
	 /*Comparator for sorting a list by Contact Name*/
    public static Comparator<Contact> ContNameComparator = new Comparator<Contact>() {

	public int compare(Contact c1, Contact c2) {
	   String Name1 = c1.get_name().toUpperCase();
	   String Name2 = c2.get_name().toUpperCase();

	   //ascending order
	   return Name1.compareTo(Name2);

    }};

    /*Comparator for sorting a list by Contact Number*/
    public static Comparator<Contact> ContNumberComparator = new Comparator<Contact>() {

	public int compare(Contact c1, Contact c2) {

	   String Num1 = c1.get_number();
	   String Num2 = c2.get_number();

	   /*For ascending order*/
	   return Num1.compareTo(Num2);
   }};
   
   //overwrite the function equals and hashCode 
   //to enable comparison between two Contact objects

   @Override
   public boolean equals(Object obj) {

       if(obj instanceof Contact)
       {
           Contact temp = (Contact) obj;
           if(this.get_name().equals(temp.get_name()) && this.get_number().equals(temp.get_number()))
               return true;
       }
       return false;
   }

   @Override
   public int hashCode() {
	   
       return (this.get_name().hashCode() + this.get_number().hashCode());        
   }
	
}//class
