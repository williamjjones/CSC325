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
        Airport OAK = new Airport("Oakland International Airport", "123-333-4444", "OAK", "CA");
		Airport DEN = new Airport("Denver International Airport", "231-323-5664", "DEN", "CO");
        Airport DAB = new Airport("Daytona Beach International Airport", "132-432-6465", "DAB", "FL");
        Airport JAX = new Airport("Jacksonville International Airport", "143-341-4356", "JAX","FL");
        Airport CSG = new Airport("Columbus Airport", "123-444-6556", "CSG", "GA");
        Airport SAV = new Airport("Savannah/Hilton Head International Airport", "123-445-6653", "SAV", "GA");
        Airport MDW = new Airport("Chicago Midway International Airport", "432-443-5654", "MDW", "IL");
        Airport MLI = new Airport("Quad City International Airport", "341-431-3324", "MLI", "IL");
        Airport EWR = new Airport("Newark Liberty International Airport", "654-345-4664", "EWR", "NJ");
        Airport ABQ = new Airport("Albuquerque International Sunport", "134-431-5534", "ABQ", "NM");
        Airport ALB = new Airport("Albany International Airport", "643-453-7667", "ALB", "NY");
        Airport SLC = new Airport ("Salt Lake City International Airport", "213-433-2123", "SLC", "UT");
        Airport PHX = new Airport ("Phoenix Sky Harbor International Airport", "213-123-5421", "PHX", "AZ");
        Airport BOS = new Airport ("Boston Logan International Airport", "231-412-3121", "BOS", "MA");
        Airport MCO = new Airport ("Orlando International Airport", "231-322-1234", "MCO", "FL");
		
		Flight flight1 = new Flight(100, JFK, LAX, "12:00PM", "5:00PM");
		Flight flight2 = new Flight(101, LAS, JFK, "2:00PM", "6:00PM");
		Flight flight3 = new Flight(102, LAX, JFK, "6:00PM", "9:00PM");
		Flight flight4 = new Flight(103, BOS, PHX, "8:00AM", "1:00PM");
        Flight flight5 = new Flight(104, MCO, BOS, "1:00PM", "5:00PM");
        Flight flight6 = new Flight(105, JFK, SLC, "9:00am", "12:00PM");
		
		
		UserTreeSet userSet = UserTreeSet.getGlobalSet();
		FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
		AirportTreeSet airportSet = AirportTreeSet.getGlobalSet();
		
		userSet.insert(user1);
		userSet.insert(user2);
		userSet.insert(user3);
        userSet.insert(user5);
        userSet.insert(user6);
        userSet.insert(user7);
        userSet.insert(user8);
        userSet.insert(user9);
        userSet.insert(user10);
        userSet.insert(user11);
        userSet.insert(user12);
        userSet.insert(user13);
        userSet.insert(user14);
		userSet.insert(admin);
		
		userSet.display();
		
		airportSet.insert(JFK);
		airportSet.insert(LAX);
		airportSet.insert(LAS);
        airportSet.insert(OAK);
        airportSet.insert(DEN);
        airportSet.insert(DAB);
        airportSet.insert(JAX);
        airportSet.insert(CSG);
        airportSet.insert(SAV);
        airportSet.insert(MDW);
        airportSet.insert(MLI);
        airportSet.insert(EWR);
        airportSet.insert(ABQ);
        airportSet.insert(ALB);
        airportSet.insert(MCO);
        airportSet.insert(SLC);
        airportSet.insert(PHX);
        airportSet.insert(BOS);
                		
		airportSet.display();
		
		flightSet.insert(flight1);
		flightSet.insert(flight2);
		flightSet.insert(flight3);
		flightSet.insert(flight4);
        flightSet.insert(flight5);
        flightSet.insert(flight6);
                
		flightSet.display();
		
		// Adding Flight History to Test User
		FlightTreeSet bogusTreeSet = user1.getflightHistory();
		bogusTreeSet.insert(flight3);
		
//		user1.getflightHistory().display();
		

		// Backing Up User, Flight, and Airport Data
		BackupRestoreTools.backupUsersTreeSet(userSet);
		BackupRestoreTools.backupFlightHistory(flightSet);
		BackupRestoreTools.backupAirportHistory(airportSet);
		
		
	    
	    
	}
	
	

}
