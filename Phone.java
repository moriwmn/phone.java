package ex2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class Phone {
	
	private SmsApp sms;
	private MediaApp media;
	private CalendarApp calendar;
	private PhoneBookApp phoneBook;
	private static Scanner input = new Scanner(System.in); // create an object of Scanner
	
	public Phone()
	{
		this.sms= new SmsApp();
		this.media=new MediaApp();
		this.calendar= new CalendarApp(); 
		this.phoneBook=new PhoneBookApp();
	}
	
	public void PhoneMenu() { 
		//Scanner input = new Scanner(System.in);
		//input.nextLine();
		int exit = 0;
		while (exit == 0) {
			System.out.println("********************Menu********************");
			System.out.println("1. open PhoneBook");
			System.out.println("2. sms app");
			System.out.println("3. Calendar");
			System.out.println("4. media Player");
			System.out.println("5. Exit");
			System.out.println("********************************************");
			System.out.println("Enter app number:");
			int app = Integer.parseInt(input.nextLine());
			//input.nextLine();
			
			switch (app) {
			case 1: 
				phoneBook.menu();
				break;
			case 2:
				SmsApp_menu();
				break; 
			case 3:
				CalendarApp_menu(); 
				break;
			case 4: 
				media.menu();
				break;
			case 5: 
				exit++; 
				break;
			default: System.out.println("Not valid choice!"); break;
			}
		}
		input.close();
	}
	
	public void SmsApp_menu() {
		this.sms.print_menu(); //TODO: decide if print is part of sub class App or phone.
		int choice = Integer.parseInt(input.nextLine());
		//input.nextLine();
		int exit = 0;
		while (exit == 0) {
			switch (choice) {
			case 1: { //add chat
				String name = get_and_validate_contact();
				if (name != "error") {
					this.sms.add_massage(name);
				}	
				else
					System.out.println(""); //return on error
				break;
			}
			case 2: { //delete chat 
				String name = get_and_validate_contact();
				if (name != "error") {
					this.sms.delete_chat(name);
				}	
				else
					System.out.println(""); //return on error
				break;
			}
			case 3: { //print chat w/contact
				String name = get_and_validate_contact();
				if (name != "error") {
					this.sms.print_chat(name);
				}	
				else
					System.out.println(""); //return on error
				break;
			}
			case 4: { //search for phrase
				System.out.println("which phrase you want to search? ");
				String phrase= input.nextLine();
				this.sms.find_phrase(phrase);
				break;
			}
			case 5: { // print all chats
				this.sms.print_all_chats();
				break;
			}
			case 6: { 
				exit++;
				break;
			}
	
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			
		}
	}
}
	public void CalendarApp_menu() {
		this.calendar.menu(); //TODO: decide if print is part of sub class App or phone.
		int choice = Integer.parseInt(input.nextLine());
		int exit = 0;
		while (exit == 0) {
			switch (choice) {
			case 1:
			{ //add event
				System.out.println("Do you want to create a meeting or event? please enter: M/E");
				String kindOfEv = input.nextLine();
				String dure;
				if (kindOfEv == "M" || kindOfEv == "m")
				{
					//AddMeeting()
					String name = get_and_validate_contact();//checking if the person is in the phonebook
					if (name != "error") 
						this.calendar.add_event(name);	
					else
						System.out.println("there is no such a contact in your phonebook"); //TODO return on error		
				}
				if (kindOfEv == "E" || kindOfEv == "e")
				{
					String name="no name";
					this.calendar.add_event(name);
				}
				break;
			}
			case 2: 
			{ //delete event
				System.out.println("Do you want to delete a meeting or event? please enter: M/E");
				String kindOfEv = input.nextLine();
				String dure;
				if (kindOfEv == "M" || kindOfEv == "m")
				{
					String name = get_and_validate_contact();//checking if the person is in the phonebook
					if (name != "error") 
						this.calendar.remove_event(name);	
					else
						System.out.println("there is no such a contact in your phonebook"); //TODO return on error		
				}
				if (kindOfEv == "E" || kindOfEv == "e") {
					String name="no name";
					this.calendar.remove_event(name);
				}
				break;
			}
	
			case 3: { //print events of the day
					this.calendar.show_events_of_the_day();
					break;
				}	
			
	
			case 4: { //print events with contact by order
				String contact = get_and_validate_contact();//checking if the person is in the phonebook
				this.calendar.print_meeting_with_contact(contact);
				break;
			}
		
			case 5: { //check if 2 events collided
				this.calendar.show_events_of_the_day();
				break;
			}
			case 6: { //.print all events and meetings
				this.calendar.show_events_of_the_day();
				break;
			}
			case 7: { 
				exit++;	
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
	}
	
	public String get_and_validate_contact(){
		//this function gets from the user name of contact
		//and checks if there is such a contact in the phone-book.
		//return the name if exist and error o.w.
		//used by SmsApp and calendarApp
		System.out.println("please enter the Contact name: ");
		String name = input.nextLine();
		if(this.phoneBook.contatIsExist(name))
			return name;
		System.out.println("error msg"); //TODO: add error massage
		return "error";
	}
	

}
