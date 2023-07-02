package com.glearning.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.emp.model.Employee;
import com.glearning.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> viewAllEmployees() {
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	@Override
	public Employee findEmployeeById(long id) {
		return this.employeeRepo.findById(id).orElseThrow();
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Optional<Employee> findById = this.employeeRepo.findById(id);
		if (findById.isPresent()) {
			Employee employee2 = findById.get();
			employee2.setFirstName(employee.getFirstName());
			employee2.setLastName(employee.getLastName());
			employee2.setEmail(employee.getEmail());

			employeeRepo.save(employee2);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepo.deleteById(id);

	}

}
