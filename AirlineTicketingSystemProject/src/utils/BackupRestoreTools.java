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

import model.FlightHistory;
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
		
		public static void backupHikeHistory(FlightHistory flightBag) {
			try {
				FileOutputStream fos = new FileOutputStream("datastor/flighthistory.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(flightBag);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		



		
		public static void restoreUsersTreeSet() {
			File file = new File("datastor/users.dat");
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
		
		public static FlightHistory restoreHikeHistory() {

			try {
				File file = new File("datastor/flighthistory.dat");
				if (file.exists()) {
					FileInputStream fis = new FileInputStream("datastor/flighthistory.dat");
					ObjectInputStream oos = new ObjectInputStream(fis);
					FlightHistory myBag = (FlightHistory) (oos.readObject());
					oos.close();
					return myBag;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return new FlightHistory(500);

		}
		
		
		

		
		


}