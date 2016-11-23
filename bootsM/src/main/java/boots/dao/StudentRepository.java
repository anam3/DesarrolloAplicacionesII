package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
