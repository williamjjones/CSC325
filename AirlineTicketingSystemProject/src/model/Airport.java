/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bcs.mycompany.airportandcustomerclasses;

import java.util.LinkedList;

/**
 *
 * @author nickl
 */
public class Airport {
    
    private String apName;
    private String apPhone;
    private String apCode;
    private String state;
    private LinkedList<Flight> flights;
    
    public Airport() {
        apName = null;
        apPhone = null;
        apCode = null;
        state = null;
        flights = new LinkedList<Flight>();
    }
    
    public Airport(String name, String phone, String code, String state ) {
        apName = name;
        apPhone = phone;
        apCode = code;
        this.state = state;
        flights = new LinkedList<flight>();
    }
    
    public Airport(Airport other) {
            this(other.apName, other.apPhone, other.apCode, other.state);
    }
    
    public void setApName(String name) {
        apName = name;
    }
    
    public String getApName() {
        return apName;
    }
    
    public void setApPhone(String phone) {
        apPhone = phone;
    }
    
    public String getApPhone() {
        return apPhone;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setApCode(String code) {
        apCode = code;
    }
    
    public String getApCode() {
        return apCode;
    }
    
    public void addFlight(Flight newFlight) {
        flights.add(newFlight);
     }
    
    
    public void printFlights() {
        System.out.println(flights);
    }
    
    public void clearFlights() {
        flights.clear();
    }
    
    @Override 
    public String toString() {
        return apName + " " + apPhone + " " + state + " " + apCode;
    }
    
    
}
