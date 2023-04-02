package model;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Predicate;

public class Flight implements Serializable, Comparable<Flight>{
	private static final long serialVersionUID = 1L;
	private int flightNumber;
	private Airport origin;
	private Airport destination;
	private String arrivalTime;
	private String departureTime;
	
	
	
	public Flight(int flightNumber, Airport origin, Airport destination, String arrivalTime, String departureTime) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public Airport getOrigin() {
		return origin;
	}


	public void setOrigin(Airport origin) {
		this.origin = origin;
	}


	public Airport getDestination() {
		return destination;
	}


	public void setDestination(Airport destination) {
		this.destination = destination;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	private static boolean searchFindsFlightNum(Flight flightNum, String searchText){
	    return (Integer.valueOf(flightNum.getFlightNumber()).toString().contains(searchText.toLowerCase()));
	}
	
	public static Predicate<? super Flight> flightNumPredicate(String searchText){
	    return flightNum -> {
	        if (searchText == null || searchText.isEmpty()) return true;
	        return searchFindsFlightNum(flightNum, searchText);
	    };
	}


	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + " Origin=" + origin + " Destination=" + destination +", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(departureTime, other.departureTime)
				&& flightNumber == other.flightNumber;
	}


	@Override
	public int compareTo(Flight o) {
		return this.origin.getApName().compareTo(o.origin.getApName());
	}
	
	
	
	
}
