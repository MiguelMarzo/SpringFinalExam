package org.sistema.springmvc.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.dao.UserDAO;
import org.sistema.springmvc.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for users.
 * 
 * @author Eugenia Pérez Martínezo
 *
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;

	/**
	 * handles default /users
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/users"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/users" })
	public String showUsers(Map<String, Object> model) {
		logger.info("Product showUsers. ");

		List<User> users = userDAO.selectAll();
		model.put("users", users);

		return "user/users";
	}

	/**
	 * handles default /users/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/users/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/users/{id}" })
	public String userDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		logger.info("User detail");

		User user = userDAO.selectById(id);
		model.put("user", user);

		return "user/userDetail";
	}

	/**
	 * handles /users/new
	 * 
	 * @return the name of the view to show RequestMapping({"/users/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/users/new" })
	public String newUser(Map<String, Object> model) {
		logger.info("Showing custom view GET ");

		model.put("user", new User());

		return "user/newUser";
	}

	/**
	 * handles /users/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/users/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/users/new" })
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("user/newUser");
			modelAndView.addObject("user", user);
			return modelAndView;
		}

		if (userDAO.insert(user) > 0) {
			logger.info("Saveview POST " + user.getId());
			// We return view name
			modelAndView.setViewName("user/created");
			modelAndView.addObject("user", user);
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new user. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Simply selects the update view
	 */
	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Showing update view GET ");

		// We find the product through DAO and load into model
		model.addAttribute("user", userDAO.selectById(userId));

		return "user/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the User.
	 */
	@RequestMapping(value = "/users/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(User user) {
		logger.info("Save update " + user.getId());

		userDAO.update(user);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the user received through this object
		modelAndView.addObject("user", user);

		// The same as return "user/saveUpdate"
		modelAndView.setViewName("user/saveUpdated");
		return modelAndView;
	}

	/**
	 * Delete the specific user
	 */
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer userId, Model model) {
		logger.info("Product detail /delete");

		userDAO.delete(userId);
		model.addAttribute("userId", userId);

		return "user/deleted";
	}

}
