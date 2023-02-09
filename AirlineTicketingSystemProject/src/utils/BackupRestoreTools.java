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
		
		
		

		
		


}