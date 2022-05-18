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
		super();
	}

	public NewDate(long date) {
		super(date);
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
		return ("date is "+this.getYear()+" / "+this.month+ " / "+this.day+" in time- "+this.hour+" : "+this.minute);
	}
	
	
	
	

}
