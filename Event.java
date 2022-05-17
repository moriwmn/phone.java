package ex2;

import java.util.Date;

public abstract class Event implements Comparable<Event>{
	protected Date date;
	protected long duration; // 1-60 minutes
	protected int type;// 0 for meeting 1 for event
	
	public Event(Date date, int duration) 
	{
		if(duration <= 1 || duration > 60 )
			System.out.println("Not a valid duration for a meeting");
		this.date= new Date(date.getTime());//long getTime() // what does date obj has in it?
		this.duration=duration;
	}
	public Date gatDate() {
		return this.date;
	}
	public void setDate(Date dateToSet) {
		this.date=new Date(dateToSet.getTime());
	}

	public long getDuration() {
		return this.duration;
	}
	public void setDuration(int minuetes) {
		this.duration=minuetes;
	}
	
	@Override
	public int compareTo(Event other) {
		Date myDate=this.date;
		Date otherDate=other.date;
		return myDate.compareTo(otherDate);
	}

@Override
public String toString() {
	return "\r\n"+date.toString()+"\r\nduration: " + duration + " minutes";
}

}//class
