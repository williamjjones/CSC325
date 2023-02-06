package model;

import java.io.Serializable;
import java.util.Arrays;


public class UserBag implements Serializable{
	private User[] users;
	private int nElems;
	
	
	public UserBag(int maxSize) {
		users = new User[maxSize];
	}
	
	public void insert(User user) {
		users[nElems++] = user;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(users[i]);
		}
	}
	
	public boolean login(String username, String password) {
		return false;
		
	}
	
	public User[] searchByUserName(String username) {
		User[] tempArr = new User[nElems];
		int count = 0;
		for(int i = 0; i < nElems; i++) {
			if(users[i].getUserName().equals(username)) {
				tempArr[count++] = users[i];
			}
		}
		
		return Arrays.copyOf(tempArr,  count);
	}
	
	public User returnSearchByUserName(String username) {
		User[] tempArr = new User[nElems];
		int count = 0;
		for(int i = 0; i < nElems; i++) {
			if(users[i].getUserName().equals(username)) {
				return users[i];
			}
		}
		
		return null;
	}
	
	public User[] removeByUserName(User loggedInUser, String username) {
		int count = 0;
		User[] tempArr = new User[nElems];
		if(loggedInUser.isAdmin() || username.equals(loggedInUser.getUserName())) {	
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(username)) {
				tempArr[count++] = users[i];
				for(int j = i; j< nElems - 1; j++) {
					users[j] = users[j+1];
				}
				i--;
				nElems--;
				
			}
			
		}
		
		return Arrays.copyOf(tempArr, count);
		} else {
			 System.out.println("No changes have been made. You don't have the correct rights to make this change.");
			 return Arrays.copyOf(users, count);
			 
		}
	}

	public User[] getUserArray () {
		return users;
	}
	
	public int size() {
		return nElems;
	}
	
	public int length() {
		return users.length;
	}
	
	public boolean isSignInCorrect(String username, String password) {
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(username) && users[i].getPassword().equals(password)) {
					return true;
			}
		}
		return false;
	}
	public boolean isUserAdmin(String username, String password) {
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(username) && users[i].getPassword().equals(password) && users[i].isAdmin()) {
					return true;
			}
		}
		return false;
	}
	public User signedInUser(String username, String password) {
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(username) && users[i].getPassword().equals(password)) {
					return users[i];
			}
		}
		return null;
	}
	
	public boolean isUserNameDuplicated(String username) {
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(username)) {
					return true;
			}
		}
		return false;
	}
	
	public void setHikeHistoryForLastUser(HikingHistory hikehistory) {
		users[nElems-1].setHikingHistory(hikehistory);
	}
	
	public boolean isUserNameValid(String userName) {
		for(int i = 0; i< nElems; i++) {
			if(users[i].getUserName().equals(userName)) {
					return true;
			}
		}
		return false;
	}
	
	public User[] displayInUsers(UserBag usersBag) {
		User[] a = new User[nElems];
		int count = 0;
		for(int i = 0; i < nElems; i++) {
			
				a[count++] = users[i];
			
		}
		
		return Arrays.copyOf(a,  count);
	}

}


