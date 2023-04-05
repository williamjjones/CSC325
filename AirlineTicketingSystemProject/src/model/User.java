package model;

import java.io.Serializable;

public class User implements Serializable, Comparable<User>{
	private static final long serialVersionUID = 18566487;
	private String firstName;
	private String lastName;
	private boolean isAdmin;
	private String emailAddress;
	private String username;
	private String password;
	private FlightTreeSet flightHistory;
	
	private static final int MIN_PASSWORD_LENGTH = 6;
	
	
	public User(String firstName, String lastName, String emailAddress, String username, String password,
			FlightTreeSet flightHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.flightHistory = flightHistory;
	}

	public User(String username, String password, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public User(String firstName, String lastName, String emailAddress, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.flightHistory = new FlightTreeSet();
	}

	public static void createAdmin() {
		User admin = new User("admin", "Admin123", true);
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		
	}




	public String getPassword() {
		return password;
		
	}
	


	public void setPassword(User loggedInUser, User username, String password) {
		if(loggedInUser.isAdmin || username.equals(loggedInUser)) {
			username.password = password;
			System.out.println("The password for " + username + "was changed.");
		}else {
			System.out.println("You must be an admin to set passwords!");
		}
		
	}
        
        // used for setting password in admin dash
        public void setPassword(String password){
            this.password = password;
        }

	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getUserName() {
		return username;
	}


	public void setUserName(String username) {
		this.username = username;
	}


	public FlightTreeSet getflightHistory() {
		return flightHistory;
	}


	public void setflightHistory(FlightTreeSet flightHistory) {
		this.flightHistory = flightHistory;
	}
	
	public static boolean hasMinimumOneCapital(String password) {
		boolean capital = false;
		for(int i = 0; i< password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean hasMinimumOneLowerCase(String password) {
		for(int i = 0; i< password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		return false;
		
	}

	public static boolean rightLength(String password) {
		if(password.length() >= MIN_PASSWORD_LENGTH) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public static boolean hasMinOneDigit(String password) {
		for(int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
        

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", isAdmin= " + isAdmin +", emailAddress=" + emailAddress
				+ ", username=" + username + ", flightHistory=" + flightHistory
				+ "]";
	}
	
	@Override
	public int compareTo(User o) {
		return this.username.compareTo(o.username);
	}

}
