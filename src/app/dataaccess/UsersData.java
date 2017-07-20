package app.dataaccess;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import app.model.*;

public class UsersData {

	public static Map<Integer, User> usersPassword = new HashMap<Integer, User>();

	// creating and adding some users with password

	private static int count = 0;
    private static boolean isLoggedIn = false;
	public static void addUsers() {
        
		Role role = new Role(1, "user");
		Role role1 = new Role(2, "admin");
		User user1 = new User();
		user1.setUsername("jak@gmail.com");
		user1.setFirstName("Jak");
		user1.setPassword("jak");
		user1.addRole(role);
		User user2 = new User();
		user2.setUsername("jak1@gmail.com");
		user2.setFirstName("Jak1");
		user2.setPassword("jak1");
		user2.addRole(role1);
		User user3 = new User();
		user3.setUsername("jak2");
		user2.setFirstName("Jak1");
		user3.setPassword("jak2");

		add(user1);
		add(user2);
		add(user3);

	}

	public static void add(User user) {
		usersPassword.put(count, user);
		count++;
	}

	public static User checkUser(String username, String password) {
		Iterator userPasswords = usersPassword.entrySet().iterator();
		while (userPasswords.hasNext()) {
			Entry<Integer, User> mappairs = (Entry<Integer, User>) userPasswords.next();
			if (username.equals(mappairs.getValue().getUsername())
					&& password.equals(mappairs.getValue().getPassword())) {
				isLoggedIn = true;
				return mappairs.getValue();
				
			}

		}
		return null;
	}
	public static boolean hasLoggedIn()
	{
		return isLoggedIn;
	}

}
