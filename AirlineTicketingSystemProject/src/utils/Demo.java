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
		
		userSet.display();
		
		airportSet.insert(JFK);
		airportSet.insert(LAX);
		airportSet.insert(LAS);
		
		airportSet.display();
		
		flightSet.insert(flight1);
		flightSet.insert(flight2);
		flightSet.insert(flight3);
		
		flightSet.display();
		
		BackupRestoreTools.backupUsersTreeSet(userSet);
		BackupRestoreTools.backupFlightHistory(flightSet);
		BackupRestoreTools.backupAirportHistory(airportSet);
		
		//System.out.println(userSet.findUser("wjones"));
		//System.out.println(userSet.isUserNameDuplicated("tester"));
				
	    
	    
	}
	
	

}
