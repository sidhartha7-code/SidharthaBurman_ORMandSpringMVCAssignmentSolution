package com.greatlearning.customermanagement.service;

import java.util.List;

import com.greatlearning.customermanagement.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);
}
