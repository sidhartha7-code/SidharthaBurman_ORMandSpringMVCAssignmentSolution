package com.greatlearning.customermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customermanagement.entity.Customer;




@Repository
public class CustomerServiceImpl implements CustomerService{

		private SessionFactory sessionFactory;

		private Session session;

		@Autowired
		CustomerServiceImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
			try {
				session=sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				// TODO: handle exception
				session=sessionFactory.openSession();
			}
	}

		@Override
		@Transactional
		public List<Customer> findAll(){

			Transaction tx= session.beginTransaction();
			List<Customer> customers =session.createQuery("from Customer").list();
			tx.commit();
			return customers;
		}


		@Override
		public Customer findById(int id) {
			Customer customers=new Customer();
			Transaction tx=session.beginTransaction();

			customers=session.get(Customer.class,id);
			tx.commit();

			return customers;
		}

		@Override
		public void save(Customer theCustomer) {
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(theCustomer);
			tx.commit();
		}

		@Override
		public void deleteById(int id) {
			Transaction tx=session.beginTransaction();

			Customer student=session.get(Customer.class,id);
			session.delete(student);
			tx.commit();
		}

}
