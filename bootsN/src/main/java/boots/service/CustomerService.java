package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.CustomerRepository;
import boots.model.Customer;


@Service @Transactional
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository){
		super();
		this.customerRepository=customerRepository;
	}

	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		for(Customer customer : customerRepository.findAll()){
			customers.add(customer);
		}
		return customers;
	}
	
	public void save(Customer customer){
		customerRepository.save(customer);
	}
	
	public void delete(int id){
		customerRepository.delete(id);
	}
	
	public Customer findOne(int id){
		return customerRepository.findOne(id);
	}
	
}
