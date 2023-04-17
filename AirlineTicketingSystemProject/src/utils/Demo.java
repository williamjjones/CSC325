package utils;

import model.Airport;
import model.AirportTreeSet;
import model.Flight;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;

public class Demo {

	public static void main(String[] args) {

		
		User user1 = new User("Will", "Jones", "will.jones@gmail.com", "wjones", "Password1");
		User user2 = new User("Dina", "Frances", "dina.frances@gmail.com", "dfrances", "Password1");
		User user3 = new User("Phil", "Rogers", "phil.rogers@gmail.com", "progers", "Password1");
		User user5 = new User("Daniel", "Goldstein", "daniel.goldstein@gmail.com", "dgoldstein", "Password1");
		User user6 = new User("Tomasz", "Hajman", "tomasz.hajman@gmail.com", "thajman", "Password1");
		User user7 = new User("Alex", "Lopez", "alez.lopez@gmail.com", "alopez", "Password1");
		User user8 = new User("Tim", "Sluka", "tim.sluka@gmail.com", "tsluka", "Password1");
		User user9 = new User("Rob", "Joyce", "rob.joyce@gmail.com", "rjoyce", "Password1");
		User user10 = new User("Tom", "Thibodeau", "tom.thibodeau@gmail.com", "tthibodeau", "Password1");
		User user11 = new User("Jim", "Simpson", "jim.simpson@gmail.com", "jsimpson", "Password1");
		User user12 = new User("Brian", "Martin", "brian.martin@gmail.com", "bmartin", "Password1");
		User user13 = new User("Willy", "Wonka", "willy.wonka@gmail.com", "wwnka", "Password1");
		User user14 = new User("Peter", "Parker", "peter.parker@gmail.com", "pparker", "Password1");
		User admin = User.createAdmin();
		
		Airport JFK = new Airport("John F. Kennedy International Airport", "888-888-8888", "JFK", "NY");
		Airport LAX = new Airport("Los Angeles International Airport", "343-555-5555", "LAX", "CA");
		Airport LAS = new Airport("Harry Reid International Airport", "522-111-1111", "LAS", "NV");
		
		
		Flight flight1 = new Flight(100, JFK, LAX, "12:00PM", "5:00PM");
		Flight flight2 = new Flight(101, LAS, JFK, "2:00PM", "6:00PM");
		Flight flight3 = new Flight(102, LAX, JFK, "6:00PM", "9:00PM");
		
		
		UserTreeSet userSet = UserTreeSet.getGlobalSet();
		FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
		AirportTreeSet airportSet = AirportTreeSet.getGlobalSet();
		
		userSet.insert(user1);
		userSet.insert(user2);
		userSet.insert(user3);
		userSet.insert(admin);
		
		userSet.display();
		
		airportSet.insert(JFK);
		airportSet.insert(LAX);
		airportSet.insert(LAS);
		
		airportSet.display();
		
		flightSet.insert(flight1);
		flightSet.insert(flight2);
		flightSet.insert(flight3);
                
		flightSet.display();
		
		FlightTreeSet bogusTreeSet = user1.getflightHistory();
		bogusTreeSet.insert(flight3);
		
		user1.getflightHistory().display();
		
//		FlightTreeSet test = user2.getflightHistory();
//		test.removeFlight(test, 102);
//		user2.getflightHistory().display();
		
		BackupRestoreTools.backupUsersTreeSet(userSet);
		BackupRestoreTools.backupFlightHistory(flightSet);
		BackupRestoreTools.backupAirportHistory(airportSet);
		
		//System.out.println(userSet.findUser("wjones"));
		//System.out.println(userSet.isUserNameDuplicated("tester"));
				
	    
	    
	}
	
	

}
