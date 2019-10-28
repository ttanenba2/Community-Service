package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import initialClasses.*;
import people.*;


public class ChesSystem implements Serializable{
	//private String name; //if it is being used by different orginisations
	private ArrayList<Person> recipients;  
	private ArrayList<Person> volunteers;
	private Person currentPerson;
	private FileInputStream file;
	private ObjectInputStream arr;
	private FileOutputStream fileOut;
	private FileOutputStream fileOutV;


	public ChesSystem() throws IOException, ClassNotFoundException {
		
		

		/*//*file = new FileInputStream("C:\\Users\\Rivkie\\Documents\\desktop\\CommunityServiceSystem\\src\\system\\Recipients.txt");
		if(file.available()==0) {
			recipients=new ArrayList<Person>();

		}
		else {
		 arr = new ObjectInputStream(file);



		recipients= (ArrayList<Person>)arr.readObject();
		}



		FileInputStream fileTwo = new FileInputStream("Volunteers.txt");
		ObjectInputStream arrV = new ObjectInputStream(file);

		volunteers= (ArrayList<Person>)arrV.readObject();
		//if doing files, read in from file here

		currentPerson=null;

		fileOut=new FileOutputStream("C:\\Users\\Rivkie\\Documents\\desktop\\CommunityServiceSystem\\src\\system\\Recipients.txt");
		fileOutV=new FileOutputStream("C:\\Users\\Rivkie\\Documents\\desktop\\CommunityServiceSystem\\src\\system\\Volunteers.txt");
		/*/

		currentPerson=null;
		recipients=new ArrayList<Person>();
		volunteers= new ArrayList<Person>();
	}

	public void addRecipient(String name, Address address, String number,
			JobTypeEnum jobType, String email, String password) {
		Recipient r = new Recipient(name, address, number, jobType, email, password);
		recipients.add(r);
	}


	public void addVolunteer(String name, Address address, String number,
			JobTypeEnum jobType, String email, String password) {
		Volunteer v = new Volunteer (name, address, number, jobType, email, password);
		volunteers.add(v);
	}

	public void addAvailability(Person p, String dayOfWeek, int beginTimeRange, int endTimeRange) {
		p.addAvailability(dayOfWeek, beginTimeRange, endTimeRange);
	}


	public void removeAvailability (Person p, String dayOfWeek, int beginTimeRange, int endTimeRange){
		p.removeAvailability(dayOfWeek, beginTimeRange, endTimeRange);
	}


	public ArrayList<Person> findMatches(Person ind){ 

		//an ArrayList of the opposite type (Recipient or volunteer)
		ArrayList<Person> people1;

		if (ind instanceof Volunteer) {
			people1 = recipients;
		}

		else {
			people1 = volunteers;
		}

		ArrayList<Person> matches = new ArrayList<Person>(); 
		ArrayList<Person> matchesCityOnly = new ArrayList<Person>(); 

		DTStruc dtstruc =ind.getDTStruc();
		int[] days = dtstruc.getEarliestHourOfDays();

		for(Person groupie: people1) {  //groupie as in is part of a group, this is not the individual
            if(groupie.getAddress().getCity().equalsIgnoreCase(ind.getAddress().getCity())) {
            	
                for(int i=0; i<7; i++) {
                	
                    String yom= "default";
                    
                    switch (i) {
                    case 0:
                        yom="Sunday";
                        break;
                    case 1:
                        yom="Monday";
                        break;
                    case 2:
                        yom="Tuesday";
                        break;
                    case 3:
                        yom="Wednesday";
                        break;
                    case 4:
                        yom="Thursday";
                        break;
                    case 5:
                        yom="Friday";
                        break;
                    case 6:
                        yom="Saturday";
                        break;
                    }
                    for(int k = days[i]; k<24;k++) { 
                        if(dtstruc.isAvailable(yom, k)) {  
                            if(groupie.getDTStruc().isAvailable(yom,k)) {
                                matches.add(groupie);
                                break;//breaks out of k for loop /////so it stops comparing times, because if it matches
                                		//on one it should be added
                            }
                        }
                    }
                    if(people1.contains(groupie)) break;  //now stops comparing times
                }


			}//if city matches
			if(!matches.contains(groupie)) {
				matchesCityOnly.add(groupie);
				//matchcity++;
			}
		}//for loop 1	

		matches.addAll(matchesCityOnly);//*add match variable again,, matchesCityOnly will be added to the end so it will be in order, using variables will allow a separation btw closer matches and matches just for city
		return matches;	

	}


	public void setCurrentPerson(Person currentPerson) {
		this.currentPerson=currentPerson;
	}

	public Person getCurrentPerson() {
		return currentPerson;
	}

	public void write() throws IOException {
		if(currentPerson instanceof Recipient)
			new ObjectOutputStream(fileOut).writeObject(recipients);

		else {
			new ObjectOutputStream(fileOutV).writeObject(volunteers);
		}

	}


	//upon login, return a person if the login is valid. Otherwise, return null
	public Person validateLogin(String email, String password) {

		//loop through the recipients to see if the email is there
		for (int i=0; i<recipients.size(); i++) {
			if (recipients.get(i).getEmail().equalsIgnoreCase(email)){
				if (recipients.get(i).getPassword().equals(password)) {

					//set currentPerson to the found user and return
					currentPerson = recipients.get(i);
					return recipients.get(i);

				}

			}
		}
		for (int j =0; j<volunteers.size(); j++) {
			if (volunteers.get(j).getEmail().equalsIgnoreCase(email)){
				if (volunteers.get(j).getPassword().equals(password)) {

					//set currentPerson to the found user and return
					currentPerson = volunteers.get(j);
					return volunteers.get(j);
				}
			}
		}
		return null;
	}
}
