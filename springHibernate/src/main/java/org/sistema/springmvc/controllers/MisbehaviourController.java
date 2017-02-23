package org.sistema.springmvc.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.dao.MisbehaviourDAO;
import org.sistema.springmvc.dao.UserDAO;
import org.sistema.springmvc.models.Misbehaviour;
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

@Controller
public class MisbehaviourController {
	private static final Logger logger = LoggerFactory
			.getLogger(MisbehaviourController.class);

	@Autowired
	private MisbehaviourDAO misbehaviourDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = {"/misbehaviours" })
	public String showMisbehaviours(Map<String, Object> model) {
		logger.info("Product misbehaviours.");

		List<Misbehaviour> misbehaviours = misbehaviourDAO.selectAll();
		model.put("misbehaviours", misbehaviours);
		model.put("misbehaviour", new Misbehaviour());
		return "misbehaviour/misbehaviours";
	}

	/**
	 * handles /misbehaviours/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/misbehaviours/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/misbehaviours/{id}" })
	public String userMisbehaviourDetail(@PathVariable(value = "id") Long id,
			Map<String, Object> model) {
		logger.info("User misbehaviour detail");
		List<User> users = userDAO.selectAll();
		model.put("users", users);
		Misbehaviour misbehaviour = misbehaviourDAO.selectById(id);
		model.put("misbehaviour", misbehaviour);

		return "misbehaviour/misbehaviourDetail";
	}

	/**
	 * handles /misbehaviours/new
	 * 
	 * @return the name of the view to show RequestMapping({"/misbehaviours/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/misbehaviours/new" })
	public String newUser(Map<String, Object> model) {
		logger.info("Showing custom view GET ");
		List<User> users = userDAO.selectAll();
		model.put("users", users);
		model.put("misbehaviour", new Misbehaviour());

		return "misbehaviour/newMisbehaviour";
	}

	/**
	 * handles /misbehaviours/misbehaviour/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/misbehaviours/created"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/misbehaviours/created" })
	public ModelAndView createMisbehaviour(@Valid Misbehaviour misbehaviour, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			
			modelAndView.setViewName("misbehaviour/newMisbehaviour");
			modelAndView.addObject("misbehaviour", misbehaviour);
			List<User> users = userDAO.selectAll();
			modelAndView.addObject("users", users);
			return modelAndView;
		}
		
		if (misbehaviourDAO.insert(misbehaviour) > 0) {
			logger.info("Saveview POST " + misbehaviour.getId());
			// We return view name
			modelAndView.setViewName("misbehaviour/created");
			modelAndView.addObject("misbehaviour", misbehaviour);
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new ciudad. Please, try again");
		}
		/*
		try {
			misbehaviourDAO.insert(misbehaviour);
			// We return view name
			modelAndView.setViewName("misbehaviour/created");
			modelAndView.addObject("misbehaviour", misbehaviour);
		} catch (Exception e) {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new ciudad. Please, try again");
		}*/
		
		return modelAndView;
	}

	/**
	 * Simply selects the update view for misbehaviours
	 */
	@RequestMapping(value = "/misbehaviours/update/{id}", method = RequestMethod.GET)
	public String updateMisbehaviour(@PathVariable(value = "id") Long misbehaviourId,
			Model model) {
		logger.info("Showing update misbehaviour view GET ");
		model.addAttribute("misbehaviour", misbehaviourDAO.selectById(misbehaviourId));
		
		Misbehaviour misbehaviour = misbehaviourDAO.selectById(misbehaviourId);
		List<User> users = userDAO.selectAll();
		model.addAttribute("users", users);
		
		return "misbehaviour/update";		
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the misbehaviour.
	 */
	@RequestMapping(value = "/misbehaviours/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateMisbehaviour(@Valid Misbehaviour misbehaviour, BindingResult bindingResult) {
		logger.info("Save update misbehaviour " + misbehaviour.getId());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("misbehaviour/saveUpdated");
			modelAndView.addObject("misbehaviour", misbehaviour);
			return modelAndView;
		}	

		try {
			misbehaviourDAO.update(misbehaviour);
			// We return view name
			modelAndView.setViewName("misbehaviour/saveUpdated");
			modelAndView.addObject("misbehaviour", misbehaviour);
		} catch (Exception e) {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new misbehaviour. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Delete the specific misbehaviour
	 */
	@RequestMapping(value = "/misbehaviours/delete/{id}", method = RequestMethod.GET)
	public String deleteMisbehaviour(@PathVariable(value = "id") Long misbehaviourId,
			Model model) {
		logger.info("User detail /delete misbehaviour: " + misbehaviourId);

		// Store the concrete cliente to send it back before deleting to use it in
		// the following view.
		
		Misbehaviour misbehaviour = misbehaviourDAO.selectById(misbehaviourId);
		model.addAttribute("misbehaviour", misbehaviour);

		misbehaviourDAO.delete(misbehaviour.getId());

		return "misbehaviour/deleted";
	}

}
