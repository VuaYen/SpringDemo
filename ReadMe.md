sql insert
INSERT INTO `location` VALUES (1,'4th','Fairfield','IA', '52557');
INSERT INTO `location` VALUES (2,'8th','Osaka','OZ', '12345');
 
INSERT INTO `employee` VALUES (1,12, 8754,'Junene','George' ,'President',1);
INSERT INTO `employee` VALUES (2,123, 8733,'Bellman','Bush' ,'CEO',2);
Implement Address and Employee with relation one-to-one.
Domain Address.java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="location")
public class Address {

    @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;

   private String street;
   private String city;
   
   private String state;

   private String zipCode;

}
And Employee.java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   
   private String firstName;
   private String lastName;
   private int age;
   private String title;
   private int employeeNumber;

   @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="addressid")
   private Address address;

 
}
The result we have two tables
 
That means every Employee has only a Address.
Continue we create 2 template in thymeleaf.
Employees.html.: show the list of employees
 
addEmployee.html: A Form to insert a new employee.
 
Add a EmployeeServices.
public interface EmployeeService {

   public void save(Employee employee);
   public List<Employee> findAll();
   public Employee findByEmployeeNumber(Long employeeId);
}
Implement  services
@Service
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {
   
   @Autowired
   private EmployeeRepository employeeRepository;

   public void save(Employee employee) {
      employeeRepository.save(employee);
   }
   public List<Employee> findAll() {
      return (List<Employee>)employeeRepository.findAll();
   }

   public Employee findByEmployeeNumber(Long employeeId) {
      return employeeRepository.findByEmployeeNumber(employeeId);
   }
 

}

Add Controller : EmployeeController.java
Show the home page
@Controller
public class EmployeeController {
   
   @Autowired
   private EmployeeService employeeService;
   @GetMapping("/")
   public  String listEmployee(){
      return "employees";
   }

Show the  Form add new employee
@RequestMapping(value = "/add", method = RequestMethod.GET)
public String getAddNewEmployeeForm(@ModelAttribute("newEmployee") Employee newEmployee) {
   return "addEmployee";
}

Add new Employee
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
Show the list of employee
@RequestMapping(value={"","/list"})
public String listEmployees(Model model) {
   model.addAttribute("employees", employeeService.findAll());
   return "employees";
}
Config application.properties
server.port=8092
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
