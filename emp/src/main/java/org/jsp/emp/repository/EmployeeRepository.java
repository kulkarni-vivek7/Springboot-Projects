package org.jsp.emp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmailAndPassword(String email, String password);

	List<Employee> findByName(String name);

}
