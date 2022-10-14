package com.greatlearning.customermanagement.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customermanagement.entity.Customer;
import com.greatlearning.customermanagement.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@RequestMapping(value="/list")
	public String listbooks(Model theModel) {
		List<Customer> customer=customerService.findAll();
		theModel.addAttribute("Customer",customer);
		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer=new Customer();
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id")int theId, Model theModel) {
		Customer customer=customerService.findById(theId);
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}

	@RequestMapping("/save")
	public String saveBook(@RequestParam("custId")int id,@RequestParam("firstName")String firstname,@RequestParam("lastName") String lastname,
			@RequestParam("email")String email) {

		Customer theCustomer;
		System.out.println("id: "+id);
		if(id!=0) {
			theCustomer=customerService.findById(id);
			theCustomer.setFirstName(firstname);
			theCustomer.setLastName(lastname);
			theCustomer.setEmail(email);
		}
		else {
			theCustomer=new Customer();
			theCustomer.setFirstName(firstname);
			theCustomer.setLastName(lastname);
			theCustomer.setEmail(email);



		}
		System.out.println("Before Save");
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/delete")

	public String delete(@RequestParam("id")int theId) {

		customerService.deleteById(theId);

		return "redirect:/customer/list";
	}








}
