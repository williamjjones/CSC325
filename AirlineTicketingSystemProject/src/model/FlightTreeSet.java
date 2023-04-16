package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightTreeSet implements Serializable{
	private TreeSet<Flight> flightSet;
	private static FlightTreeSet globalSet;
        private static final long serialVersionUID = 8259469692953558898L;
	
	public static FlightTreeSet getGlobalSet() {
		if(FlightTreeSet.globalSet == null) {
			globalSet = new FlightTreeSet();
		}
		return globalSet;
		
	}
	public FlightTreeSet() {
		flightSet = new TreeSet<Flight>();
	}
	
	public TreeSet<Flight> getFlightSet() {
		return flightSet;
	}
	public void setFlightSet(TreeSet<Flight> flightSet) {
		this.flightSet = flightSet;
	}
	
	public static void setGlobalSet(FlightTreeSet userSet) {
		FlightTreeSet.globalSet = userSet;
	}
	
	public void insert(Flight flight) {
		flightSet.add(flight);
	}
	
	public Flight findFlight(int flightNumber) {
		Iterator<Flight> iter = flightSet.iterator();
		while(iter.hasNext()) {
			Flight returnFlight = iter.next();
			if(returnFlight.getFlightNumber() == flightNumber)
				return returnFlight;
		}
		return null;
	}
	
	public void removeFlight(FlightTreeSet flightHistory, int flightNumber) {
		Flight deleteFlight = findFlight(flightNumber);
		TreeSet<Flight> userFlights = flightHistory.getFlightSet();
		userFlights.remove(deleteFlight);
	}

	public void display() {
		Iterator<Flight> iterator = flightSet.iterator();
        System.out.println("Flight set data: ");
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        System.out.println();
        }
		
	}
	
	public ObservableList<Flight> displayInFlight() {
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		Iterator<Flight> iter = flightSet.iterator();
		while(iter.hasNext()) {
			Flight returnFlight = iter.next();
			flights.add(returnFlight);
		}
		return flights;
		
	}
	
	
	public boolean isFlightNumberDuplicated(int flightNumber) throws NullPointerException {
		
		try {
			if(findFlight(flightNumber).getFlightNumber() == flightNumber) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
        
        public ArrayList<String> returnFlightNums(){
            ArrayList<String> arr = new ArrayList<>();
            
            Iterator<Flight> iter = flightSet.iterator();
            while (iter.hasNext()) {
                arr.add(Integer.toString(iter.next().getFlightNumber()));
            }
            
            return arr;
        }
        
        public ArrayList<String> returnFlightNums(String searchPhrase){
            ArrayList<String> arr = new ArrayList<>();
            
            Iterator<Flight> iter = flightSet.iterator();
            while (iter.hasNext()) {
                int flightNumber = iter.next().getFlightNumber();
                if(flightNumber == Integer.parseInt(searchPhrase))
                {
                    arr.add(Integer.toString(flightNumber));
                }
            }
            
            return arr;
        }
	

}
