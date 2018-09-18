package co.grandcircus.authdemo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.grandcircus.authdemo.entity.User;

// Pretending to be a DAO for convenience, but really just keeps the data in a map. In a real app, use a real DAO.
@Component
public class UserDao {

	private Map<Long, User> users = new HashMap<>();
	private long nextId = 1;
	
	{
		// This is called an instance initialization block. It runs when a class instance is created,
		// right before the constructor.
		// Here we add two premade users to the "database".
		save(new User("Jimmy Johns", "jjohns", "freaky fast"));
		save(new User("Mrs. Fields", "mfields", "sweet!"));
	}
	
	public User findById(Long id) {
		return users.get(id);
	}
	
	public User findByUsername(String username) {
		return users.values().stream().filter(user -> username.equals(user.getUsername())).findAny().orElse(null);
	}
	
	public User findByGithubId(Long githubId) {
		return users.values().stream().filter(user -> user.getGithubId() == githubId).findAny().orElse(null);
	}
	
	public void save(User user) {
		if (user.getId() == null) {
			user.setId(nextId++);
		}
		users.put(user.getId(), user);
	}

}
