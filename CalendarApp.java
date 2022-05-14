package ex2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import java.util.Scanner;


public class CalendarApp {

	private ArrayList<LinkedList<Event>> calendar;


	//ArrayList<LinkedList<String>> array = new ArrayList<LinkedList<String>>(size);
	//array = new ArrayList<LinkedList<String>>(size);
	//array[index].add(value); - inserting
	private static Scanner input; // create an object of Scanner
	
	//constructor:
	public CalendarApp() {
        this.calendar=new ArrayList<LinkedList<Event>>(30);
    }
	//methods:
	
	public void add_event() {
		
		System.out.println("Do you want to create a meeting or event? please enter: M/E");
		String choice = input.nextLine();
		String dure;
		if (choice == "M" || choice == "m")
		{
			//AddMeeting()
			System.out.println("Who will attend the meeting?");
			choice = input.nextLine();
			//checking if the person is in the phonebook
			System.out.println("when is the event?");
			//create date object
			System.out.println("for how long?");
			dure=input.nextLine();
			//MeetingEvent new_event=new MeetingEvent(date,dure, choice)
		}
		if (choice == "E" || choice == "e")
		{
			//AddEvent()
			System.out.println("when is the event?");
			//create date object
			System.out.println("for how long?");
			dure=input.nextLine();
			System.out.println("please describe the event");
			choice = input.nextLine();//description
			//RegEvent new_event=new RegEvent(date,dure, choice)
			//array[index].add(value); - inserting
		}
		
		
	}
	
	public void remove_event() {}
	public void show_events_of_the_day(int day) {}
	public void print_meeting_with_contact(int day) {}
	
	public void collision_detection() {}
	public void print_all_events() {}
}
