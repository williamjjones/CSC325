package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class AirportTreeSet implements Serializable{
	private TreeSet<Airport> airportSet;
	private static AirportTreeSet globalSet;
	
	public static AirportTreeSet getGlobalSet() {
		if(AirportTreeSet.globalSet == null) {
			globalSet = new AirportTreeSet();
		}
		return globalSet;
		
	}
	private AirportTreeSet() {
		airportSet = new TreeSet<Airport>();
	}
	
	public static void setGlobalSet(AirportTreeSet userSet) {
		AirportTreeSet.globalSet = userSet;
	}
	
	public void insert(Airport airport) {
		airportSet.add(airport);
	}
	
	public Airport findAirport(String airportCode) {
		Iterator<Airport> iter = airportSet.iterator();
		while(iter.hasNext()) {
			Airport returnAirport = iter.next();
			if(returnAirport.getApCode().equals(airportCode))
				return returnAirport;
		}
		return null;
	}

	public void display() {
		Iterator<Airport> iterator = airportSet.iterator();
        System.out.println("Airport set data: ");
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        System.out.println();
        }
		
	}
	
	
	public boolean isAirportCodeDuplicated(String airportCode) throws NullPointerException {
		
		try {
			if(findAirport(airportCode) != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	

}
