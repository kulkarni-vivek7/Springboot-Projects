package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EmployeeDao;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.responcestructure.ResponceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDao e_dao;
	
	public ResponceStructure<Employee> saveEmployee(Employee employee)
	{
		employee = e_dao.saveEmployee(employee);
		
		ResponceStructure<Employee> res = new ResponceStructure<>();
		
		res.setStatus(HttpStatus.CREATED.value());
		res.setMessage("Employee Added Successfully");
		res.setBody(employee);
		
		return res;
	}
	
	public ResponceStructure<Employee> findEmployeeById(int id)
	{
		Optional<Employee> o_emp = e_dao.findEmployeeById(id);
		
		ResponceStructure<Employee> res = new ResponceStructure<>();
		
		if(o_emp.isEmpty())
		{
			res.setStatus(HttpStatus.NOT_FOUND.value());
			res.setMessage("No Employee Found For The Given Id");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Employee Found Successfully...");
		res.setBody(o_emp.get());
		
		return res;
	}
	
	public ResponceStructure<List<Employee>> findAllEmployees()
	{
		List<Employee> l_emp = e_dao.findAllEmployees();
		
		ResponceStructure<List<Employee>> res = new ResponceStructure<>();
		
		if(l_emp.isEmpty())
		{
			res.setStatus(HttpStatus.NOT_FOUND.value());
			res.setMessage("No Employee Is Present In The Database Table");
			res.setBody(l_emp);
			
			return res;
		}
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("All Employees Found Successfully");
		res.setBody(l_emp);
		
		return res;
	}
	
	public ResponceStructure<String> deleteEmployeeById(int id)
	{
		Optional<Employee> o_emp = e_dao.findEmployeeById(id);
		
		ResponceStructure<String> res = new ResponceStructure<>();
		
		if(o_emp.isEmpty())
		{
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			res.setMessage("Bad Request - Invalid Employee Id");
			res.setBody("Unable To Delete Employee");
			
			return res;
		}
		
		e_dao.deleteEmployeeById(id);
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Employee Deleted From The Database Table Successfully...");
		res.setBody("Employee Deleted");
		
		return res;
	}
	
	public ResponceStructure<Employee> updateEmployee(Employee employee)
	{
		employee = e_dao.updateEmployee(employee);
		
		ResponceStructure<Employee> res = new ResponceStructure<>();
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Employee Updated Successfully");
		res.setBody(employee);
		
		return res;
	}
	
	public ResponceStructure<Employee> findEmployeeByEmailAndPassword(String email, String password)
	{
		Optional<Employee> o_emp = e_dao.findByEmailAndPassword(email, password);
		
		ResponceStructure<Employee> res = new ResponceStructure<>();
		
		if(o_emp.isEmpty())
		{
			res.setStatus(HttpStatus.NOT_FOUND.value());
			res.setMessage("Invalid Employee Credentials... Unable To Find Employee");
			res.setBody(null);
			
			return res;
		}
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("Employee Found Successfully...");
		res.setBody(o_emp.get());
		
		return res;
	}
	
	public ResponceStructure<List<Employee>> findEmployeeByName(String name)
	{
		List<Employee> emps = e_dao.findByName(name);
		
		ResponceStructure<List<Employee>> res = new ResponceStructure<>();
		
		if(emps.isEmpty())
		{
			res.setStatus(HttpStatus.NOT_FOUND.value());
			res.setMessage("No Employees Present For The Given Name");
			res.setBody(emps);
			
			return res;
		}
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("All Employees Found Successfully For The Given Name");
		res.setBody(emps);
		
		return res;
	}
}
