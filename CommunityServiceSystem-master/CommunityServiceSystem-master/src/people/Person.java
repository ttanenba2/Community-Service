

package people;



import initialClasses.*;

import java.time.*;//This is so that we can use the java.time.DayOfWeek enum. 

import java.util.ArrayList;





//import System;





public class Person {



	private DTStruc daysAndTimes;
	private String name;

	private Address address;

	private String number;

	private String email; //will function as a username

	private JobTypeEnum jobType; ///i thought wer not doing this

	private String password;





	//CONSTRUCTORS

	public Person (String name, Address address, String number,

			JobTypeEnum jobType, String email, String password){



		//This constructor takes all the info that the user entered.

		this(name, address, number);





		this.jobType = jobType;

		this.daysAndTimes = new DTStruc();

		
		if (verifyEmail(email)) {

			this.email = email;

		}



		if (verifyPassword(password)) {

			this.password = password;

		}

	}





	//not used for instantiating a person as of now

	public Person (String name, Address address, String number){

		//This constructor enters the user's personal information to register him as a user. He can always come back and enter the rest of his information. 

		this.name = name;

		this.address = address;

		if (verifyPhoneNumber(number)) {

			this.number = number;

		}

	}





	//copy constructor

	public Person (Person p) {

		this(p.getName(), p.getAddress(), p.getNumber(), p.getJobTypes(),

				p.getEmail(), p.getPassword());

	}



	//SETTERS:



	public void setName(String name){

		this.name=name;

	}

	public void setAddress (Address address){

		this.address=address;

	}

	public void setNumber (String number){

		if (verifyPhoneNumber(number)) {

			this.number=number;

		}

	}



	public void setJobType (JobTypeEnum jobType){

		this.jobType=jobType;

	}



	public void setEmail(String email) {

		if (verifyEmail(email)) {

			this.email = email;

		}

	}



	public void setPassword(String password) {

		if (verifyPassword(password)){

			this.password = password;

		}

	}

	

	/* Verify phone number

	 * phone number must have 10 digits

	 */

	public static boolean verifyPhoneNumber(String number) {

		if (number.length()!=10) {

			throw new InvalidDataException("Number must have 10 digits.");

		}

		return true;

	}

	

	/* Verify email

	 * email must be at least 6 characters and contain '@' and '.'

	 */ 

	public static boolean verifyEmail(String email) {

		if(!email.contains("@") || !email.contains(".")) {

			throw new InvalidDataException("Invalid email address:"

					+ " must be in form of  'xxxxxxxx@xxxxx.xxx'");

		} 

		if (email.length() < 6) {

			throw new InvalidDataException("Invalid email address: "

					+ " Password you entered did not contain all "

					+ "desired components.");

		}

		return true;

	}

	
	

	/* Verify password

	 * password must have at least 6 characters

	 */

	public static boolean verifyPassword(String password) {

		if (password.length() < 6) {

			throw new InvalidDataException("Invalid password. "

					+ "Password must be 6 or more characters.");

		}

		return true;

	}





	public void addAvailability(String dayOfWeek, int beginTimeRange, int endTimeRange) {



		//this loops through each hour of the range and adds it to the Person's availability.

		for (int i = beginTimeRange; i<endTimeRange; i++) {

			this.daysAndTimes.addHour(dayOfWeek, i);

		}
		

	}

	public void removeAvailability(String dayOfWeek, int beginTimeRange, int endTimeRange) {



		//this loops through each hour of the range and adds it to the Person's availability.

		for (int i = beginTimeRange; i<endTimeRange; i++) {

			this.daysAndTimes.removeHour(dayOfWeek, i);

		}

	}
public void removeAllAvailability(){
	this.daysAndTimes.removeAllAvailability();
}
	//GETTERS

	//getDStruc

	public DTStruc getDTStruc() {//////added for matching

		return daysAndTimes;

	}

	public String getName(){

		return this.name;

	}

	public Address getAddress (){

		return this.address;

	}

	public String getNumber (){

		return this.number;

	}

	public JobTypeEnum getJobTypes(){	

		return this.jobType;

	}



	public String getEmail() {

		return this.email;

	}

	public String getPassword() {

		return this.password;

	}





	//always check whether the new person equals someone already in the database before adding him.

	//If he does, just update his info instead of creating a new person. 



	public boolean equals (Person P){

		///I did not first check that the object being passed in is a person, 

		//and then typecast... because it's just us here, and I think we'll

		//code well enough that only people 

		//will be passed in. 

		//That's why I didn't write @Override- 

		//it gave an error because it's a different parameter. 

		//Feel free to change it if you want. 



		if (this.name.equals (P.getName())&&this.number.equals(P.getNumber()))

			return true;

		else return false;

	}



	public int compareTo(Person P){

		//Here, too, I did not @Override because the parameter is Person, not Object.

		//I left this empty- Will we ever need to compare two people? Based on what? Do we want to alphabetize them or rank them based on how many hours they volunteered for? 

		//I guess we'll decide as we go. Feel free to edit this method as you wish. 

		//For now this method has an error because it doesn't return an int.

		return 0;

	}


@Override
	public String toString(){



		StringBuilder str=new StringBuilder();



		str.append(this.name+"  \n");

		str.append(this.address+"  \n");

		str.append(this.number+"  \n");

		str.append(this.jobType + "  \n");



		//display days and times available using the DTStruc's toString

		if(daysAndTimes!=null) {

		str.append("\n  Days and Times Available: ");

		str.append("\n" + daysAndTimes.toString());

		}

		return str.toString();

	}

}


