package ex2;

import java.util.Scanner;
import java.util.Date;

public class RegEvent extends Event {
	private String description;
	
	public RegEvent(Date date,int duration,String des)
	{
		super(date,duration);//Event(Date date, int duration) 
		this.type=0;
		this.description=des;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String setDes) {
		this.description=setDes;
	}
	
	@Override
	public String toString() {
		return super.toString()+" \r\ncomment: "+this.getComment()+" \r\n";
	}
	@Override
	public boolean equals(Object o) {
		if(o==this)
		{
			return true;
		}
		if(!(o instanceof RegEvent))
		{
			return false;
		}
		RegEvent r=(RegEvent) o;
		return this.getDescription().equals(r.getDescription())&&this.getDate().equals(r.getDate())&& this.getDuration()==r.getDuration();
	}

}
