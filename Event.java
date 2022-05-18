package ex2;



public abstract class Event implements Comparable<Event>{
	protected NewDate date;
	protected long duration; // 1-60 minutes
	protected int type;// 0 for meeting 1 for event
	
	public Event(NewDate date, int duration) 
	{
		if(duration <= 1 || duration > 60 )
			System.out.println("Not a valid duration for a meeting");
		this.date= new NewDate(date);//long getTime() // what does date obj has in it?
		this.duration=duration;
	}
	public void setDate(NewDate dateToSet) {
		this.date=new NewDate(dateToSet);
	}

	public long getDuration() {
		return this.duration;
	}
	public void setDuration(int minuetes) {
		this.duration=minuetes;
	}
	public NewDate getDate() {
		return (NewDate) this.date;	
	}
	
	@Override
	public int compareTo(Event other) {
		NewDate myDate=this.date;
		NewDate otherDate=other.date;
		return myDate.compareTo(otherDate);
	}

	@Override
	public String toString() {
		return "\r\n"+date.toString()+"\r\nduration: " + duration + " minutes";
	}
	@Override
	public abstract boolean equals(Object obj);
	
	
	
	
	

}//class
