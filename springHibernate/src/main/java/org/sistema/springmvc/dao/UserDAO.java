package org.sistema.springmvc.dao;

import java.util.List;

import org.sistema.springmvc.models.User;

/**
 * Interface for a UserDAO.
 * 
 * @author Eugenia Pérez Martínez.
 *
 */
public interface UserDAO {

	/**
	 * This is the method to be used to create a record in the Student table.
	 * 
	 * @param user
	 *            user to be saved.
	 * 
	 * @return the ID of the saved user.
	 */
	public int insert(User user);

	/**
	 * This is the method to be used to list down a record from the Student
	 * table corresponding to a passed student id.
	 * 
	 * @param id
	 * 
	 * @return the user found
	 */
	public User selectById(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * Student table.
	 * 
	 * @return the list of users.
	 */
	public List<User> selectAll();

	/**
	 * This is the method to be used to delete a record from the Student table
	 * corresponding to a passed student id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the Student table.
	 */
	public void update(User user);
}
