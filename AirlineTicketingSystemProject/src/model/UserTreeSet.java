package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class UserTreeSet implements Serializable{
	private TreeSet<User> userSet;
	private static UserTreeSet globalSet;
	private static User storedUser;
        private static final long serialVersionUID = -7454500041812709768L;
	
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
	
	public static void setStoredUser(User storeUser) {
		storedUser = storeUser;
	}
	
	public static User getStoredUser() {
		return storedUser;
	}
	
	public void insert(User user) {
		userSet.add(user);
	}
	
	public User storeUser(String username) {
		storedUser = findUser(username);
		return storedUser;
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
        
        public ArrayList<String> returnUsernames(){
            ArrayList<String> arr = new ArrayList<>();
            
            Iterator<User> iter = userSet.iterator();
            while (iter.hasNext()) {
                arr.add(iter.next().getUserName());
            }
            
            return arr;
        }
        
        public ArrayList<String> returnUsernames(String searchPhrase){
            ArrayList<String> arr = new ArrayList<>();
            
            Iterator<User> iter = userSet.iterator();
            while (iter.hasNext()) {
                String username = iter.next().getUserName();
                if(username.contains(searchPhrase))
                {
                    arr.add(username);
                }
            }
            
            return arr;
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
