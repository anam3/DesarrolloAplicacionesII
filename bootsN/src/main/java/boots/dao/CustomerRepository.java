package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
