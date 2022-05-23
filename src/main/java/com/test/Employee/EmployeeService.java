package com.test.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	public String saveEmployee(Employee employee) {
		Employee existing = repository.findById(employee.getId()).orElse(null);
		if(existing == null ) {
			repository.save(employee);
			return "Employee added succssfully";
		}
		else
		     return "Employee Already Exist";
	}
	public List<Employee> saveEmployees(List<Employee> employees){
		return repository.saveAll(employees);
	}
	public List<Employee> getEmployees(){
		return repository.findAllByOrderBySalaryDesc();
	}
	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}
  public Employee updateEmployee(Employee employee) {
	  Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
	  existingEmployee.setName(employee.getName());
	  existingEmployee.setDesignation(employee.getDesignation());
	  existingEmployee.setSalary(employee.getSalary());
	  return repository.save(existingEmployee);
  }
	
}
