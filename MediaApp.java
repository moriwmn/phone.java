package ex2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class MediaApp {

	private ArrayList<Media> mediaList;
	private static Scanner input;


public MediaApp() {
	this.mediaList= new ArrayList<Media>();
	input = new Scanner(System.in); 
}
public ArrayList<Media> getMediaList() {
	return mediaList;
}

public void setMediaList(ArrayList<Media> mediaList) {
	this.mediaList = mediaList;
}
public void menu() {
	
	Scanner input = new Scanner(System.in);
	int exit = 0;
	while (exit == 0) {
		System.out.println("********************Menu********************");
		System.out.println("1. add new media");
		System.out.println("2. play media by name");
		System.out.println("3. play all media");
		System.out.println("4. Exit from media");
		System.out.println("********************************************");
		int func = Integer.parseInt(input.nextLine());
		//input.nextLine();
		
		switch (func) {
		case 1: AddMedia(); break;
		case 2: PlayMediaByName(); break; 
		case 3: PlayAll(); break; 
		case 4:exit++; break; 
		}
	}
//	input.close();
}
public void AddMedia() {
	input.nextLine();
	System.out.println("please choose type of media- song or video.");
	String type = input.nextLine();
	if(!(type.equals("Song") || type.equals("song") ||type.equals("Video") || type.equals("video"))) {
		System.out.println("This is not a type of media that exist in the app :)");
		return;
	}
	System.out.println("please enter name of the "+type);
	String name=input.nextLine();
	System.out.println("please enter the length of "+type+ " (minutes)");
	double length=input.nextDouble();
	Media newMedia=new Media(type,name,length);
	mediaList.add(newMedia);
	}
	
public void PlayMediaByName() {
	System.out.println("What is the name of song or video do you want to play?");
	String name = input.nextLine();
	name = input.nextLine();
	boolean exist=false;
	for (int i = 0; i <mediaList.size(); i++)
	{
        if(mediaList.get(i).GetName().equals(name)) {
        	System.out.println("the "+mediaList.get(i).GetType()+" "+mediaList.get(i).GetName()+" is now playing for "+mediaList.get(i).GetLength() +"minutes");
        	exist=true;
        	break;
        }
	}
	if(exist==false) {
		System.out.println("this media- " +name+ " not exist in media list");
}
}

public void PlayAll() {
	for (int i = 0; i <mediaList.size(); i++)
	{
		System.out.println("the "+mediaList.get(i).GetType()+" "+mediaList.get(i).GetName()+" is now playing for "+mediaList.get(i).GetLength() +" minutes");
	}	
}


}

 
		
