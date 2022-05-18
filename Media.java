package ex2;

public class Media {
	
	private String name;
	private double length;
	private String type; //song or video
	
	public Media(String type, String name,double length) {
		this.type=type;
		this.name=name;
		this.length=length;
	}
	
	public String GetName() {
		return this.name;
	}
	public double GetLength() {
		return this.length;
	}
	public String GetType() {
		return this.type;
	}
	

}
