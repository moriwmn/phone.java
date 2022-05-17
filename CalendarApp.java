package ex2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import java.util.Scanner;


public class CalendarApp {

	private LinkedList<Event> calendar;


	//ArrayList<LinkedList<String>> array = new ArrayList<LinkedList<String>>(size);
	//array = new ArrayList<LinkedList<String>>(size);
	//array[index].add(value); - inserting
	private static Scanner input; // create an object of Scanner
	
	//constructor:
	public CalendarApp() {
        this.calendar=new LinkedList<Event>();
    }
	//methods:
	
	public void add_event(String name) {////// added
		if(name.equals("no name"))
		{
			Date new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()) 
			{
				System.out.println("for how long? (1-60 minutes)");
				string duretion=input.nextLine();
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				System.out.println("Add description");
				string dsc=input.nextLine();
				RegEvent new_event=new RegEvent(new_date,duretion, dsc)//MeetingEvent(Date date,int duration,String contact
				this.calendar.add.new_event;/////////////////////
			}
			else
				System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage			
		}
		else 
		{
			Date new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()) 
			{
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
	}
		
	public void remove_event(String name)//////////addedddd
	{
		if(name.equals("no name"))
		{//regular event
			System.out.println("when is the event that you want to delete?");
			Date new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()) 
			{
				System.out.println("what is the meeting longetion? (1-60 minutes)");
				string duretion=input.nextLine();
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				System.out.println("what is the description of the event?");
				string dsc=input.nextLine();
				RegEvent new_event= new RegEvent(new_date,duretion,dsc)
				if(deleted_e(new_event))
					System.out.println("Event deleted seccesfuly");
				else
					System.out.println("error-cant delete meeting");//TODO error massage	
			}
			else
				System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage			
		}
		else
		{//meeting
			System.out.println("when is the event that you want to delete?");
			Date new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()) 
			{
				System.out.println("what is the meeting longetion? (1-60 minutes)");
				string duretion=input.nextLine();
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				MeetingEvent new_event= new MeetingEvent(new_date,duretion,name)
				if(deleted_e(new_event))
					System.out.println("Meeting deleted seccesfuly");
				else
					System.out.println("error-can't delete meeting");//TODO error massage	
			}
			else
				System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage	
		}
	}
	
	public boolean deleted_e(Event new_event) 
	{
		boolean flag=false;
		Iterator<Event> iter=this.calendar.iterator();
		while(iter.hasNext())
		{
			Event temp=iter.next();
			if(temp.equals(new_event))
			{
				iter.remove();
				flag=true;
			}
		}	
		return flag;
    	}

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
	public void show_events_of_the_day() {}
	public void print_meeting_with_contact() {}
	
	public void collision_detection() {}
	public void print_all_events() {}
	public Date Create_Date() {
		System.out.println("pls enter the year:");
		int year=input.nextLine();
		System.out.println("pls enter the month:");
		int month=input.nextLine();
		System.out.println("pls enter the day:");
		int day=input.nextLine();
		System.out.println("pls enter the time of the meeting. in what hour?");
		int hrs=input.nextLine()
		System.out.println("how many minutes after"+ hour+ "?");
		int min=input.nextLine();
		return new Date(year,month,day,hrs,min);
	}
	public boolean CheckIsValidDate(int year,int month,int day) 
	{
		Date date=new Date();
		int gap=0;
		int y=date.setDay(); //y=this year
		int m=date.setMonth();//m=this month
		int d=date.setDay();//d=this day
		
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) { //monthes with 31 days
			gap=-1;
		}
		if(month==4||month==6||month==9||month==11) {//monthes with 30 days
			gap=0;
		}
		if(month==2) {//month with 28 days
			gap=2
		}
		
		if (year!=y && m!=12) { //In case the given year is different from the current year and the given month isn't 12
			System.out.println("error messege");//TODO error messege
			return false;
		}
		if (year!=y&&month!=1||(month==1&&day>d+gap)) { 
			System.out.println("error messege");//TODO error messege
			return false;
		}

		if(month==m&&day<d) {
			System.out.println("error messege");//TODO error messege
			return false;
		}
		if (month==m+1 && day>d+gap) {
			System.out.println("error messege");//TODO error messege
			return false;
		}
		if (month !=m && month!=m+1) {//in case the month is not in range
			System.out.println("error messege");//TODO error messege
			return false;
		}
		  
	public void remove_same_time_meatings(){
		for (Event event : calendar ){
		    int index = get_event_index(event); //to delete and change the for loop? 
		    for (int i=index+1;i<event.size();i++)
		    {
		       if(event.time>calc_2dates_delta_in_min(event,calendar(i))){
			remove_event(calendar(i));
			i--; //return i to indicate the next event;
		       }
		       else
			    break

		    }
		}
	    }
	public void show_events_of_the_day() {
		Date chooseDate=Create_Date();
		for(Event temp:calendar) {
			if(IsSameDate(temp.GatDate(),chooseDate)) {
		       if(temp instanceof RegEvent) {
		    	   System.out.println(temp);
		       }
			}
		}
	}
	public boolean IsSameDate(Date d1,Date d2) {
		if((d1.getYear()==d2.getYear())&&(d1.getMonth()==d2.getMonth())&&(d1.getDay()==d2.getDay())) {
			return true;
		}
		return false;
	}
	public void print_meeting_with_contact(Contact contact) {
		for(Event temp:calendar) {
		       if(temp instanceof MeetingEvent) {
		    	   if(((MeetingEvent)temp).getContact()==contact) {
		    	   System.out.println(temp);
		       }
			}
		}
	}	
	public void print_all_events() {
		for(Event temp:calendar) {
		    System.out.println(temp);
		}	   
	}
	 public int calc_2events_delta_in_min(Event event1,Event event2){//only for events with a chance to be חופפים

		    long delta = event1.date.getTime()-event2.date.getTime();//ערך מוחלט???

		    // return time difference in minutes.
		    return(delta / (1000 * 60) % 60);
	    }

	
	}

