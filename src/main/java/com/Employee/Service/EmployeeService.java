package com.Employee.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;
import com.Employee.Exception.EmployeeException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) throws EmployeeException {
		try {
		if(e.getSalary()<10000) {
			throw new EmployeeException("Salary not eligible exception");
		}
		else {
			return empDao.addEmployee(e);
		}
		}
		catch(EmployeeException ee) {
			return ee.getMessage();
		}
	}

	public String setEmpList(List<Employee> e1) {
		return empDao.setEmpList(e1);
	}

	public Employee oneEmp(int a) {
		return empDao.oneEmp(a);
	}
//----------------------------------------------------------------------------------------------------------------
	public String delEmp(int a) {
		return empDao.delEmp(a);
	}
	
	
//	public String delEmp(int a) throws NoSuchElementException {
//		List<Employee> li = this.allEmp();
//		List <Employee> l = li.stream().filter(x->x.getId()==a).toList();
//		if(l.isEmpty()==true) {
//			throw new NoSuchElementException("No Employee found for delete in this id");
//		}
//		else {
//			return empDao.delEmp(a);
//		}
//	}
	
	
	
//	---------------------------------------------------------------------------------

	public List<Employee> allEmp() {
		return empDao.allEmp();
	}

	public String updateOneEmp(Employee a) {
		return empDao.updateOneEmp(a);
	}
//----------------------------------------------------------------------------------------------------------------------------------
//     CONTROLLER AND SERVICE CLASS ONLY USED
	
	public List<Employee> salaryHike(String des) {
		List<Employee> getAllEmp = this.allEmp();
		return getAllEmp.stream().filter(x -> x.getDesignation().equals(des))

				.peek(x -> x.setSalary((x.getSalary() * 5 / 100) + x.getSalary())).toList();
	}

	public Employee findMaxSalary() {
		List<Employee> maxx = this.allEmp();
		return maxx.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
	}

	public Employee findMinSalary() {
		List<Employee> minn = this.allEmp();
		return minn.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
	}

	public List<Employee> getByNa(String name) throws EmployeeException {
		List<Employee> allE = this.allEmp();
		List<Employee> temp = allE.stream().filter(x -> x.getName().contains(name)).toList();
		if (temp.isEmpty()) {
			throw new EmployeeException("there is no name in this data");
		} else {
			return temp;
		}
	}

	public List<String> getName(String des) {
		List<Employee> allE = this.allEmp();
		return allE.stream().filter(x -> x.getDesignation().equals(des)).map(x -> x.getName()).toList();
	}

	public List<Integer> getSalary(int limit) {
		List<Employee> allE = this.allEmp();
		return allE.stream().filter(x -> x.getSalary() < limit).map(x -> x.getSalary()).toList();
	}

	public List<String> getDesignation(CharSequence l) {
		List<Employee> allE = this.allEmp();
		return allE.stream().filter(x -> x.getDesignation().contains(l)).map(x -> x.getDesignation()).toList();

	}

	public List<Employee> getBySalary(int a, int b) { /// NATIVE QUERY USED
		return empDao.getBySalary(a, b);
	}

	public List<Employee> getByS(int sal1, int sal2) {
		return empDao.getByS(sal1, sal2);
	}

//	public String addEmployee(Employee e) throws EmployeeException {
//		if (e.getSalary() < 19000) {
//			throw new EmployeeException("not eligible");
//		} else {
//			return empDao.addEmployee(e);
//		}
//	}
	
	public Optional<Employee> getById(int i) throws EmployeeException {
		List<Employee> list = this.allEmp();
		List<Employee> es = list.stream().filter(x->x.getId()== i).toList();
		
		if(es.isEmpty()) {
			throw new EmployeeException ("these no matched input salary");
		}
		else {
			return empDao.getByES(i);
		}
	}
	
	public String postNL(List<Employee> e2) throws EmployeeException {
	          List<Employee> list = e2.stream().filter(x->x.getSalary() >= 20000).toList();
	          if(list.isEmpty()==true) {
	        	  throw new EmployeeException("not valid to post");
	          }
	          else {
	        	  return empDao.postNL(e2);
	          }
	}
	
}
