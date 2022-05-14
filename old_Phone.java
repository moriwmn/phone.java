package ex2;

import java.util.Scanner;

public class old_Phone {
	
	private SmsApp SmsApp;
	private PhoneBookApp phoneBookApp;
	private static Scanner input; // create an object of Scanner

	//SmsApp method/handle etc
	
	public void SmsApp_handle() {
		this.SmsApp.print_menu(); //TODO: decide if print is part of sub class App or phone.
		int choice = input.nextInt();
		switch (choice) {
		case 1: { //add chat
			String name = get_and_validate_contact();
			if (name != "error") {
				this.SmsApp.add_massage(name);
			}	
			else
				System.out.println(""); //return on error
		}
		case 2: { //delete chat 
			String name = get_and_validate_contact();
			if (name != "error") {
				this.SmsApp.delete_chat(name);
			}	
			else
				System.out.println(""); //return on error
		}
		case 3: { //print chat w/contact
			String name = get_and_validate_contact();
			if (name != "error") {
				this.SmsApp.print_chat(name);
			}	
			else
				System.out.println(""); //return on error
		}
		case 4: { //search for phrase
			System.out.println("which phrase you want to search? ");
			String phrase= input.nextLine();
			this.SmsApp.find_phrase(phrase);
		}
		case 5: { // print all chats
			this.SmsApp.print_all_chats();
		}
		case 6: { // exit
			
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public String get_and_validate_contact(){
		//this function gets from the user name of contact
		//and checks if there is such a contact in the phone-book.
		//return the name if exist and error o.w.
		//used by SmsApp and calendarApp
		System.out.println("please enter the Contact name: ");
		String name = input.nextLine();
		if(this.phoneBookApp.contatIsExist(name))
			return name;
		System.out.println("error msg"); //TODO: add error massage
		return "error";
	}
	
}
