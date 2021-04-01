package database.demo.databaseconnect.controller;

import database.demo.databaseconnect.Address;
import database.demo.databaseconnect.Employee;
import database.demo.databaseconnect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/emp")
    public Employee emp(Model model) {

        Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52557");
        Employee e = new Employee(1L, "Keyboard", "Friday", LocalDate.of(2021, 04, 01), 100, addr);

        model.addAttribute("emp", e);

        return e;
    }
    @GetMapping("/empl")
    public List<Employee> empl(Model model) {
        List<Employee> list= new ArrayList<>();

        Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52557");
        Employee e = new Employee(1L, "Black", "Friday", LocalDate.of(2021, 04, 01), 100, addr);
        Address addr1 = new Address("1001 N 4th St", "Fairfield", "IA", "52557");
        Employee e1 = new Employee(2L, "Tom", "Smith", LocalDate.of(2021, 04, 01), 100, addr1);
        Employee e2 = new Employee(3L, "Tom", "Fruit", LocalDate.of(2021, 01, 01), 100, addr1);
        list.add(e);
        list.add(e1);
        list.add(e2);
        return list;
    }
//    @Autowired
//    EmployeeRepository employeeRepository;
//    @GetMapping("/empl1")
//    public List<Employee> getAllEmp()
//    {
//        return employeeRepository.findAll();
//    }
}
