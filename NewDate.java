package ex2;

import java.util.Date;


public class NewDate extends Date {

	private static final long serialVersionUID = 1L;

	private int month;
	private int day;
	private int hour;
	private int minute;
	private int year;
	
	public NewDate() {
		
	}

	public NewDate(NewDate date) {
		this.year = date.getYear();
		this.month = date.getMonth();
		this.day = date.getDay();
		this.hour = date.getHour();
		this.minute = date.getMinute();
	}
	
	public NewDate(int year, int month, int day, int hour, int minute) {
		//super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public NewDate(int year, int month, int day) {
		//super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) {
			return true;
		}
		if(!(o instanceof NewDate)) {
			return false;
		}
		NewDate e= (NewDate) o;
		
		return this.getYear()==e.getYear()&&this.getDay()==e.getDay()&&this.getMonth()==e.getMonth()&&this.getHour()==e.getHour()&&this.getMinute()==e.getMinute();
	}

	@Override
	public String toString() {
		if( this.minute<10 )
		{
			return ("date is "+this.getYear()+" / "+this.month+ " / "+this.day+" in time- "+this.hour+" : 0"+this.minute);
		}
		return ("date is "+this.getYear()+" / "+this.month+ " / "+this.day+" in time- "+this.hour+" : "+this.minute);
	}	
	
	@Override
	public long getTime() {
		//return time from January 1 2000 in minutes
		long time=0;
		time+=((this.getYear()-2000)*365*24*60);;
		time+=(this.getDay()*24*60);
		time+=(this.getHour()*60*60);
		time+=this.getMinute();
		int month = this.getMonth();
		switch (month) {
        case 1: 
        	break;
        case 2: 
        	time+=31*24*30;
        	break;
        case 3:
        	time+=(31+29)*24*30;
        	break;
        case 4: 
        	time+=(31*2+29)*24*30;
        	break;
        case 5: 
        	time+=(31*2+29+30)*24*30;
        	break;
        case 6: 
        	time+=(31*3+29+30)*24*30;
        	break;
        case 7: 
        	time+=(31*3+29+30*2)*24*30;
        	break;
        case 8: 
        	time+=(31*4+29+30*2)*24*30;
        	break;
        case 9: 
        	time+=(31*5+29+30*2)*24*30;
        	break;
        case 10: 
        	time+=(31*5+29+30*3)*24*30;
        	break;
        case 11:
        	time+=(31*6+29+30*3)*24*30;
        	break;
        case 12:
        	time+=(31*6+29+30*4)*24*30;
        default: 
   	 }

		return time;
	}	
}
