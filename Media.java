package ex2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Media {
	
	private String name;
	private double length;
	private String type;
	
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
