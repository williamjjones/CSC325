package utils;

import model.User;
import model.UserTreeSet;

public class Demo {

	public static void main(String[] args) {

		
		User user1 = new User("Will", "Jones", "will.jones@gmail.com", "wjones", "Password1");
		User user2 = new User("Dina", "Frances", "dina.frances@gmail.com", "dfrances", "Password1");
		User user3 = new User("Phil", "Rogers", "phil.rogers@gmail.com", "progers", "Password1");
		
		UserTreeSet userSet = UserTreeSet.getGlobalSet();
		
		
		
		userSet.insert(user1);
		userSet.insert(user2);
		userSet.insert(user3);
		
		userSet.display();
		
		BackupRestoreTools.backupUsersTreeSet(userSet);
		
		//System.out.println(userSet.findUser("wjones"));
		//System.out.println(userSet.isUserNameDuplicated("tester"));
				
	    
	    
	}
	
	

}
