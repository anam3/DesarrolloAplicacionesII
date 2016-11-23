package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.StudentRepository;
import boots.model.Student;


@Service @Transactional
public class StudentService {
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository){
		super();
		this.studentRepository=studentRepository;
	}
	
	public List<Student> findAll(){
		List<Student> students = new ArrayList<Student>();
		for(Student student : studentRepository.findAll()){
			students.add(student);
		}
		return students;
	}
	
	public void save(Student student){
		studentRepository.save(student);
	}
	
	public void delete(int id){
		studentRepository.delete(id);
	}
	
	public Student findOne(int id){
		return studentRepository.findOne(id);
	}

}
