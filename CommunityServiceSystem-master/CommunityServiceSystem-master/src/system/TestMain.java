package system;
import java.util.Scanner;

import initialClasses.Address;
import initialClasses.DTStruc;
import initialClasses.JobTypeEnum;
import people.Person;
import people.Recipient;
import people.Volunteer;

import java.io.IOException;
import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner scan = new Scanner(System.in );
		
		ChesSystem sys = new ChesSystem();
	
		
		ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
		//would read in from the file here
		//JobType jj= new JobTypeEnum.JobType();
		
		JobTypeEnum c = JobTypeEnum.Cooking;
		JobTypeEnum b = JobTypeEnum.Babysitting;
		
		sys.addVolunteer("Sarelle Lugomov", new Address("123 coolstreet", "far rockaway", "New york", "11691"), 
													"3477640846", c, "coolgirl@gmail.com", "ppppp5");
		sys.addVolunteer("Moshe kapaya", new Address("3423 hstreet", "jsjd", "New jersey", "11321"), 
				"3243844699", c, "j@gmail.com", "8ppppp");
		sys.addVolunteer("aidel maidel", new Address("613 sevenstreet", "brooklyn", "New york", "1829"), 
				"7183270398", b, "k@gmail.com", "613333");
		sys.addVolunteer("levi cohen", new Address("345 skdfjstreet", "far rockaway", "New York", "11691"), 
				"9759829299", b, "o@gmail.com", "ppppp6");
		
		//ArrayList<Recipient> recipients = new ArrayList<Recipient>();
		
		sys.addRecipient("Mrs. Goodman", new Address("343 rose street", "far rockaway", "New york", "11691"), 
				"2478324600", c, "kosher@gmail.com", "ppppp7");
		sys.addRecipient("Chai Lifeline", new Address("458 kdstreet", "brooklyn", "New york", "11691"), 
				"8882342530", b, "chailifeline@gmail.com", "pppp10");
		sys.addRecipient("shprinzi needy", new Address("97 petunia street", "far Rockaway", "New york", "11691"), 
				"2248824609", c, "r@gmail.com", "pppp11");
		sys.addRecipient("Heimlech manuever", new Address("234 sdkjls", "idk", "New jersey", "11391"), 
				"1235677499", b, "nochoke@gmail.com", "pppp12");
		
		
		
		//Validate Login
		Person currP = sys.validateLogin("k@gmail.com", "613333");
		System.out.println(currP);
		currP = sys.validateLogin("kjkh@gmail.com", "613333");  //should return null here
		System.out.println();
		System.out.println(currP);
		
		
		
		
		Person p = new Person ("Heimlech manuever", new Address("234 sdkjls", "idk", "New jersey", "11391"), 
				"1235677499", b, "nochoke@gmail.com", "pppp12");
		
		p.addAvailability("Monday", 3, 4);
		
		
		DTStruc d = new DTStruc();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
