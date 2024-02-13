package com.Employee.Controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Exception.EmployeeException;
import com.Employee.Service.EmployeeService;

@RestController
@RequestMapping("/emp")

public class EmployeeController {
	@Autowired
	EmployeeService empSer;
	@PostMapping(value="/insert")
	public String addEmployee(@RequestBody Employee e) throws EmployeeException  {
		return empSer.addEmployee(e);
	}
//------------------------------------------------------------------------------------------------------------------------------------	
	
	
	@PostMapping(value="/setList")
	public String setEmpList(@RequestBody List<Employee> e1) {
		return empSer.setEmpList(e1);
	}
	
	@GetMapping(value="/oneEmp/{a}")
	public Employee oneEmp(@PathVariable int a) {
			
		return empSer.oneEmp(a);
	}
	@DeleteMapping(value="/delById/{a}")
	public String delEmp(@PathVariable int a) {
		return empSer.delEmp(a);
	}
	
	@GetMapping(value="/getAllEmp")
	public List<Employee> allEmp() throws EmployeeException {
		return empSer.allEmp();
	}
	@PutMapping(value="/update")
	public String updateOneEmp(@RequestBody Employee a) {
		return empSer.updateOneEmp(a);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	CONTROLLER AND SERVICE CLASS ONLY USED
	
	@GetMapping(value="/hike/{des}")
	public List<Employee> salaryHike(@PathVariable String des) {
		return empSer.salaryHike(des);
	}
	
	@GetMapping(value="/maxslry")
	public Employee findMaxSalary() {
		return empSer.findMaxSalary();
	}
	
	
	@GetMapping(value="/minSalary")
	public Employee findMinSalary() {
		return empSer.findMinSalary();
	}
	
	
	
	@GetMapping(value="/getByName/{name}")
	public List<Employee> getByNa(@PathVariable String name) throws EmployeeException {
		return empSer.getByNa(name);
		/*[
		    {
		        "id": 2,
		        "name": "Ravi Kumar",
		        "salary": 45000,
		        "gender": "Male",
		        "designation": "Owner"
		    }
		]*/
	}
	
	
	
	@GetMapping(value="/nameFieldOfManager/{des}")
	public List<String> getName(@PathVariable String des) {
		return empSer.getName(des);
		/*[
		    "Velu"
		]*/
	}
	
	
	@GetMapping(value="/below45/{limit}")
	public List<Integer> getSalary(@PathVariable int limit) {
		return empSer.getSalary(limit);
		/*[
		    19000,
		    25000,
		    25000,
		    26000
		]*/
	}
	
	@GetMapping(value="/rContains/{l}")
	public List<String> getDesignation(@PathVariable CharSequence l) {
		
		return empSer.getDesignation(l);
		/*[
		    "Manager",
		    "Owner",
		    "Driver"
		]
		http://localhost:8080/emp/rContains/r
		*/
	}
	
	
	@GetMapping(value="/getBySal/{a}/{b}")
	public List<Employee> getBySalary(@PathVariable int a, @PathVariable int b) {  ///NATIVE QUETY USED
		return empSer.getBySalary(a,b);
		
		/*[
		    {
		        "id": 3,
		        "name": "Ravi",
		        "salary": 25000,
		        "gender": "Male",
		        "designation": "CEO"
		    },
		    {
		        "id": 6,
		        "name": "Ravi",
		        "salary": 27000,
		        "gender": "Male",
		        "designation": "CEO"
		    },
		    {
		        "id": 7,
		        "name": "Kanagaraj",
		        "salary": 26000,
		        "gender": "Male",
		        "designation": "Driver"
		    }
		]
		http://localhost:8080/emp/getBySal/20000/30000
		
		*/	
	}
	
	@GetMapping(value="/getByS/{sal1}/{sal2}")
	public List<Employee> getByS(@PathVariable int sal1, @PathVariable int sal2) {  //J QUERY USED
		return empSer.getBySalary(sal1, sal2);
	}
	
	@GetMapping(value="/getById/{i}")
	public Optional<Employee> getById(@PathVariable int i) throws EmployeeException {
		return empSer.getById(i);
	}
	@PostMapping(value="/postNewList")
	public String postNL(@RequestBody List<Employee> e2) throws EmployeeException {
		return empSer.postNL(e2);
	}
	
}