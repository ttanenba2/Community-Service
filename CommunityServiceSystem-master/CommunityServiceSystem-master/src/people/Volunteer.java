package people;

import java.time.*;
import initialClasses.*;
import java.util.ArrayList;

import initialClasses.Address;

public class Volunteer extends Person{

	//instance variables
	private LocalDate birthdate; //not currently in use
	private boolean canDrive;
	private int hours; //this is in case we ever want to keep track of the amount of hours a Volunteer put in (possibly for a reward system)
	
	
	//CONSTRUCTORS
	public Volunteer(String name, Address address, String number, JobTypeEnum jobTypes, String email, String password) {
		
		super(name, address, number, jobTypes, email, password);
		
		this.hours = 0; //starts off with 0 hours
	}
	
	public Volunteer(String name, Address address, String number) {
		super(name, address, number);
	}
	
	//GETTERS
	public int getHours() {
		return hours;
	}
	
	public LocalDate getBday() {
		return birthdate;
	}
	
	public int getAge() {
		int yearBorn = birthdate.getYear();
		int age = LocalDate.now().getYear() - yearBorn;
		return age;
	}
	public boolean getCanDrive() {
		if (this.getAge() >= 18) {
			return this.canDrive;
		}
		else return false;
	}
	
	
	//SETTERS
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public void setCanDrive(boolean canDrive) {
		if (this.getAge()>=18) {
		this.canDrive = canDrive;
		}
		else this.canDrive = false;
	}
	
	//add hours
	public void addHours(int addHours) {
		try {
		if (addHours<0) {
			throw new InvalidDataException("Invalid entry for hours");
		}
		this.hours += addHours; 
		}
		catch(InvalidDataException inv) {
			System.out.println(inv);
		}
	}
	//toString()
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nVOLUNTEER:\n"  + super.toString());
		sb.append("\nDrives: " );
		if (canDrive) {
			sb.append("Yes");
		}
		else {
		sb.append("No");
		}
		sb.append("\nTotal Hours Volunteered: " + hours);
		return sb.toString();
	}
}
