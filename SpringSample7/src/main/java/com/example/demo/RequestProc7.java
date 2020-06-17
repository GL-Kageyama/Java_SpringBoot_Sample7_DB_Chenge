package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class for screen display and DB integration
 */
@Controller
public class RequestProc7 {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Function for initial screen display
	 * @param model Model for storing customer information.
	 * @return "index7" Return index7.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		// Obtain all customer information registered in the DB.
		List<Customer> userlist = customerRepository.findAll();
		model.addAttribute("customerlist", userlist);

		return "/index7";
	}

	/**
	 * Function to display the customer information to be changed
	 * @param num ID to be changed.
	 * @param model Model for storing the customer information to be changed.
	 * @return "change" Return change.html
	 */
	@RequestMapping(value = "/{num}/change", method = RequestMethod.GET)
	public String changeValue(@PathVariable Long num, Model model) {

		// Get an ID
		Customer customer = customerRepository.findById(num).get();
		model.addAttribute("customerUpdate", customer);

		return "change";
	}

	/**
	 * Register the modified customer information in the DB
	 * @param customerUpdate Modified Customer Information.
	 * @return "redirect:/" Return to root list.html
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute Customer customerUpdate) {

		// Register the modified customer information in the DB.
		customerRepository.save(customerUpdate);

		return "redirect:/";
	}

}

