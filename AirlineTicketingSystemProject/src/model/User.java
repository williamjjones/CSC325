package model;

import java.io.Serializable;

public class User implements Serializable{
	private String firstName;
	private String lastName;
	private boolean isAdmin;
	private String emailAddress;
	private String username;
	private String password;
	private String profilePicture;
	private FlightHistory flightHistory;
	
	
	
	public User(String firstName, String lastName, String emailAddress, String username, String password, String profilePicture,
			FlightHistory flightHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.flightHistory = flightHistory;
	}

	public User(String username, String password, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public User(String firstName, String lastName, String emailAddress, String username, String password, String profilePicture) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.flightHistory = null;
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


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	public FlightHistory getflightHistory() {
		return flightHistory;
	}


	public void setflightHistory(FlightHistory flightHistory) {
		this.flightHistory = flightHistory;
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", isAdmin= " + isAdmin +", emailAddress=" + emailAddress
				+ ", username=" + username + ", profilePicture=" + profilePicture + ", flightHistory=" + flightHistory
				+ "]";
	}

}
