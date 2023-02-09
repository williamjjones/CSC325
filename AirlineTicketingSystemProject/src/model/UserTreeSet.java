package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class UserTreeSet implements Serializable{
	private TreeSet<User> userSet;
	private static UserTreeSet globalSet;
	
	public static UserTreeSet getGlobalSet() {
		if(UserTreeSet.globalSet == null) {
			globalSet = new UserTreeSet();
		}
		return globalSet;
		
	}
	private UserTreeSet() {
		userSet = new TreeSet<User>();
	}
	
	public static void setGlobalSet(UserTreeSet userSet) {
		UserTreeSet.globalSet = userSet;
	}
	
	public void insert(User user) {
		userSet.add(user);
	}
	
	public User findUser(String username) {
		Iterator<User> iter = userSet.iterator();
		while(iter.hasNext()) {
			User returnUser = iter.next();
			if(returnUser.getUserName().equals(username))
				return returnUser;
		}
		return null;
	}

	public void display() {
		Iterator<User> iterator = userSet.iterator();
        System.out.println("Tree set data: ");
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        System.out.println();
        }
		
	}
	
	public boolean isSignInCorrect(String username, String password) {
			try {
				if(findUser(username).getUserName().equals(username) && findUser(username).getPassword().equals(password)) {
						return true;
				}
			} catch (Exception e) {
				return false;
			}
		return false;
	}
	
	public boolean isUserNameDuplicated(String username) throws NullPointerException {
		
		try {
			if(findUser(username).getUserName().equals(username)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	

}
