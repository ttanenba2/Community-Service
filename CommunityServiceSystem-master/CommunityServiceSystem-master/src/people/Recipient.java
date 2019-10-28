package people;

import java.util.ArrayList;
import initialClasses.*;
import gui.*;
import system.*;

import initialClasses.Address;
public class Recipient extends Person{

	//instance variables

	int hours;  //keep track of how many hours of service received (needed for finding the balance)
	
	//CONSTRUCTORS
	public Recipient(String name, Address address, String number, JobTypeEnum jobType, String email, String password) {
		super(name, address, number, jobType, email, password);
		
		this.hours = 0; //start off with 0 hours
	}
	public Recipient (String name, Address address, String number) {
		super(name, address, number);
	}
	
	//GETTERS
	public int getHours() {
		return hours;
	}
	
	//SETTERS
	
	public void addHours(int hours) {
		if (hours>0) {
		this.hours += hours;
		}
	}
	
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nRecipient:\n"  + super.toString());
		if (this.hours>0) {
		sb.append("\nTotal Hours Volunteered: " + hours);
		}
		return sb.toString();
	}
}
