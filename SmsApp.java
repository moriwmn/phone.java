package ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class SmsApp {

	private ArrayList<Chat> chats; 
	private static Scanner input; // create an object of Scanner
	

	
	//constructor:
		public SmsApp() {
		this.chats = new ArrayList<Chat>();
	}
		
	//methods:
	
	public void add_massage(String name) {
		//get massage
		System.out.println("Do you want to receive or send a massage? (r/s)");
		String choice = input.nextLine();
		System.out.println("Type your massage: ");
		String new_massage = input.nextLine();
		if (choice == "r" || choice == "R")
		{
			new_massage = name + ": " + new_massage;
		}
		if (choice == "s" || choice == "S")
		{
			new_massage = "you: " + new_massage;
		}
		else {
			//return_on_error
		}
		
		//find the chat if exist, or create new one
		
		int index = find_chat_by_name(name); //the function return the index, or -1 if chat does not exist
		if( index >= 0) {
			this.chats.get(index).add_massage(new_massage);
		}
		else { //meaning there is no chat w/this contact
			//add new chat w/the new massage
			Chat newChat = new Chat(name,new_massage);
			this.chats.add(newChat);
		}
	}
	
	public int find_chat_by_name(String name) {
		for(int i=0 ; i<this.chats.size() ; i++) {
			if (chats.get(i).getName() == name)
				return i;
		}
		return -1; //chat w/"name" does'nt exist.
	}
	
	public void delete_chat(String name) {
		int index = find_chat_by_name(name);
		if (index != -1)
			this.chats.remove(index);
		else
			System.out.println("can not delete chat with " + name + ". chat does not exist.");
	}
	
	public void print_chat(String name) {
		int index = find_chat_by_name(name);
		this.chats.get(index).print_chat();
	}
	
	public void print_all_chats() {
		for (Chat chat : chats)
			chat.print_chat();
	}
	
	public void find_phrase(String phrase) {
		for (Chat chat : chats) {
			if(chat.isContain(phrase))
				System.out.println("something about name has this phrase"); //TODO: fix the massage
		}
	}
	
	public void print_menu() {
		System.out.println("********************Menu********************");
		System.out.println("1. text a contact ");
		System.out.println("2. delete conversation");
		System.out.println("3. print conversation");
		System.out.println("4. search a sentence");
		System.out.println("5. print of conversations ");
		System.out.println("6. Exit");
		System.out.println("********************************************");
	}
}
