package org.sistema.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.sistema.springmvc.dao.UserDAO;
import org.sistema.springmvc.models.User;

/**
 * Fake implementation for a UserDAO.
 * 
 * @author Eugenia Pérez Martínez.
 *
 */
public class FakeUserDAO implements UserDAO {
	
	private List<User> mockUserDB;
	
	/**
	 * default constructor
	 */
	public FakeUserDAO(){
		init();
	}
	
	/**
	 * inits fake/mock database
	 */
	private void init () {
		mockUserDB = new ArrayList<User>();
		User user1 = new User(1, "sjobs", "Apple CEO", "stewie");
		User user2 = new User(2, "lellison", "Oracle CEO", "larry");
		User user3 = new User(3, "bgates", "Microsoft CEO", "imrich");
		User user4 = new User(4, "mzuckerberg", "Facebook CEO", "selfie");

		mockUserDB.add(user1);
		mockUserDB.add(user2);
		mockUserDB.add(user3);
		mockUserDB.add(user4);
	}

	/**
	 * Returns a number greater or equal than 0 if everything goes well.
	 */
	public int insert(User user) {
		user.setId(mockUserDB.size() + 1);
		mockUserDB.add(user);
		return user.getId();
	}

	
	/**
	 * Implements one user find.
	 */
	public User selectById(Integer id) {
		List<User> users = selectAll();
		User result = null;

		for (User u : users) {
			if (u.getId() == id)
				result = u;
		}

		return result;
	}

	/**
	 * Get returns the complete db
	 */
	public List<User> selectAll() {
		return mockUserDB;
	}
	

	/**
	 * Implements delete operation
	 */
	public void delete(Integer id) {
		List<User> users = selectAll();
		User result = null;

		for (User u : users) {
			if (u.getId() == id) {
				users.remove(u);
				break;
			}
		}
	}
	

	/**
	 * Implements update operation
	 */
	public void update(Integer id, User user) {
		List<User> users = selectAll();

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).getId() == id) {
				users.set(i, user);
				break;
			}
		}
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


}
