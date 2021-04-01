package database.demo.databaseconnect.service;

import database.demo.databaseconnect.Employee;
import database.demo.databaseconnect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
//@Transactional
public class EmployeeServicesImpl implements EmployeeServices {

//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Override
//    public List<Employee> all() {
////        return toList(employeeRepository.findAll());
//    }
//
//    @Override
//    public Optional<Employee> getById(Integer id) {
//        return employeeRepository.findById(id);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//        employeeRepository.deleteById(id);
//
//    }
    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> all() {
        return null;
    }

    @Override
    public Optional<Employee> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
