package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmployeeDao {

	@Autowired
	private EmployeeRepository e_repo;
	
	public Employee saveEmployee(Employee emp)
	{
		return e_repo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp)
	{
		return e_repo.save(emp);
	}
	
	public Optional<Employee> findEmployeeById(int id)
	{
		return e_repo.findById(id);
	}
	
	public List<Employee> findAllEmployees()
	{
		return e_repo.findAll();
	}
	
	public void deleteEmployeeById(int id)
	{
		e_repo.deleteById(id);
	}
	
	public Optional<Employee> findByEmailAndPassword(String email,String password)
	{
		return e_repo.findByEmailAndPassword(email,password);
	}
	
	public List<Employee> findByName(String name)
	{
		return e_repo.findByName(name);
	}
}
