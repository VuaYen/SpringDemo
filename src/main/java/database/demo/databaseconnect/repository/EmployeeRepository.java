package database.demo.databaseconnect.repository;

import database.demo.databaseconnect.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository  {
}
//public interface EmployeeRepository extends JpaRepository<Employee,Integer>
