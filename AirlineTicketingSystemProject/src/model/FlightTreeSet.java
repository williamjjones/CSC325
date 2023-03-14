package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightTreeSet implements Serializable{
	private TreeSet<Flight> flightSet;
	private static FlightTreeSet globalSet;
	
	public static FlightTreeSet getGlobalSet() {
		if(FlightTreeSet.globalSet == null) {
			globalSet = new FlightTreeSet();
		}
		return globalSet;
		
	}
	private FlightTreeSet() {
		flightSet = new TreeSet<Flight>();
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

	public void display() {
		Iterator<Flight> iterator = flightSet.iterator();
        System.out.println("Flight set data: ");
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        System.out.println();
        }
		
	}
	
	public ObservableList<Flight> displayInFlight() {
		ObservableList<Flight> cameras = FXCollections.observableArrayList();
		Iterator<Flight> iter = flightSet.iterator();
		while(iter.hasNext()) {
			Flight returnCamera = iter.next();
			cameras.add(returnCamera);
		}
		return cameras;
		
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
	

}
