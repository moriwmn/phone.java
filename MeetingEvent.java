package ex2;


public class MeetingEvent extends Event {
	
	private String contactName; 
	
	public MeetingEvent(NewDate date,int duration,String contact) {
		super(date,duration);
		this.type=0;
		this.contactName=contact;
	}
	public String getContact() {
		return this.contactName;
	}
	public void setContact(String contact) {
		this.contactName=contact;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\r\nwith contact: "+this.getContact().toString()+"\r\n";
	}
	@Override
	public boolean equals(Object o) {
		if(o==this) {
			return true;
		}
		if(!(o instanceof MeetingEvent)) {
			return false;
		}
		MeetingEvent e= (MeetingEvent) o;
		boolean ans=this.getContact().equals(e.getContact())&& this.getDate().equals(e.getDate()) && this.getDuration()==e.getDuration();
		return ans;
	}
	






}
