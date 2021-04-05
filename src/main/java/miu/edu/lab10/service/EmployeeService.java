package miu.edu.lab10.service;

import java.util.List;

import miu.edu.lab10.domain.Employee;
 
public interface EmployeeService {

	public void save(Employee employee);
	public List<Employee> findAll();
	public Employee findByEmployeeNumber(Long employeeId);
}
