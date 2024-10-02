package org.jsp.emp.controller;

import java.util.List;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.responcestructure.ResponceStructure;
import org.jsp.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Response body + controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/employees")
	public ResponceStructure<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/employees")
	public ResponceStructure<List<Employee>> findAllEmployees()
	{
		return service.findAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponceStructure<Employee> findEmployeeById(@PathVariable int id)
	{
		return service.findEmployeeById(id);
	}
	
	@DeleteMapping("/employees")
	public ResponceStructure<String> deleteEmployeeById(@RequestParam int id)
	{
		return service.deleteEmployeeById(id);
	}
	
	@PutMapping("/employees")
	public ResponceStructure<Employee> updateEmployee(@RequestBody Employee emp)
	{
		return service.updateEmployee(emp);
	}
	
	@GetMapping("/employees/name/{name}")
	public ResponceStructure<List<Employee>> findEmployeeByName(@PathVariable String name)
	{
		return service.findEmployeeByName(name);
	}
	
	@GetMapping("/employees/{email}/{password}")
	public ResponceStructure<Employee> findEmployeeByEmailAndPassword(@PathVariable String email, @PathVariable String password)
	{
		return service.findEmployeeByEmailAndPassword(email, password);
	}
}
