package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;

import model.AirportTreeSet;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;


public class BackupRestoreTools{
		
		public static void backupUsersTreeSet(UserTreeSet userSet) {
			try {
				FileOutputStream fos = new FileOutputStream("datastor/usersSet.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userSet);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void backupFlightHistory(FlightTreeSet flightSet) {
			try {
				FileOutputStream fos = new FileOutputStream("datastor/flights.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(flightSet);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void backupAirportHistory(AirportTreeSet airportSet) {
			try {
				FileOutputStream fos = new FileOutputStream("datastor/airports.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(airportSet);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		



		
		public static void restoreUsersTreeSet() {
			File file = new File("datastor/usersSet.dat");
			if (file.exists()) {
				try {
					FileInputStream fis = new FileInputStream("datastor/usersSet.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					UserTreeSet userSet = (UserTreeSet) (ois.readObject());
					UserTreeSet.setGlobalSet(userSet);
					ois.close();
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			} else {
				
			}
			
		}
		
		
		public static void restoreFlightTreeSet() {
			File file = new File("datastor/flights.dat");
			if (file.exists()) {
				try {
					FileInputStream fis = new FileInputStream("datastor/flights.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					FlightTreeSet flightSet = (FlightTreeSet) (ois.readObject());
					FlightTreeSet.setGlobalSet(flightSet);
					ois.close();
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			} else {
				
			}
			
		}
		
		public static void restoreAirportTreeSet() {
			File file = new File("datastor/airports.dat");
			if (file.exists()) {
				try {
					FileInputStream fis = new FileInputStream("datastor/airports.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					AirportTreeSet airportSet = (AirportTreeSet) (ois.readObject());
					AirportTreeSet.setGlobalSet(airportSet);
					ois.close();
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			} else {
				
			}
			
		}
		
		
		

		
		


}