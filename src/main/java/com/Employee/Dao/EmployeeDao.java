package com.Employee.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDao  {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Succesfully Saved";
	}
	
	
	public String setEmpList(List<Employee>e1) {
		empRepo.saveAll(e1);
		return "Employee List Saved";
	}
	
	public Employee oneEmp(int a) {
	    return empRepo.findById(a).get(); 	
	}
	public String delEmp(int a) {
		 empRepo.deleteById(a);
		 return "Deleted Succes";
	}
	public List<Employee> allEmp() {
		return empRepo.findAll();
	}
	public String updateOneEmp(Employee a) {
		  empRepo.save(a);
		  return "updated";
	}
	public List<Employee> getBySalary(int a, int b) {  //NATIVE QUETY USED
		return empRepo.getBySal(a, b);	
	}
	public List<Employee> getByS(int sal1, int sal2) {
		return empRepo.getByS(sal1, sal2);
	}
	
	public Optional<Employee> getByES(int i) {
		return empRepo.findById(i);
	}
	
	public String postNL(List<Employee> e2) {
		 empRepo.saveAll(e2);
		 return "Saved";
	}
}
