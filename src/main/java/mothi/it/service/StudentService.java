package mothi.it.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mothi.it.Student;
import mothi.it.Entity.StudentEntity;
import mothi.it.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) {
		System.out.println(student);
		StudentEntity ent = new StudentEntity();
		BeanUtils.copyProperties(student, ent);
		System.out.println(ent);
		ent.setTimings(Arrays.toString(student.getTimings()));
				
		
		repo.save(ent);
		return true;
	}
   
	public List<String> getCourses(){
		return Arrays.asList("Java","Python","SQL","DevOps");
	}
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afternoon","Evening");
	}
}
