package ex2;

import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.io.*;


public class PhoneBookApp {
	
	private ArrayList<Contact> contacts;
	
	private static Scanner input= new Scanner(System.in); // create an object of Scanner

	//constructor:
	public PhoneBookApp() { 
		this.setContacts(new ArrayList<Contact>());
	}
	
	//getter and setter:
	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	//*******************
	//methods:
	
	public static void print_menu() {
		System.out.println("*******menu*******");
		System.out.println("To add a contact- press 1");
		System.out.println("To remove a contact- press 2");
		System.out.println("To print all phonebook- press 3");
		System.out.println("To find a contact- press 4");
		System.out.println("To sort by name- press 5");
		System.out.println("To sort by number- press 6");
		System.out.println("To remove duplicated contacts- press 7");
		System.out.println("To reverse phonebook order- press 8");
		System.out.println("To save phonebook in a file- press 9");
		System.out.println("To import phonebook from file- press 10");
		System.out.println("To Exit- press 11");
		System.out.println("*******************");
	}
	
	public void add_contact() { //1
		System.out.println("Please enter contact name");
		String name = input.nextLine();
		
		//check if there is a contact with that name:
		for (int i = 0; i <contacts.size(); i++)
		{
            if(contacts.get(i).get_name().equals(name))
            {
            	System.out.println("error-exit contact with the same name"); 
            	return; //return w/o adding the contact
            }
		}
		
		System.out.println("Enter phone number");
		String num = input.nextLine();
		if (numIsValid(num)) {
		Contact ContactNew = new Contact(name, num); //create a new contact
		contacts.add(ContactNew);
		}
		else {
			System.out.println("The number you entered is invalid. number should include 9-10 digits (exept of energancy numbers)");
		}
	}
	
	public void remove_contact() { //2
		System.out.println("enter name of contact to remove");
		String name= input.nextLine();
		int i=0;
		String contact_name = contacts.get(i).get_name();
		while(contacts.size()>i ) {
			if(contact_name.equals(name))
			{
				contacts.remove(i);
				System.out.println("the contact- "+contact_name+"  removed succesfully");
				break;
			}
			i++;
			contact_name=contacts.get(i).get_name();
		}
	}
	
	public void print_book() { //3
		for (int i = 0; i < contacts.size(); i++)
            System.out.println(this.contacts.get(i).get_name() +" : "+this.contacts.get(i).get_number());
	}
	
	public void find_contact() { //4
		System.out.println("What is the name do you want to find:");
		String name = input.nextLine();
		int counter=0;
		for (int i = 0; i <contacts.size(); i++)
		{
            if(contacts.get(i).get_name().equals(name))
            {
            	System.out.println(this.contacts.get(i).get_name() +" : "+this.contacts.get(i).get_number());
            	counter++;
            }
		}  
		
		if(counter!=0)
			System.out.println("The name "+ name + " appears "+counter + " times in the phonebook");
		else
			System.out.println(name + " is not in the phonebook");
				
	}
	
	public void sort_by_name() { //5
		Collections.sort(contacts, Contact.ContNameComparator);
		System.out.println("sort successfully!");
	}
	
	public void sort_by_number() { //6
		Collections.sort(contacts, Contact.ContNumberComparator );
		System.out.println("sort successfully!");
	}
	
	public void remove_duplicate() { //7
		// Create a new ArrayList
		ArrayList<Contact> tempList = new ArrayList<Contact>();
	    // Traverse through the first list
	    for (int i = 0; i <contacts.size(); i++)
	    {
	        // If this element is not present in tempList
	        // then add it
	        if (!tempList.contains(contacts.get(i))) 
	            tempList.add(contacts.get(i));
	    }
	    // return the new list
	    this.contacts = tempList;
	}
	
	public void invert_order() { //8
		ArrayList<Contact> revArrayList = new ArrayList<Contact>();
        for (int i = contacts.size() - 1; i >= 0; i--) {
            // append the elements in reverse order
            revArrayList.add(contacts.get(i));
        }
        // Return the reversed arraylist
        contacts=revArrayList;
        System.out.println("reversed successfully!");
	}
	
	public void save_in_file() { //9
		System.out.println("File name:");//getting the file name from user
		String file_Name = input.nextLine();
		
		File phone_book_file = null;
		try {//creating a file if it doesn't exist yet
			phone_book_file = new File(file_Name + ".txt");
			if (!phone_book_file.createNewFile()) {
				System.out.println("There is a file under this name");
				return;
			}
		} catch (IOException e) {
			System.out.println("Can not open file");
			e.printStackTrace();
			return;
		}
		
		String text = "";
		for (int i =0;i< contacts.size(); i++) {
			text = text + this.contacts.get(i).get_name() + "," + this.contacts.get(i).get_number() + "\n";
		try {
			FileWriter theWriter = new FileWriter(phone_book_file.getName());
			theWriter.write(text);
			theWriter.close();
			
		} catch (IOException e) {
			System.out.println("Can not write to file");
			e.printStackTrace();
			return;
		}
		}//for
		System.out.println("PhoneBook saved to file");
	}
	
	public void import_from_file() { //10

		System.out.println("please enter the file name:");
		String file_name = input.nextLine();
		
		try {
			File phone_book_File = new File(file_name + ".txt");
			Scanner theReader = new Scanner(phone_book_File);
			while (theReader.hasNextLine()) {
		        String line_reader = theReader.nextLine();
		        if (line_reader == "")
		        	break;
		        String[] data = line_reader.split(",");
		        this.contacts.add(new Contact(data[0],data[1]));
			}
			theReader.close();
			System.out.println("PhoneBook has load from file");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
		
	}
	
	public boolean contatIsExist(String name) {
		for (int i = 0; i <contacts.size(); i++)
		{
            if(contacts.get(i).get_name().equals(name))
            	return true;
		}  
		return false;
	}
	
	public boolean numIsValid(String number) {
		//valid number is number with 9/10 digits, or an emergency number
		if(number.equals("100") || number.equals("101") || number.equals("102"))
			return true;
		if(number.length()==9 || number.length()==10 )
			return true;
		return false;
	}
	
	public void add_contact_ahead(String  add_name, String add_num) { 
	//another function to add some contact ahead for debug and check :)
		Contact ContactNew = new Contact(add_name, add_num); //create a new contact
		contacts.add(ContactNew);
	}
	
	public void menu() 
	{
		Scanner input = new Scanner(System.in);
		int exit = 0;
		while (exit == 0) {
			print_menu();
			int choice = Integer.parseInt(input.nextLine());
			switch(choice) {
			case 1: 
				this.add_contact();
				break;
			case 2: {
				this.remove_contact();
				exit =1; //exit for update the chats and calendar
				break;
			}
			case 3: 
				this.print_book();
				break;
			case 4: 
				this.find_contact(); 
				break;
			case 5: 
				this.sort_by_name(); 
				break;
			case 6: 
				this.sort_by_number();
				break;
			case 7: 
				this.remove_duplicate();
				break;
			case 8: 
				this.invert_order();
				break;
			case 9: 
				this.save_in_file();
				break;
			case 10: 
				this.import_from_file();
				break;
			case 11:
				exit=1;
				break;
			default:
				System.out.println("Invalid number");
			}//switch
		}//while
	}	
	
} //class
