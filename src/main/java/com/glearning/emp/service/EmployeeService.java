package com.glearning.emp.service;

import java.util.List;

import com.glearning.emp.model.Employee;

public interface EmployeeService {

	List<Employee> viewAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee findEmployeeById(long id);

	Employee updateEmployee(long id, Employee employee);

	void deleteEmployeeById(long id);

}
