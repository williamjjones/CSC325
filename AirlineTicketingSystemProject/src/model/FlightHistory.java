package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;


public class FlightHistory implements Serializable{
	private ArrayList<Flight> Flights;
	
	public FlightHistory(int maxSize) {
		Flights = new ArrayList<Flight>(maxSize);
	}

	public void display() {
		System.out.print(Flights);
	}
	public void insert(Flight Flight) {
		Flights.add(Flight);
	}
	
	public ArrayList<Flight> displayInFlights() {
		ArrayList<Flight> a = Flights;
		
		return a;
	}
	
	public ArrayList<Flight> search(Predicate predicate){
		ArrayList<Flight> newList = new ArrayList<>();
		Flights.forEach(s -> {
			if(predicate.test(s)) {
				newList.add(s);
			};
		});
		newList.trimToSize();
		return newList;
	}

	@Override
	public String toString() {
		return "HikingHistory [Flights=" + Flights + "]";
	}
	
}
