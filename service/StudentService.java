package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.model.Registration;
import com.example.demo.repository.JPARepo;

@Service
public class StudentService {

	@Autowired
	private JPARepo jparepo;
	

	public Registration addData(Registration registration) {
		return this.jparepo.save(registration);
	}

	public List<Registration> getAllRecords(){
		System.out.println((this.jparepo.findAll()).size());
		return this.jparepo.findAll();
	}
	
	public Optional<Registration> getRecord(Integer id){
		return this.jparepo.findById(id);
	}
	
	public Registration updateRecord(Integer Id, Registration registration) {
		
		Registration record = this.jparepo.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("User Data not found"));
		
		record.setAge(registration.getAge());
		record.setStudentName(registration.getStudentName());
		
		return this.jparepo.save(record);
	}
	
	public String deleteRecord(Integer id) {
		this.jparepo.deleteById(id);
		return "Record "+id+" has been deleted successfully...";
	}
	
}
