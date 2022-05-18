package ex2;


import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
import java.util.Calendar;



public class CalendarApp {

	private LinkedList<Event> calendar;


	//ArrayList<LinkedList<String>> array = new ArrayList<LinkedList<String>>(size);
	//array = new ArrayList<LinkedList<String>>(size);
	//array[index].add(value); - inserting
	private static Scanner input = new Scanner(System.in);  // create an object of Scanner
	
	//constructor:
	public CalendarApp() {
        this.calendar=new LinkedList<Event>();
    }
	//methods:
	
	public void add_event(String name) {////// added
		if(name.equals("no name"))
		{
			NewDate new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()))
			{	int duretion;
				while(true) {
				System.out.println("for how long? (1-60 minutes)");
				duretion=input.nextInt();
				if(duretion >0 && duretion <= 60)
					break;
				System.out.println("you are out of range. please try again");//TODO error massage
				}
				System.out.println("Add meeting description");
				String dsc=input.nextLine();
				dsc = input.nextLine();
				RegEvent new_event=new RegEvent(new_date,duretion, dsc);//MeetingEvent(Date date,int duration,String contact
				this.calendar.add(new_event);/////////////////////
			}
			else
				System.out.println("This date is not valid. pls enter a date that is in 30 days from today :)");//TODO: error massage			
		}
		else 
		{
			NewDate new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay()))
			{
				System.out.println("for how long? (1-60 minutes)");
				int duretion=input.nextInt();
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				MeetingEvent new_event=new MeetingEvent(new_date,duretion, name);//MeetingEvent(Date date,int duration,String contact
				this.calendar.add(new_event);/////////////////////
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
			NewDate new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay())) {
				System.out.println("what is the meeting longetion? (1-60 minutes)");
				int duretion=Integer.parseInt(input.nextLine());
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				System.out.println("what is the description of the event?");
				String dsc=input.nextLine();
				RegEvent new_event= new RegEvent(new_date,duretion,dsc);
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
			NewDate new_date=Create_Date();
			if(CheckIsValidDate(new_date.getYear(),new_date.getMonth() ,new_date.getDay())){
				System.out.println("what is the meeting longetion? (1-60 minutes)");
				int duretion=Integer.parseInt(input.nextLine());
				if(duretion<1 || duretion > 60)
					System.out.println("you are out of range");//TODO error massage
				MeetingEvent new_event= new MeetingEvent(new_date,duretion,name);
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
	
	public void show_events_of_the_day() {
		boolean flag=false;
		NewDate chooseDate= Create_Date_without_time() ;
		for(Event temp:calendar) {
			if(IsSameDate(temp.getDate(),chooseDate)) {
		       if(temp instanceof RegEvent)
		       {
		    	   System.out.println(temp);
		    	   flag=true;
		       }
			}
		}
		if(flag==false)
			System.out.println("no events to show");
	}
	public boolean IsSameDate(NewDate d1,NewDate d2) {
		if((d1.getYear()==d2.getYear())&&(d1.getMonth()==d2.getMonth())&&(d1.getDay()==d2.getDay())) {
			return true;
		}
		return false;
	}
	public void print_meeting_with_contact(String contact) {
		boolean flag=false;
		Collections.sort(calendar);
		for(Event temp:calendar) {
		       if(temp instanceof MeetingEvent) {
		    	   if(((MeetingEvent)temp).getContact().equals(contact)) {
		    		   flag=true;
		    	   System.out.println(temp);
		       }
			}
		}
		if(flag==false)
			System.out.println("no meetings to show");
	}	
	public void print_all_events() {
		Collections.sort(calendar); //sort calendar before printing
		for(Event temp:calendar) {
		    System.out.println(temp);
		}	   
	}
	public void collision_detection() {}

	
	public NewDate Create_Date() {
		int year,month,day,hrs,min;
		//get details and validate:
		while(true) {
		System.out.println("please enter the year:");
		year=input.nextInt();
		if(year>2000)
			break;
		System.out.println("invalid choice, please try again");
		}
		while(true) {
		System.out.println("please enter the month:");
		month=input.nextInt();
		if(month>0 && month<13)
			break;
		System.out.println("invalid choice, please try again");
		}
		while (true) {
		System.out.println("please enter the day:");
		day=input.nextInt();
		if (dayIsValid(month,day))
			break;
		System.out.println("invalid choice, please try again");
		}
		while (true) {
		System.out.println("please enter the time of the meeting. in what hour?");
		hrs=input.nextInt();
		if(hrs>-1 && hrs<24)
			break;
		System.out.println("invalid choice, please try again");
		}
		while (true) {
		System.out.println("how many minutes after "+ hrs+ "?");
		min=input.nextInt();
		if(min>-1 && min <60)
			break;
		System.out.println("invalid choice, please try again");
		}
		return new NewDate(year,month,day,hrs,min);
	}
	public NewDate Create_Date_without_time() { 
		int year,month,day;
		//get details and validate:
		while(true) {
		System.out.println("please enter the year:");
		year=input.nextInt();
		if(year>2000)
			break;
		System.out.println("invalid choice, please try again");
		}
		while(true) {
		System.out.println("please enter the month:");
		month=input.nextInt();
		if(month>0 && month<13)
			break;
		System.out.println("invalid choice, please try again");
		}
		while (true) {
		System.out.println("please enter the day:");
		day=input.nextInt();
		if (dayIsValid(month,day))
			break;
		System.out.println("invalid choice, please try again");
		}
		return new NewDate(year,month,day);
	}
	public boolean CheckIsValidDate(int year,int month,int day) 
	{
		int gap=0;
		int y = Calendar.getInstance().get(Calendar.YEAR); //y=this year
		int m=1+Calendar.getInstance().get(Calendar.MONTH);//m=this month 
		int d= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);//d=this day
		
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) { //monthes with 31 days
			gap=-1;
		}
		if(month==4||month==6||month==9||month==11) {//monthes with 30 days
			gap=0;
		}
		if(month==2) {//month with 28 days
			gap=2;
		}
		
		if (year!=y && m!=12) { //In case the given year is different from the current year and the given month isn't 12
			System.out.println("error invalid date-out of range");
			return false;
		}
		if (year!=y&&month!=1||(month==1&&day>d+gap)) { 
			System.out.println("error invalid date-out of range");
			return false;
		}

		if(month==m&&day<d) {
			System.out.println("error invalid date-out of range");
			return false;
		}
		if (month==m+1 && day>d+gap) {
			System.out.println("error invalid date-out of range");
			return false;
		}
		if (month !=m && month!=m+1) {//in case the month is not in range
			System.out.println("error invalid date-out of range");
			return false;
		}
		return true;
	}
		  
	public void remove_overlape_meetings(){
		Collections.sort(calendar);
		if(calendar.isEmpty())
			return;
		for (int i=0 ; i<calendar.size();i++)
		{
			Event this_event = calendar.get(i);
			for (int j=i+1 ; j<calendar.size();j++) {
				Event next_event = calendar.get(j);
				if (this_event.getDuration() > calc_2dates_delta_in_min(this_event,next_event)) {
					calendar.remove(j);
					j--;
				}
				else
					break;
			}
		}
	}
		
	private long calc_2dates_delta_in_min(Event event1, Event event2) {
		long delta = event2.date.getTime()-event1.date.getTime();//
		return delta;
	}
	
	public boolean dayIsValid(int month,int day) {
		 if ((day < 1) || (day > 31)) return false;
	        switch (month) {
	            case 1: return true;
	            case 2: return (day < 30);
	            case 3: return true;
	            case 4: return day < 31;
	            case 5: return true;
	            case 6: return day < 31;
	            case 7: return true;
	            case 8: return true;
	            case 9: return day < 31;
	            case 10: return true;
	            case 11: return day < 31;
	            default: return true;
	        }
	}
	
	public void add_some_events_ahead() { //for debug only
		NewDate new_date= new NewDate(2022,5,19,10,0);
		RegEvent new_event=new RegEvent(new_date,60, "meeting1");
		this.calendar.add(new_event);
		NewDate new_date1= new NewDate(2022,5,19,10,30);
		RegEvent new_event1=new RegEvent(new_date1,10, "meeting2");
		this.calendar.add(new_event1);
		NewDate new_date2= new NewDate(2022,5,19,11,0);
		RegEvent new_event2=new RegEvent(new_date2,10, "meeting");
		this.calendar.add(new_event2);
		NewDate new_date3= new NewDate(2022,5,19,12,0);
		RegEvent new_event3=new RegEvent(new_date3,10, "meeting");
		this.calendar.add(new_event3);
	}
	}

