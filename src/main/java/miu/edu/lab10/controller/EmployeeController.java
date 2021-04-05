package miu.edu.lab10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import miu.edu.lab10.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import miu.edu.lab10.domain.Employee;
import miu.edu.lab10.service.EmployeeService;

import java.util.List;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public  String listEmployee(){
		return "employees";
	}
	
//	@Autowired
//	private EmployeeValidator employeeValidator;
//@PostMapping("/placeOrder")
//public Customer placeOrder(@RequestBody Customer customer){
//
//	return customerRepository.save(customer);
//}
//@GetMapping("/findAllOrders")
//public List<Customer> findAllOrders(){
//	return customerRepository.findAll();
//}
	@Autowired
	private EmployeeRepository employeeRepository;
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
//	@GetMapping("/findAllEmployees")
//	public List<Employee> findAllEmployees(){
//		return employeeRepository.findAll();
//	}

	@RequestMapping(value={"","/list"})
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "employees";
	}
	
  	@RequestMapping("/employee")
	public String getEmployeeById(Model model, @RequestParam("id") Long employeeId) {
		Employee employee = employeeService.findByEmployeeNumber(employeeId);
		model.addAttribute("employee", employee);
		return "employee";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewEmployeeForm(@ModelAttribute("newEmployee") Employee newEmployee) {
	   return "addEmployee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployeeForm(@ModelAttribute("newEmployee") @Valid Employee employeeToBeAdded, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/add";
		}

		model.addAttribute("employee", employeeToBeAdded);
		try {
			employeeService.save(employeeToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");

		}

		return "redirect:/list";
	}
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String processAddNewEmployeeForm(@ModelAttribute("newEmployee") @Valid Employee employeeToBeAdded, BindingResult result, HttpServletRequest request) {
//		if(result.hasErrors()) {
//			return "/add";
//		}
//
//   		try {
//			employeeService.save(employeeToBeAdded);
//		} catch (Exception up) {
//	      System.out.println("Transaction Failed!!!");
//
//		}
//
//	   	return "redirect:/list";
//	}
	
 
}
