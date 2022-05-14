package ex2;

import java.util.ArrayList;

public class Chat {

	private String name;
	private ArrayList<String> massages; 


	//constructor:
	public Chat (String name, String new_massage) {
		this.name = name;
		massages = new ArrayList<String>();
		this.massages.add(new_massage);
	}
	
	//getter
	public String getName() {
		return name;
	}

	
	//methods:
	public void add_massage(String new_massage) {
			massages.add(new_massage);
		}

	public boolean isContain(String massage) {
		// check is massage exist in the chat as a sub-string
		for (String msg : massages) {
			if(msg.contains(massage))
				return true;
		}
		return false;
	} 
	
	public void print_chat() {
		System.out.println("printing chat with " + name + ":");
		for (String msg : massages)
			System.out.println(msg);
	}
	
}
