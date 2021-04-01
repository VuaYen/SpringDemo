package database.demo.databaseconnect.controller;


import database.demo.databaseconnect.Address;
import database.demo.databaseconnect.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StandardExpressionController {

	@GetMapping("/simpleExpression")
	public String displaySimpleExpressions(Model model) {

		Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52556");
		Employee e = new Employee(1L, "Black", "Friday", LocalDate.of(2021, 03, 01), 100, addr);

		model.addAttribute("emp", e);

		return "SimpleExpression";
	}


	@GetMapping("/conditionalExpression")
	public String displayConditionalExpressions(Model model) {
		Employee e = new Employee(1L, "Black", "Friday", LocalDate.of(2018, 10, 01), 100, null);
		model.addAttribute("emp", e);

		Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52556");
		Employee e2 = new Employee(1L, "Black", "Friday", LocalDate.of(2018, 10, 01), 100, addr);
		model.addAttribute("emp2", e2);

		model.addAttribute("gender", "F");
		return "ConditionalExpression";
	}

}
