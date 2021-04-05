package miu.edu.lab10.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import miu.edu.lab10.domain.Employee;

	@Repository
//	public interface EmployeeRepository extends  JpaRepository<Employee,Integer>
//	{
//		@Query("select e from Employee  e where e.id= :id")
//		public Employee findByEmployeeNumber(@Param("id") Long employeeNumber);
// 	}
public interface EmployeeRepository extends  CrudRepository<Employee, Long>
{
	@Query("select e from Employee  e where e.id= :id")
	public Employee findByEmployeeNumber(@Param("id") Long employeeNumber);
}


