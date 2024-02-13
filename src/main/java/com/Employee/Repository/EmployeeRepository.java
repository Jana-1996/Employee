package com.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query(value="select * from employee_details where salary>=? and salary <=?", nativeQuery= true ) //NATIVE QUERY
	
	public List<Employee> getBySal(int sal1, int sal2);
	
//	-----------------------------------------------------------------------------------------------------------------------------
	
	@Query(value= "select e from Employee e where e.salary>=: sal1 and e.salary<=: sal2")   //J QUERY
	
	public List<Employee> getByS(@Param(value="sal1") int sal1, @Param(value="sal2") int sal2);
	


	
}
