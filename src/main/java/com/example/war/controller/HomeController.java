package com.example.war.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.war.model.Registration;
import com.example.war.service.StudentService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	StudentService studentService;

	@GetMapping(value = "/getInfo")
	public String getUserInfo() {
		return "Welcome...!!!";
	}

	@GetMapping(value = "/getName/{name}")
	public String getName(@PathVariable(value = "name") String n) {
		return "Hello " + n;
	}
	
	// To Add record into the database.
	@PostMapping("/registration")
	public Registration addvalues(@RequestBody Registration registration) {
		return studentService.addData(registration);
	}

	// To Fetch All records from the database.
	@GetMapping("/getAllRecords")
	public List <Registration> getAllRecords(){
		return this.studentService.getAllRecords();
	}
	
	// To Fetch particular record from the database.
	@GetMapping("/getRecord/{Id}")
	public Optional getRecord(@PathVariable(value = "Id") Integer n){
		return this.studentService.getRecord(n);
	}
	
	// To update the particular record.
	@PutMapping("/updateRecord/{id}")
	public Registration updateRecord(@PathVariable (value="id") Integer n, @RequestBody Registration registration){
		return this.studentService.updateRecord(n,registration);
	}
	
	// To Delete particular record from the database.
	@DeleteMapping("/deleteRecord/{id}")
	public String deleteRecord(@PathVariable (value="id") Integer id) {
		return this.studentService.deleteRecord(id);
	}
	
}