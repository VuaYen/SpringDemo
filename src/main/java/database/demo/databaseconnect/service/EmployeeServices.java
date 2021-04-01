package database.demo.databaseconnect.service;

import database.demo.databaseconnect.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    public List<Employee> all();
    public Optional<Employee> getById(Integer id);
    public Employee save(Employee employee);
    public void  delete(Integer id);
}
