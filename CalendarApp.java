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
	
	
	public void add_meeting(string name) {
		System.out.println("when is your event? pls enter the year:");
		int year=input.nextLine();
		System.out.println("pls enter the month:");
		int month=input.nextLine();
		System.out.println("pls enter the day:");
		int day=input.nextLine();
		System.out.println("pls enter the time of the meeting. in what hour?");
		int hrs=input.nextLine()
		System.out.println("how many minutes after"+ hour+ "?");
		int min=input.nextLine()
		if(CheckIsValidDate(year,month,day)) 
		{
			Date dateOfEvent= new Date(year,month,day,hrs,min);//create date object
			System.out.println("for how long? (1-60 minutes)");
			string duretion=input.nextLine();
			if(duretion<1 || duretion > 60)
				System.out.println("you are out of range");//TODO error massage
			MeetingEvent new_event=new MeetingEvent(dateOfEvent,duretion, name)//MeetingEvent(Date date,int duration,String contact
			this.calendar.add.new_event;/////////////////////
		}
		else
			System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage			
	}


	
	public void add_event()
	{
		System.out.println("when is your event? pls enter the year:");
		int year=input.nextLine();
		System.out.println("pls enter the month:");
		int month=input.nextLine();
		System.out.println("pls enter the day:");
		int day=input.nextLine();
		System.out.println("pls enter the time of the meeting. in what hour?");
		int hrs=input.nextLine()
		System.out.println("how many minutes after"+ hour+ "?");
		int min=input.nextLine()
		if(CheckIsValidDate(year,month,day)) 
		{
			Date dateOfEvent= new Date(year,month,day,hrs,min);//create date object
			System.out.println("for how long? (1-60 minutes)");
			string duretion=input.nextLine();
			if(duretion<1 || duretion > 60)
				System.out.println("you are out of range");//TODO error massage
			System.out.println("Add description");
			string dsc=input.nextLine();
			RegEvent new_event=new RegEvent(dateOfEvent,duretion, dsc)//MeetingEvent(Date date,int duration,String contact
			this.calendar.add.new_event;/////////////////////
		}
		else
			System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage			
	}
	//RegEvent new_event=new RegEvent(date,dure, choice)
			//array[index].add(value); - inserting
		
		
		
	}
	
	public void remove_event() {}
	
	public void menu() {
	System.out.println("********************Menu********************");
	System.out.println("1. add event ");
	System.out.println("2. delete event");
	System.out.println("3. Print events of a specific date ");
	System.out.println("4.Print meetings with a specific contact date by order  ");
	System.out.println("5. Identify and remove overlapping events ");
	System.out.println("6.print all events and meetings ");
	System.out.println("7.exit ");
	System.out.println("********************************************");
	}
	public void show_events_of_the_day(int day) {}
	public void print_meeting_with_contact(int day) {}
	
	public void collision_detection() {}
	public void print_all_events() {}
}
