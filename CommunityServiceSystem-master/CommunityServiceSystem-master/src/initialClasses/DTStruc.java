package initialClasses;





import java.time.*;//This is so that we can use the java.time.DayOfWeek enum. 



public class DTStruc {



	private boolean[] Sunday= new boolean [24];

	private boolean[] Monday= new boolean [24];

	private boolean[] Tuesday= new boolean [24];

	private boolean[] Wednesday= new boolean [24];

	private boolean[] Thursday= new boolean [24];

	private boolean[] Friday= new boolean [24];

	private boolean[] Saturday= new boolean [24];

	private int[] days = new int[7]; //sunday is 0; bc it doesnt make sense to 

	//go through every single hour of every single day in order to see when the first person is 

	//available, it will still be v indefficent with the hours but save a ton

	//private ArrayList<Integer>() days = new ArrayList<Integer>(7); //bc wont need more than 7

	public DTStruc(){

		for(int day: days) {

			day=25;

		}

	}

	public int[] getEarliestHourOfDays() {//if the earliest hour is 25 then u know that it is not used and dont waste time checking it

		return days;

	}

	public void addHour(String d, int hr){

		String day=d.toUpperCase(); 

		//if(hr < days[DayOfWeek.day.getValue]) {//if this day was not added yet,,contains

		//	days[DayOfWeek.day.getValue]=hr;  //now when comparing first check here and only start from here       //this doesnt work bc it doesnt recoginze day

		//}

		switch (day){

		case "SUNDAY":

			this.Sunday[hr]=true;

			if(hr < days[0]) days[0]=hr;  

			break;

		case "MONDAY":

			this.Monday[hr]=true;

			if(hr < days[1]) days[1]=hr;

			break;

		case "TUESDAY":

			this.Tuesday[hr]=true;

			if(hr < days[2]) days[2]=hr;

			break;

		case "WEDNESDAY":

			this.Wednesday[hr]=true;

			if(hr < days[3]) days[3]=hr;

			break;

		case "THURSDAY":

			this.Thursday[hr]=true;

			if(hr < days[4]) days[4]=hr;

			break;

		case "FRIDAY":

			this.Friday[hr]=true;

			if(hr < days[5]) days[5]=hr;

			break;

		case "SATURDAY":

			this.Saturday[hr]=true;

			if(hr < days[6]) days[6]=hr;

			break;

		default:

			throw new IllegalArgumentException();

		}



	}

	public void removeHour(String d, int hr){//switch d to int for looping

		String day=d.toUpperCase(); 

		switch (day){

		case "SUNDAY":

			this.Sunday[hr]=false;

			break;

		case "MONDAY":

			this.Monday[hr]=false;

			break;

		case "TUESDAY":

			this.Tuesday[hr]=false;

			break;

		case "WEDNESDAY":

			this.Wednesday[hr]=false;

			break;

		case "THURSDAY":

			this.Thursday[hr]=false;

			break;

		case "FRIDAY":

			this.Friday[hr]=false;

			break;

		case "SATURDAY":

			this.Saturday[hr]=false;

			break;

		default:

			throw new IllegalArgumentException();

		}



	}

	//might have to make getters for the matching

	public boolean isAvailable(String d, int hr){

		String day=d.toUpperCase(); 

		switch (day){

		case "SUNDAY":

			if (Sunday[hr]==true)  return true;   

			break;

		case "MONDAY":

			if(Monday[hr]==true) return true;

			break;

		case "TUESDAY":

			if (Tuesday[hr]==true) return true;

			break;

		case "WEDNESDAY":

			if (Wednesday[hr]==true) return true;

			break;

		case "THURSDAY":

			if (Thursday[hr]==true) return true;

			break;

		case "FRIDAY":

			if (Friday[hr]==false) return true;

			break;

		case "SATURDAY":

			if (Saturday[hr]==true) return true;

			break;

		default:

			return false;

		}

		return false;

	}

	public void removeAllAvailability() {
		for (boolean a: Sunday) {
			
			a=false;
			System.out.println(a);
		}
		for (boolean a: Monday) {
			a=false;
		}for (boolean a: Tuesday) {
			a=false;
		}for (boolean a: Wednesday) {
			a=false;
		}for (boolean a: Thursday) {
			a=false;
		}for (boolean a: Friday) {
			a=false;
		}for (boolean a: Saturday) {
			a=false;
		}
	}
	
	
	@Override

	public String toString(){

		StringBuilder sun=new StringBuilder("Sunday: ");

		for (int i=0;i<Sunday.length; i++){

			if (Sunday[i]==true){

				sun.append(i+":00, ");

			}

		}//close for loop

		StringBuilder mon=new StringBuilder("Monday: ");

		for (int i=0;i<Monday.length; i++){

			if (Monday[i]==true){

				mon.append(i+":00, ");

			}

		}//close for loop

		StringBuilder tues=new StringBuilder("Tuesday: ");

		for (int i=0;i<Tuesday.length; i++){

			if (Tuesday[i]==true){

				tues.append(i+":00, ");

			}

		}//close for loop

		StringBuilder wed=new StringBuilder("Wednesday: ");

		for (int i=0;i<Wednesday.length; i++){

			if (Wednesday[i]==true){

				wed.append(i+":00, ");

			}

		}//close for loop

		StringBuilder thurs=new StringBuilder("Thursday: ");

		for (int i=0;i<Thursday.length; i++){

			if (Thursday[i]==true){

				thurs.append(i+":00, ");

			}

		}//close for loop

		StringBuilder fri=new StringBuilder("Friday: ");

		for (int i=0;i<Friday.length; i++){

			if (Friday[i]==true){

				fri.append(i+":00, ");

			}

		}//close for loop

		StringBuilder sat=new StringBuilder("Saturday: ");

		for (int i=0;i<Saturday.length; i++){

			if (Saturday[i]==true){

				sat.append(i+":00, ");

			}

		}//close for loop

		String ret=(sun.toString()+"\n"+mon.toString()+"\n"+tues.toString()+"\n"+wed.toString()+"\n"+thurs.toString()+"\n"+fri.toString()+"\n"+sat.toString());

		return ret;

	}





}//close class